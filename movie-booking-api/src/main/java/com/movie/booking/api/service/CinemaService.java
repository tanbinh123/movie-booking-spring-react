package com.movie.booking.api.service;

import com.movie.booking.api.entity.Auditorium;
import com.movie.booking.api.entity.Cinema;
import com.movie.booking.api.model.AuditoriumModel;
import com.movie.booking.api.model.CinemaModel;
import com.movie.booking.api.repository.AuditoriumRepository;
import com.movie.booking.api.repository.CinemaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
@AllArgsConstructor
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final ModelMapper modelMapper;

    public Collection<CinemaModel> getCinemas(){
        return Arrays.asList(modelMapper.map(cinemaRepository.findAll(), CinemaModel[].class));
    }

    public CinemaModel getCinema(Long id){
        return modelMapper.map(cinemaRepository.findById(id).get(), CinemaModel.class);
    }

    public CinemaModel addCinema(CinemaModel cinemaModel){
        Cinema cinema = cinemaRepository.save(modelMapper.map(cinemaModel, Cinema.class));
        return modelMapper.map(cinema, CinemaModel.class);
    }

    public CinemaModel updateCinema(CinemaModel cinemaModel){
        return this.addCinema(cinemaModel);
    }

    public void removeCinema(CinemaModel cinemaModel){
        cinemaRepository.deleteById(cinemaModel.getId());
    }
}
