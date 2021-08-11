package com.movie.booking.api.service;


import com.movie.booking.api.entity.Reservation;
import com.movie.booking.api.model.ReservationModel;
import com.movie.booking.api.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;

    public Collection<ReservationModel> getReservations(){
        return Arrays.asList(modelMapper.map(reservationRepository.findAll(), ReservationModel[].class));
    }

    public ReservationModel addReservation(ReservationModel reservationModel){
        Reservation reservation = reservationRepository.save(modelMapper.map(reservationModel, Reservation.class));
        return modelMapper.map(reservation, ReservationModel.class);
    }

    public ReservationModel updateReservation(ReservationModel reservationModel){
        return this.addReservation(reservationModel);
    }

    public void removeReservation(ReservationModel reservationModel){
        reservationRepository.deleteById(reservationModel.getId());
    }

}
