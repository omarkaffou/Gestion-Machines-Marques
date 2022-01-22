 var label;
var dataset;

$(document).ready(function(){
    $.ajax({
        url:"MachineController",
        data:{action:"listeNombreParMachineParMarque"},
        method:"post",
        success:function(data){
            console.log(data);
            label = data.map(val =>  val["cle"]);
            dataset = data.map(val =>  val["valeur"]);
           updateChart(label, dataset);
           updateChart2(label, dataset);
           updateChart3(label, dataset);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(error);
        }
    });
});
function updateChart(keys, values) {
    var ctx = document.getElementById('myDoughnutChart').getContext('2d');
    var chart = new Chart(ctx, {
        // The type of chart we want to create
        type: 'bar',
        // The data for our dataset
        data: {
            labels: keys,
            datasets: [{
                    label: 'Nombre de machines par marque',
                    backgroundColor: [
                'rgb(65,105,225)',
                'rgb(0,250,154)',
                'rgb(255,0,255)',
                'rgb(255, 234, 0)',
                'rgb(255, 95, 31)'
            ],
            borderColor: [
                'rgb(65,105,225)',
                'rgb(0,250,154)',
                'rgb(255,0,255)',
                'rgb(255, 234, 0)',
                'rgb(255, 95, 31)'
            ],
            borderWidth: 1,
                    data: values,
                    
                }]
        },
        // Configuration options go here
        options: {
        legend: {
            display: false
        },
        scales: {
            xAxes: [{
                gridLines: {
                    display: false
                }
            }],
            yAxes: [{
                ticks: {
                    stepSize: 1,
                    beginAtZero :  true,
                },
                gridLines: {
                    display: false
                }
            }]
            
        }
    
    }
    });
}

function updateChart2(keys, values) {
    var ctx = document.getElementById('myBarChart').getContext('2d');
    var chart = new Chart(ctx, {
        // The type of chart we want to create
        type: 'pie',
        // The data for our dataset
        data: {
            labels: keys,
            datasets: [{
                    label: 'nombre de marque par machine',
                    backgroundColor: [
                'rgb(65,105,225)',
                'rgb(0,250,154)',
                'rgb(255,0,255)',
                'rgb(255, 234, 0)',
                'rgb(255, 95, 31)'
            ],
            borderColor: [
                'rgb(65,105,225)',
                'rgb(0,250,154)',
                'rgb(255,0,255)',
                'rgb(255, 234, 0)',
                'rgb(255, 95, 31)'
            
            ],
            borderWidth: 1,
                    data: values,
                    
                }]
        },
        // Configuration options go here
        options: {
        legend: {
            display: false
        },
        scales: {
            xAxes: [{
                gridLines: {
                    display: false
                }
            }],
            yAxes: [{
                ticks: {
                    stepSize: 1,
                    beginAtZero :  true,
                },
                gridLines: {
                    display: false
                }
            }]
            
        }
    
    }
    });
}

function updateChart3(keys, values) {
    var ctx = document.getElementById('myLineChart').getContext('2d');
    var chart = new Chart(ctx, {
        // The type of chart we want to create
        type: 'doughnut',
        // The data for our dataset
        data: {
            labels: keys,
            datasets: [{
                    label: 'nombre de marque par machine',
                    backgroundColor: [
                'rgb(65,105,225)',
                'rgb(0,250,154)',
                'rgb(255,0,255)',
                'rgb(255, 234, 0)',
                'rgb(255, 95, 31)'
            ],
            borderColor: [
                'rgb(65,105,225)',
                'rgb(0,250,154)',
                'rgb(255,0,255)',
                'rgb(255, 234, 0)',
                'rgb(255, 95, 31)'
            ],
            borderWidth: 1,
                    data: values,
                    
                }]
        },
        // Configuration options go here
        options: {
        legend: {
            display: false
        },
        scales: {
            xAxes: [{
                gridLines: {
                    display: false
                }
            }],
            yAxes: [{
                ticks: {
                    stepSize: 1,
                    beginAtZero :  true,
                },
                gridLines: {
                    display: false
                }
            }]
            
        }
    
    }
    });
    }



