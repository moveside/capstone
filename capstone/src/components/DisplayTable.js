import React from "react";

class DisplayTable extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            list:[]
        }

        this.callAPI = this.callAPI.bind(this)
        this.callAPI();
    }

    callAPI(){
        fetch("http://localhost:8080/menu").then(
            (response)=> response.json()
        ).then((data) => {
            console.log(data)
            this.setState({
                list:data.data
            })
        })
    }

    render(){
        let tb_data = this.state.list.map((item)=>{
            return(
                <tr key={item.id}>
                    <td>{item.id}</td>
                    <td>{item.name}</td>
                    <td>{item.price}</td>
                    <td>{item.info}</td>
                    <td>{item.store}</td>
                </tr>
            )
        })
        return(
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>name</th>
                            <th>price</th>
                            <th>info</th>
                            <th>store</th>
                        </tr>
                    </thead>
                    <tbody>
                        {tb_data}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default DisplayTable