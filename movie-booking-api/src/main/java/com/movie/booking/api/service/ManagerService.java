package com.movie.booking.api.service;

import com.movie.booking.api.entity.Manager;
import com.movie.booking.api.model.ManagerModel;
import com.movie.booking.api.repository.ManagerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
@AllArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final ModelMapper modelMapper;

    public Collection<ManagerModel> getManagers(){
        return Arrays.asList(modelMapper.map(managerRepository.findAll(), ManagerModel[].class));
    }

    public ManagerModel addManager(ManagerModel managerModel){
        Manager manager = managerRepository.save(modelMapper.map(managerModel, Manager.class));
        return modelMapper.map(managerModel, ManagerModel.class);
    }

    public ManagerModel updateManager(ManagerModel managerModel){
        return this.addManager(managerModel);
    }

    public void removeManager(ManagerModel managerModel){
        managerRepository.deleteById(managerModel.getId());
    }



}
