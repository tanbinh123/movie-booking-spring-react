import React, {useState, useEffect} from 'react'
import API from '../api'

function AddCinema() {

    const [name, setName] = useState("");
    const [address, setAddress] = useState("");
    const [phone, setPhone] = useState("");
    const [options, setOptions] = useState([]);

    const handleReset = ()=>{
        setName("");
        setAddress("");
        setPhone("");
    }

    const handleSubmit = (e)=>{
        e.preventDefault();
        const body = {
            name: name, 
            address: address, 
            phone: phone
        }
        API.post("cinemas", body).then(res => {
            console.log(res);
            console.log(res.data);
            alert("Le cinema a été créé avec succès.")
            handleReset();
        }).catch(err => {
            alert("Quelque chose s'est mal passé. Veuillez vérifier les champs et réessayer.");
        });
    }

    return (
        <div className="card m-3 p-3">
            <b>Ajouter un cinema</b>
            <form className="mt-3" onSubmit={handleSubmit}>
                <div className="mb-2">
                    <label className="form-label">Nom</label>
                    <input type="text" className="form-control" value={name} onChange={e=>setName(e.target.value)} required />
                </div>
                <div className="mb-2">
                    <label className="form-label">Adresse</label>
                    <input type="text" className="form-control" value={address} onChange={e=>setAddress(e.target.value)} required/>
                </div>
                <div className="mb-2">
                    <label className="form-label">Téléphone</label>
                    <input type="text" className="form-control" value={phone} onChange={e=>setPhone(e.target.value)} required/>
                </div>
                <div className="mt-3">
                    <button type="submit" className="btn btn-primary me-2">ajouter</button>
                    <button type="reset" className="btn btn-warning text-white" onClick={handleReset}>réinitialiser</button>
                </div>
            </form>
        </div>
    )
}
export default AddCinema
