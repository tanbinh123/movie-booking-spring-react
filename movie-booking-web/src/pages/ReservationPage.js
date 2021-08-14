import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import API from '../api'
import CheckoutForm from '../components/CheckoutForm'
import { Elements } from '@stripe/react-stripe-js'
import { loadStripe } from '@stripe/stripe-js'

const stripePromise = loadStripe('pk_test_51JNwAXHHcZhmlwBIk3HQhJukVLU10cz9B7afSVYclbFOYhNdWlzgn2lSGnKYbCPeC06XzFhjIcKz5P66xFwB8SGr00l4ARAzPV', {
    locale: 'fr'
  });

function ReservationPage(props) {

    const { id, screeningId } = useParams();
    const [screening, setScreening] = useState(null);
    const [reservations, setReservations] = useState(null);

    useEffect(() => {
        API.get("screenings/" + screeningId).then(res => {
            setScreening(res.data);
            console.log(res.data);
        }).catch(err => {
            console.log(err);
            console.log("Impossible to fetch /api/screenings/id");
        });
    }, [])

    useEffect(() => {
        API.get("screenings/" + screeningId + "/reservations").then(res => {
            setReservations(res.data);
            console.log(res.data);
        }).catch(err => {
            console.log(err);
            console.log("Impossible to fetch /api/screenings/id/reservations");
        });
    }, [screening])

    if (screening) {
        return (
            <div className="container mt-5">
                <form className="search-form border border-warning">
                    <div className="row">
                        <div className="col-12 row">
                            <div>ACHETEZ VOS PLACES POUR LE: {screening.screening_date.replace('T', ' ').replace(':00', '')}</div>
                            <div><h1>{screening.movie.title}</h1></div>
                        </div>
                    </div>
                </form>
                <div className="row mt-2 g-4">
                    <div className="col-5">
                        <Elements stripe={stripePromise}>
                            <CheckoutForm screening={screening} />
                        </Elements>
                    </div>
                    <div className="col text-center">
                        <img src={screening.movie.poster}/> 
                    </div>
                    <div className="col-4">
                        <p>Billets encore disponibles pour la séance : {screening.auditorium.seats.length - reservations.length} sur {screening.auditorium.seats.length}</p>
                        <p>Salle: {screening.auditorium.name}</p>
                        <p>Film: {screening.movie.title}</p>
                    </div>
                </div>
            </div>
        )
    } else {
        return <h1>Loading</h1>
    }
}

export default ReservationPage
