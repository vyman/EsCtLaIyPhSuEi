<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>Huigere</title>
<link href="<c:url value="/static/resources/css/reset.css" />" type="text/css" rel="stylesheet" />
<link href="<c:url value="/static/resources/css/home-style.css" />" type="text/css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" media="all" href="<c:url value="/static/resources/css/font-awesome.min.css" />" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value="/static/resources/css/jgallery.min.css" />" />
    <script type="text/javascript" src="<c:url value="/static/resources/js/jquery-1.11.2.js" />" ></script>
    <script type="text/javascript" src="<c:url value="/static/resources/js/tinycolor-0.9.16.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/static/resources/js/jgallery.min.js" />" ></script>
    <script type="text/javascript">
    $( function() {
        $( '#gallery' ).jGallery( {
            'mode': 'slider'
        } );
    } );
    </script>
</head>

<body>
<div class="headerBg"><div class="header"><div class="logo"><img src="<c:url value="/static/resources/images/logo-huigere.png" />" /></div>
<div class="loginbox btn-1"><form> <input name="username" type="text"  id="username" value="User Name" onblur="if (this.value == '') {this.value = 'User Name';}"  onfocus="if (this.value == 'User Name') {this.value = '';}" /> <input name="password" type="text"  id="password" value="Password" onblur="if (this.value == '') {this.value = 'Password';}"  onfocus="if (this.value == 'Password') {this.value = '';}" /> <a href="#" class="submit_btn">Submit <img src="<c:url value="/static/resources/images/arrow2.png" />" alt="" class="no_resize"></a></form></div></div>
     </div>


<div class="bannerarea">

<div class="container">
            <div class="row">
                <div class="block-1">
                   <div class="text-3">Book now:</div>
                   <div class="text-2">+91 999 999 9999</div>
                    
                </div>
                <div class="block-2">
                    <div class="text-4">
                        Bangalore Karnataka <br>
                        India - 560000<br>
                        e-mail: <a href="#" class="h-underline">mail@huigere.com</a>
                    </div>
                </div>
            </div>
  <div class="row">
  
   <div class="block-3"><div class="dash-border"></div>
     <div style="height:73px; width:100%;"> <div class="searchbxhd">All Stays from Huigere:</div> <div class="btn-1">
   <input name="homesearch" type="text"  id="homesearch" value="Search" onblur="if (this.value == '') {this.value = 'Search';}"  onfocus="if (this.value == 'Search') {this.value = '';}"  /> <a href="#"><span></span></a></div>
     </div> 
     <!--banner -->
     <div style="height:auto !important;">  
     <div style="float:left;"> <div id="gallery">
            <c:forEach items="${stays}" var="stay" >				
			<img src="${ stay.profileImgPath}" />
			</c:forEach>
        </div></div> 
     <div class="red-band"><div class="red-dash-border"></div>
     <div class="text-4 spacer">Book Now <br>
To Get Best Price!</div>
     </div>              
      </div> 
      
     
      <!-- end banner -->
               </div>
                
                <div class="block-4"><div class="dash-border"></div>
                    <a href="#">
                       <div class="right-1" onclick="/StayEclipse/getBestOffers"><p> BEST!<br>
                        Offers</p></div>
                    </a>
                </div>
                 <div class="block-4"><div class="dash-border"></div>
                    <a href="#">
                      <div class="right-1"><p>  Video<br>
                        and Adds</p></div>
                    </a>
                </div>
            </div>
        </div>

</div>
<!-- navigation -->
<div class="mid-nav">
    <div class="container">        
            <div class="list-1 first">
              <a href="#"><div class="rel">Best<br>Offers</div></a></div>
             <div class="list-1"> <a href="#"><div class="rel">Places<br>arround</div></a></div>
             <div class="list-1"> <a href="#"><div class="rel">Seasonal<br>offers</div></a></div>
             <div class="list-1"> <a href="#"><div class="rel">Booking</div></a>
            </div>        
    </div>
</div>
<!-- middle section -->

<div class="bdy-container">

</div>


<!-- footer -->
<%@include file="pr_footer.jsp" %>
</body>
</html>
