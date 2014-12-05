<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Huigere</title>
<link href="resources/css/inner-style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="resources/css/pickmeup.css" type="text/css" />
<link href="resources/jQueryAssets/jquery.ui.core.min.css" rel="stylesheet" type="text/css">
<link href="resources/jQueryAssets/jquery.ui.theme.min.css" rel="stylesheet" type="text/css">
<link href="resources/jQueryAssets/jquery.ui.datepicker.min.css" rel="stylesheet" type="text/css">
<script src="resources/jQueryAssets/jquery-1.8.3.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="resources/js/jquery.bxslider.css" type="text/css" />
<script src="resources/js/jquery.bxslider.js"></script>
<script type="text/javascript" src="resources/js/jquery.pickmeup.js"></script>
<script type="text/javascript" src="resources/js/demo.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
    
$('.bxslider').bxSlider({
  pagerCustom: '#bx-pager'
});
  });
</script>
<script src="resources/jQueryAssets/jquery-ui-1.9.2.datepicker.custom.min.js" type="text/javascript"></script>
</head>

<body>
<div class="headerBg"><div class="header"><div class="logo"><img src="resources/images/logo-huigere.png" /></div>
<div class="loginbox btn-1">Welcome: Username &nbsp; | &nbsp;  <a href="#">Logout</a></div></div>
     </div>
<div class="bdy-container">
   
<div class="leftsec-booking">
<h2>Room View</h2>
<div class="slider">
<ul class="bxslider">
  <li><img src="resources/images/s1.jpg"  height="350" width="100%" /></li>
  <li><img src="resources/images/s2.jpg"  height="350" width="100%" /></li>
  <li><img src="resources/images/s3.jpg"  height="350"  width="100%" /></li>
</ul>

<div id="bx-pager">
  <a data-slide-index="0" href=""><img src="resources/images/s1.jpg"  height="72" /></a>
  <a data-slide-index="1" href=""><img src="resources/images/s2.jpg" height="72" /></a>
  <a data-slide-index="2" href=""><img src="resources/images/s3.jpg" height="72" /></a>
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
 <a href="#" class="gen_btn">Procede to Booking <img src="resources/images/arrow2.png" alt="" class="no_resize"></a>
 </div>
</div>  
<div class="cenDivBdr">
<h2>--- Gallery ---</h2>
  <div id="bx-pager">
  <a data-slide-index="0" href=""><img src="resources/images/s1.jpg"  height="72" /></a>
  <a data-slide-index="1" href=""><img src="resources/images/s2.jpg" height="72" /></a>
  <a data-slide-index="2" href=""><img src="resources/images/s3.jpg" height="72" /></a>
  <a data-slide-index="0" href=""><img src="resources/images/s1.jpg"  height="72" /></a>
  <a data-slide-index="1" href=""><img src="resources/images/s2.jpg" height="72" /></a>
  <a data-slide-index="2" href=""><img src="resources/images/s3.jpg" height="72" /></a>
  <a data-slide-index="0" href=""><img src="resources/images/s1.jpg"  height="72" /></a>
  <a data-slide-index="1" href=""><img src="resources/images/s2.jpg" height="72" /></a>
  <a data-slide-index="2" href=""><img src="resources/images/s3.jpg" height="72" /></a>
</div>
</div>
  
<!-- footer -->
<%@include file="pr_footer.jsp" %>

</body>
</html>
