import React,{useContext} from 'react'
import {
    Switch,
    Route,
    Link,
    Redirect
  } from "react-router-dom"
  import AddCinema from '../pages/AddCinema'
  import AddAuditorium from '../pages/AddAuditorium'
  import AppContext from '../context/AppContext'
  import PageNotFound from '../pages/PageNotFound'
import ListAuditoriums from '../pages/ListAuditoriums'
import ListCinemas from '../pages/ListCinemas'
import AddGenre from '../pages/AddGenre'
import AddMovie from '../pages/AddMovie'
import ListGenres from '../pages/ListGenres'
import ListMovies from '../pages/ListMovies'
import ListUsers from '../pages/ListUsers'
import AddScreening from '../pages/AddScreening'
import AddUser from '../pages/AddUser'
import ListReservations from '../pages/ListReservations'
import ListScreenings from '../pages/ListScreenings'

function Dashboard() {

    const [context, setContext] = useContext(AppContext);
    const timestamp = new Date(localStorage.getItem("timestamp"));

    //Check if session or context user
    if(context.user != null || timestamp>new Date() ){

        return (
            <div id="wrapper" className="d-flex">
                <ul className="navbar-nav sidebar sidebar-dark text-secondary">
                    <li className="mx-3 mt-4"><h1>MB ADMIN</h1></li>
                    <li><h3 className="m-0 mt-2">Dashboard</h3></li>
                    <li><Link to="/list-reservations">Reservations</Link></li>
                    <li><Link to="/add-user">Ajouter un administrateur</Link></li>
                    <li><Link to="/list-users">Liste des administrateurs</Link></li>
                    <li><h3 className="m-0 mt-2">Cinema</h3></li>
                    <li><Link to="/add-cinema">Ajouter un cinema</Link></li>
                    <li><Link to="/add-auditorium">Ajouter une salle</Link></li>
                    <li><Link to="/list-cinemas">Liste des cinemas</Link></li>
                    <li><Link to="/list-auditoriums">Liste des salles</Link></li>
                    <li><h3 className="m-0 mt-2">Movies</h3></li>
                    <li><Link to="/add-genre">Ajouter un genre</Link></li>
                    <li><Link to="/add-movie">Ajouter un film</Link></li>
                    <li><Link to="/list-genres">Liste des genres</Link></li>
                    <li><Link to="/list-movies">Liste des films</Link></li>
                    <li><h3 className="m-0 mt-2">Screenings</h3></li>
                    <li><Link to="/add-screening">Ajouter une séance</Link></li>
                    <li><Link to="/list-screenings">Liste des séances</Link></li>
                </ul>
                <div id="content-wrapper" className="d-flex flex-column">
                    <Switch>
                        <Route path="/add-cinema">
                            <AddCinema></AddCinema>
                        </Route>
                        <Route path="/add-auditorium">
                            <AddAuditorium></AddAuditorium>
                        </Route>
                        <Route path="/add-screening">
                            <AddScreening></AddScreening>
                        </Route>
                        <Route path="/add-genre">
                            <AddGenre></AddGenre>
                        </Route>
                        <Route path="/add-movie">
                            <AddMovie></AddMovie>
                        </Route>
                        <Route path="/list-auditoriums">
                            <ListAuditoriums></ListAuditoriums>
                        </Route>
                        <Route path="/list-cinemas">
                            <ListCinemas></ListCinemas>
                        </Route>
                        <Route path="/list-genres">
                            <ListGenres></ListGenres>
                        </Route>
                        <Route path="/list-movies">
                            <ListMovies></ListMovies>
                        </Route>
                        <Route path="/list-users">
                            <ListUsers></ListUsers>
                        </Route>
                        <Route path="/list-screenings">
                            <ListScreenings></ListScreenings>
                        </Route>                        
                        <Route path="/list-users">
                            <ListUsers></ListUsers>
                        </Route>                        
                        <Route path="/add-user">
                            <AddUser></AddUser>
                        </Route>                        
                        <Route path="/list-reservations">
                            <ListReservations></ListReservations>
                        </Route>
                        <Route>
                            <PageNotFound></PageNotFound>
                        </Route>
                    </Switch>
                </div>
            </div>
        )
    }else{
        return <Redirect push to="/login" />
    }
}

export default Dashboard
