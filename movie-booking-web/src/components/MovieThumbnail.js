import {Link} from 'react-router-dom'

const MovieThumbnail = (props) => {
    const movie = props.movie;
    return (
        <Link push to={"/details/"+movie.id} style={{textDecoration:"none"}}>
            <div className="movie-thumbnail">
                <div className="movie-thumbnail-poster" style={{background:`url(${movie.poster}) no-repeat center center/cover`}}></div>
                {/* <div className="movie-thumbnail-content text-center border border-warning">
                    <h4 className="text-warning">{movie.title}</h4>
                </div> */}
            </div>
        </Link>
    );
}

export default MovieThumbnail;