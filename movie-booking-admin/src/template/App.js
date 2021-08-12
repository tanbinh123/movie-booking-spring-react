import React from 'react'
import {
    Switch,
    Route,
} from "react-router-dom";
import Dashboard from './Dashboard';
import Login from './Login';

function App() {

    return (
        <Switch>
            <Route path="/login" component={Login} />
            <Route path="/" component={Dashboard} />
        </Switch>
    )
}

export default App

