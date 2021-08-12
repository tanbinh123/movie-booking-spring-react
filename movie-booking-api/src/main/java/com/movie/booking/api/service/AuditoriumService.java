package com.movie.booking.api.service;

import com.movie.booking.api.entity.Auditorium;
import com.movie.booking.api.entity.Seat;
import com.movie.booking.api.model.AuditoriumModel;
import com.movie.booking.api.model.CinemaModel;
import com.movie.booking.api.repository.AuditoriumRepository;
import com.movie.booking.api.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
@AllArgsConstructor
public class AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;
    private final ModelMapper modelMapper;

    public Collection<AuditoriumModel> getAuditoriums(){
        return Arrays.asList(modelMapper.map(auditoriumRepository.findAll(), AuditoriumModel[].class));
    }

    public AuditoriumModel getAuditorium(Long id){
        return modelMapper.map(auditoriumRepository.findById(id).get(), AuditoriumModel.class);
    }

    public AuditoriumModel addAuditorium(AuditoriumModel auditoriumModel){
        Auditorium auditorium = auditoriumRepository.save(modelMapper.map(auditoriumModel, Auditorium.class));
        return modelMapper.map(auditorium, AuditoriumModel.class);
    }

    public AuditoriumModel updateAuditorium(AuditoriumModel auditoriumModel){
        return this.addAuditorium(auditoriumModel);
    }

    public void removeAuditorium(AuditoriumModel auditoriumModel){
        auditoriumRepository.deleteById(auditoriumModel.getId());
    }
}
