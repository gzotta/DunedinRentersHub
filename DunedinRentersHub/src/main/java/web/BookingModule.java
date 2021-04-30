/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.BookingJdbcDAO;
import domain.Booking;
import org.jooby.Jooby;
import org.jooby.Status;

/**
 *
 * @author zotta
 */
public class BookingModule extends Jooby {

    public BookingModule(BookingJdbcDAO bookingDao) {

        
        //Save (POST) a booking.
        post("/api/bookings", (req, rsp) -> {
            Booking booking = req.body().to(Booking.class);
            bookingDao.save(booking);
            rsp.status(Status.CREATED);
        });

    }

}
