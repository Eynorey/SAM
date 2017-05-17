package de.saminitiative.sam.service;

import de.saminitiative.sam.domain.Course;
import de.saminitiative.sam.domain.Profile;
import de.saminitiative.sam.domain.User;
import de.saminitiative.sam.repository.ProfileRepository;
import de.saminitiative.sam.repository.search.ProfileSearchRepository;
import de.saminitiative.sam.repository.search.UserSearchRepository;
import org.elasticsearch.common.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Service class for managing courses.
 */
@Service
@Transactional
public class CourseService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserSearchRepository userSearchRepository;

    @Inject
    private ProfileRepository profileRepository;

    @Inject
    private ProfileSearchRepository profileSearchRepository;

    public CourseService(UserSearchRepository userSearchRepository) {
        this.userSearchRepository = userSearchRepository;
    }

    public List<User> getBookedBy (Course course) {
        Iterable<Profile> profiles = profileSearchRepository.findAll();
        List<User> bookedBy = new LinkedList<>();
        for (Profile profile : profiles) {
            if (profile.getOccupiedCourses().contains(course)) {
                bookedBy.add(userSearchRepository.findOne(profile.getId()));
            }
        }
        return bookedBy;
    }

}
