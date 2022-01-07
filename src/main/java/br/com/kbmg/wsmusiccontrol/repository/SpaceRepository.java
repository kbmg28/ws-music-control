package br.com.kbmg.wsmusiccontrol.repository;

import br.com.kbmg.wsmusiccontrol.enums.SpaceStatusEnum;
import br.com.kbmg.wsmusiccontrol.model.Space;
import br.com.kbmg.wsmusiccontrol.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpaceRepository extends JpaRepository<Space, String> {

    Optional<Space> findByName(String name);

    @Query("SELECT ass.space from SpaceUserAppAssociation ass " +
            "join ass.space s " +
            "where s.id = :spaceId and s.spaceStatus = :spaceStatus and ass.userApp = :userApp")
    Optional<Space> findByIdAndSpaceStatusAndUserApp(String spaceId, SpaceStatusEnum spaceStatus, UserApp userApp);

    List<Space> findAllBySpaceStatus(SpaceStatusEnum spaceStatusEnum);
}
