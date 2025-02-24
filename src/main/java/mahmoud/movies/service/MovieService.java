package mahmoud.movies.service;

import mahmoud.movies.exception.EntityNotFoundException;
import mahmoud.movies.model.Movie;
import mahmoud.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;



    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getSingleMovie(int id){

        return movieRepository.findById(id)
.orElseThrow(() -> new EntityNotFoundException("Movie with id " + id + " not found"));
       }

       public Movie fineMovieByImdId(String imdId){
        return  movieRepository.findByImdId(imdId)

                .orElseThrow(()-> new EntityNotFoundException("Movie with imdId " + imdId + " not found"));

       }
}