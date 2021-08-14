import React, { useState, useContext } from 'react'
import API from '../api'
import AppContext from '../context/AppContext'
import { useHistory } from 'react-router-dom';

function Login() {

    let history = useHistory();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [context, setContext] = useContext(AppContext);

    const handleSubmit = (e) => {
        e.preventDefault();
        API.post("auth/signin", { username, password }).then(res => {
            console.log(res);
            console.log(res.data);
            setContext({ ...context, user: res.data.user });
            API.defaults.headers.common['Authorization'] = res.data.token;
            localStorage.setItem("token", res.data.token);
            localStorage.setItem("timestamp", new Date().setMinutes(new Date().getMinutes + 30));
            history.push("/list-reservations");
        }).catch(err => {
            alert("Something went wrong. Please check user info.")
        });
    }

    return (
        <div id="login-wrapper">
            <form className="form-signin text-center" onSubmit={handleSubmit}>
                <h1 className="h3 mb-3 font-weight-normal">Please sign in</h1>
                <div className="mb-2">
                    <input type="text" className="form-control" placeholder="Username" required value={username} onChange={e => setUsername(e.target.value)} />
                </div>
                <div className="mb-2">
                    <input type="password" className="form-control" placeholder="Password" required value={password} onChange={e => setPassword(e.target.value)} />
                </div>
                <div className="mb-3 d-grid">
                    <button className="btn btn-primary" type="submit">Sign in</button>
                </div>
                <p className="text-muted">© 2020-{new Date().getFullYear()}</p>
            </form>
        </div>
    )
}

export default Login
