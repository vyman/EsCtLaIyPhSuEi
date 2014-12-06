<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Huigere</title>
<link href="resources/css/inner-style.css" rel="stylesheet" type="text/css" />
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="all" href="css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" media="all" href="css/jgallery.min.css" />
<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/tinycolor-0.9.16.min.js"></script>
<script type="text/javascript" src="js/jgallery.min.js"></script>
<script type="text/javascript">
    $( function() {
        $( '#gallery' ).jGallery( {
            'mode': 'standard'
        } );
    } );
    </script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(function() {
$( ".datepicker" ).datepicker();
});
</script>
</head>

<body>
<div class="headerBg">
  <div class="header">
    <div class="logo"><img src="resources/images/logo-huigere.png" /></div>
    <div class="loginbox btn-1">Welcome: Username &nbsp; | &nbsp; <a href="#">Logout</a></div>
  </div>
</div>
<div class="container">
  <h2>Profile View</h2>
  <div class="row">
    <div class="col-md-6 col-xs-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Basic Info</h3>
        </div>
        <div class="panel-body">
          <div class="col-sm-8 col-xs-8">
            <div class="col-sm-4 col-xs-4">Name:</div><div class="col-sm-8 col-xs-8"><input type="text" name="name" id="name" />
            </div>
            <div class="col-sm-4 col-xs-4">Address:</div>
            <div class="col-sm-8 col-xs-8"><input type="text" name="address" id="address" /></div>
            <div class="col-sm-4 col-xs-4">Phone:</div>
            <div class="col-sm-8 col-xs-8"><input type="text" name="phone" id="phone" /></div>
            <div class="col-sm-4 col-xs-4">Email:</div>
            <div class="col-sm-8 col-xs-8"><input type="text" name="email" id="email" /></div>
          </div>
          <div class="col-sm-4 col-xs-4"> <img src="resources/images/s1.jpg" height="100" /> </div> <div class="col-sm-12 col-xs-12 butdiv">
                  <button type="button" class="btn btn-sm btn-primary">Edit</button> </div>
        </div>
       
      </div>
    </div>
    <div class="col-md-6 col-xs-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Stay Info</h3>
        </div>
        <div class="panel-body">
          
            <div class="col-xs-4">Stay Type :</div>
            <div class="col-xs-8"><select name='staytype' id='staytype' >
                <option value="">Select One</option>
                <option value="Single-Room">Single Room</option>
                <option value="Sharing">Sharing</option>
                <option value="Multiple-Cottage">Multiple Cottage</option>
                <option value="Stay-with-Induvidual-Suite">Stay with Induvidual Suite</option>
                <option value="Resort">Resort</option>
              </select></div>
            
            <div class="col-xs-4">Price :</div>
            <div class="col-xs-8"><input type="text" name="price" id="price" value="1500" /></div>
            <div class="col-xs-4">No of Rooms:</div>
              <div class="col-xs-8"><input type="text" name="no_of_rooms" id="no_of_rooms" value="5" />
            </div>
            <div class="col-xs-4">Discount :</div>
              <div class="col-xs-8"><input type="text" name="discount" id="discount" value="20 %" />
            </div>
         <div class="col-sm-4 col-xs-4"><a data-slide-index="0" href=""><img src="resources/images/s1.jpg"  height="72" /></a></div>
                <div class="col-sm-4 col-xs-4"><a data-slide-index="1" href=""><img src="resources/images/s2.jpg" height="72" /></a></div>
                <div class="col-sm-4 col-xs-4"><a data-slide-index="2" href=""><img src="resources/images/s3.jpg" height="72" /></a></div>
          <div class="butdiv">
                  <button type="button" class="btn btn-sm btn-primary">Edit</button> </div>
        </div>
      </div>
    </div>
    
      <div class="col-xs-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">Account Details</h3>
          </div>
          <div class="panel-body">
            <div class="col-sm-12">
              <div class="col-sm-4 col-xs-12">
                <div class="col-xs-4">User&nbsp;Name:&nbsp;</div><div class="col-xs-8"><input type="text" name="username" id="username" />
              </div></div>
              <div class="col-sm-4 col-xs-12">
                <div class="col-xs-4">Acount&nbsp;No:&nbsp; </div><div class="col-xs-8"><input type="text" name="address" id="address" />
              </div></div>
              <div class="col-sm-4 col-xs-12">
               <div class="col-xs-4">Bank&nbsp;Address:&nbsp;</div><div class="col-xs-8"><input type="text" name="bankadd" id="bankadd" /></div>
              </div>
              
            </div>
            <div class="butdiv">
                  <button type="button" class="btn btn-sm btn-primary">Edit</button> </div>
          </div>
        </div>
      </div>
      
        <div class="col-md-6 col-xs-12">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Near By Places</h3>
            </div>
            <div class="panel-body">
              <div class="col-xs-12">
                <div class="col-sm-4  col-xs-4"><a data-slide-index="0" href=""><img src="resources/images/s1.jpg"  height="72" /></a></div>
                <div class="col-sm-4  col-xs-4"><a data-slide-index="1" href=""><img src="resources/images/s2.jpg" height="72" /></a></div>
                <div class="col-sm-4  col-xs-4"><a data-slide-index="2" href=""><img src="resources/images/s3.jpg" height="72" /></a></div>
                <div class="col-sm-4  col-xs-4"><a data-slide-index="0" href=""><img src="resources/images/s1.jpg"  height="72" /></a></div>
                <div class="col-sm-4  col-xs-4"><a data-slide-index="1" href=""><img src="resources/images/s2.jpg" height="72" /></a></div>
                <div class="col-sm-4  col-xs-4"><a data-slide-index="2" href=""><img src="resources/images/s3.jpg" height="72" /></a></div>
                <div class="col-sm-4  col-xs-4"><a data-slide-index="0" href=""><img src="resources/images/s1.jpg"  height="72" /></a> </div>
                <div class="col-sm-4   col-xs-4"><a data-slide-index="1" href=""><img src="resources/images/s2.jpg" height="72" /></a></div>
                
              </div>
              <div class="butdiv">
                  <button type="button" class="btn btn-sm btn-primary">Edit</button> </div>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-xs-12">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Galary View</h3>
            </div>
            <div class="panel-body">
            <div class="col-xs-12">
              <div class="col-sm-4   col-xs-4"><a data-slide-index="0" href=""><img src="resources/images/s1.jpg"  height="72" /></a></div>
              <div class="col-sm-4   col-xs-4"><a data-slide-index="1" href=""><img src="resources/images/s2.jpg" height="72" /></a></div>
              <div class="col-sm-4  col-xs-4"><a data-slide-index="2" href=""><img src="resources/images/s3.jpg" height="72" /></a></div>
              <div class="col-sm-4  col-xs-4"><a data-slide-index="0" href=""><img src="resources/images/s1.jpg"  height="72" /></a> </div>
              <div class="col-sm-4  col-xs-4"><a data-slide-index="1" href=""><img src="resources/images/s2.jpg" height="72" /></a></div>
               <div class="col-sm-4  col-xs-4"><a data-slide-index="2" href=""><img src="resources/images/s3.jpg" height="72" /></a></div>
               <div class="col-sm-4  col-xs-4"><a data-slide-index="0" href=""><img src="resources/images/s1.jpg"  height="72" /></a> </div>
              <div class="col-sm-4  col-xs-4"><a data-slide-index="1" href=""><img src="resources/images/s2.jpg" height="72" /></a></div>
               <div class="col-sm-4  col-xs-4"><a data-slide-index="2" href=""><img src="resources/images/s3.jpg" height="72" /></a></div>
              </div>
              <div class="butdiv">
                  <button type="button" class="btn btn-sm btn-primary">Edit</button> </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- footer -->
<%@include file="pr_footer.jsp" %>
</body>
</html>
