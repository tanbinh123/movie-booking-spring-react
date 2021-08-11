package com.movie.booking.api.service;

import com.movie.booking.api.entity.Screening;
import com.movie.booking.api.model.ScreeningModel;
import com.movie.booking.api.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
@AllArgsConstructor
public class ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final ModelMapper modelMapper;

    public Collection<ScreeningModel> getScreenings(){
        return Arrays.asList(modelMapper.map(screeningRepository.findAll(), ScreeningModel[].class));
    }

    public ScreeningModel addScreening(ScreeningModel screeningModel){
        Screening screening = screeningRepository.save(modelMapper.map(screeningModel, Screening.class));
        return modelMapper.map(screening, ScreeningModel.class);
    }

    public ScreeningModel updateScreening(ScreeningModel screeningModel){
        return this.addScreening(screeningModel);
    }

    public void removeScreening(ScreeningModel screeningModel){
        screeningRepository.deleteById(screeningModel.getId());
    }

}
