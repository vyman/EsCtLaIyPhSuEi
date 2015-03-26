
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>Huigere</title>
<link href="<c:url value="/static/resources/css/inner-style.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/static/resources/css/imgLiquid.css" />" rel="stylesheet" type="text/css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js" type="text/javascript"></script>
<script src ="<c:url value="/static/resources/js/imgLiquidJs/imgLiquid.js" />" type="text/javascript"></script>
<!-- <script type="text/javascript">
	$(document).ready(function () {
		$(".suiterightsec").imgLiquid({fill:false});
	});
	</script> -->
</head>

<body>
<%@include file="pr_header.jsp" %>
<div class="bdy-container">
  <h2 class="bdyhd1">Available Suites</h2> 
<div class="suiteleftsec"><h2>Suits Available</h2>
	<c:forEach items="${staySuites}" var="staySuite" >	
	<a href="http://localhost:7001/StayEclipse/StaySuite/getSuiteDetails?staySuiteId=${staySuite.id}"> 			
	<img src="${ staySuite.suiteProfilePic}" />
	</a>
	</c:forEach>
</div>    
<div class="suiterightsec"><h2>Menus & Prices</h2>
	<img src="${stayMenu.menuphoto}" width="800" height="400" /></td>
</div>
<div class="suiterightsec imgLiquid"><h2>Places nearby</h2>
	<c:forEach items="${stayNearByPlaces}" var="stayNearByPlace" >				
	<a href="http://localhost:7001/StayEclipse/StayNearByPlace/getStayNearByPlaceDetails?stayNearByPlaceId=${stayNearByPlace.id}">
	<img src="${ stayNearByPlace.photo}" />
	</a>
	</c:forEach>
</div>


</div>  
<div class="cenDivBdr">
<a href="roomview.html" class="submit_btn">Next <img src="<c:url value="/static/resources/images/arrow2.png" />" alt="" class="no_resize"></a> 
</div>  
</div>
  

<!-- footer -->
<%@include file="pr_footer.jsp" %>
</body>
</html>
