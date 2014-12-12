<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>Huigere</title>
<link href="<c:url value="/static/resources/css/inner-style.css" />" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<c:url value="/static/resources/css/pickmeup.css" />" type="text/css" />
<link href="<c:url value="/static/resources/jQueryAssets/jquery.ui.core.min.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/static/resources/jQueryAssets/jquery.ui.theme.min.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/static/resources/jQueryAssets/jquery.ui.datepicker.min.css" />" rel="stylesheet" type="text/css">
<script src="<c:url value="/static/resources/jQueryAssets/jquery-1.8.3.min.js" />" type="text/javascript"></script>
<link rel="stylesheet" href="<c:url value="/static/resources/js/jquery.bxslider.css" />" type="text/css" />
<script src="<c:url value="/static/resources/js/jquery.bxslider.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/resources/js/jquery.pickmeup.js" />" ></script>
<script type="text/javascript" src="<c:url value="/static/resources/js/demo.js" />" ></script>
<script type="text/javascript">
  $(document).ready(function(){
    
$('.bxslider').bxSlider({
  pagerCustom: '#bx-pager'
});
  });
</script>
<script src="<c:url value="/static/resources/jQueryAssets/jquery-ui-1.9.2.datepicker.custom.min.js" />" type="text/javascript"></script>
</head>

<body>
<%@include file="pr_header.jsp" %>
<div class="bdy-container">
   
<div class="leftsec-booking">
<h2>Room View</h2>
<div class="slider">
<ul class="bxslider">
  <li><img src="<c:url value="/static/resources/images/s1.jpg" />"  height="350" width="100%" /></li>
  <li><img src="<c:url value="/static/resources/images/s2.jpg" />"  height="350" width="100%" /></li>
  <li><img src="<c:url value="/static/resources/images/s3.jpg" />" height="350"  width="100%" /></li>
</ul>

<div id="bx-pager">
  <a data-slide-index="0" href=""><img src="<c:url value="/static/resources/images/s1.jpg"/>"  height="72" /></a>
  <a data-slide-index="1" href=""><img src="<c:url value="/static/resources/images/s2.jpg" />"height="72" /></a>
  <a data-slide-index="2" href=""><img src="<c:url value="/static/resources/images/s3.jpg" />" height="72" /></a>
</div></div>

</div>
<div class="rightsec-booking">

<h2>Booking:</h2>
<div class="multiple"></div>
<table>
<tr>
<td>Price Offer:</td>
<td>Rs. 1200</td>
</tr>
<tr>
<td>Date from:</td><td><input type="text" /></td>
</tr>
<tr>
<td>Date to:</td><td><input type="text" /></td>
</tr>
<tr>
<td>No.of Days:</td><td><input type="text" /></td>
</tr>
<tr>
<td>Total Rs.</td><td><input type="text" /></td>
</tr>
</table>
 <a href="#" class="gen_btn">Procede to Booking <img src="<c:url value="/static/resources/images/arrow2.png" />" alt="" class="no_resize"></a>
 </div>
</div>  
<div class="cenDivBdr">
<h2>--- Gallery ---</h2>
  <div id="bx-pager">
  <a data-slide-index="0" href=""><img src="<c:url value="/static/resources/images/s1.jpg" />"  height="72" /></a>
  <a data-slide-index="1" href=""><img src="<c:url value="/static/resources/images/s2.jpg" />" height="72" /></a>
  <a data-slide-index="2" href=""><img src="<c:url value="/static/resources/images/s3.jpg" />" height="72" /></a>
  <a data-slide-index="0" href=""><img src="<c:url value="/static/resources/images/s1.jpg" />"  height="72" /></a>
  <a data-slide-index="1" href=""><img src="<c:url value="/static/resources/images/s2.jpg" />" height="72" /></a>
  <a data-slide-index="2" href=""><img src="<c:url value="/static/resources/images/s3.jpg" />" height="72" /></a>
  <a data-slide-index="0" href=""><img src="<c:url value="/static/resources/images/s1.jpg" />" height="72" /></a>
  <a data-slide-index="1" href=""><img src="<c:url value="/static/resources/images/s2.jpg" />" height="72" /></a>
  <a data-slide-index="2" href=""><img src="<c:url value="/static/resources/images/s3.jpg" />" height="72" /></a>
</div>
</div>
  
<!-- footer -->
<%@include file="pr_footer.jsp" %>

</body>
</html>
