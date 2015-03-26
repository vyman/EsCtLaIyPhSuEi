<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Add Suite to Stay</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- <link rel="stylesheet" href=""> -->
<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/inner-style.css"/>"/>
<!-- Bootstrap styles -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- Generic page styles -->
<link rel="stylesheet" href="resources/css/bimp/style.css">
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

	<div class="bdy-container">

		<form:form commandName="newStaySuite" id="newStaySuiteForm" action="/StaySuite" method="POST">
		<div class="leftsec" style="height: auto !important;">
			<h2>Add Room:</h2>
			<input type="hidden" value="${stayId}" name="stayId">
			<table width="100%" cellpadding="5" cellspacing="5" border="0">
				<tr>
					<td class="text-6">Suite Type :</td>
					<td><form:select path="suiteType.id" items="${suiteTypes}" itemLabel="type" itemValue="id"></form:select></td>
					<td><form:errors class="invalid" path="suiteType" /></td>
				</tr>
				<tr>
					<td class="text-6">Suite Code :</td>
					<td><form:input path="suiteCode" /></td>
					<td><form:errors class="invalid" path="suiteCode" /></td>
				</tr>
				<tr>
					<td class="text-6">Description :</td>
					<td><form:textarea path="discription" /></td>
					<td><form:errors class="invalid" path="discription" /></td>
				</tr>
				<tr>
					<td class="text-6">Price :</td>
					<td><form:input path="price" /></td>
					<td><form:errors class="invalid" path="price" /></td>
				</tr>
				<tr>
					<td class="text-6">Available No. of Rooms :</td>
					<td><form:input path="numberOfAvilableRooms" /></td>
					<td><form:errors class="invalid" path="numberOfAvilableRooms" /></td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td align="center"></td>
				</tr>
			</table>
		</div>
		<div class="rightsec1">
			<div style="text-align: left;">
				<h3>Facilities Available</h3>
				<table>
				<c:forEach items="${facilities}" var="facility" varStatus="loop">
					<tr>
						<td><form:checkbox path="facilities[${loop.index}].id" value="${facility.id}"/></td>
						<td>${facility.equipment}</td>
					</tr>
				</c:forEach>
				</table>
			</div>
		</div>
		</form:form>
		

		<div class="cenDivBdr">
			<a href="javascript:document.getElementById('newStaySuiteForm').submit();" class="submit_btn" >Next <img src="images/arrow2.png"
				alt="" class="no_resize"></a>
		</div>
	</div>
</body>
</html>
