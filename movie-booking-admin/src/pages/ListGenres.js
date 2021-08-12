import React, {useState, useEffect} from 'react'
import API from '../api'


function ListGenres() {

    const [genres, setGenres] = useState([]);

    useEffect(() => {
        API.get("genres").then(res => {
            setGenres(res.data);
        }).catch(err => {
            console.log("Impossible to fetch /api/genres");
        });
    },[]);

    const handleDelete = (id)=>{
        API.delete("genres/"+id).then(res => {
            document.getElementById("genre-"+id).remove();
            alert("Genre supprimé avec succès.");
        }).catch(err => {
            console.log("Impossible to delete /api/genres");
        });
    }

    return (
        <div className="card m-3 p-3">
            <b>Liste des genres</b>
            <table className="table table-stripped mt-3">
                <thead>
                    <tr>
                        <th scope="col">Nom du genre</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        genres.map((genre,i)=>{
                            return (
                                <tr id={"genre-"+genre.id}>
                                    <td>{genre.name}</td>
                                    <td><button type="button" onClick={()=>handleDelete(genre.id)} className="btn btn-danger text-white">supprimer</button></td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListGenres
