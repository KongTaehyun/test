<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>NetFilx</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Netflix</title>

<script src="https://kit.fontawesome.com/c7adb7b803.js"
	crossorigin="anonymous"></script>
<!-- 폰트/ 아이콘 -->

<link href="<c:url value="./resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="./resources/css/header.css" />"
	rel="stylesheet">
<link href="<c:url value="./resources/css/main_top_style.css" />"
	rel="stylesheet">
<link href="<c:url value="./resources/css/main_style.css" />"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<style>
.hide_menu{
   display:flex !important;
}
.main-table{
   display:table !important;
}
</style>


</head>
<body>
	<!-- header -->
	<jsp:include page="include/header.jsp"/>


	<main id="main">

	<div class="popular_movie">
		<video autoplay="autoplay" id="vid" muted="muted"
			poster="http://kghosting.dothome.co.kr/poster/doctor_lifes_big.jpg">
			<source src="http://kghosting.dothome.co.kr/video/doctor_lifes.mp4"
				type="video/mp4">

		</video>
		<!-- 	<img
			src="https://occ-0-395-325.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABQUdI3-AGBRBmdqOgvC9743TfSgCKAAtD1POkRDkBG6m9uk6KP_NbbepYv4S9l8sbvG8PiDdD84VMDIdgXZEScGnA2jX.webp?r=a81"
			alt="popular movie" class="popular_movie_img"> -->

		<div class="popular_movie_info_box">
			<div class="popular_movie_info">
				<div class="popular_movie_title">
					<img src="http://kghosting.dothome.co.kr/logo/doctor_lifes_logo.png" alt="">
				</div>
				<div class="popular_movie_overview">어떤 이에겐 아픔이 어떤 이에겐 희망이 되는 병원이란 공간. 
				산모는 아기를 지켜내겠다는 간절함으로 하루하루를 버텨낸다. 이 모습을 지켜보는 석형도 계속 마음이 쓰이는데...
                                    한편 서울과 속초를 오가며 바쁘게 일하는 송화에게 한 가지 제안이 건네진다.</div>
                            
			</div>
			<div class="popular_btn_box">
				<button class="popular_movie_play popular_btn">
					<i class="fas fa-play" > 재생</i>
				</button>
				<button class="popular_movie_infobtn popular_btn">
					<i class="fas fa-info-circle"> 상세정보</i>
				</button>
			</div>
		</div>
		<div class="popular_subbtn_box">
			<button class="popular_replay" onclick="restart()">
			
				<i class="fas fa-redo"></i>
			</button>
			<span class="movie_age">15+</span>
		</div>
	</div>
	<!-- movie end-->


	<div class="slider-frame">
		<h2>넷플릭스 인기 콘텐츠</h2>
		<div class="btn prev"><</div>
		<div class="btn next">></div>
		<div class="slider-container">
			<%--  <%
			    for (int i = 0; i < 10; i++) {
			%>  --%>
			<c:forEach var="i" items="${contentsList}">
				<div class="slide">
					<div>
				<!-- 
	                   <video id="over_vid" muted="muted"
	                        poster="http://kghosting.dothome.co.kr/poster/mr.png">
	                        <source src="http://kghosting.dothome.co.kr/video/mr.mp4"
	                            type="video/mp4">
	                    </video>  -->
	                      
	                    
	                   <!-- 트래픽 막혀서 아래로 태스트 -->
	                    <video id="over_vid" muted="muted"
	                        poster="http://kghosting.dothome.co.kr/poster/doctor_lifes.png">
	                        <source src="<c:url value="/resources/video/doctor_lifes2.mp4" />"
	                            type="video/mp4">                        
	                    </video>
	                   
	                    
						<div class="contents_btn">
							<ul>
								<li><i class="fas fa-play"></i></li>
								<li><i class="fas fa-plus"></i></li>
								<li><i class="far fa-thumbs-up"></i></li>
								<li><i class="far fa-thumbs-down"></i></li>
								<li class="more_view"><i class="fas fa-chevron-down"></i></li>
							</ul>
						</div>
						<div class="context_info">
							<span class="con_match">98% 일치</span> <span class="con_age">${i.age}  </span>
							<span class="con_season">시즌 ${i.seosons}개</span> <span class="con_quality">${i.quality}</span>
						</div>
					</div>
				</div>
			</c:forEach>
			<%--  <%
			    }
			%> --%>
		</div>
	</div>


	<div class="slider-frame">
		<h2>지금 뜨는 콘텐츠</h2>
		<div class="btn prev"></div>
		<div class="btn next"></div>
		<div class="slider-container">
			<%
			    for (int i = 0; i < 10; i++) {
			%>
			<div class="slide" >
				<div>
	               				
	               <video id="over_vid" muted="muted"
						poster="http://kghosting.dothome.co.kr/poster/exit.png">
						<source src="http://kghosting.dothome.co.kr/video/exit.mp4"
							type="video/mp4">
					</video> 
					 
					
					<!-- 트래픽 막혀서 아래로 태스트 -->
					
					<div class="contents_btn">
						<ul>
							<li><i class="fas fa-play"></i></li>
							<li><i class="fas fa-plus"></i></li>
							<li><i class="far fa-thumbs-up"></i></li>
							<li><i class="far fa-thumbs-down"></i></li>
							<li class="more_view" onclick="hidden_video()"><i class="fas fa-chevron-down"></i></li>
						</ul>
					</div>
					<div class="context_info">
						<span class="con_match">98% 일치</span> <span class="con_age">15+</span>
						<span class="con_season">시즌 1개</span> <span class="con_quality">HD</span>
					</div>
				</div>
			</div>
			<%
			    }
			%>
		</div>
	</div>


	</div>
	<div class="popup_layer">
		<div class="contents_layer">
			<div class="layer_moviebox">
				<video id="vid_hidden" muted="muted"
					poster="http://kghosting.dothome.co.kr/poster/exit_big.png">
					<source src="http://kghosting.dothome.co.kr/video/exit.mp4"
						type="video/mp4">
				</video>
				<div class="layer_inner_info">
					<img src="http://kghosting.dothome.co.kr/logo/exit_logo.png" alt="">
					<div class="layer_info_btn">
						<ul>
							<li><i class="fas fa-play">재생</i></li>
							<li><i class="fas fa-plus"></i></li>
							<li><i class="far fa-thumbs-up"></i></li>
							<li><i class="far fa-thumbs-down"></i></li>
						</ul>
					</div>
				</div>
				<i class="fas fa-times close_btn"></i>
			</div>
			<!--이미지부분 -->
			<div class="layer_info_box">
				<div class="layer_con_left">
					<div class="layer_content_info">
						<span class="con_match">98% 일치</span> <span class="con_age">15+</span>
						<span class="con_season">시즌 1개</span> <span class="con_quality">HD</span>
					</div>
					<div class="layer_contnet_text_box">
						<span class="open_day">매주 목요일 새로운 에피소드 공개</span> <span
							class="layer_content_text">세상을 위협하는 무시무시한 악마의 세력이 문명이 파괴된
							지구에 어둠을 드리우는 가운데, 세 명의 영웅이 유일한 구원의 빛이 된다.</span>
					</div>
				</div>
				<div class="layer_con_right">
					<p>
						출연: <span><a href="">오스틴 버틀러</a></span> <span><a href="">포피
								드레이틴</a></span> <span><a href="">이바나 바케로</a></span> <span><a href="">더보기</a></span>
					</p>
					<p>
						장르: <span><a href="">TV프로그램·판타지</a></span> <span><a href="">도서
								원작 TV프로그램</a></span> <span><a href="">TV 드라마</a></span>
					</p>
				</div>
			</div>
			<div class="play_list_box">
				<div class="play_list_top">
					<h3>
						회차 <select name="season_list" id="season_select">
							<option value="시즌 1">시즌 1</option>
							<option value="시즌 2">시즌 2</option>
						</select>
					</h3>

				</div>
				<div class="episode_list_box">
					<div class="episode_list">
						<div class="episode_inner_card">
							<div class="ep_no">1</div>
							<div class="ep_img">
								<img
									src="https://occ-0-395-325.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABVYFdwBMDkR7BoGopjQjwcq6PBZ4W3piMkb35OBzLbh7b_xl_CQIO49bEQT22GwrpzxLqV8gczlSmojTi8RJi51mdl_QebamgnIeKn-zJtwz4yJH.webp?r=b1b"
									alt="">
							</div>
							<div class="ep_con">
								<span class="ep_name">선택받은자 : 파트1</span> <span class="ep_time">48분</span>
								<p class="ep_txt">'선택받은 자'로 임명된 앰벌리에겐 끔찍한 환영이 보인다. 에레트리아는
									윌뿐만 아니라 윌이 죽어가는 어머니에게서 받은 엘프석에 눈독을 들인다.</p>
							</div>
						</div>
						<div class="episode_inner_card">
							<div class="ep_no">2</div>
							<div class="ep_img">
								<img
									src="https://occ-0-395-325.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABTKGC8-zQsDyAHFCb5uYPtM3qnhQ-oaB9R65_7VOosJGewYKZP7aRGtcZ6bSYoBwmIh_PPuAssSFWklctWuQPUHW2qqCNLmstPqJIii_Fh80K6sw.webp?r=e3f"
									alt="">
							</div>
							<div class="ep_con">
								<span class="ep_name">선택받은자 : 파트2</span> <span class="ep_time">41분</span>
								<p class="ep_txt">다그다 모어는 선택받은 기사단을 학살하기 위해 체인질링을 보낸다. 앰벌리와
									에레트리아는 정면승부를 하고, 알라논은 윌에게 운명을 일깨워준다.</p>
							</div>
						</div>
						<div class="episode_inner_card">
							<div class="ep_no">3</div>
							<div class="ep_img">
								<img
									src="https://occ-0-395-325.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABblNwFNaDlKD7uM4guMbChhIxYjBdXviWbtawb9B5IHb5usqKnk93_ZbRCyLebEytdTbHFo6scLvbn-PYmulNfSRaT-C2VlXrbyAyRr2nIYZyw04.webp?r=b3b"
									alt="">
							</div>
							<div class="ep_con">
								<span class="ep_name">퓨리</span> <span class="ep_time">41분</span>
								<p class="ep_txt">에레트리아와 로버족은 엘프석의 비밀을 알아내는 데 혈안이 되어 윌과 앰벌리를
									납치하고, 악마 퓨리는 이들을 모두 뒤쫓는다.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--컨텐츠 박스-->
	</div>

	<jsp:include page="include/footer.jsp"/>
	</main>






	<script src="<c:url value="./resources/js/header.js" />"></script>
	<!--header 스크롤시 색변환 js-->
	<script src="<c:url value="./resources/js/main_slider.js" />"></script>
	<!--슬라이더 js -->
	<script src="<c:url value="./resources/js/video.js" />"></script>


	<script>
/* 		document.getElementById("vid").muted = ture;
		// 소리 끄기 
		//Muted Play중에 Muted을 없애면, 실행이 멈춥니다. 
		document.getElementById("vid").muted = false;
		// 소리 켜기
		 */
	</script>







</body>
</html>
