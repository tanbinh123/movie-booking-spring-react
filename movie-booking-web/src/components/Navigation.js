import React, { Fragment } from 'react';
import { useHistory, Link } from 'react-router-dom';

const Navigation = (props) => {

    const history = useHistory();

    return (
        <Fragment>
            <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                <div className="container">
                    <div className="row w-100">
                        <div className="col text-start">
                            <Link to="/" className="navbar-brand text-warning">Movie booking</Link>
                        </div>
                        <div className="col text-end">
                            <button className="btn btn-outline-warning btn-lg rounded-circle me-2" data-bs-toggle="modal" data-bs-target="#searchModal"><i className="bi bi-search"></i></button>
                            <button className="btn btn-outline-warning btn-lg rounded-circle" onClick={()=>history.push("/contact")}><i className="bi bi-building"></i></button>
                        </div>
                    </div>
                </div>
            </nav>
            <div className="modal fade" id="searchModal">
                <button className="close border-0 bg-transparent" data-bs-dismiss="modal" aria-label="Close"><i className="fal fa-times"></i></button>
                <div className="modal-dialog modal-dialog-centered">
                    <div className="modal-content border-0 bg-transparent">
                        <input type="text" className="form-control border-0 bg-transparent" placeholder="search your keyword..."/>
                    </div>
                </div>
            </div>
        </Fragment>
    );
}

export default Navigation;