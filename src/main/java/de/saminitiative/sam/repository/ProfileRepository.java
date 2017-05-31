package de.saminitiative.sam.repository;

import de.saminitiative.sam.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA repository for the Profile entity.
 */
@SuppressWarnings("unused")
public interface ProfileRepository extends JpaRepository<Profile,Long> {

    @Query("select distinct profile from Profile profile left join fetch profile.skills")
    List<Profile> findAllWithEagerRelationships();

    @Query("select profile from Profile profile left join fetch profile.skills where profile.id =:id")
    Profile findOneWithEagerRelationships(@Param("id") Long id);

}
