package de.saminitiative.sam.web.rest;

import com.codahale.metrics.annotation.Timed;
import de.saminitiative.sam.domain.Profile;
import de.saminitiative.sam.repository.ProfileRepository;
import de.saminitiative.sam.repository.search.ProfileSearchRepository;
import de.saminitiative.sam.web.rest.util.HeaderUtil;
import de.saminitiative.sam.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * REST controller for managing Profile.
 */
@RestController
@RequestMapping("/api")
public class ProfileResource {

    private final Logger log = LoggerFactory.getLogger(ProfileResource.class);

    private static final String ENTITY_NAME = "profile";

    private final ProfileRepository profileRepository;

    private final ProfileSearchRepository profileSearchRepository;

    public ProfileResource(ProfileRepository profileRepository, ProfileSearchRepository profileSearchRepository) {
        this.profileRepository = profileRepository;
        this.profileSearchRepository = profileSearchRepository;
    }

    /**
     * PUT  /profiles : Updates an existing profile.
     *
     * @param profile the profile to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated profile,
     * or with status 400 (Bad Request) if the profile is not valid,
     * or with status 500 (Internal Server Error) if the profile couldnt be updated
     */
    @PutMapping("/profiles")
    @Timed
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        log.debug("REST request to update Profile : {}", profile);
        if (profile.getId() == null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idnull", "A new profile has to be created via registration. Updated profiles must have an id.")).body(null);
        }
        Profile result = profileRepository.save(profile);
        profileSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, profile.getId().toString()))
            .body(result);
    }

    /**
     * GET  /profiles : get all the profiles.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of profiles in body
     */
    @GetMapping("/profiles")
    @Timed
    public ResponseEntity<List<Profile>> getAllProfiles(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Profiles");
        Page<Profile> page = profileRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/profiles");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /profiles/:id : get the "id" profile.
     *
     * @param id the id of the profile to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the profile, or with status 404 (Not Found)
     */
    @GetMapping("/profiles/{id}")
    @Timed
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        log.debug("REST request to get Profile : {}", id);
        Profile profile = profileRepository.findOneWithEagerRelationships(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(profile));
    }

    /**
     * DELETE  /profiles/:id : delete the "id" profile.
     *
     * @param id the id of the profile to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/profiles/{id}")
    @Timed
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        log.debug("REST request to delete Profile : {}", id);
        profileRepository.delete(id);
        profileSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/profiles?query=:query : search for the profile corresponding
     * to the query.
     *
     * @param query the query of the profile search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/profiles")
    @Timed
    public ResponseEntity<List<Profile>> searchProfiles(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Profiles for query {}", query);
        Page<Profile> page = profileSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/profiles");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }


}
