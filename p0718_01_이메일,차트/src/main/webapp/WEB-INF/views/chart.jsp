<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>차트그리기</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
		<style>
			#main{border:3px solid black; width:70%; height: 550px; margin:20px auto;}
		</style>
		
		<script>
			$(function(){ // 기본구문
				
				let ch_label;
				let ch_data;
				
				$("#btn").click(function(){ // 버튼 누르면 실행
					alert("검색을 시작합니다");
					
					// 차트 초기화
					let chartStatus = Chart.getChart("myChart"); // <canvas> id
					  if (chartStatus != undefined) {
					  	chartStatus.destroy();
					  }
					
					ch_label = []; // x축
					ch_data = []; // y축
					
					// 데이터 불러오기
					$.ajax({

						url:"/chart_data", // FController에서 post방식으로 받음
						type:"post",
						data:{"data": $("#data").val()}, // body 부분에 data의 내용을
						dataType:"json",
						success:function(data){
							alert("성공");
							console.log("data"+data);
							
							// 데이터를 배열에 추가
							data.forEach(function(d){  // data의 각항목을 d로 지정
								console.log(d.region); // 각 항목의 지역값
								console.log(d.period);
								console.log(d.amt); // 각 항목의 액수
								
								if(d.period==null) ch_label.push(d.region);
								else ch_label.push(d.period); // 리스트에 추가
								ch_data.push(d.amt);
							});
	
							
							// 차트 생성 시작

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
						},
						error:function(){
							alert("실패");
						}
						
					});//ajax
			
			
				 });//btn
			});//jquery
		</script>
		
	</head>
	<body>
		
		<h2>차트그리기</h2>
		<label>데이터</label>
		<select name="data" id="data">
			<option value="region">지역별</option>
			<option value="period">기간별</option>
		</select>
		<button type="button" id="btn">검색</button>
		<br><br>
		<div id="main">
	  		<canvas id="myChart"></canvas>
		</div>
		
		<script>
		  
		</script>
	
	
	</body>
</html>