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
<!-- ��Ʈ/ ������ -->

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
				<div class="popular_movie_overview">� �̿��� ������ � �̿��� ����� �Ǵ� �����̶� ����. 
				���� �Ʊ⸦ ���ѳ��ڴٴ� ���������� �Ϸ��Ϸ縦 ���߳���. �� ����� ���Ѻ��� ������ ��� ������ ���̴µ�...
                                    ���� ����� ���ʸ� ������ �ٻڰ� ���ϴ� ��ȭ���� �� ���� ������ �ǳ�����.</div>
                            
			</div>
			<div class="popular_btn_box">
				<button class="popular_movie_play popular_btn">
					<i class="fas fa-play" > ���</i>
				</button>
				<button class="popular_movie_infobtn popular_btn">
					<i class="fas fa-info-circle"> ������</i>
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
		<h2>���ø��� �α� ������</h2>
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
	                      
	                    
	                   <!-- Ʈ���� ������ �Ʒ��� �½�Ʈ -->
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
							<span class="con_match">98% ��ġ</span> <span class="con_age">${i.age}  </span>
							<span class="con_season">���� ${i.seosons}��</span> <span class="con_quality">${i.quality}</span>
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
		<h2>���� �ߴ� ������</h2>
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
					 
					
					<!-- Ʈ���� ������ �Ʒ��� �½�Ʈ -->
					
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
						<span class="con_match">98% ��ġ</span> <span class="con_age">15+</span>
						<span class="con_season">���� 1��</span> <span class="con_quality">HD</span>
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
							<li><i class="fas fa-play">���</i></li>
							<li><i class="fas fa-plus"></i></li>
							<li><i class="far fa-thumbs-up"></i></li>
							<li><i class="far fa-thumbs-down"></i></li>
						</ul>
					</div>
				</div>
				<i class="fas fa-times close_btn"></i>
			</div>
			<!--�̹����κ� -->
			<div class="layer_info_box">
				<div class="layer_con_left">
					<div class="layer_content_info">
						<span class="con_match">98% ��ġ</span> <span class="con_age">15+</span>
						<span class="con_season">���� 1��</span> <span class="con_quality">HD</span>
					</div>
					<div class="layer_contnet_text_box">
						<span class="open_day">���� ����� ���ο� ���Ǽҵ� ����</span> <span
							class="layer_content_text">������ �����ϴ� ���ù����� �Ǹ��� ������ ������ �ı���
							������ ����� �帮��� ���, �� ���� ������ ������ ������ ���� �ȴ�.</span>
					</div>
				</div>
				<div class="layer_con_right">
					<p>
						�⿬: <span><a href="">����ƾ ��Ʋ��</a></span> <span><a href="">����
								�巹��ƾ</a></span> <span><a href="">�̹ٳ� ���ɷ�</a></span> <span><a href="">������</a></span>
					</p>
					<p>
						�帣: <span><a href="">TV���α׷�����Ÿ��</a></span> <span><a href="">����
								���� TV���α׷�</a></span> <span><a href="">TV ���</a></span>
					</p>
				</div>
			</div>
			<div class="play_list_box">
				<div class="play_list_top">
					<h3>
						ȸ�� <select name="season_list" id="season_select">
							<option value="���� 1">���� 1</option>
							<option value="���� 2">���� 2</option>
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
								<span class="ep_name">���ù����� : ��Ʈ1</span> <span class="ep_time">48��</span>
								<p class="ep_txt">'���ù��� ��'�� �Ӹ�� �ڹ������� ������ ȯ���� ���δ�. ����Ʈ���ƴ�
									���Ӹ� �ƴ϶� ���� �׾�� ��ӴϿ��Լ� ���� �������� ������ ���δ�.</p>
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
								<span class="ep_name">���ù����� : ��Ʈ2</span> <span class="ep_time">41��</span>
								<p class="ep_txt">�ٱ״� ���� ���ù��� ������ �л��ϱ� ���� ü�������� ������. �ڹ�����
									����Ʈ���ƴ� ����ºθ� �ϰ�, �˶���� ������ ����� �ϱ����ش�.</p>
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
								<span class="ep_name">ǻ��</span> <span class="ep_time">41��</span>
								<p class="ep_txt">����Ʈ���ƿ� �ι����� �������� ����� �˾Ƴ��� �� ������ �Ǿ� ���� �ڹ�����
									��ġ�ϰ�, �Ǹ� ǻ���� �̵��� ��� ���Ѵ´�.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--������ �ڽ�-->
	</div>

	<jsp:include page="include/footer.jsp"/>
	</main>






	<script src="<c:url value="./resources/js/header.js" />"></script>
	<!--header ��ũ�ѽ� ����ȯ js-->
	<script src="<c:url value="./resources/js/main_slider.js" />"></script>
	<!--�����̴� js -->
	<script src="<c:url value="./resources/js/video.js" />"></script>


	<script>
/* 		document.getElementById("vid").muted = ture;
		// �Ҹ� ���� 
		//Muted Play�߿� Muted�� ���ָ�, ������ ����ϴ�. 
		document.getElementById("vid").muted = false;
		// �Ҹ� �ѱ�
		 */
	</script>







</body>
</html>
