// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

var dayList = [];
var month, day, year, newDate;
var date = new Date();
for (let i=0; i<revenueDayList.length; i++) {
    month = date.getMonth() + 1; //months from 1-12
    day = date.getDate();
    year = date.getFullYear();

    newDate = year + "/" + month + "/" + day;
    dayList.push(newDate);

    date.setDate(date.getDate() - 1);
}

// Bar Chart Example
var ctx = document.getElementById("barDay");
var myLineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: dayList.reverse(),
    datasets: [{
      label: "Revenue",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: revenueDayList,
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'day'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: revenueDayList.length
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
