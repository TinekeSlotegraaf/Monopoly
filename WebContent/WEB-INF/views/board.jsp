<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<link type="text/css" rel="stylesheet" href="/Monopoly/resources/stylesheet.css"/>




<title>Monopoly Board</title>
</head>
<body>
<section>
<div class = wholeGame>

<div class = firstColumn>
<h2> name of the player is ...</h2>
<p> the player has ... money </p>
</div>
<div class = secondColumn>

<canvas id="canvas1" 
width="966" height="966"
style="z-index:1;
position:absolute;
left0px;
top0px;"></canvas>
<canvas id="canvas2" 
width = "966" height = "966"
style="z-index:2;
position:absolute;
left0px;
top0px;"></canvas>



</div>
<div class = thirdColumn>
<h2>
<a href="<c:url value="/diceRoll" />">Roll the Dice</a>
</h2>
<p>
<img src="<c:url value="/resources/dice1.jpg"/>" class=dice/>
<img src="<c:url value="/resources/dice1.jpg"/>" class=dice/>
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

function init(){
	img1.src = '<c:url value="/resources/Board_London_Edition.jpg" />';
	img2.src = '<c:url value="/resources/boot.jpg" />';
	// assign our canvas element to a variable
	layer1 = document.getElementById("canvas1");
	// Create the HTML5 context object to enable draw methods
	ctx1 = layer1.getContext("2d");
	layer2 = document.getElementById("canvas1");
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
		ctx2.drawImage(img2,60,900, 60, 60);
	};
};
init();
</script>
</section>
</body>
</html>