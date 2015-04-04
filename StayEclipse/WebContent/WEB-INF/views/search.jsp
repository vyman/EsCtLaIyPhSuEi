<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>Huigere</title>
<link href="resources/css/inner-style.css" rel="stylesheet" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap styles -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- Generic page styles -->
<link rel="stylesheet" href="resources/css/style.css">
<!-- blueimp Gallery styles -->
<link rel="stylesheet" href="//blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
<!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
<link rel="stylesheet" href="resources/css/jquery.fileupload.css">
<link rel="stylesheet" href="resources/css/jquery.fileupload-ui.css">
<!-- CSS adjustments for browsers with JavaScript disabled -->
<noscript><link rel="stylesheet" href="resources/css/jquery.fileupload-noscript.css"></noscript>
<noscript><link rel="stylesheet" href="resources/css/jquery.fileupload-ui-noscript.css"></noscript>
</head>

<body>
<div class="headerBg"><div class="header"><div class="logo"><img src="resources/images/logo-huigere.png" /></div>
<div class="loginbox btn-1">Welcome: Username &nbsp; | &nbsp;  <a href="#">Logout</a></div></div>
     </div>
<div class="bdy-container">
<h1>Search Hotels:</h1>
<div class="midfulldiv">   
<div class="searchbox" >

<table width="300" cellpadding="10" cellspacing="5" border="0">
<tr>
<td width="180">Where? :</td>
</tr>
<tr>
  <td><input type="text" name="stayName" id="stayName" /></td>
  </tr>
<tr>
<td>Check-in :</td>
</tr>
<tr>
  <td><input type="text" name="city2" id="city2" /></td>
  </tr>
<tr>
<td>Check-out :</td>
</tr>
<tr>
  <td><input type="text" name="city" id="city" /></td>
  </tr>
<tr>
  <td><input type="checkbox"> 
  I don't have specific dates yet</td>
  </tr>
<tr>
<td>Guests</td>
</tr>

<tr>
  <td><select name="hc_f_id_guestsRooms_" id="hc_f_id_guestsRooms_1" class="hc_evt_roomsGuests">
    <option value="1-1">1 adult</option>
    <option value="2-1" selected="selected">2 adults in 1 room</option>
    <option value="3-1">3 adults in 1 room</option>
    <option value="4-1">4 adults in 1 room</option>
    <option value="2-2">2 adults in 2 rooms</option>
    <option value="0">Need more rooms or have children?</option>
  </select></td>
  </tr>
<tr>
  <td><a href="#" class="submit_btn">Search</a></td>
</tr>
</table>

</div>
<div class="searchresult">

<h3>Available Hotels</h3>
<table width="100%">
<tr>
  <td width="15%"></td>
  <td width="15%"><b>Hotel Name</b></td>
  <td width="32%"><b>A/C Delux</b></td>
  <td width="18%"><b>Price</b></td>
</tr>


						<c:forEach items="${stayList}" var="stay">
								<tr>
									<td width="25%"><img src="${stay.profileImgPath} "
										height="100" /></td>
									<td width="25%">${stay.stayname}</td>
									<td width="25%">
									
									<c:forEach items="${stay.staySuites}" var="staySuite">
									<input type="checkbox">${staySuite.suiteType.type }<br>
									</c:forEach>
									</td>
									<td width="25%">
									<c:forEach items="${stay.staySuites}" var="staySuite">
									${staySuite.price }<br>
									</c:forEach>
									</td>
									
									<td width="20%"><button type="button"
											class="btn btn-sm btn-success">Book Now</button></td>
								</tr>
							</c:forEach>
</table>
</div> 
</div>

 
</div>
<!-- footer -->
<%@include file="pr_footer.jsp" %></body>
</html>
