var scaling = 1.7;
var scaling2 = 1.25;
var scaling3 = 2;
// count
var currentSliderCount = 0;
var videoCount = $(".slider-container").children().length;
var showCount = 4;
var sliderCount = videoCount / showCount;
var controlsWidth = 40;
var scollWidth = 0;
    

$(document).ready(function(){
    // $('.slider-container
	// .slide:nth-last-child(-n+4)').prependTo('.slider-container');
    init();
    
});
$( window ).resize(function() {
    init();
});
function init(){
    // elements
    var win = $(window);
    var sliderFrame = $(".slider-frame");
    var sliderContainer = $(".slider-container");
    var slide = $(".slide");
    
    // counts
    var scollWidth = 0;
 
    
    // sizes
    var windowWidth = win.width();
    var frameWidth = win.width() - 80;
     if(windowWidth >= 0 && windowWidth <= 414){
       showCount = 2;
   }else if(windowWidth >= 414 &&  windowWidth <= 768){
       showCount = 3;
   }else{
       showCount = 4;
   }
    var videoWidth = ((windowWidth - controlsWidth * 2) / showCount );
    var videoHeight = Math.round(videoWidth / (16/9));
    
    var videoWidthDiff = (videoWidth * scaling) - videoWidth;
    var videoHeightDiff = (videoHeight * scaling) - videoHeight;
    
  
    
    // set sizes
    sliderFrame.width(windowWidth);
    sliderFrame.height(videoHeight * scaling3);
    
    
    // sliderFrame.css("top", (videoHeightDiff / 2));
    
    sliderContainer.height(videoHeight * scaling);
    sliderContainer.width((videoWidth * videoCount) + videoWidthDiff);
    sliderContainer.css("top", (videoHeightDiff / 2));
    sliderContainer.css("margin-left", (controlsWidth));
    
    slide.height(videoHeight);
    slide.width(videoWidth);
    
    // hover effect
    $(".slide").delay(2000).mouseover(function() {
        $(this).css("width", videoWidth * scaling2);
        $(this).css("height", videoHeight * scaling);
        $(this).css("top", -(videoHeightDiff / 2));
        $(this).find('.contents_btn').delay(1000).fadeIn();   //버튼 show
        $(this).find('.context_info ').delay(1000).fadeIn(); //버튼 show
        $(this).find('#over_vid').get(0).play();  //마우스 오버하면 비디오 플레이 
       
 /*       if($(".slide").index($(this)) == 0 || ($(".slide").index($(this))) % 4 == 0){
          // do nothing
        }
        else if(($(".slide").index($(this)) + 1) % 4 == 0 && $(".slide").index($(this)) != 0){
            $(this).parent().css("margin-left", -(videoWidthDiff - controlsWidth));
        }
        else{
            $(this).parent().css("margin-left", - (videoWidthDiff / 2));
        }*/
    }).mouseout(function() {
        $(this).css("width", videoWidth * 1);
        $(this).css("height", videoHeight * 1);
        $(this).css("top", 0);
        $('.contents_btn ').hide();
        $('.context_info ').hide();        
        $(this).find('#over_vid').get(0).src="";
        $(this).find('#over_vid').get(0).src= "http://kghosting.dothome.co.kr/video/doctor_lifes.mp4";
        //마우스가 나가면 src를 지운후 재 부여하여 재생 리셋  //src 주소를 수정해야함 현재 슬의생으로 고정해놈
        $(this).parent().css("margin-left", controlsWidth);
    });
    $('.popular_movie_infobtn').click(function(){
    	$('.popup_layer').css({
    		display:"block",    
            position:"fixed",
            top:"0px"
    	});
    	$(main).css({
            overflow:"hidden"
        });
    });
    $('.more_view').click(function(){
    	$('.popup_layer').css({
    		display:"block",    
            position:"fixed",
            // top : $(window).scrollTop(),
            // 탑 수정해야함
            top:"0px"
    	});
    	
    	 $('.hidden_info_box').css({
             display:"none"
         });
         $(main).css({
             overflow:"hidden"
         });
    });
    
    $('.close_btn').click(function(){
        $('.popup_layer').css({
            display:"none"
        });
        $(main).css({
            "overflow-y":"scroll"
        })
    });

    // controls
    controls(frameWidth, scollWidth);
}
function controls(frameWidth, scollWidth){
    var prev = $(".prev");
    var next = $(".next");
    
    next.on("click", function(){
        console.log(currentSliderCount);
        console.log(sliderCount);
        scollWidth = scollWidth + frameWidth;
        $(this).siblings('.slider-container').animate({
            left: - scollWidth
        }, 300, function(){ 
            if(currentSliderCount >= sliderCount-1){
                $(".slider-container").css("left", 0);
                currentSliderCount = 0;
                scollWidth = 0;
            }else{
                currentSliderCount++;
            }
        });        
    });
    prev.on("click", function(){
        scollWidth = scollWidth - frameWidth;
        $(this).siblings('.slider-container').animate({
            left: + scollWidth
        }, 300, function(){ 
            currentSliderCount--;
        });
        // $(".slider-container").css("left", scollWidth);
    });
    
    
    
    
};