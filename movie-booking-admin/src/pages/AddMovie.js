import React, { useState, useEffect } from 'react'
import API from '../api'
import Select from 'react-select'

function AddMovie() {

    const [title, setTitle] = useState("");
    const [poster, setPoster] = useState("");
    const [imdbRating, setImdbRating] = useState("");
    const [releaseDate, setReleaseDate] = useState("");
    const [description, setDescription] = useState("");
    const [runtime, setRuntime] = useState("");
    const [genres, setGenres] = useState([]);
    const [filterValue, setFilterValue] = useState([]);
    const [filterOptions, setFilterOptions] = useState([]);

    const handleReset = () => {
        setTitle("");
        setPoster("");
        setImdbRating("");
        setReleaseDate("");
        setDescription("");
        setRuntime("");
        setFilterValue([]);
    }

    useEffect(() => {
        API.get("genres").then(res => {
            const genres = res.data;
            let options = [];
            for(const genre of genres){
                options.push({value:genre, label:genre.name})
            }
            setFilterOptions(options);
        }).catch(err => {
            console.log("Impossible to fetch /api/genres");
        });
    },[]);

    const handleSelect = (e)=>{
        setGenres(e.map(m=>m.value));
        setFilterValue(e);
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        const body = {
            title: title,
            poster:poster,
            imdb_rating:imdbRating,
            release_date:releaseDate,
            description:description,
            runtime:runtime,
            genres: genres
        }
        API.post("movies", body).then(res => {
            console.log(res);
            console.log(res.data);
            alert("Le film a été créé avec succès.")
            handleReset();
        }).catch(err => {
            alert("Quelque chose s'est mal passé. Veuillez vérifier les champs et réessayer.");
        });
    }

    return (
        <div className="card m-3 p-3">
            <b>Ajouter un film</b>
            <form className="mt-3" onSubmit={handleSubmit}>
                <div className="mb-2">
                    <label className="form-label">Titre</label>
                    <input type="text" className="form-control" value={title} onChange={e => setTitle(e.target.value)} required />
                </div>
                <div className="mb-2">
                    <label className="form-label">Poster URL</label>
                    <input type="text" className="form-control" value={poster} onChange={e => setPoster(e.target.value)} required/>
                </div>
                <div className="mb-2">
                    <label className="form-label">Score IMDB</label>
                    <input type="text" className="form-control" value={imdbRating} onChange={e => setImdbRating(e.target.value)} required />
                </div>
                <div className="mb-2">
                    <label className="form-label">Date de sortie</label>
                    <input type="date" className="form-control" value={releaseDate} onChange={e => setReleaseDate(e.target.value)} required/>
                </div>
                <div className="mb-2">
                    <label className="form-label">Synopsis</label>
                    <textarea rows="10" style={{resize:"none"}} className="form-control" value={description} onChange={e => setDescription(e.target.value)} required></textarea>
                </div>
                <div className="mb-2">
                    <label className="form-label">Durée</label>
                    <input type="text" className="form-control" value={runtime} onChange={e => setRuntime(e.target.value)} required/>
                </div>
                <div className="mb-2">                    
                    <label className="form-label">Genres</label>
                    <Select
                        isMulti
                        className="basic-multi-select"
                        classNamePrefix="select"
                        onChange={handleSelect}
                        options={filterOptions}
                        value={filterValue}
                    />
                </div>
                <div className="mt-3">
                    <button type="submit" className="btn btn-primary me-2">ajouter</button>
                    <button type="reset" className="btn btn-warning text-white" onClick={handleReset}>réinitialiser</button>
                </div>
            </form>
        </div>
    )
}

export default AddMovie
