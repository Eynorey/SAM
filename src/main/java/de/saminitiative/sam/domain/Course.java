package de.saminitiative.sam.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Course.
 */
@Entity
@Table(name = "course")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "jhi_start")
    private ZonedDateTime start;

    @Column(name = "jhi_end")
    private ZonedDateTime end;

    @Column(name = "location")
    private String location;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "course_implied_skills",
               joinColumns = @JoinColumn(name="courses_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="implied_skills_id", referencedColumnName="id"))
    private Set<Skill> impliedSkills = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "course_acquirable_skills",
               joinColumns = @JoinColumn(name="courses_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="acquirable_skills_id", referencedColumnName="id"))
    private Set<Skill> acquirableSkills = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "course_attendees",
               joinColumns = @JoinColumn(name="courses_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="attendees_id", referencedColumnName="id"))
    private Set<User> attendees = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "course_teachers",
               joinColumns = @JoinColumn(name="courses_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="teachers_id", referencedColumnName="id"))
    private Set<User> teachers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Course title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Course description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public Course start(ZonedDateTime start) {
        this.start = start;
        return this;
    }

    public void setStart(ZonedDateTime start) {
        this.start = start;
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    public Course end(ZonedDateTime end) {
        this.end = end;
        return this;
    }

    public void setEnd(ZonedDateTime end) {
        this.end = end;
    }

    public String getLocation() {
        return location;
    }

    public Course location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Skill> getImpliedSkills() {
        return impliedSkills;
    }

    public Course impliedSkills(Set<Skill> skills) {
        this.impliedSkills = skills;
        return this;
    }

    public Course addImpliedSkills(Skill skill) {
        this.impliedSkills.add(skill);
        return this;
    }

    public Course removeImpliedSkills(Skill skill) {
        this.impliedSkills.remove(skill);
        return this;
    }

    public void setImpliedSkills(Set<Skill> skills) {
        this.impliedSkills = skills;
    }

    public Set<Skill> getAcquirableSkills() {
        return acquirableSkills;
    }

    public Course acquirableSkills(Set<Skill> skills) {
        this.acquirableSkills = skills;
        return this;
    }

    public Course addAcquirableSkills(Skill skill) {
        this.acquirableSkills.add(skill);
        return this;
    }

    public Course removeAcquirableSkills(Skill skill) {
        this.acquirableSkills.remove(skill);
        return this;
    }

    public void setAcquirableSkills(Set<Skill> skills) {
        this.acquirableSkills = skills;
    }

    public Set<User> getAttendees() {
        return attendees;
    }

    public Course attendees(Set<User> users) {
        this.attendees = users;
        return this;
    }

    public Course addAttendees(User user) {
        this.attendees.add(user);
        return this;
    }

    public Course removeAttendees(User user) {
        this.attendees.remove(user);
        return this;
    }

    public void setAttendees(Set<User> users) {
        this.attendees = users;
    }

    public Set<User> getTeachers() {
        return teachers;
    }

    public Course teachers(Set<User> users) {
        this.teachers = users;
        return this;
    }

    public Course addTeachers(User user) {
        this.teachers.add(user);
        return this;
    }

    public Course removeTeachers(User user) {
        this.teachers.remove(user);
        return this;
    }

    public void setTeachers(Set<User> users) {
        this.teachers = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        if (course.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Course{" +
            "id=" + id +
            ", title='" + title + "'" +
            ", description='" + description + "'" +
            ", start='" + start + "'" +
            ", end='" + end + "'" +
            ", location='" + location + "'" +
            '}';
    }
}
