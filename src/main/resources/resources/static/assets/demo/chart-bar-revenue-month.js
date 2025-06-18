// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

var monthList = [];
var month, year, newMonth;
var date = new Date();
for (let i=0; i<revenueMonthList.length; i++) {
    month = date.getMonth() + 1; //months from 1-12
    year = date.getFullYear();

    newMonth = year + "/" + month;
    monthList.push(newMonth);

    date.setMonth(date.getMonth() - 1);
}

// Bar Chart Example
var ctx = document.getElementById("barMonth");
var myLineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: monthList.reverse(),
    datasets: [{
      label: "Revenue",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: revenueMonthList,
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: revenueMonthList.length
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
