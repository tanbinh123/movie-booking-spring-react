import React, {useState, useEffect} from 'react'
import API from '../api'

function AddUser() {

    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [phone, setPhone] = useState("");
    const [address, setAddress] = useState("");
    const [email, setEmail] = useState("");
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [password2, setPassword2] = useState("");

    const handleReset = ()=>{
        setFirstName("");
        setLastName("");
        setPhone("");
        setAddress("");
        setEmail("");
        setUsername("");
        setPassword("");
        setPassword2("");
    }

    const handleSubmit = (e)=>{
        e.preventDefault();
        if(password!=password2){
            return alert("Le mot de passe ne correspond pas.")
        }
        const body = {
            "first_name": firstName,
            "last_name": lastName,
            "username":username,
            "password":password,
            "email":email,
            "address":address,
            "phone": phone,
            "enabled": true
        }
        API.post("singup", body).then(res => {
            console.log(res);
            console.log(res.data);
            alert("L'administrateur a été créé avec succès.")
            handleReset();
        }).catch(err => {
            alert("Quelque chose s'est mal passé. Veuillez vérifier les champs et réessayer.");
        });
    }

    return (
        <div className="card m-3 p-3">
            <b>Ajouter un administrateur</b>
            <form className="mt-3" onSubmit={handleSubmit}>
                <div className="mb-2">
                    <label className="form-label">Prenom</label>
                    <input type="text" className="form-control" value={firstName} onChange={e=>setFirstName(e.target.value)} required />
                </div>
                <div className="mb-2">
                    <label className="form-label">Nom</label>
                    <input type="text" className="form-control" value={lastName} onChange={e=>setLastName(e.target.value)} required />
                </div>
                <div className="mb-2">
                    <label className="form-label">Adresse</label>
                    <input type="text" className="form-control" value={address} onChange={e=>setAddress(e.target.value)} required/>
                </div>
                <div className="mb-2">
                    <label className="form-label">Téléphone</label>
                    <input type="text" className="form-control" value={phone} onChange={e=>setPhone(e.target.value)} required/>
                </div>
                <div className="mb-2">
                    <label className="form-label">Email</label>
                    <input type="text" className="form-control" value={email} onChange={e=>setEmail(e.target.value)} required/>
                </div>
                <div className="mb-2">
                    <label className="form-label">Nom d'utilisateur</label>
                    <input type="text" className="form-control" value={username} onChange={e=>setUsername(e.target.value)} required/>
                </div>
                <div className="mb-2">
                    <label className="form-label">Mot de passe</label>
                    <input type="password" className="form-control" value={password} onChange={e=>setPassword(e.target.value)} required/>
                </div>
                <div className="mb-2">
                    <label className="form-label">Répéter le mot de passe</label>
                    <input type="password" className="form-control" value={password2} onChange={e=>setPassword2(e.target.value)} required/>
                </div>
                <div className="mt-3">
                    <button type="submit" className="btn btn-primary me-2">ajouter</button>
                    <button type="reset" className="btn btn-warning text-white" onClick={handleReset}>réinitialiser</button>
                </div>
            </form>
        </div>
    )
}

export default AddUser
