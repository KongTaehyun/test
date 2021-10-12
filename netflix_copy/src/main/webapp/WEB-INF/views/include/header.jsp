<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link href="<c:url value="../resources/css/header.css" />"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/c7adb7b803.js"
	crossorigin="anonymous"></script>

</head>
<body>
	<!-- header -->
	<header>
		<div class="header_container">
			<div class="logo">
				<a href=""> <img
					src="<c:url value="../resources/img/Netflix_Logo.png" />"
					alt="NETFLIX">
				</a>
				<button class="header_toggleBtn">
					<i class="fa fa-bars"></i>
				</button>
			</div>
			<ul class="main_nav hide_menu">
				<li class="main_nav_tab"><a href="">Ȩ</a></li>
				<li class="main_nav_tab"><a href="">TV ���α׷�</a></li>
				<li class="main_nav_tab"><a href="">��ȭ</a></li>
				<li class="main_nav_tab"><a href="">�ֽ� ������</a></li>
				<li class="main_nav_tab"><a href="">���� ���� ������</a></li>
			</ul>
			<ul class="sub_nav">
				<li class="sub_nav_tab hide_menu"><i class="fas fa-search"></i></li>
				<li class="sub_nav_tab hide_menu">Ű��</li>
				<li class="sub_nav_tab hide_menu"><i class="fas fa-gift"></i></li>
				<li class="sub_nav_tab hide_menu"><i class="fas fa-bell"></i></li>
				<li class="sub_nav_tab" onmouseover="mover()" onmouseout="mout()"><img
					src="https://occ-0-395-325.1.nflxso.net/dnm/api/v6/K6hjPJd6cR6FpVELC5Pd6ovHRSk/AAAABbme8JMz4rEKFJhtzpOKWFJ_6qX-0y5wwWyYvBhWS0VKFLa289dZ5zvRBggmFVWVPL2AAYE8xevD4jjLZjWumNo.png?r=a41"
					alt="" />
					<div class="sub_nav_user_tab" id="user_tab_btn">
						<ul class="user_sec1">
							<%
							    for (int i = 0; i < 2; i++) {
							%>
							<li>
								<div style="display: flex">
									<img
										src="https://occ-0-395-325.1.nflxso.net/dnm/api/v6/K6hjPJd6cR6FpVELC5Pd6ovHRSk/AAAABbme8JMz4rEKFJhtzpOKWFJ_6qX-0y5wwWyYvBhWS0VKFLa289dZ5zvRBggmFVWVPL2AAYE8xevD4jjLZjWumNo.png?r=a41"
										alt="" /> <span>������ �̸�</span>
								</div>
							</li>
							<%
							    }
							%>
							<li><a href="">������ ����</a></li>
						</ul>

						<ul>
							<li><a href="">����</a></li>
							<li><a href="">�� ����</a></li>
							<li><a href="">�α׾ƿ�</a></li>
						</ul>
					</div></li>

			</ul>
		</div>
	</header>
    <script>
    function mover(){
        var ubox = document.getElementById("user_tab_btn")
        ubox.style.display ='block';
        ubox.style.background ='#black';
    }
    function mout(){
        var ubox = document.getElementById("user_tab_btn")
        ubox.style.display ='none';
    }
    </script>
</body>
</html>