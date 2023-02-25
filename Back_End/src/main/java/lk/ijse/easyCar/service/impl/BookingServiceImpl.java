package lk.ijse.easyCar.service.impl;

import lk.ijse.easyCar.dto.BookingDTO;
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
        count=getAllBookingDetails().size();
        return count;
    }

    @Override
    public ArrayList<BookingDTO> getAllBookingDetails() {
        return mapper.map(bookingRepo.findAll(),new TypeToken<ArrayList<BookingDTO>>(){}.getType());
    }
}
