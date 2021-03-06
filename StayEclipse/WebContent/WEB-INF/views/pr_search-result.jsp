<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>Huigere</title>
<link href="<c:url value="/static/resources/css/inner-style.css" />" rel="stylesheet" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap styles -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- Generic page styles -->
<link rel="stylesheet" href="<c:url value="/static/resources/css/style.css" />" >
<!-- blueimp Gallery styles -->
<link rel="stylesheet" href="//blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
<!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
<link rel="stylesheet" href="<c:url value="/static/resources/css/jquery.fileupload.css" />">
<link rel="stylesheet" href="<c:url value="/static/resources/css/jquery.fileupload-ui.css" />" >
<!-- CSS adjustments for browsers with JavaScript disabled -->
<noscript>
<link rel="stylesheet" href="<c:url value="/static/resources/css/jquery.fileupload-noscript.css" />" >
</noscript>
<noscript>
<link rel="stylesheet" href="<c:url value="/static/resources/css/jquery.fileupload-ui-noscript.css" />" >
</noscript>
</head>
<body>
<%@include file="pr_header.jsp" %>
<div class="container">
  <h2>Search Hotels:</h2>
  <div class="row">
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Search Rooms</h3>
        </div>
        <div class="panel-body"> <div class="col-xs-11"><table width="80%" border="0">
        <tr>
          <td>Where? :</td>
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
          <td><div class="butdiv">
                  <button type="button" class="btn btn-sm btn-primary">Search</button> </div></td>
        </tr>
      </table></div></div>
      </div>
    </div>
    <div class="col-sm-8 col-xs-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Avaliable Hotels</h3>
        </div>
        <div class="panel-body">
        
        <table width="100%">
        <tr>
          <td width="25%"><img src="<c:url value="/static/resources/images/s1.jpg" />" width="156" height="117" /></td>
          <td width="25%">Banngalore Hotel</td>
          <td width="15%">A/C Delux</td>
          <td width="15%">$400</td>
          <td width="20%"><button type="button" class="btn btn-sm btn-success">Book Now</button></td>
        </tr>
       <tr>
          <td width="25%"><img src="<c:url value="/static/resources/images/s2.jpg" />" width="156" height="117" /></td>
          <td width="25%">Banngalore Hotel</td>
          <td width="15%">A/C Delux</td>
          <td width="15%">$400</td>
          <td width="20%"><button type="button" class="btn btn-sm btn-success">Book Now</button></td>
        </tr>
        <tr>
          <td width="25%"><img src="<c:url value="/static/resources/images/s3.jpg"/>" width="156" height="117" /></td>
          <td width="25%">Banngalore Hotel</td>
          <td width="15%">A/C Delux</td>
          <td width="15%">$400</td>
          <td width="20%"><button type="button" class="btn btn-sm btn-success">Book Now</button></td>
        </tr>
        <tr>
          <td width="25%"><img src="<c:url value="/static/resources/images/s1.jpg" />" width="156" height="117" /></td>
          <td width="25%">Banngalore Hotel</td>
          <td width="15%">A/C Delux</td>
          <td width="15%">$400</td>
          <td width="20%"><button type="button" class="btn btn-sm btn-success">Book Now</button></td>
        </tr>
        <tr>
          <td width="25%"><img src="<c:url value="/static/resources/images/s2.jpg" />" width="156" height="117" /></td>
          <td width="25%">Banngalore Hotel</td>
          <td width="15%">A/C Delux</td>
          <td width="15%">$400</td>
          <td width="20%"><button type="button" class="btn btn-sm btn-success">Book Now</button></td>
        </tr>
      </table> </div>
      </div>
    </div>
  </div>
  <div class="cenDivBdr">
  <div class="pluginDiv">Plug -in Comes here</div>
  
    <div class="rgt"> <a href="suite-available.html" class="submit_btn rgt">Next <img src="<c:url value="/static/resources/images/arrow2.png" />" alt="" class="no_resize"></a> </div>
  </div>
</div>



<!-- footer -->
<%@include file="pr_footer.jsp" %>
</body>
</html>
