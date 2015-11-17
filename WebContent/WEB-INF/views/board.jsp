<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="/Monopoly/resources/stylesheet.css" />




<title>Monopoly Board</title>
</head>
<body>
	<section>
		<div class=wholeGame>

			<div class=firstColumn>
				<h2>${name1}</h2>
				<p>money: ${money1}</p>
				<h2>${name2}</h2>
				<p>money: ${money2}</p>
				<h2>${name3}</h2>
				<p>money: ${money3}</p>
			</div>
			<div class=secondColumn>

				<canvas id="canvas1" width="966" height="966"
					style="z-index: 1; position: absolute;"></canvas>
				<canvas id="canvas2" width="966" height="966"
					style="z-index: 2; position: absolute;"></canvas>



			</div>
			<div class=thirdColumn>
				<h2>
					<a href="<c:url value="/diceRoll" />">Roll the Dice</a>
				</h2>
				<p>
					<script>
function changeImage() {
    var dice1 = ${dice1};
    var image = document.getElementById("dice1");
    if (dice1==1) {
        image.src = "<c:url value="/resources/dice1.jpg"/>"                                          ;
    } else if(dice1==2){
        image.src = "<c:url value="/resources/dice2.jpg"/>";
    } else if(dice1==3){
        image.src = "<c:url value="/resources/dice3.jpg"/>";
    } else if(dice1==4){
        image.src = "<c:url value="/resources/dice4.jpg"/>";
    } else if(dice1==5){
        image.src = "<c:url value="/resources/dice5.jpg"/>";
    }else if(dice1==6){
        image.src = "<c:url value="/resources/dice6.jpg"/>";
    }
}
</script>
		<img src="<c:url value="/resources/dice1.jpg"/>" onclick="changeImage()" class=dice id=dice1/> 
		<img src="<c:url value="/resources/dice1.jpg"/>" class=dice id=dice2 />
				</p>

			</div>

		</div>
		<script> 

var layer1;
var layer2;
var ctx1;
var ctx2;
var img1 = new Image();
var img2 = new Image();
var WIDTH = 966;
var HEIGHT = 966;
var xCoordinate = ${xCoordinate1};
var yCoordinate = ${yCoordinate1};

function init(){
	img1.src = '<c:url value="/resources/Board_London_Edition.jpg" />';
	img2.src = '<c:url value="/resources/boot.jpg" />';
	// assign our canvas element to a variable
	layer1 = document.getElementById("canvas1");
	// Create the HTML5 context object to enable draw methods
	ctx1 = layer1.getContext("2d");
	layer2 = document.getElementById("canvas2");
	ctx2 = layer2.getContext("2d");
	drawAll();
}

function drawAll(){
	draw1();
	draw2();
}
function draw1(){
	ctx1.clearRect(0,0,WIDTH,HEIGHT);
	// make sure the url is right!!
	
	img1.onload = function(){
		ctx1.drawImage(img1,0,0);
	};
}
function draw2(){
	ctx2.clearRect(0,0,WIDTH,HEIGHT);
	img2.onload = function(){
		ctx2.drawImage(img2,xCoordinate - 30,yCoordinate-30, 60, 60);
	};
};
init();
</script>
	</section>
</body>
</html>