package com.movie.booking.api.service;

import com.movie.booking.api.entity.Movie;
import com.movie.booking.api.model.MovieModel;
import com.movie.booking.api.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    public Collection<MovieModel> getMovies(){
        return Arrays.asList(modelMapper.map(movieRepository.findAll(), MovieModel[].class));
    }

    public MovieModel getMovie(Long id){
        return modelMapper.map(movieRepository.findById(id).get(), MovieModel.class);
    }

    public MovieModel addMovie(MovieModel movieModel){
        Movie movie = movieRepository.save(modelMapper.map(movieModel, Movie.class));
        return modelMapper.map(movie, MovieModel.class);
    }

    public MovieModel updateMovie(MovieModel movieModel){
        return this.addMovie(movieModel);
    }

    public void removeMovie(MovieModel movieModel){
        movieRepository.deleteById(movieModel.getId());
    }



}
