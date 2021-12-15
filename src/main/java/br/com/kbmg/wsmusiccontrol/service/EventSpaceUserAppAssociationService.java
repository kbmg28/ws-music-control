package br.com.kbmg.wsmusiccontrol.service;

import br.com.kbmg.wsmusiccontrol.dto.event.EventMainDataDto;
import br.com.kbmg.wsmusiccontrol.dto.music.MusicOnlyIdAndMusicNameAndSingerNameDto;
import br.com.kbmg.wsmusiccontrol.dto.user.UserOnlyIdNameAndEmailDto;
import br.com.kbmg.wsmusiccontrol.enums.DatabaseOperationEnum;
import br.com.kbmg.wsmusiccontrol.model.Event;
import br.com.kbmg.wsmusiccontrol.model.EventSpaceUserAppAssociation;
import br.com.kbmg.wsmusiccontrol.model.Space;
import br.com.kbmg.wsmusiccontrol.model.UserApp;

import java.util.List;
import java.util.Set;

public interface EventSpaceUserAppAssociationService extends GenericService<EventSpaceUserAppAssociation>{
    List<UserApp> findAllUserAppByEvent(Event event);

    Set<EventSpaceUserAppAssociation> createAssociation(Space space, Event event, Set<String> userEmailList, Set<MusicOnlyIdAndMusicNameAndSingerNameDto> musicList);

    Set<EventSpaceUserAppAssociation> updateAssociations(Event eventInDatabase, Set<UserOnlyIdNameAndEmailDto> userList, Set<MusicOnlyIdAndMusicNameAndSingerNameDto> musicList);

    void sendMailNotification(EventMainDataDto eventMainDataDto,
                              Set<UserApp> userList,
                              DatabaseOperationEnum operation);
}
