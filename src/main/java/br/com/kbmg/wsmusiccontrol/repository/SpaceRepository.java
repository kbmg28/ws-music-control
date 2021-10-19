package br.com.kbmg.wsmusiccontrol.repository;

import br.com.kbmg.wsmusiccontrol.model.Space;
import br.com.kbmg.wsmusiccontrol.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {

    Optional<Space> findByName(String name);

    @Query("SELECT ass.space from SpaceUserAppAssociation ass where ass.space.id = :spaceId and ass.userApp = :userApp")
    Optional<Space> findByIdAndUserApp(Long spaceId, UserApp userApp);
}
