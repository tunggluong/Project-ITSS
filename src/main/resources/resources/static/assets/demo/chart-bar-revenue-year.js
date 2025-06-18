// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

var yearList = [];
var year, year, newYear;
var date = new Date();
for (let i=0; i<revenueYearList.length; i++) {
    year = date.getFullYear();

    yearList.push(year);

    date.setYear(date.getFullYear() - 1);
}

// Bar Chart Example
var ctx = document.getElementById("barYear");
var myLineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: yearList.reverse(),
    datasets: [{
      label: "Revenue",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: revenueYearList,
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'year'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: revenueYearList.length
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          maxTicksLimit: 10
        },
        gridLines: {
          display: true
        }
      }],
    },
    legend: {
      display: false
    }
  }
});
