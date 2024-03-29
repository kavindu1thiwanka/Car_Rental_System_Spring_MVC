package lk.ijse.easyCar.service.impl;

import lk.ijse.easyCar.dto.BookingDTO;
import lk.ijse.easyCar.entity.Booking;
import lk.ijse.easyCar.repo.BookingRepo;
import lk.ijse.easyCar.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Object getAllBookingForDayCount() {
        int count;
        count = getAllApprovedBooking().size();
        return count;
    }

    @Override
    public ArrayList<BookingDTO> getAllApprovedBooking() {
        return mapper.map(bookingRepo.findByBkAdminStatus("Approved"), new TypeToken<ArrayList<BookingDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<BookingDTO> getAllBookingDetails() {
        return mapper.map(bookingRepo.findAll(), new TypeToken<ArrayList<BookingDTO>>() {
        }.getType());
    }

    @Override
    public void placeBooking(Booking dto) {
        if (bookingRepo.existsById(dto.getBkId())) {
            throw new RuntimeException("User Already Exist From This Email.Use Another Email..!");
        }
        bookingRepo.save(mapper.map(dto, Booking.class));
    }

    @Override
    public ArrayList<BookingDTO> getDriverWorkShedule(String bkDriver) {
        return mapper.map(bookingRepo.findByBkDriver(bkDriver), new TypeToken<ArrayList<BookingDTO>>() {
        }.getType());
    }

    @Override
    public void setAdminStatus(BookingDTO dto) {
        if (!bookingRepo.existsById(dto.getBkId())) {
            throw new RuntimeException("Booking Not Exist..!");
        }
        bookingRepo.save(mapper.map(dto, Booking.class));
    }

}
