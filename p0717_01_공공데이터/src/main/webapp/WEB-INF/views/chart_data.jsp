<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		let ch_label = ['1월', '2월', '3월', '4월', '5월', '6월'];
					let ch_data = [20, 19, 40, 30, 20, 50]; 
					alert("검색을 시작합니다");
					
					const ctx = document.getElementById('myChart');
					
					  new Chart(ctx, {
					    type: 'bar',
					    data: {
					      labels: ch_label,
					      datasets: [{
					        label: '지역별 대출액',
					        data: ch_data,
					        borderWidth: 1
					      }]
					    },
					    options: {
					      scales: {
					        y: {
					          beginAtZero: true
					        }
					      }
					    }
					  });//chart
					  
					  
	<h2>차트그리기</h2>
		<label>데이터</label>
		<input type="text" name="data" id="data">
		<button type="button" id="btn">검색</button>
		<br><br>
		<div id="main">
	  		<canvas id="myChart"></canvas>
		</div>
		
		<script>
		  
		</script>				  
	
	</body>
</html>