
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>Huigere</title>
<link href="<c:url value="/static/resources/css/inner-style.css" />" rel="stylesheet" type="text/css" />
</head>

<body>
<%@include file="pr_header.jsp" %>
<div class="bdy-container">
  <h2 class="bdyhd1">Available Suites</h2> 
<div class="suiteleftsec"><h2>Suits Available</h2>
	<c:forEach items="${staySuites}" var="staySuite" >	
	<a href="http://localhost:7001/StayEclipse/StaySuite/getSuiteDetails?staySuiteId=${staySuite.id}"> 			
	<img src="<c:url value="/static/resources/images/s1.jpg" />" >
	<img src="<c:url value="/static/resources/images/s2.jpg" />" >
	<img src="<c:url value="/static/resources/images/s3.jpg" />" >
	</a>
	</c:forEach>
</div>    
<div class="suiterightsec"><h2>Menus & Prices</h2>
	<img src="<c:url value="/static/resources/images/ban1.jpg" />" width="800" height="400" /></td>
</div>

<div class="suiterightsec"><h2>Places nearby</h2>
	<c:forEach items="${stayNearByPlaces}" var="stayNearByPlace" >				
	<a href="http://localhost:7001/StayEclipse/StayNearByPlace/getStayNearByPlaceDetails?stayNearByPlaceId=${stayNearByPlace.id}">
	<img src="<c:url value="/static/resources/images/s1.jpg" />" >
	<img src="<c:url value="/static/resources/images/s2.jpg" />" >
	<img src="<c:url value="/static/resources/images/s3.jpg" />" >
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
