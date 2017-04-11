package de.saminitiative.sam.web.rest.vm;

import de.saminitiative.sam.service.dto.UserDTO;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import java.time.ZonedDateTime;
import java.util.Set;

/**
 * View Model extending the UserDTO, which is meant to be used in the user management UI.
 */
public class ManagedUserVM extends UserDTO {

    public static final int PASSWORD_MIN_LENGTH = 4;

    public static final int PASSWORD_MAX_LENGTH = 100;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    //Properties from Profile
    private String degree;

    private Integer semester;

    private String faculty;

    private String university;

    private ZonedDateTime birthday;

    public ManagedUserVM() {
        // Empty constructor needed for Jackson.
    }

    public ManagedUserVM(Long id, String login, String password, String firstName, String lastName,
                         String email, boolean activated, String imageUrl, String langKey,
                         String createdBy, ZonedDateTime createdDate, String lastModifiedBy, ZonedDateTime lastModifiedDate,
                        Set<String> authorities,

                         //Profile Properties
                         String degree, Integer semester, String faculty, String university, ZonedDateTime birthday) {

        super(id, login, firstName, lastName, email, activated, imageUrl, langKey,
            createdBy, createdDate, lastModifiedBy, lastModifiedDate,  authorities);

        this.password = password;

        //Profile properties
        this.degree = degree;
        this. semester = semester;
        this.faculty = faculty;
        this.university = university;
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    //Getters for Profile
    public String getDegree() {
        return degree;
    }

    public Integer getSemester() {
        return semester;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getUniversity() {
        return university;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "ManagedUserVM{" +
            super.toString() + '\'' +
            "degree='" + degree + '\'' +
            ", semester=" + semester +
            ", faculty='" + faculty + '\'' +
            ", university='" + university + '\'' +
            ", birthday=" + birthday +
            '}';
    }
}
