import React, { useState, useEffect } from 'react'
import API from '../api'


function AddScreening() {

    const [movie, setMovie] = useState({});
    const [auditorium, setAuditorium] = useState({});
    const [movies, setMovies] = useState([]);
    const [auditoriums, setAuditoriums] = useState([]);
    const [date, setDate] = useState("");

    const handleReset = () => {
        setMovie("");
        setAuditorium("");
        setDate("");
    }

    useEffect(() => {
        API.get("movies").then(res => {
            setMovies(res.data);
            setMovie(res.data[0]);
        }).catch(err => {
            console.log("Impossible to fetch /api/movies");
        });
    },[]);

    useEffect(() => {
        API.get("auditoriums").then(res => {
            setAuditoriums(res.data);
            setAuditorium(res.data[0]);
        }).catch(err => {
            console.log("Impossible to fetch /api/auditoriums");
        });
    },[movies]);

    useEffect(() => {
        console.log(movie, auditorium);
    },[movie, auditorium]);

    const handleSubmit = (e) => {
        e.preventDefault();
        const body = {
            movie:movie,
            auditorium:auditorium,
            screening_date:date
        }
        console.log(body);
        API.post("screenings", body).then(res => {
            console.log(res);
            console.log(res.data);
            alert("Le screening a été créé avec succès.")
            handleReset();
        }).catch(err => {
            alert("Quelque chose s'est mal passé. Veuillez vérifier les champs et réessayer.");
        });
    }
    
    return (
        <div className="card m-3 p-3">
            <b>Ajouter un screening</b>
            <form className="mt-3" onSubmit={handleSubmit}>
                <div className="mb-2">
                    <label className="form-label">Movies</label>
                    <select className="form-control" onChange={e=>setMovie(movies[e.target.value])}>
                        {
                            movies.map((movie, i)=>(
                                <option key={i} value={i}>{movie.title}</option>
                            ))
                        }
                    </select>
                </div>
                <div className="mb-2">
                    <label className="form-label">Auditoriums</label>
                    <select className="form-control" onChange={e=>setAuditorium(auditoriums[e.target.value])}>
                        {
                            auditoriums.map((auditorium, i)=>(
                                <option key={i} value={i}>{auditorium.name}</option>
                            ))
                        }
                    </select>
                </div>
                <div className="mb-2">
                    <label className="form-label">Date</label>
                    <input type="datetime-local" className="form-control" value={date} onChange={e => setDate(e.target.value)} />
                </div>
                <div className="mt-3">
                    <button type="submit" className="btn btn-primary me-2">ajouter</button>
                    <button type="reset" className="btn btn-warning text-white" onClick={handleReset}>réinitialiser</button>
                </div>
            </form>
        </div>
    )
}

export default AddScreening
