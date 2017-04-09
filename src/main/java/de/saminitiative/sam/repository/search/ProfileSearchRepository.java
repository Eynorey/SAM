package de.saminitiative.sam.repository.search;

import de.saminitiative.sam.domain.Profile;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Profile entity.
 */
public interface ProfileSearchRepository extends ElasticsearchRepository<Profile, Long> {
}
