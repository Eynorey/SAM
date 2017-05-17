package de.saminitiative.sam.web.rest;

import de.saminitiative.sam.SamApp;

import de.saminitiative.sam.domain.Profile;
import de.saminitiative.sam.repository.ProfileRepository;
import de.saminitiative.sam.repository.search.ProfileSearchRepository;
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
 * Test class for the ProfileResource REST controller.
 *
 * @see ProfileResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SamApp.class)
public class ProfileResourceIntTest {

    private static final Integer DEFAULT_CREDIBILITY = 1;
    private static final Integer UPDATED_CREDIBILITY = 2;

    private static final Double DEFAULT_CREDITS = 1D;
    private static final Double UPDATED_CREDITS = 2D;

    private static final String DEFAULT_DEGREE = "AAAAAAAAAA";
    private static final String UPDATED_DEGREE = "BBBBBBBBBB";

    private static final Integer DEFAULT_SEMESTER = 1;
    private static final Integer UPDATED_SEMESTER = 2;

    private static final String DEFAULT_FACULTY = "AAAAAAAAAA";
    private static final String UPDATED_FACULTY = "BBBBBBBBBB";

    private static final String DEFAULT_UNIVERSITY = "AAAAAAAAAA";
    private static final String UPDATED_UNIVERSITY = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_BIRTHDAY = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_BIRTHDAY = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileSearchRepository profileSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restProfileMockMvc;

    private Profile profile;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ProfileResource profileResource = new ProfileResource(profileRepository, profileSearchRepository);
        this.restProfileMockMvc = MockMvcBuilders.standaloneSetup(profileResource)
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
    public static Profile createEntity(EntityManager em) {
        Profile profile = new Profile()
            .credibility(DEFAULT_CREDIBILITY)
            .credits(DEFAULT_CREDITS)
            .degree(DEFAULT_DEGREE)
            .semester(DEFAULT_SEMESTER)
            .faculty(DEFAULT_FACULTY)
            .university(DEFAULT_UNIVERSITY)
            .birthday(DEFAULT_BIRTHDAY);
        return profile;
    }

    @Before
    public void initTest() {
        profileSearchRepository.deleteAll();
        profile = createEntity(em);
    }

