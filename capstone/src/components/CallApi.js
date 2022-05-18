import React, { useEffect } from "react";
import axios from 'axios';

const CallApi = () => {
    useEffect(() => {
        axios.get('localhost:8080/menu')
            .then(response => {
                console.log(response);
            });
    }, []);
    return (
        <h1>Users</h1>
    );
}
export default CallApi;