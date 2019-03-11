package com.mirr.tickets.discount;

import com.mirr.tickets.dao.AirDateDao;
import com.mirr.tickets.events.Event;
import com.mirr.tickets.events.Seance;
import com.mirr.tickets.ticket.Ticket;
import com.mirr.tickets.users.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * created by Oksana_Abramova
 */
@Component
public class DiscountStrategy {

    private final int USER_HAS_BIRTHDAY_WITHIN_5_DAYS_OF_AIR_DATE = 5;
    private final int DISCOUNT = 5;

    private final int EVERY_TEN_PURCHASED_TICKET_BY_USER = 10;
    private final byte MAX_DISCOUNT = 50;

    @Autowired
    AirDateDao airDateDao;


    public boolean airsOnDates(LocalDate from, LocalDate to) {
        return airDateDao.airDates.stream().anyMatch(dt -> dt.toLocalDate().compareTo(from) >= 0 && dt.toLocalDate().compareTo(to) <= 0);
    }

    public int getBirthdayDiscount(User user, Event event, Seance seance, int numberOfTickets) {

        LocalDate airDate = LocalDate.of(0, seance.getAirDateTime().getMonth(), seance.getAirDateTime().getDayOfMonth());
        LocalDate birthdayDate = LocalDate.of(0, user.getDateOfBirthday().getMonth(), user.getDateOfBirthday().getDayOfMonth());

        int discount = 0;
        Period period = Period.between(birthdayDate, airDate);
        if (period.getDays() <= USER_HAS_BIRTHDAY_WITHIN_5_DAYS_OF_AIR_DATE) {
            discount = DISCOUNT;
        }
        return discount;
    }

    public int getEveryTenTicketDiscount(User user, Event event, LocalDateTime airDateTime, int numberOfTickets) {
        NavigableSet<Ticket> tickets = new TreeSet<>();

        return 0;
    }
}
