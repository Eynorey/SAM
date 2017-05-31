package de.saminitiative.sam.repository;

import de.saminitiative.sam.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Skill entity.
 */
@SuppressWarnings("unused")
public interface SkillRepository extends JpaRepository<Skill,Long> {

}