    @Test
    @Transactional
    public void createProfile() throws Exception {
        int databaseSizeBeforeCreate = profileRepository.findAll().size();

        // Create the Profile
        restProfileMockMvc.perform(post("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(profile)))
            .andExpect(status().isCreated());

        // Validate the Profile in the database
        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeCreate + 1);
        Profile testProfile = profileList.get(profileList.size() - 1);
        assertThat(testProfile.getCredibility()).isEqualTo(DEFAULT_CREDIBILITY);
        assertThat(testProfile.getCredits()).isEqualTo(DEFAULT_CREDITS);
        assertThat(testProfile.getDegree()).isEqualTo(DEFAULT_DEGREE);
        assertThat(testProfile.getSemester()).isEqualTo(DEFAULT_SEMESTER);
        assertThat(testProfile.getFaculty()).isEqualTo(DEFAULT_FACULTY);
        assertThat(testProfile.getUniversity()).isEqualTo(DEFAULT_UNIVERSITY);
        assertThat(testProfile.getBirthday()).isEqualTo(DEFAULT_BIRTHDAY);

        // Validate the Profile in Elasticsearch
        Profile profileEs = profileSearchRepository.findOne(testProfile.getId());
        assertThat(profileEs).isEqualToComparingFieldByField(testProfile);
    }

    @Test
    @Transactional
    public void createProfileWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = profileRepository.findAll().size();

        // Create the Profile with an existing ID
        profile.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProfileMockMvc.perform(post("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(profile)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllProfiles() throws Exception {
        // Initialize the database
        profileRepository.saveAndFlush(profile);

        // Get all the profileList
        restProfileMockMvc.perform(get("/api/profiles?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(profile.getId().intValue())))
            .andExpect(jsonPath("$.[*].credibility").value(hasItem(DEFAULT_CREDIBILITY)))
            .andExpect(jsonPath("$.[*].credits").value(hasItem(DEFAULT_CREDITS.doubleValue())))
            .andExpect(jsonPath("$.[*].degree").value(hasItem(DEFAULT_DEGREE.toString())))
            .andExpect(jsonPath("$.[*].semester").value(hasItem(DEFAULT_SEMESTER)))
            .andExpect(jsonPath("$.[*].faculty").value(hasItem(DEFAULT_FACULTY.toString())))
            .andExpect(jsonPath("$.[*].university").value(hasItem(DEFAULT_UNIVERSITY.toString())))
            .andExpect(jsonPath("$.[*].birthday").value(hasItem(sameInstant(DEFAULT_BIRTHDAY))));
    }

    @Test
    @Transactional
    public void getProfile() throws Exception {
        // Initialize the database
        profileRepository.saveAndFlush(profile);

        // Get the profile
        restProfileMockMvc.perform(get("/api/profiles/{id}", profile.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(profile.getId().intValue()))
            .andExpect(jsonPath("$.credibility").value(DEFAULT_CREDIBILITY))
            .andExpect(jsonPath("$.credits").value(DEFAULT_CREDITS.doubleValue()))
            .andExpect(jsonPath("$.degree").value(DEFAULT_DEGREE.toString()))
            .andExpect(jsonPath("$.semester").value(DEFAULT_SEMESTER))
            .andExpect(jsonPath("$.faculty").value(DEFAULT_FACULTY.toString()))
            .andExpect(jsonPath("$.university").value(DEFAULT_UNIVERSITY.toString()))
            .andExpect(jsonPath("$.birthday").value(sameInstant(DEFAULT_BIRTHDAY)));
    }

    @Test
    @Transactional
    public void getNonExistingProfile() throws Exception {
        // Get the profile
        restProfileMockMvc.perform(get("/api/profiles/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProfile() throws Exception {
        // Initialize the database
        profileRepository.saveAndFlush(profile);
        profileSearchRepository.save(profile);
        int databaseSizeBeforeUpdate = profileRepository.findAll().size();

        // Update the profile
        Profile updatedProfile = profileRepository.findOne(profile.getId());
        updatedProfile
            .credibility(UPDATED_CREDIBILITY)
            .credits(UPDATED_CREDITS)
            .degree(UPDATED_DEGREE)
            .semester(UPDATED_SEMESTER)
            .faculty(UPDATED_FACULTY)
            .university(UPDATED_UNIVERSITY)
            .birthday(UPDATED_BIRTHDAY);

        restProfileMockMvc.perform(put("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedProfile)))
            .andExpect(status().isOk());

        // Validate the Profile in the database
        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeUpdate);
        Profile testProfile = profileList.get(profileList.size() - 1);
        assertThat(testProfile.getCredibility()).isEqualTo(UPDATED_CREDIBILITY);
        assertThat(testProfile.getCredits()).isEqualTo(UPDATED_CREDITS);
        assertThat(testProfile.getDegree()).isEqualTo(UPDATED_DEGREE);
        assertThat(testProfile.getSemester()).isEqualTo(UPDATED_SEMESTER);
        assertThat(testProfile.getFaculty()).isEqualTo(UPDATED_FACULTY);
        assertThat(testProfile.getUniversity()).isEqualTo(UPDATED_UNIVERSITY);
        assertThat(testProfile.getBirthday()).isEqualTo(UPDATED_BIRTHDAY);

        // Validate the Profile in Elasticsearch
        Profile profileEs = profileSearchRepository.findOne(testProfile.getId());
        assertThat(profileEs).isEqualToComparingFieldByField(testProfile);
    }

    @Test
    @Transactional
    public void updateNonExistingProfile() throws Exception {
        int databaseSizeBeforeUpdate = profileRepository.findAll().size();

        // Create the Profile

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restProfileMockMvc.perform(put("/api/profiles")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(profile)))
            .andExpect(status().isCreated());

        // Validate the Profile in the database
        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteProfile() throws Exception {
        // Initialize the database
        profileRepository.saveAndFlush(profile);
        profileSearchRepository.save(profile);
        int databaseSizeBeforeDelete = profileRepository.findAll().size();

        // Get the profile
        restProfileMockMvc.perform(delete("/api/profiles/{id}", profile.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean profileExistsInEs = profileSearchRepository.exists(profile.getId());
        assertThat(profileExistsInEs).isFalse();

        // Validate the database is empty
        List<Profile> profileList = profileRepository.findAll();
        assertThat(profileList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchProfile() throws Exception {
        // Initialize the database
        profileRepository.saveAndFlush(profile);
        profileSearchRepository.save(profile);

        // Search the profile
        restProfileMockMvc.perform(get("/api/_search/profiles?query=id:" + profile.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(profile.getId().intValue())))
            .andExpect(jsonPath("$.[*].credibility").value(hasItem(DEFAULT_CREDIBILITY)))
            .andExpect(jsonPath("$.[*].credits").value(hasItem(DEFAULT_CREDITS.doubleValue())))
            .andExpect(jsonPath("$.[*].degree").value(hasItem(DEFAULT_DEGREE.toString())))
            .andExpect(jsonPath("$.[*].semester").value(hasItem(DEFAULT_SEMESTER)))
            .andExpect(jsonPath("$.[*].faculty").value(hasItem(DEFAULT_FACULTY.toString())))
            .andExpect(jsonPath("$.[*].university").value(hasItem(DEFAULT_UNIVERSITY.toString())))
            .andExpect(jsonPath("$.[*].birthday").value(hasItem(sameInstant(DEFAULT_BIRTHDAY))));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Profile.class);
    }
}
