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
 * A Profile.
 */
@Entity
@Table(name = "profile")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "profile")
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "credibility")
    private Integer credibility;

    @Column(name = "credits")
    private Double credits;

    @Column(name = "jhi_degree")
    private String degree;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "university")
    private String university;

    @Column(name = "birthday")
    private ZonedDateTime birthday;

    @OneToOne
    @MapsId
    @JoinColumn(unique = true)
    private User user;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "profile_offered_courses",
               joinColumns = @JoinColumn(name="profiles_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="offered_courses_id", referencedColumnName="id"))
    private Set<Course> offeredCourses = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "profile_occupied_courses",
               joinColumns = @JoinColumn(name="profiles_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="occupied_courses_id", referencedColumnName="id"))
    private Set<Course> occupiedCourses = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "profile_skills",
               joinColumns = @JoinColumn(name="profiles_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="skills_id", referencedColumnName="id"))
    private Set<Skill> skills = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCredibility() {
        return credibility;
    }

    public Profile credibility(Integer credibility) {
        this.credibility = credibility;
        return this;
    }

    public void setCredibility(Integer credibility) {
        this.credibility = credibility;
    }

    public Double getCredits() {
        return credits;
    }

    public Profile credits(Double credits) {
        this.credits = credits;
        return this;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public String getDegree() {
        return degree;
    }

    public Profile degree(String degree) {
        this.degree = degree;
        return this;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Integer getSemester() {
        return semester;
    }

    public Profile semester(Integer semester) {
        this.semester = semester;
        return this;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getFaculty() {
        return faculty;
    }

    public Profile faculty(String faculty) {
        this.faculty = faculty;
        return this;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getUniversity() {
        return university;
    }

    public Profile university(String university) {
        this.university = university;
        return this;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public Profile birthday(ZonedDateTime birthday) {
        this.birthday = birthday;
        return this;
    }

    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

    public User getUser() {
        return user;
    }

    public Profile user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Course> getOfferedCourses() {
        return offeredCourses;
    }

    public Profile offeredCourses(Set<Course> courses) {
        this.offeredCourses = courses;
        return this;
    }

    public Profile addOfferedCourses(Course course) {
        this.offeredCourses.add(course);
        return this;
    }

    public Profile removeOfferedCourses(Course course) {
        this.offeredCourses.remove(course);
        return this;
    }

    public void setOfferedCourses(Set<Course> courses) {
        this.offeredCourses = courses;
    }

    public Set<Course> getOccupiedCourses() {
        return occupiedCourses;
    }

    public Profile occupiedCourses(Set<Course> courses) {
        this.occupiedCourses = courses;
        return this;
    }

    public Profile addOccupiedCourses(Course course) {
        this.occupiedCourses.add(course);
        return this;
    }

    public Profile removeOccupiedCourses(Course course) {
        this.occupiedCourses.remove(course);
        return this;
    }

    public void setOccupiedCourses(Set<Course> courses) {
        this.occupiedCourses = courses;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public Profile skills(Set<Skill> skills) {
        this.skills = skills;
        return this;
    }

    public Profile addSkills(Skill skill) {
        this.skills.add(skill);
        return this;
    }

    public Profile removeSkills(Skill skill) {
        this.skills.remove(skill);
        return this;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        if (profile.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Profile{" +
            "id=" + id +
            ", credibility='" + credibility + "'" +
            ", credits='" + credits + "'" +
            ", degree='" + degree + "'" +
            ", semester='" + semester + "'" +
            ", faculty='" + faculty + "'" +
            ", university='" + university + "'" +
            ", birthday='" + birthday + "'" +
            '}';
    }
}
