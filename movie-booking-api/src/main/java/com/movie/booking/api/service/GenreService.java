package com.movie.booking.api.service;

import com.movie.booking.api.entity.Genre;
import com.movie.booking.api.model.GenreModel;
import com.movie.booking.api.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
@AllArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper;

    public Collection<GenreModel> getGenres(){
        return Arrays.asList(modelMapper.map(genreRepository.findAll(), GenreModel[].class));
    }

    public GenreModel addGenre(GenreModel genreModel){
        Genre genre = genreRepository.save(modelMapper.map(genreModel, Genre.class));
        return modelMapper.map(genre, GenreModel.class);
    }

    public GenreModel updateGenre(GenreModel genreModel){
        return this.addGenre(genreModel);
    }

    public void removeGenre(GenreModel genreModel){
        genreRepository.deleteById(genreModel.getId());
    }



}
