import React from 'react';
import { Chart as ChartJS, ArcElement, Tooltip, Legend, CategoryScale, LinearScale, BarElement, Title, } from 'chart.js';
import { Doughnut } from 'react-chartjs-2';
import { Bar } from 'react-chartjs-2';

import "./Sta.css";

const Statistic = () => {
    ChartJS.register(ArcElement, Tooltip, Legend, CategoryScale, LinearScale, BarElement, Title);

    const data = {
        labels: ['피자', '스테이크', '파스타', '연어스테이크', '치즈', '마카롱'],
        datasets: [
            {
                label: '# of Votes',
                data: [10, 10, 10, 10, 15, 15],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)',
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)',
                ],
                borderWidth: 1,
            },
        ],
    };

    const options = {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: '요일별 매출 통계',
                font: {
                    size: 25,
                },
            },
        },
    };

    const labels = ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'];

    const data2 = {
        labels,
        datasets: [
            {
                label: '요일별 매출 (단위 : 만원)',
                data: [10, 10, 15, 7, 8, 10, 10],
                backgroundColor: 'rgba(53, 162, 235, 0.5)',
            },
        ],
    };
    return (
        <>
            <div className='explain1'><h3>주간 매출 (총 매출 : 70만원)</h3></div>
            <div className='statistic'>
                <Doughnut data={data} />
            </div>
            <div className='explain2'><h3>단위: 만원</h3></div>
            <br></br>
            <br></br>
            <div className='statistic2'>
                <Bar options={options} data={data2} />
            </div>
            <br></br>
        </>
    );
}

export default Statistic