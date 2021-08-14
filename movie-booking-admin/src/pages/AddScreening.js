import React, { useState, useEffect } from 'react'
import API from '../api'


function AddScreening() {

    const [movie, setMovie] = useState({});
    const [days, setDays] = useState(10);
    const [auditorium, setAuditorium] = useState({});
    const [movies, setMovies] = useState([]);
    const [auditoriums, setAuditoriums] = useState([]);
    const [date, setDate] = useState("");

    const handleReset = () => {
        setMovie("");
        setAuditorium("");
        setDate("");
        setDays(10);
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
        var screenings = [];
        for(var i=0; i<days; i++){
            screenings.push({
                movie:movie,
                auditorium:auditorium,
                screening_date: new Date(new Date(date).getTime() + Number(i) * 86400000).toISOString()
            })
        }
        API.post("screenings", screenings).then(res => {
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
                    <select className="form-control" onChange={e=>setMovie(movies[e.target.value])} required >
                        {
                            movies.map((movie, i)=>(
                                <option key={i} value={i}>{movie.title}</option>
                            ))
                        }
                    </select>
                </div>
                <div className="mb-2">
                    <label className="form-label">Auditoriums</label>
                    <select className="form-control" onChange={e=>setAuditorium(auditoriums[e.target.value])} required>
                        {
                            auditoriums.map((auditorium, i)=>(
                                <option key={i} value={i}>{auditorium.name}</option>
                            ))
                        }
                    </select>
                </div>
                <div className="mb-2">
                    <label className="form-label">Date</label>
                    <input type="datetime-local" className="form-control" value={date} onChange={e => setDate(e.target.value)} required/>
                </div>
                <div className="mb-2">
                    <label className="form-label">Répéter pendant combien de jours?</label>
                    <input type="number" min="1" max="30" className="form-control" value={days} onChange={e => setDays(e.target.value)} required/>
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
