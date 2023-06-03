<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <section name="itemDetails">
            <p class="text_item_details">Item Details</p>
            <div class="itemDetails-box">
              <div class="chart-pie-container">
                <canvas id="pie-chart"></canvas>
                <script src="/chart.min.js"></script>
                <script>
                  new Chart(document.getElementById("pie-chart"), {
                    type: "pie",
                    data: {
                      datasets: [
                        {
                          backgroundColor: ["#009698", "#ab2300", "#ffcd00"],
                          data: [60, 20, 40],
                        },
                      ],
                    },
                  });
                </script>
              </div>
              <div class="pie-label">
                <h4 style="margin-bottom: 15px">Types</h4>
                <h5 class="pLabel">
                  <div class="colorselection colorselection--black"></div>
                  Dry ingredients
                </h5>
                <h5 class="pLabel">
                  <div class="colorselection colorselection--red"></div>
                  Wet ingredients
                </h5>
                <h5 class="pLabel">
                  <div class="colorselection colorselection--yellow"></div>
                  Stuff
                </h5>

                <h4 style="margin-top: 35px; margin-bottom: 15px">Quantity</h4>
                <h5 class="pLabel">
                  <div class="colorselection colorselection--black"></div>
                  20 ingredients
                </h5>
                <h5 class="pLabel">
                  <div class="colorselection colorselection--red"></div>
                  40 ingredients
                </h5>
                <h5 class="pLabel">
                  <div class="colorselection colorselection--yellow"></div>
                  60 stuff
                </h5>
              </div>
            </div>
          </section>
     
</body> 
</html>