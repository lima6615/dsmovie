
import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { BASE_URL } from "utils/request";
import { MoviePage } from "types/movie";

function Listing() {

     // eslint-disable-next-line @typescript-eslint/no-unused-vars
    const[pageNumber, setPageNumber] = useState(0);

    const[page, setPage] = useState<MoviePage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 12,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true,
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/movies?page=${pageNumber}&size=12&sort=title`)
        .then(response => {
            const data = response.data as MoviePage;
            setPage(data);
        })
    },[pageNumber]);

    return (
        <>
            <Pagination />
            <div className="container">
                <div className="row">
                    {page.content.map(movie  => 
                        <div key={movie.id} className="col-sm-6 col-lg-4 col-x1-3 mb-3">
                            <MovieCard movie={movie}/>
                        </div>
                    )}
                </div>
            </div>
        </>
    );
}

export default Listing;