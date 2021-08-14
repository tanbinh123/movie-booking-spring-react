import React, { useEffect, useState } from 'react'
import { useHistory } from 'react-router'
import API from '../api'
import Select from 'react-select'
import DatePicker from 'react-datepicker'
import 'react-datepicker/dist/react-datepicker.css'
import MovieThumbnail from '../components/MovieThumbnail'

const HomePage = (props) => {

    const params = new URLSearchParams(window.location.search);
    const [genres, setGenres] = useState([]);
    const [movies, setMovies] = useState([]);
    const [moviesBackup, setMoviesBackup] = useState([]);
    const [options, setOptions] = useState([]);


    const [genre, setGenre] = useState(null);
    const [title, setTitle] = useState("");

    useEffect(() => {
        API.get("movies").then(res => {
            setMovies(res.data);
            setMoviesBackup(res.data);
        }).catch(err => {
            console.log("Impossible to fetch /api/movies");
        });
    }, [])

    useEffect(() => {
        API.get("genres").then(res => {
            setGenres(res.data);
        }).catch(err => {
            console.log("Impossible to fetch /api/genres");
        });
    }, [movies])

    useEffect(() => {
        let options = [];
        for (const genre of genres) {
            options.push({ value: genre.id, label: genre.name })
        }
        setOptions(options);
    }, [genres])

    function handleSubmit(e) {
        e.preventDefault();
        let moviesToShow = moviesBackup;
        if (title != "") {
            moviesToShow = movies.filter(m => m.title.toUpperCase().includes(title.toUpperCase()));
        }
        if(genre != null){
            console.log(genre);
            moviesToShow = moviesToShow.filter(m => m.genres.some(c=>c.id==genre));
        }
        console.log(moviesToShow)
        setMovies(moviesToShow);
    }

    return (
        <div className="container mt-5">
            <form className="search-form border border-warning" onSubmit={handleSubmit}>
                <div className="row">
                    <div className="col-12 row">
                        <div className="col-4">
                            <input type="text" className="form-control" value={title} onChange={e => setTitle(e.target.value)} style={{ height: "64px" }} />
                        </div>
                        <div className="col-4">
                            <Select className='react-select-container' classNamePrefix="react-select" options={options} placeholder="Sélectionnez un genre" onChange={e => setGenre(e.value)} />
                        </div>
                        <div className="col-4">
                            <button type="submit" className="btn btn-warning w-100">Search now</button>
                        </div>
                    </div>
                </div>
            </form>
            {
                (movies.length == 0) ?
                    <div className="container mt-5 text-white">Aucun film disponible pour la liste.</div>
                    :
                    <div className="row mt-2 g-4">
                        {
                            movies.map((movie, i) => (
                                <div className="col-3">
                                    <MovieThumbnail movie={movie} key={i}></MovieThumbnail>
                                </div>
                            ))
                        }
                    </div>
            }

        </div>
    );
}



export default HomePage;