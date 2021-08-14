import React, {useState, useEffect} from 'react'
import API from '../api'

function ContactPage() {

    const [cinemas, setCinemas] = useState([]);

    useEffect(()=>{
        API.get("cinemas").then(res=>{
            setCinemas(res.data);
        }).catch(err=>{
            console.log(err);
        })
    },[])


    return (
        <div className="container mt-5">
            <form className="search-form border border-warning">
                <div className="row">
                    <div className="col-12">
                        <h1 className="text-warning" style={{lineHeight: "63px"}}>Contact</h1>
                    </div>
                </div>
            </form>
            <div className="row mt-5 text-white">
                {
                    cinemas.map((cinema,i)=>{
                        return <div className="col-4">
                            <p><b>{cinema.name}</b></p>
                            <p>{cinema.address}</p>
                            <p>Telephone: {cinema.phone}</p>                       
                            <p>Total de salles: {cinema.auditoriums.length}</p>
                        </div>
                    })
                }
            </div>            
        </div>
    )
}

export default ContactPage
