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
  <h2 class="bdyhd1">Type of Stay</h2> 
<div class="bodysec">
Stay Type: <select name='staytype' id='staytype' >
    <option value="">Select One</option>
    <option value="Single-Room">Single Room</option>
      <option value="Sharing">Sharing</option>
      <option value="Multiple-Cottage">Multiple Cottage</option>
      <option value="Stay-with-Induvidual-Suite">Stay with Induvidual Suite</option>
      <option value="Resort">Resort</option>
    </select>

<h2>Stay Details:</h2>
<p><span>Single Room</span>: This is about detail of singal room. This is about detail of singal room. This is about detail of singal room. This is about detail of singal room</p>
<p><span>Sharing</span>: This is about detail of singal room. This is about detail of singal room. This is about detail of singal room. This is about detail of singal room. This is about detail of singal room</p>
<p><span>Multiple Cottage</span>: This is about detail of singal room. This is about detail of singal room. This is about detail of singal room. This is about detail of singal room. This is about detail of singal room</p>
<p><span>Stay with Individual Suite</span>: This is about detail of singal room. This is about detail of singal room. This is about detail of singal room. This is about detail of singal room . This is about detail of singal room</p>
<p><span>Resort</span>: This is about detail of singal room. This is about detail of singal room. This is about detail of singal room. This is about detail of singal room. This is about detail of singal room</p>

</div>  
<div class="cenDivBdr">
<a href="#" class="submit_btn">Next <img src="<c:url value="/static/resources/images/arrow2.png" />" alt="" class="no_resize"></a> 
</div>  
</div>
  
<!-- footer -->
<%@include file="pr_footer.jsp" %>
</body>
</html>
