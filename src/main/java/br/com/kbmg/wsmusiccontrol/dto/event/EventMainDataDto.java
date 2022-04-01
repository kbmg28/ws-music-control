package br.com.kbmg.wsmusiccontrol.dto.event;

import br.com.kbmg.wsmusiccontrol.dto.music.MusicOnlyIdAndMusicNameAndSingerNameDto;
import br.com.kbmg.wsmusiccontrol.dto.music.MusicSimpleToEventDto;
import br.com.kbmg.wsmusiccontrol.model.Event;
import lombok.Data;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
public class EventMainDataDto {

    private String id;
    private LocalDate dateEvent;
    private LocalTime timeEvent;
    private String timeZoneName;
    private String nameEvent;

    @Valid private Set<MusicSimpleToEventDto> musicList;

    public EventMainDataDto(Event event, Set<MusicSimpleToEventDto> musicList) {
        this.id = event.getId();
        this.dateEvent = event.getDateEvent();
        this.timeEvent = event.getTimeEvent();
        this.timeZoneName = event.getTimeZoneName();
        this.nameEvent = event.getName();
        this.musicList = musicList;
    }
}
