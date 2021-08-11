package com.movie.booking.api.service;

import com.movie.booking.api.entity.Seat;
import com.movie.booking.api.model.SeatModel;
import com.movie.booking.api.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;
    private final ModelMapper modelMapper;

    public SeatModel addSeat(SeatModel seatModel){
        Seat seat = seatRepository.save(modelMapper.map(seatModel, Seat.class));
        return modelMapper.map(seat, SeatModel.class);
    }

    public void removeSeat(SeatModel seatModel){
        seatRepository.deleteById(seatModel.getId());
    }

}
