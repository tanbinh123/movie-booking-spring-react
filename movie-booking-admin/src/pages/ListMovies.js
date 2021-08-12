import React, {useState, useEffect} from 'react'
import API from '../api'


function ListMovies() {

    const [movies, setMovies] = useState([]);

    useEffect(() => {
        API.get("movies").then(res => {
            setMovies(res.data);
        }).catch(err => {
            console.log("Impossible to fetch /api/movies");
        });
    },[]);

    const handleDelete = (id)=>{
        API.delete("movies/"+id).then(res => {
            document.getElementById("movie-"+id).remove();
            alert("Film supprimé avec succès.");
        }).catch(err => {
            console.log("Impossible to delete /api/movies");
        });
    }

    return (
        <div className="card m-3 p-3">
            <b>Liste des films</b>
            <table className="table table-stripped mt-3">
                <thead>
                    <tr>
                        <th scope="col">Poster</th>
                        <th scope="col">Titre</th>
                        <th scope="col">Durée</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        movies.map((movie,i)=>{
                            return (
                                <tr id={"movie-"+movie.id}>
                                    <td><img src={movie.poster} height="120" width="90"/></td>
                                    <td>{movie.title}</td>
                                    <td>{movie.runtime}</td>
                                    <td><button type="button" onClick={()=>handleDelete(movie.id)} className="btn btn-danger text-white">supprimer</button></td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListMovies
