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
				<p><img src='<c:url value="/resources/boot.jpg"  />' width=60 height=60/> </p>
				<h2>${name2}</h2>
				<p>money: ${money2}</p>
				<p><img src='<c:url value="/resources/battleship.jpg" />' width=60 height=60/> </p>
				<h2>${name3}</h2>
				<p>money: ${money3}</p>
				<p><img src='<c:url value="/resources/tophat.jpg" />'width=60 height=60 /> </p>
			</div>
			<div class=secondColumn>

				<canvas id="canvas1" width="966" height="966"
					style="z-index: 1; position: absolute;"></canvas>
				<canvas id="canvas2" width="966" height="966"
					style="z-index: 2; position: absolute;"></canvas>
				<canvas id="canvas3" width="966" height="966"
					style="z-index: 3; position: absolute;"></canvas>
				<canvas id="canvas4" width="966" height="966"
					style="z-index: 4; position: absolute;"></canvas>


			</div>
			<div class=thirdColumn>
				<h2>
					<a href="<c:url value="/diceRoll" />">Roll the Dice</a>
				</h2>
				<p>
<script>
//preload the six images first
var face1=new Image()
face1.src="<c:url value="/resources/dice1.jpg"/>"
var face2=new Image()
face2.src="<c:url value="/resources/dice2.jpg"/>"
var face3=new Image()
face3.src="<c:url value="/resources/dice3.jpg"/>"
var face4=new Image()
face4.src="<c:url value="/resources/dice4.jpg"/>"
var face5=new Image()
face5.src="<c:url value="/resources/dice5.jpg"/>"
var face6=new Image()
face6.src="<c:url value="/resources/dice6.jpg"/>"
</script>

		<img src="<c:url value="/resources/dice1.jpg"/>" class=dice id=dice1 name=dice1/> 
		<img src="<c:url value="/resources/dice1.jpg"/>" class=dice id=dice2 name=dice2 />
		
<script>

    var diceValue = ${dice1};
    var diceValue2 = ${dice2};
    document.images.namedItem("dice1").src=eval("face"+diceValue+".src")
    document.images.namedItem("dice2").src=eval("face"+diceValue2+".src")

</script>

				</p>
				
				<h2>Tile:</h2>
				<p> ${tileName}</p>
				<p> ${tileExplanation}</p>
				<h2>Card:</h2>
				<p> ${cardName} </p>
				<p> Cost is ${costTile};
				<p> ${cardExplanation} </p>
				<p> en een klein formulier met twee knoppen </p>

			</div>

		</div>
		<script> 

var layer1;
var layer2;
var ctx1;
var ctx2;
var img1 = new Image();
var img2 = new Image();
var img3 = new Image();
var img4 = new Image();
var WIDTH = 966;
var HEIGHT = 966;
var xCoordinate1 = ${xCoordinate1};
var yCoordinate1 = ${yCoordinate1};
var xCoordinate2 = ${xCoordinate2};
var yCoordinate2 = ${yCoordinate2};
var xCoordinate3 = ${xCoordinate3};
var yCoordinate3 = ${yCoordinate3};

function init(){
	img1.src = '<c:url value="/resources/Board_London_Edition.jpg" />';
	img2.src = '<c:url value="/resources/boot.jpg" />';
	img3.src = '<c:url value="/resources/battleship.jpg" />';
	img4.src = '<c:url value="/resources/tophat.jpg" />';
	// assign our canvas element to a variable
	layer1 = document.getElementById("canvas1");
	// Create the HTML5 context object to enable draw methods
	ctx1 = layer1.getContext("2d");
	layer2 = document.getElementById("canvas2");
	ctx2 = layer2.getContext("2d");
	layer3 = document.getElementById("canvas3");
	ctx3 = layer3.getContext("2d");
	layer4 = document.getElementById("canvas4");
	ctx4 = layer4.getContext("2d");
	drawAll();
}

function drawAll(){
	draw1();
	draw2();
	draw3();
	draw4();
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
		ctx2.drawImage(img2,xCoordinate1-30,yCoordinate1-30,60,60);
	};
};
function draw3(){
	ctx3.clearRect(0,0,WIDTH,HEIGHT);
	img3.onload = function(){
		ctx3.drawImage(img3,xCoordinate2-30,yCoordinate2-30,60,60);
	}
}
function draw4(){
	ctx4.clearRect(0,0,WIDTH,HEIGHT);
	img4.onload = function(){
		ctx4.drawImage(img4,xCoordinate3-30,yCoordinate3-30,60,60);
	}
}
init();
</script>
	</section>
</body>
</html>