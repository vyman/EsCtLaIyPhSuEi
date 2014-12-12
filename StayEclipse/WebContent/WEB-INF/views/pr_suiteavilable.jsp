
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
<img src="<c:url value="/static/resources/images/s1.jpg" />" />
<img src="<c:url value="/static/resources/images/s2.jpg" />" />
<img src="<c:url value="/static/resources/images/s3.jpg" />" />
</div>    
<div class="suiterightsec"><h2>Menus & Prices</h2>
<table  cellpadding="5" cellspacing="0" border="0">
<tr>
<td><img src="<c:url value="/static/resources/images/page1_pic1.jpg" />" width="156" height="117" /></td>
<td>Text text text</td>
<td><img src="<c:url value="/static/resources/images/page1_pic1-01.jpg" />" width="156" height="117" /></td>
<td>Text text text</td>
</tr>
<tr>
<td>Text text text</td>
<td><img src="<c:url value="/static/resources/images/page1_pic2.jpg" />" width="156" height="117" /></td>
<td>Text text text</td>
<td><img src="<c:url value="/static/resources/images/page1_pic1-02.jpg" />" width="156" height="117" /></td>
</tr>
<tr>
<td><img src="<c:url value="/static/resources/images/page1_pic3.jpg" />" width="156" height="117" /></td>
<td>Text text text</td>
<td><img src="<c:url value="/static/resources/images/page1_pic1-03.jpg" />" width="156" height="117" /></td>
<td>Text text text</td>
</tr>
<tr>
<td>Text text text</td>
<td><img src="<c:url value="/static/resources/images/page1_pic4.jpg" />" width="156" height="117" /></td>
<td>Text text text</td>
<td><img src="<c:url value="/static/resources/images/page1_pic1-04.jpg" />" width="156" height="117" /></td>
</tr>
</table>

</div>

<div class="suiterightsec"><h2>Places nearby</h2>
<img src="<c:url value="/static/resources/images/s1.jpg" />" />
<img src="<c:url value="/static/resources/images/s2.jpg" />" />
<img src="<c:url value="/static/resources/images/s3.jpg" />" />
<img src="<c:url value="/static/resources/images/s1.jpg" />" />
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
