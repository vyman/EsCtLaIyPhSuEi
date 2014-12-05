<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Huigere</title>
<link href="resources/css/inner-style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="headerBg"><div class="header"><div class="logo"><img src="resources/images/logo-huigere.png" /></div>
<div class="loginbox btn-1">Welcome: Username &nbsp; | &nbsp;  <a href="#">Logout</a></div></div>
     </div>
<div class="bdy-container">
  <h2 class="bdyhd1">Proceed to Booking</h2> 
<div class="bookingleftsec">
<h2>Your Details</h2>
<table width="100%" cellpadding="5" cellspacing="0" border="0">
<tr><td>Name :</td><td><input name="name" id="name" /></td></tr>
<tr><td>Email :</td><td><input name="email" id="email" /></td></tr>
<tr><td>Address :</td><td><input name="address" id="address" /></td></tr>
<tr><td>Phone No :</td><td><input name="phone" id="phone" /></td></tr>
<tr><td>Quiery :</td><td><textarea  name="query" id="query" ></textarea> </td></tr>
</table>

</div>
<div class="bookingrightsec">
<h2>Card Details:</h2>
<table width="100%" cellpadding="5" cellspacing="0" border="0">
<tr>
<td>Card No. :</td>
<td><input type="text" name="cardNo" id="cardNo" /></td>
</tr>
<tr>
<td>Name Print on Card :</td>
<td><input type="text" name="cardName" id="cardName" /></td>
</tr>
<tr>
<td>Expiry on Date :</td>
<td><input type="text" name="exp" id="exp" class="sml"  /> MM / <input type="text" name="exp" id="exp"  class="sml" />  YY</td>
</tr>
<tr>
  <td>CVV :</td>
  <td><input type="text" name="cvv" id="cvv"  class="sml" /></td>
</tr>
</table>
</div>  
<div class="cenDivBdr">
<a href="#" class="submit_btn">Pay Now <img src="resources/images/arrow2.png" alt="" class="no_resize"></a> 
</div>  
</div>
  
<!-- footer -->
<%@include file="pr_footer.jsp" %>
</body>
</html>
