import axios from "axios";
import React, { useEffect, useState} from "react";
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

const StyledTableCell = styled(TableCell)(({ theme }) => ({
    [`&.${tableCellClasses.head}`]: {
      backgroundColor: theme.palette.common.black,
      color: theme.palette.common.white,
    },
    [`&.${tableCellClasses.body}`]: {
      fontSize: 14,
    },
}));
  
const StyledTableRow = styled(TableRow)(({ theme }) => ({
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.action.hover,
    },
    // hide last border
    '&:last-child td, &:last-child th': {
      border: 0,
    },
}));

const TestTable=()=>{
    const [product, setProduct] = useState([]);

    const getProductData = async() =>{
        try{
            const data = await axios.get("/menu");
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
        
        <TableContainer component={Paper}>
            <Table sx={{ minWidth: 700 }} aria-label="customized table">
                <TableHead>
                    <TableRow>
                    <StyledTableCell>id</StyledTableCell>
                    <StyledTableCell align="right">name</StyledTableCell>
                    <StyledTableCell align="right">price</StyledTableCell>
                    <StyledTableCell align="right">info</StyledTableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {product
                    .map((item) => {
                        return (
                        <StyledTableRow key={item.id}>
                            <StyledTableCell component="th" scope="row">
                            {item.id}
                            </StyledTableCell>
                            <StyledTableCell align="right">
                            {item.name}
                            </StyledTableCell>
                            <StyledTableCell align="right">
                            {item.price}
                            </StyledTableCell>
                            <StyledTableCell align="right">
                            {item.info}
                            </StyledTableCell>

                        </StyledTableRow>
                        );
                    })}
                </TableBody>
            </Table>
        </TableContainer>
    );
    
};

export default TestTable