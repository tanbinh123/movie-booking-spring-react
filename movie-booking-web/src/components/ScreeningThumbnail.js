import React from 'react'
import {Link} from 'react-router-dom'

function ScreeningThumbnail(props) {

    const { screening } = props;

    return (
        <Link push to={"/details/" + screening.movie.id + "/reservation/" + screening.id}>
            <div class="screen border border-warning text-center rounded">
                {screening.screening_date.replace('T',' ').replace(':00','')}
            </div>
        </Link>
    )
}

export default ScreeningThumbnail
