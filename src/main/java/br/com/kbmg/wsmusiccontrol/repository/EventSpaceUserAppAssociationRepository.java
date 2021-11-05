package br.com.kbmg.wsmusiccontrol.repository;

import br.com.kbmg.wsmusiccontrol.model.Event;
import br.com.kbmg.wsmusiccontrol.model.EventSpaceUserAppAssociation;
import br.com.kbmg.wsmusiccontrol.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventSpaceUserAppAssociationRepository extends JpaRepository<EventSpaceUserAppAssociation, String> {

    @Query("SELECT su.userApp from EventSpaceUserAppAssociation esu join esu.spaceUserAppAssociation su where esu.event = :event")
    List<UserApp> findAllUserAppByEvent(Event event);
}
