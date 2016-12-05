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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start")
    private ZonedDateTime start;

    @Column(name = "end")
    private ZonedDateTime end;

    @Column(name = "location")
    private String location;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "course_dependencies",
               joinColumns = @JoinColumn(name="courses_id", referencedColumnName="ID"),
               inverseJoinColumns = @JoinColumn(name="dependencies_id", referencedColumnName="ID"))
    private Set<Skill> dependencies = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "course_skills_to_learn",
               joinColumns = @JoinColumn(name="courses_id", referencedColumnName="ID"),
               inverseJoinColumns = @JoinColumn(name="skills_to_learns_id", referencedColumnName="ID"))
    private Set<Skill> skillsToLearns = new HashSet<>();

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

    public Set<Skill> getDependencies() {
        return dependencies;
    }

    public Course dependencies(Set<Skill> skills) {
        this.dependencies = skills;
        return this;
    }

    public Course addDependencies(Skill skill) {
        dependencies.add(skill);
        return this;
    }

    public Course removeDependencies(Skill skill) {
        dependencies.remove(skill);
        return this;
    }

    public void setDependencies(Set<Skill> skills) {
        this.dependencies = skills;
    }

    public Set<Skill> getSkillsToLearns() {
        return skillsToLearns;
    }

    public Course skillsToLearns(Set<Skill> skills) {
        this.skillsToLearns = skills;
        return this;
    }

    public Course addSkillsToLearn(Skill skill) {
        skillsToLearns.add(skill);
        return this;
    }

    public Course removeSkillsToLearn(Skill skill) {
        skillsToLearns.remove(skill);
        return this;
    }

    public void setSkillsToLearns(Set<Skill> skills) {
        this.skillsToLearns = skills;
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
