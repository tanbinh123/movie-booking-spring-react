import React, {useEffect, useState} from 'react'
import { useParams, Route } from 'react-router-dom'
import API from '../api'
import ScreeningThumbnail from '../components/ScreeningThumbnail';

function DetailsPage() {

    const { id } = useParams();
    const [movie, setMovie] = useState({});
    const [movieScreenings, setMovieScreenings] = useState([]);

    useEffect(() => {
        API.get("movies/"+id).then(res => {
            setMovie(res.data);
            console.log(res.data);
        }).catch(err => {
            console.log("Impossible to fetch /api/movies");
        });
    },[])

    useEffect(() => {
        API.get("movies/"+id+"/screenings").then(res => {
            setMovieScreenings(res.data);
            console.log(res.data);
        }).catch(err => {
            console.log("Impossible to fetch /api/movies/screenings");
        });
    },[movie])


    return (
        <div className="container mt-5">
            <form className="search-form border border-warning">
                <div className="row">
                    <div className="col-12">
                        <h1 className="text-warning" style={{lineHeight: "63px"}}>{movie.title}</h1>
                    </div>
                </div>
            </form>
            <div className="row mt-5">
                <div className="col-3">
                    <img src={movie.poster} width="300px" height="400px"/>
                </div>
                <div className="col text-white text-justify">
                    <p className="lh-base mb-5">{movie.description}</p>
                    <div className="row g-3">                    
                        {
                            movieScreenings.map((screening,i)=>{
                                return <div className="col-3">
                                    <ScreeningThumbnail screening={screening} key={i}></ScreeningThumbnail>
                                </div>
                            })
                        }
                    </div>
                </div>
            </div>
        </div>
    )
}

export default DetailsPage
