import React, { Fragment } from 'react';
import { Switch, Route, Redirect } from "react-router-dom";

import HomePage from "./pages/HomePage";
import DetailsPage from "./pages/DetailsPage";
import ReservationPage from "./pages/ReservationPage";
import PageNotFound from "./pages/PageNotFound";

import Navigation from './components/Navigation';
import Footer from './components/Footer';
import ContactPage from './pages/ContactPage';

const App = (props) => {
  return (
    <Fragment>
      <Navigation></Navigation>
      <div style={{minHeight: "calc( 100vh - 251px )"}}>
        <Switch>
          <Route exact path="/details/:id">
            <DetailsPage />
          </Route>
          <Route exact path="/details/:id/reservation/:screeningId">
            <ReservationPage />
          </Route>
          <Route exact path="/contact">
            <ContactPage/>
          </Route>
          <Route path="/homepage">
            <HomePage />
          </Route>
          <Route exact path="/">
            <Redirect push to="/homepage"></Redirect>
          </Route>
          <Route>
            <PageNotFound></PageNotFound>
          </Route>
        </Switch>
      </div>
      <Footer></Footer>
    </Fragment>
  );
}

export default App;
