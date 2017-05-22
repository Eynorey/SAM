package de.saminitiative.sam.web.rest;

import de.saminitiative.sam.SamApp;

import de.saminitiative.sam.domain.Course;
import de.saminitiative.sam.repository.CourseRepository;
import de.saminitiative.sam.repository.search.CourseSearchRepository;
import de.saminitiative.sam.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;

import static de.saminitiative.sam.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the CourseResource REST controller.
 *
 * @see CourseResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SamApp.class)
public class CourseResourceIntTest {

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_START = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_START = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_END = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_END = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_LOCATION = "AAAAAAAAAA";
    private static final String UPDATED_LOCATION = "BBBBBBBBBB";

    private static final Integer DEFAULT_MAX_ATTENDEES = 1;
    private static final Integer UPDATED_MAX_ATTENDEES = 2;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseSearchRepository courseSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restCourseMockMvc;

    private Course course;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        CourseResource courseResource = new CourseResource(courseRepository, courseSearchRepository);
        this.restCourseMockMvc = MockMvcBuilders.standaloneSetup(courseResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Course createEntity(EntityManager em) {
        Course course = new Course()
            .title(DEFAULT_TITLE)
            .description(DEFAULT_DESCRIPTION)
            .start(DEFAULT_START)
            .end(DEFAULT_END)
            .location(DEFAULT_LOCATION)
            .maxAttendees(DEFAULT_MAX_ATTENDEES);
        return course;
    }

    @Before
    public void initTest() {
        courseSearchRepository.deleteAll();
        course = createEntity(em);
    }

    @Test
    @Transactional
    public void createCourse() throws Exception {
        int databaseSizeBeforeCreate = courseRepository.findAll().size();

        // Create the Course
        restCourseMockMvc.perform(post("/api/courses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(course)))
            .andExpect(status().isCreated());

        // Validate the Course in the database
        List<Course> courseList = courseRepository.findAll();
        assertThat(courseList).hasSize(databaseSizeBeforeCreate + 1);
        Course testCourse = courseList.get(courseList.size() - 1);
        assertThat(testCourse.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testCourse.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testCourse.getStart()).isEqualTo(DEFAULT_START);
        assertThat(testCourse.getEnd()).isEqualTo(DEFAULT_END);
        assertThat(testCourse.getLocation()).isEqualTo(DEFAULT_LOCATION);
        assertThat(testCourse.getMaxAttendees()).isEqualTo(DEFAULT_MAX_ATTENDEES);

        // Validate the Course in Elasticsearch
        Course courseEs = courseSearchRepository.findOne(testCourse.getId());
        assertThat(courseEs).isEqualTo(testCourse);
    }

    @Test
    @Transactional
    public void createCourseWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = courseRepository.findAll().size();

        // Create the Course with an existing ID
        course.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCourseMockMvc.perform(post("/api/courses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(course)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Course> courseList = courseRepository.findAll();
        assertThat(courseList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllCourses() throws Exception {
        // Initialize the database
        courseRepository.saveAndFlush(course);

        // Get all the courseList
        restCourseMockMvc.perform(get("/api/courses?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(course.getId().intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE.toString())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].start").value(hasItem(sameInstant(DEFAULT_START))))
            .andExpect(jsonPath("$.[*].end").value(hasItem(sameInstant(DEFAULT_END))))
            .andExpect(jsonPath("$.[*].location").value(hasItem(DEFAULT_LOCATION.toString())))
            .andExpect(jsonPath("$.[*].maxAttendees").value(hasItem(DEFAULT_MAX_ATTENDEES)));
    }

    @Test
    @Transactional
    public void getCourse() throws Exception {
        // Initialize the database
        courseRepository.saveAndFlush(course);

        // Get the course
        restCourseMockMvc.perform(get("/api/courses/{id}", course.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(course.getId().intValue()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.start").value(sameInstant(DEFAULT_START)))
            .andExpect(jsonPath("$.end").value(sameInstant(DEFAULT_END)))
            .andExpect(jsonPath("$.location").value(DEFAULT_LOCATION.toString()))
            .andExpect(jsonPath("$.maxAttendees").value(DEFAULT_MAX_ATTENDEES));
    }

    @Test
    @Transactional
    public void getNonExistingCourse() throws Exception {
        // Get the course
        restCourseMockMvc.perform(get("/api/courses/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCourse() throws Exception {
        // Initialize the database
        courseRepository.saveAndFlush(course);
        courseSearchRepository.save(course);
        int databaseSizeBeforeUpdate = courseRepository.findAll().size();

        // Update the course
        Course updatedCourse = courseRepository.findOne(course.getId());
        updatedCourse
            .title(UPDATED_TITLE)
            .description(UPDATED_DESCRIPTION)
            .start(UPDATED_START)
            .end(UPDATED_END)
            .location(UPDATED_LOCATION)
            .maxAttendees(UPDATED_MAX_ATTENDEES);

        restCourseMockMvc.perform(put("/api/courses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedCourse)))
            .andExpect(status().isOk());

        // Validate the Course in the database
        List<Course> courseList = courseRepository.findAll();
        assertThat(courseList).hasSize(databaseSizeBeforeUpdate);
        Course testCourse = courseList.get(courseList.size() - 1);
        assertThat(testCourse.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testCourse.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testCourse.getStart()).isEqualTo(UPDATED_START);
        assertThat(testCourse.getEnd()).isEqualTo(UPDATED_END);
        assertThat(testCourse.getLocation()).isEqualTo(UPDATED_LOCATION);
        assertThat(testCourse.getMaxAttendees()).isEqualTo(UPDATED_MAX_ATTENDEES);

        // Validate the Course in Elasticsearch
        Course courseEs = courseSearchRepository.findOne(testCourse.getId());
        assertThat(courseEs).isEqualTo(testCourse);
    }

    @Test
    @Transactional
    public void updateNonExistingCourse() throws Exception {
        int databaseSizeBeforeUpdate = courseRepository.findAll().size();

        // Create the Course

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restCourseMockMvc.perform(put("/api/courses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(course)))
            .andExpect(status().isCreated());

        // Validate the Course in the database
        List<Course> courseList = courseRepository.findAll();
        assertThat(courseList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteCourse() throws Exception {
        // Initialize the database
        courseRepository.saveAndFlush(course);
        courseSearchRepository.save(course);
        int databaseSizeBeforeDelete = courseRepository.findAll().size();

        // Get the course
        restCourseMockMvc.perform(delete("/api/courses/{id}", course.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean courseExistsInEs = courseSearchRepository.exists(course.getId());
        assertThat(courseExistsInEs).isFalse();

        // Validate the database is empty
        List<Course> courseList = courseRepository.findAll();
        assertThat(courseList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchCourse() throws Exception {
        // Initialize the database
        courseRepository.saveAndFlush(course);
        courseSearchRepository.save(course);

        // Search the course
        restCourseMockMvc.perform(get("/api/_search/courses?query=id:" + course.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(course.getId().intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE.toString())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].start").value(hasItem(sameInstant(DEFAULT_START))))
            .andExpect(jsonPath("$.[*].end").value(hasItem(sameInstant(DEFAULT_END))))
            .andExpect(jsonPath("$.[*].location").value(hasItem(DEFAULT_LOCATION.toString())))
            .andExpect(jsonPath("$.[*].maxAttendees").value(hasItem(DEFAULT_MAX_ATTENDEES)));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Course.class);
    }
}
