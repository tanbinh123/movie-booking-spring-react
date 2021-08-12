import React, {useState, useEffect} from 'react'
import API from '../api'


function ListUsers() {

    const [users, setUsers] = useState([]);

    useEffect(() => {
        API.get("users").then(res => {
            setUsers(res.data);
        }).catch(err => {
            console.log("Impossible to fetch /api/users");
        });
    },[]);

    const handleDelete = (id)=>{
        API.delete("users/"+id).then(res => {
            document.getElementById("user-"+id).remove();
            alert("Utilisateur supprimé avec succès.");
        }).catch(err => {
            console.log("Impossible to delete /api/users");
        });
    }

    return (
        <div className="card m-3 p-3">
            <b>Liste des utilisateurs</b>
            <table className="table table-stripped mt-3">
                <thead>
                    <tr>
                        <th scope="col">Prenom</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Telephone</th>
                        <th scope="col">Adresse</th>
                        <th scope="col">Email</th>
                        <th scope="col">Username</th>
                        <th scope="col">Total Reservations</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        users.map((user,i)=>{
                            return (
                                <tr id={"user-"+user.id}>
                                    <td>{user.first_name}</td>
                                    <td>{user.last_name}</td>
                                    <td>{user.phone}</td>
                                    <td>{user.address}</td>
                                    <td>{user.email}</td>
                                    <td>{user.username}</td>
                                    <td>{user.reservations.length}</td>
                                    <td>
                                        <button type="button" onClick={()=>handleDelete(user.id)} className="btn btn-danger text-white">supprimer</button>
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
export default ListUsers
