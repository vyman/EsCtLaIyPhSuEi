<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>Huigere</title>
<link href="<c:url value="/static/resources/css/inner-style.css"/>" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="<c:url value="/static/resources/jQueryAssets/jQueryAssets/jquery-1.8.3.min.js"/>"></script>  

<script type="text/javascript">
$(function() {
    $("#profileImagePic").on("change", function()
    {
    	var files = !!this.files ? this.files : [];
        if (!files.length || !window.FileReader) return; // no file selected, or no FileReader support
 
        if (/^image/.test( files[0].type)){ // only image file
            var reader = new FileReader(); // instance of the FileReader
            reader.readAsDataURL(files[0]); // read the local file
 
            reader.onloadend = function(){ // set image data as background of div
                $("#imagePreview").css("background-image", "url("+this.result+")");
            }
        }
    });
});
</script>	

<style>
#imagePreview {
    width: 200px;
    height: 200px;
    background-position: left;
    background-size: cover;
    -webkit-box-shadow: 0 0 1px 1px rgba(0, 0, 0, .3);
    display: inline-block;
}
</style> 
</head>

<body>
	<%@include file="pr_header.jsp" %>
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
					<div class="profilephoto" id="imagePreview"></div>
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
	<%@include file="pr_footer.jsp" %>
</body>
</html>
