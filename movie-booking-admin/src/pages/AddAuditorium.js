import React, {useState, useEffect} from 'react'
import API from '../api'

function AddAuditorium() {

    const [name, setName] = useState("");
    const [cinema, setCinema] = useState([]);
    //Total points/coordonées (A,B)
    const [totalA, setTotalA] = useState(5);
    const [totalB, setTotalB] = useState(5);
    const [seats, setSeats] = useState([]);
    const [disabledSeats, setDisabledSeats] = useState([]);
    const [options, setOptions] = useState([]);

    useEffect(() => {
        API.get("cinemas").then(res => {
            setOptions(res.data);
            setCinema(res.data[0]);
        }).catch(err => {
            console.log("Impossible to fetch /api/cinemas");
        });
    },[]);

    useEffect(() => {
        let seats = [];
        for(var a=0; a<totalA; a++){
            let row = [];
            for(var b=0; b<totalB; b++){
                row.push({row: a, row_number: b});
            }
            seats.push(row);
        }
        setSeats(seats);
    }, [totalA,totalB])

    const handleReset = ()=>{
        setName("");
        setTotalA(5);
        setTotalB(5);
    }

    const handleSubmit = (e)=>{
        e.preventDefault();
        if(cinema.length<1){
            return alert("Veuillez sélectionner un cinéma pour continuer.")
        }
        let se = [];
        for(var a=0; a<totalA; a++){
            for(var b=0; b<totalB ; b++){
                if(disabledSeats.filter(s=>s.row==a && s.row_number==b).length==0){
                    se.push({"row": a, "row_number": b});
                }                   
            }
        }
        const body = {
            name: name, 
            cinema: cinema, 
            seats: se 
        }
        console.log(body)
        API.post("auditoriums", body).then(res => {
            console.log(res.data);
            alert("La sale a été créé avec succès.")
            handleReset();
        }).catch(err => {
            alert("Quelque chose s'est mal passé. Veuillez vérifier les champs et réessayer.");
        });
    }

    return (
        <div className="card m-3 p-3">
            <b>Ajouter une salle</b>
            <form className="mt-3" onSubmit={handleSubmit}>
                <div className="mb-2">
                    <label className="form-label">Nom</label>
                    <input type="text" className="form-control" value={name} onChange={e=>setName(e.target.value)} required />
                </div>
                <div className="mb-2">
                    <label className="form-label">Cinema</label>
                    <select className="form-control" onChange={e=>setCinema(options[e.target.value])}>
                        {
                            options.map((cinema, i)=>(
                                <option key={i} value={i}>{cinema.name}</option>
                            ))
                        }
                    </select>
                </div>
                <div className="mb-2">
                    <label className="form-label">Number of rows</label>
                    <input type="number" min="0" max="15" onKeyPress={e=>e.preventDefault()} className="form-control" value={totalA} onChange={e=>setTotalA(e.target.value)} />
                </div>
                <div className="mb-2">
                    <label className="form-label">Number of seats per row</label>
                    <input type="number" min="0" max="15" onKeyPress={e=>e.preventDefault()} className="form-control" value={totalB} onChange={e=>setTotalB(e.target.value)} />
                </div>
                <div className="mb-2 ms-1">
                    <label className="form-label">Schema</label>
                    <div className="auditorium-schema">
                        {
                            seats.map((entries,i) => {
                                return <div key={i} className="row g-0">
                                    {
                                        entries.map((entry,ii) => {
                                            if(disabledSeats.includes(entry)){
                                                return <div key={ii} className="col m-1"><button type="button" class="btn btn-danger" onClick={()=>setDisabledSeats([...disabledSeats.filter(el=>el!=entry)])}></button></div>
                                            }else{
                                                return <div key={ii} className="col m-1"><button type="button" class="btn btn-success" onClick={()=>setDisabledSeats([...disabledSeats,entry])}></button></div>
                                            }                                            
                                        })
                                    }
                                </div>
                            })
                        }
                    </div>
                </div>
                <div className="mt-3">
                    <button type="submit" className="btn btn-primary me-2">ajouter</button>
                    <button type="reset" className="btn btn-warning text-white" onClick={handleReset}>réinitialiser</button>
                </div>
            </form>
        </div>
    )
}

export default AddAuditorium