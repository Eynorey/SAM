package de.saminitiative.sam.repository.search;

import de.saminitiative.sam.domain.Skill;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Skill entity.
 */
public interface SkillSearchRepository extends ElasticsearchRepository<Skill, Long> {
}
