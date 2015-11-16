<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<link type="text/css" rel="stylesheet" href="/Monopoly/resources/stylesheet.css"/>
<title>Monopoly Board</title>
</head>
<body>
<div class = wholeGame>

<div class = firstColumn>
<p> name of the player is ...</p>
<p> the player has ... money </p>
</div>
<div class = secondColumn>
	<img src="<c:url value="/resources/Board_London_Edition.jpg" />" id=boardImage/>
	<script>
	$(document).ready(function() {
  $('img').click(function(e) {
    var offset = $(this).offset();
    var relativeX = (e.pageX - offset.left);
    var relativeY = (e.pageY - offset.top);
    alert(relativeX+':'+ relativeY);
  });
});
	</script>
</div>
<div class = thirdColumn>
</div>

</div>
	

</body>
</html>