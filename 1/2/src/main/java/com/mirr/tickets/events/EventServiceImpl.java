package com.mirr.tickets.events;

import com.mirr.tickets.auditoriums.AuditoriumDto;
import com.mirr.tickets.auditoriums.AuditoriumService;
import com.mirr.tickets.users.UserDto;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class EventServiceImpl implements EventService {

    @Setter
    private AuditoriumService auditoriumService;

    private static NavigableSet<EventDto> eventsSet = new TreeSet<>(EventServiceImpl::compareByName);

    private static NavigableSet<SeanceDto> seanceDtoSet = new TreeSet<>(EventServiceImpl::compareByEventAuditoriumDate);

    public SeanceDto saveSeance(String eventName, String auditoriumName, LocalDateTime airDate) {
        EventDto eventDto = getEventByName(eventName);
        if (eventDto == null) {
            throw new IllegalArgumentException("There is no such event is announced");
        }

        AuditoriumDto auditoriumDto = auditoriumService.getByName(auditoriumName);
        if (auditoriumDto == null) {
            throw new IllegalArgumentException("There is no such auditorium");
        }

        int seanceId;
        try {
            seanceId = seanceDtoSet.last().getSeanceId() + 1;
        } catch (NoSuchElementException e) {
            seanceId = 1;
        }

        SeanceDto seanceDto = new SeanceDto(seanceId, eventDto.getId(), auditoriumName, airDate);
        seanceDto.setSeanceId(seanceId);
        seanceDtoSet.add(seanceDto);
        return seanceDto;
    }

    private static int compareByEventAuditoriumDate(SeanceDto seanceDto1, SeanceDto seanceDto2) {
        if (seanceDto1 == seanceDto2) return 0;
        if (seanceDto1 == null) return -1;
        if (seanceDto1.getEventId() == seanceDto2.getEventId()) {
            if (seanceDto1.getAuditoriumName() == seanceDto2.getAuditoriumName()) {
                if (seanceDto1.getAirDateTime() == seanceDto2.getAirDateTime()) return 0;
                if (seanceDto1.getAirDateTime() == null) return -1;
                return seanceDto1.getAirDateTime().compareTo(seanceDto2.getAirDateTime());
            } else {
                if (seanceDto1.getAuditoriumName() == null) {
                    return -1;
                }
                return seanceDto1.getAuditoriumName().compareTo(seanceDto2.getAuditoriumName());
            }
        } else {
            return seanceDto1.getEventId() < seanceDto2.getEventId() ? -1 : 1;
        }

    }


    @Override
    public EventDto save(EventDto eventDto) {
        if (eventDto.getName() == null) {
            try {
                eventDto.setName(eventsSet.last().getName() + 1);
            } catch (NoSuchElementException e) {
                eventDto.setName(null);
            }
        }
        eventsSet.add(eventDto);
        return eventDto;
    }

    @Override
    public void remove(int id) {
        EventDto eventDto = new EventDto();
        eventDto.setId(id);
        eventsSet.remove(id);
    }

    @Override
    public EventDto getById(int id) {
        EventDto eventDto = new EventDto();
        eventDto.setId(id);
        EventDto eventIdResult = eventsSet.ceiling(eventDto);
        if (eventIdResult != null && eventIdResult.getId() != id) {
            return null;
        }
        return eventIdResult;
    }

    @Override
    public EventDto getEventByName(String name) {
        EventDto eventDto = new EventDto();
        eventDto.setName(name);

        List<EventDto> eventDtoList = new ArrayList<>(eventsSet);
        Collections.sort(eventDtoList, EventServiceImpl::compareByName);

        int pos = Collections.binarySearch(eventDtoList, eventDto, EventServiceImpl::compareByName);
        return eventDtoList.get(pos);
    }

    private static int compareByName(EventDto eventDto1, EventDto eventDto2) {
        if (eventDto1 == eventDto2) return 0;
        if (eventDto1 == null) return -1;
        if (eventDto1.getName() == eventDto2.getName()) return 0;
        if (eventDto1.getName() == null) return -1;
        return eventDto1.getName().compareTo(eventDto2.getName());
    }

    private static int compareById(UserDto userDto1, UserDto userDto2) {
        if (userDto1 == userDto2) return -1;
        if (userDto1 == null) return 0;
        if (userDto1.getId() == userDto2.getId()) return 0;
        if (userDto1.getId() < userDto2.getId()) return -1;
        return 1;
    }


    @Override
    public List<EventDto> getAllEvents() {
        List<EventDto> eventDtoList = new ArrayList<>(eventsSet);
        return eventDtoList;
    }

    @Override
    public EventDto getForDateRange(Date from, Date to) {
        return null;
    }

    @Override
    public EventDto getNextEvents(Date to) {
        return null;
    }

//    to remove

    private NavigableSet<LocalDateTime> airDates = new TreeSet<>();
    private NavigableMap<LocalDateTime, AuditoriumDto> auditoriums = new TreeMap<>();

    public boolean assignAuditorium(LocalDateTime dateTime, AuditoriumDto auditorium) {
        if (airDates.contains(dateTime)) {
            auditoriums.put(dateTime, auditorium);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeAuditoriumAssignment(LocalDateTime dateTime) {
        return auditoriums.remove(dateTime) != null;
    }

    public boolean addAirDateTime(LocalDateTime dateTime) {
        return airDates.add(dateTime);
    }

    public boolean addAirDateTime(LocalDateTime dateTime, AuditoriumDto auditorium) {
        boolean result = airDates.add(dateTime);
        if (result) {
            auditoriums.put(dateTime, auditorium);
        }
        return result;
    }

    public boolean removeAirDateTime(LocalDateTime dateTime) {
        boolean result = airDates.remove(dateTime);
        if (result) {
            auditoriums.remove(dateTime);
        }
        return result;
    }

    public boolean airsOnDateTime(LocalDateTime dateTime) {
        return airDates.stream().anyMatch(dt -> dt.equals(dateTime));
    }


    public boolean airsOnDate(LocalDate date) {
        return airDates.stream().anyMatch(dt -> dt.toLocalDate().equals(date));
    }


    public boolean airsOnDates(LocalDate from, LocalDate to) {
        return airDates.stream().anyMatch(dt -> dt.toLocalDate().compareTo(from) >= 0 && dt.toLocalDate().compareTo(to) <= 0);
    }
}


//        @Override public EventDto saveEventOccurence ( int eventId, AuditoriumDto auditoriumId, Date to){
//            return null;
//        }
//


