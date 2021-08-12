import React, { useState, useEffect } from 'react'
import API from '../api'

function ListAuditoriums() {

    const [auditoriums, setAuditoriums] = useState([]);

    useEffect(() => {
        API.get("auditoriums").then(res => {
            setAuditoriums(res.data);
            console.log(res.data)
        }).catch(err => {
            console.log("Impossible to fetch /api/cinemas");
        });
    }, []);

    const handleDelete = (id) => {
        API.delete("auditoriums/" + id).then(res => {
            document.getElementById("auditorium-" + id).remove();
            alert("Cinéma supprimé avec succès.");
        }).catch(err => {
            console.log("Impossible to delete /api/cinemas");
        });
    }

    return (
        <div className="card m-3 p-3">
            <b>Liste des salles</b>
            <table className="table table-stripped mt-3">
                <thead>
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Places</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        auditoriums.map((auditorium, i) => {
                            return (
                                <tr id={"auditorium-" + auditorium.id}>
                                    <td>{auditorium.name}</td>
                                    <td>{auditorium.seats.length}</td>
                                    <td><button type="button" onClick={() => handleDelete(auditorium.id)} className="btn btn-danger text-white">supprimer</button></td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListAuditoriums
