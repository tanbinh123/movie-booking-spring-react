import React, {useState, useEffect} from 'react'
import API from '../api'

function ListCinemas() {

    const [cinemas, setCinemas] = useState([]);

    useEffect(() => {
        API.get("cinemas").then(res => {
            setCinemas(res.data);
        }).catch(err => {
            console.log("Impossible to fetch /api/cinemas");
        });
    },[]);

    const handleDelete = (id)=>{
        API.delete("cinemas/"+id).then(res => {
            document.getElementById("cinema-"+id).remove();
            alert("Cinéma supprimé avec succès.");
        }).catch(err => {
            console.log("Impossible to delete /api/cinemas");
        });
    }

    return (
        <div className="card m-3 p-3">
            <b>Liste des cinemas</b>
            <table className="table table-stripped mt-3">
                <thead>
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Adresse</th>
                        <th scope="col">Telephone</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        cinemas.map((cinema,i)=>{
                            return (
                                <tr id={"cinema-"+cinema.id}>
                                    <td>{cinema.name}</td>
                                    <td>{cinema.address}</td>
                                    <td>{cinema.phone}</td>
                                    <td><button type="button" onClick={()=>handleDelete(cinema.id)} className="btn btn-danger text-white">supprimer</button></td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListCinemas
