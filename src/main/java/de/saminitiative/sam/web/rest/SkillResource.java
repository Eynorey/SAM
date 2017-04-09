package de.saminitiative.sam.web.rest;

import com.codahale.metrics.annotation.Timed;
import de.saminitiative.sam.domain.Skill;

import de.saminitiative.sam.repository.SkillRepository;
import de.saminitiative.sam.repository.search.SkillSearchRepository;
import de.saminitiative.sam.web.rest.util.HeaderUtil;
import de.saminitiative.sam.web.rest.util.PaginationUtil;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing Skill.
 */
@RestController
@RequestMapping("/api")
public class SkillResource {

    private final Logger log = LoggerFactory.getLogger(SkillResource.class);

    private static final String ENTITY_NAME = "skill";
        
    private final SkillRepository skillRepository;

    private final SkillSearchRepository skillSearchRepository;

    public SkillResource(SkillRepository skillRepository, SkillSearchRepository skillSearchRepository) {
        this.skillRepository = skillRepository;
        this.skillSearchRepository = skillSearchRepository;
    }

    /**
     * POST  /skills : Create a new skill.
     *
     * @param skill the skill to create
     * @return the ResponseEntity with status 201 (Created) and with body the new skill, or with status 400 (Bad Request) if the skill has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/skills")
    @Timed
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) throws URISyntaxException {
        log.debug("REST request to save Skill : {}", skill);
        if (skill.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new skill cannot already have an ID")).body(null);
        }
        Skill result = skillRepository.save(skill);
        skillSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/skills/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /skills : Updates an existing skill.
     *
     * @param skill the skill to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated skill,
     * or with status 400 (Bad Request) if the skill is not valid,
     * or with status 500 (Internal Server Error) if the skill couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/skills")
    @Timed
    public ResponseEntity<Skill> updateSkill(@RequestBody Skill skill) throws URISyntaxException {
        log.debug("REST request to update Skill : {}", skill);
        if (skill.getId() == null) {
            return createSkill(skill);
        }
        Skill result = skillRepository.save(skill);
        skillSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, skill.getId().toString()))
            .body(result);
    }

    /**
     * GET  /skills : get all the skills.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of skills in body
     */
    @GetMapping("/skills")
    @Timed
    public ResponseEntity<List<Skill>> getAllSkills(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Skills");
        Page<Skill> page = skillRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/skills");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /skills/:id : get the "id" skill.
     *
     * @param id the id of the skill to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the skill, or with status 404 (Not Found)
     */
    @GetMapping("/skills/{id}")
    @Timed
    public ResponseEntity<Skill> getSkill(@PathVariable Long id) {
        log.debug("REST request to get Skill : {}", id);
        Skill skill = skillRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(skill));
    }

    /**
     * DELETE  /skills/:id : delete the "id" skill.
     *
     * @param id the id of the skill to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/skills/{id}")
    @Timed
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        log.debug("REST request to delete Skill : {}", id);
        skillRepository.delete(id);
        skillSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/skills?query=:query : search for the skill corresponding
     * to the query.
     *
     * @param query the query of the skill search 
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/skills")
    @Timed
    public ResponseEntity<List<Skill>> searchSkills(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Skills for query {}", query);
        Page<Skill> page = skillSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/skills");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }


}
