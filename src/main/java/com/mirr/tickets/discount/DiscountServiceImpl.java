package com.mirr.tickets.discount;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;

@Component
public class DiscountServiceImpl implements DiscountService {

    private final int DAYS_BEFORE_AND_AFTER_AIR_DATE = 5;
    private final byte MAX_DISCOUNT = 5;

    @Autowired
    DiscountServiceDto discountServiceDto;

    @Override
    public byte getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
       // LocalDate birthdayDate = user.getDateOfBithday();
        Optional<User> empty = Optional.empty();
        assert (empty.isPresent());
        Optional<Event> emptyEvent = Optional.empty();
        assert (emptyEvent.isPresent());
        LocalDate airDate = LocalDate.of(airDateTime.getYear(), airDateTime.getMonth(),airDateTime.getDayOfMonth());
      //  Period period = Period.between(airDate, )

        return 0;
    }
}
