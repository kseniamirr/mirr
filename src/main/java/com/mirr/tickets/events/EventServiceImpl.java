package com.mirr.tickets.events;

import com.mirr.tickets.auditoriums.AuditoriumDto;
import com.mirr.tickets.users.UserDto;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class EventServiceImpl implements EventService {

    private static NavigableSet<EventDto> navigableSetEvents = new TreeSet<>(EventServiceImpl::compareByName);
    private NavigableSet<LocalDateTime> airDates = new TreeSet<>();
    private NavigableMap<LocalDateTime, AuditoriumDto> auditoriums = new TreeMap<>();

    @Override
    public EventDto save(EventDto eventDto) {
        if (eventDto.getName() == null) {
            try {
                eventDto.setName(navigableSetEvents.last().getName() + 1);
            } catch (NoSuchElementException e) {
                eventDto.setName(null);
            }
        }
        navigableSetEvents.add(eventDto);
        return eventDto;
    }

    @Override
    public void remove(int id) {
        EventDto eventDto = new EventDto();
        eventDto.setId(id);
        navigableSetEvents.remove(id);
    }

    @Override
    public EventDto getById(int id) {
        EventDto eventDto = new EventDto();
        eventDto.setId(id);
        EventDto eventIdResult = navigableSetEvents.ceiling(eventDto);
        if (eventIdResult != null && eventIdResult.getId() != id) {
            return null;
        }
        return eventIdResult;
    }

    @Override
    public EventDto getEventByName(String name) {
        EventDto eventDto = new EventDto();
        eventDto.setName(name);

        List<EventDto> eventDtoList = new ArrayList<>(navigableSetEvents);
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
    public List<EventDto> getAll() {
        List<EventDto> eventDtoList = new ArrayList<>(navigableSetEvents);
        return eventDtoList;
    }

    public boolean assignAuditorium(LocalDateTime dateTime, AuditoriumDto auditorium) {
        if (airDates.contains(dateTime)) {
            auditoriums.put(dateTime, auditorium);
            return true;
        } else {
            return false;
        }
    }

        public boolean removeAuditoriumAssignment (LocalDateTime dateTime){
            return auditoriums.remove(dateTime) != null;
        }

        public boolean addAirDateTime (LocalDateTime dateTime){
            return airDates.add(dateTime);
        }
        public boolean addAirDateTime (LocalDateTime dateTime, AuditoriumDto auditorium){
            boolean result = airDates.add(dateTime);
            if (result) {
                auditoriums.put(dateTime, auditorium);
            }
            return result;
        }

        public boolean removeAirDateTime (LocalDateTime dateTime){
            boolean result = airDates.remove(dateTime);
            if (result) {
                auditoriums.remove(dateTime);
            }
            return result;
        }

        public boolean airsOnDateTime (LocalDateTime dateTime){
            return airDates.stream().anyMatch(dt -> dt.equals(dateTime));
        }


        public boolean airsOnDate (LocalDate date){
            return airDates.stream().anyMatch(dt -> dt.toLocalDate().equals(date));
        }


        public boolean airsOnDates (LocalDate from, LocalDate to){
            return airDates.stream().anyMatch(dt -> dt.toLocalDate().compareTo(from) >= 0 && dt.toLocalDate().compareTo(to) <= 0);
        }
    }



//        @Override public EventDto saveEventOccurence ( int eventId, AuditoriumDto auditoriumId, Date to){
//            return null;
//        }
//
//        @Override public EventDto getForDateRange (Date from, Date to){
//            return null;
//        }
//
//        @Override public EventDto getNextEvents (Date to){
//            return null;
//        }


