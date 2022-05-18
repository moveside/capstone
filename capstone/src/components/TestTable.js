import axios from "axios";
import React, {uesEffect, useEffect, useState} from "react";


const TestTable=()=>{
    const [product, setProduct] = useState([])

    const getProductData = async() =>{
        try{
            const data = await axios.get("http://localhost:8080/menu");
            console.log(data.data);
            setProduct(data.data);
        } catch(e){
            console.log(e);
        }
    };

    useEffect(()=> {
        getProductData();
    },[]);
    return(
        <div className="TestTable">
            <h1>plz plz!</h1>
            {product.map((item)=>{
                return(
                <p>
                    {item.name} - {item.price}
                </p>
                );
                })}
        </div>
    );
};

export default TestTable