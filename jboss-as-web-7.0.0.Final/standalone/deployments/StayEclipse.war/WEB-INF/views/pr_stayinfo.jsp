<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>Huigere</title>
<link href="<c:url value="/static/resources/css/inner-style.css"/>" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<div class="headerBg">
		<div class="header">
			<div class="logo">
				<img src="<c:url value="/static/resources/images/logo-huigere.png"/>" />
			</div>
			<div class="loginbox btn-1">
				Welcome: Username &nbsp; | &nbsp; <a href="#">Logout</a>
			</div>
		</div>
	</div>
	<form:form commandName="newStay" id="reg" enctype="multipart/form-data">
		<div class="bdy-container">

			<div class="leftsec">
				<h2>Stayer Details:</h2>
				<table width="100%" cellpadding="5" cellspacing="0" border="0">
					<tr>
						<td class="text-6">Stay Name :</td>
						<td><form:input path="stayname" /></td>
						<td><form:errors class="invalid" path="stayname" /></td>
					</tr>
					<tr>
						<td class="text-6">Address :</td>
						<td><form:textarea path="address" /></td>
						<td><form:errors class="invalid" path="address" /></td>
					</tr>
					<tr>
						<td class="text-6">Phone Number :</td>
						<td><form:input path="phoneno" /></td>
						<td><form:errors class="invalid" path="phoneno" /></td>
					</tr>
					<tr>
						<td class="text-6">Email Id :</td>
						<td><form:input path="emailid" /></td>
						<td><form:errors class="invalid" path="emailid" /></td>
					</tr>
					<tr>
						<td class="text-6">Website Link :</td>
						<td><form:input path="websitelink" /></td>
						<td><form:errors class="invalid" path="websitelink" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="center"></td>
					</tr>
				</table>

			</div>
			<div class="rightsec">
				<div style="text-align: center;">
					<h2>Select Profile Photo</h2>
					<div class="profilephoto"></div>
					<input type="text" /><br> <br> <a href="#"
						class="gen_btn">Browse</a>
				</div>
				<form:input type="file" name="profileImagePic" id="profileImagePic" path="profileImagePic"/>
				<form:errors class="invalid" path="profileImagePic" />
			</div>
			<div class="cenDivBdr">
				<a href="javascript:document.getElementById('reg').submit();" class="submit_btn" >Next <img
					src="<c:url value="/static/resources/images/arrow2.png"/>" alt="" class="no_resize"></a>
			</div>
		</div>
	</form:form>

	<!-- footer -->
	<div class="f-container">
		<div class="footersec">
			<div class="f-logo">
				<a href="index.html"><img src="<c:url value="/static/resources/images/f-logo.png" />"
					alt=""></a>
			</div>
			<div class="copyright">
				&copy; 2014 | <a href="#">Privacy Policy</a>
			</div>
			<div class="social">
				<a href="#"><img src="<c:url value="/static/resources/images/soc_icon_1.png"/>" alt=""></a>
				<a href="#"><img src="<c:url value="/static/resources/images/soc_icon_2.png"/>" alt=""></a>
				<a href="#"><img src="<c:url value="/static/resources/images/soc_icon_3.png"/>" alt=""></a>
				<a href="#"><img src="<c:url value="/static/resources/images/soc_icon_4.png"/>" alt=""></a>
			</div>
		</div>
	</div>

</body>
</html>
