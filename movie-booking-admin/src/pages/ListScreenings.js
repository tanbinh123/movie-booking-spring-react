import React, {useState, useEffect} from 'react'
import API from '../api'


function ListScreenings() {

    
    const [scrennings, setScreenings] = useState([]);

    useEffect(() => {
        API.get("screenings").then(res => {
            setScreenings(res.data);
        }).catch(err => {
            console.log("Impossible to fetch /api/screenings");
        });
    },[]);

    const handleDelete = (id)=>{
        API.delete("screenings/"+id).then(res => {
            document.getElementById("screening-"+id).remove();
            alert("Session supprimé avec succès.");
        }).catch(err => {
            console.log("Impossible to delete /api/screenings");
        });
    }

    return (
        <div className="card m-3 p-3">
            <b>Liste des séances</b>
            <table className="table table-stripped mt-3">
                <thead>
                    <tr>
                        <th scope="col">Poster</th>
                        <th scope="col">Film</th>
                        <th scope="col">Salle</th>
                        <th scope="col">Séance</th>
                        <th scope="col">Durée</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        scrennings.map((screening,i)=>{
                            return (
                                <tr id={"screening-"+screening.id}>
                                    <td><img src={screening.movie.poster} width="70px"/></td>
                                    <td>{screening.movie.title}</td>
                                    <td>{screening.auditorium.name}</td>
                                    <td>{screening.screening_date.replace('T',' ').replace(':00','')}</td>
                                    <td>{screening.movie.runtime}</td>
                                    <td>
                                        <button type="button" onClick={()=>handleDelete(screening.id)} className="btn btn-danger text-white">supprimer</button>
                                    </td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}
export default ListScreenings
