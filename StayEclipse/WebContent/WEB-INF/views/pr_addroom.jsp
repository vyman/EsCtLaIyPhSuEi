<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>Huigere</title>
<link href="<c:url value="/static/resources/css/inner-style.css"/>"
	rel="stylesheet" type="text/css" />

<!-- Bootstrap styles -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!-- Generic page styles -->
<link rel="stylesheet" href="<c:url value="/static/resources/css/blueimp/style.css"/>">
<!-- blueimp Gallery styles -->
<link rel="stylesheet" href="http://blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
<!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
<link rel="stylesheet" href="<c:url value="/static/resources/css/blueimp/jquery.fileupload.css"/>">
<link rel="stylesheet" href="<c:url value="/static/resources/css/blueimp/jquery.fileupload-ui.css"/>">
<!-- CSS adjustments for browsers with JavaScript disabled -->
<noscript><link rel="stylesheet" href="<c:url value="/static/resources/css/blueimp/jquery.fileupload-noscript.css"/>"></noscript>
<noscript><link rel="stylesheet" href="<c:url value="/static/resources/css/blueimp/jquery.fileupload-ui-noscript.css"/>"></noscript>

</head>
<body>
	<div class="headerBg">
		<div class="header">
			<div class="logo">
				<img src="resources/images/logo-huigere.png" />
			</div>
			<div class="loginbox btn-1">
				Welcome: Username &nbsp; | &nbsp; <a href="#">Logout</a>
			</div>
		</div>
	</div>
	<div class="bdy-container">
		<form:form commandName="newRoom" id="roomForm" enctype="multipart/form-data">
		<div class="leftsec" style="height: auto !important;">
			<h2>Add Room:</h2>
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
		<div class="cenDivBdr" style="height: auto !important">
			<form id="fileupload" action="//jquery-file-upload.appspot.com/"
				method="POST" enctype="multipart/form-data">
				<!-- Redirect browsers with JavaScript disabled to the origin page -->
				<noscript>
					<input type="hidden" name="redirect"
						value="http://blueimp.github.io/jQuery-File-Upload/">
				</noscript>
				<!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
				<div class="row fileupload-buttonbar">
					<div class="col-lg-7">
						<!-- The fileinput-button span is used to style the file input field as button -->
						<span class="btn btn-success fileinput-button"> <i
							class="glyphicon glyphicon-plus"></i> <span>Add files...</span> <input
							type="file" name="files[]" multiple>
						</span>
						<button type="submit" class="btn btn-primary start">
							<i class="glyphicon glyphicon-upload"></i> <span>Start
								upload</span>
						</button>
						<button type="reset" class="btn btn-warning cancel">
							<i class="glyphicon glyphicon-ban-circle"></i> <span>Cancel
								upload</span>
						</button>
						<button type="button" class="btn btn-danger delete">
							<i class="glyphicon glyphicon-trash"></i> <span>Delete</span>
						</button>
						<input type="checkbox" class="toggle">
						<!-- The global file processing state -->
						<span class="fileupload-process"></span>
					</div>
					<!-- The global progress state -->
					<div class="col-lg-5 fileupload-progress fade">
						<!-- The global progress bar -->
						<div class="progress progress-striped active" role="progressbar"
							aria-valuemin="0" aria-valuemax="100">
							<div class="progress-bar progress-bar-success" style="width: 0%;"></div>
						</div>
						<!-- The extended global progress state -->
						<div class="progress-extended">&nbsp;</div>
					</div>
				</div>
				<!-- The table listing the files available for upload/download -->
				<table role="presentation" class="table table-striped">
					<tbody class="files"></tbody>
				</table>
			</form>
		</div>
		<div class="cenDivBdr">
			<a href="javascript:document.getElementById('roomForm').submit();" class="submit_btn" >Next <img
					src="<c:url value="/resources/images/arrow2.png"/>" alt="" class="no_resize"></a>
		</div>
		</form:form>
	</div>

	<!-- footer -->
	<%@include file="pr_footer.jsp" %>
	
	<!-- The template to display files available for upload -->
<script id="template-upload" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade">
        <td>
            <span class="preview"></span>
        </td>
        <td>
            <p class="name">{%=file.name%}</p>
            <strong class="error text-danger"></strong>
        </td>
        <td>
            <p class="size">Processing...</p>
            <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="progress-bar progress-bar-success" style="width:0%;"></div></div>
        </td>
        <td>
            {% if (!i && !o.options.autoUpload) { %}
                <button class="btn btn-primary start" disabled>
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Start</span>
                </button>
            {% } %}
            {% if (!i) { %}
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
<!-- The template to display files available for download -->
<script id="template-download" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-download fade">
        <td>
            <span class="preview">
                {% if (file.thumbnailUrl) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" data-gallery><img src="{%=file.thumbnailUrl%}"></a>
                {% } %}
            </span>
        </td>
        <td>
            <p class="name">
                {% if (file.url) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" {%=file.thumbnailUrl?'data-gallery':''%}>{%=file.name%}</a>
                {% } else { %}
                    <span>{%=file.name%}</span>
                {% } %}
            </p>
            {% if (file.error) { %}
                <div><span class="label label-danger">Error</span> {%=file.error%}</div>
            {% } %}
        </td>
        <td>
            <span class="size">{%=o.formatFileSize(file.size)%}</span>
        </td>
        <td>
            {% if (file.deleteUrl) { %}
                <button class="btn btn-danger delete" data-type="{%=file.deleteType%}" data-url="{%=file.deleteUrl%}"{% if (file.deleteWithCredentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                    <i class="glyphicon glyphicon-trash"></i>
                    <span>Delete</span>
                </button>
                <input type="checkbox" name="delete" value="1" class="toggle">
            {% } else { %}
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="<c:url value="/static/resources/js/blueimp/vendor/jquery.ui.widget.js"/> "></script>
<!-- The Templates plugin is included to render the upload/download listings -->
<script src="http://blueimp.github.io/JavaScript-Templates/js/tmpl.min.js"></script>
<!-- The Load Image plugin is included for the preview images and image resizing functionality -->
<script src="http://blueimp.github.io/JavaScript-Load-Image/js/load-image.min.js"></script>
<!-- The Canvas to Blob plugin is included for image resizing functionality -->
<script src="http://blueimp.github.io/JavaScript-Canvas-to-Blob/js/canvas-to-blob.min.js"></script>
<!-- Bootstrap JS is not required, but included for the responsive demo navigation -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<!-- blueimp Gallery script -->
<script src="http://blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="<c:url value="/static/resources/js/blueimp/jquery.iframe-transport.js"/> "></script>
<!-- The basic File Upload plugin -->
<script src="<c:url value="/static/resources/js/blueimp/jquery.fileupload.js"/> "></script>
<!-- The File Upload processing plugin -->
<script src="<c:url value="/static/resources/js/blueimp/jquery.fileupload-process.js"/> "></script>
<!-- The File Upload image preview & resize plugin -->
<script src="<c:url value="/static/resources/js/blueimp/jquery.fileupload-image.js"/> "></script>
<!-- The File Upload audio preview plugin -->
<script src="<c:url value="/static/resources/js/blueimp/jquery.fileupload-audio.js"/> "></script>
<!-- The File Upload video preview plugin -->
<script src="<c:url value="/static/resources/js/blueimp/jquery.fileupload-video.js"/> "></script>
<!-- The File Upload validation plugin -->
<script src="<c:url value="/static/resources/js/blueimp/jquery.fileupload-validate.js"/> "></script>
<!-- The File Upload user interface plugin -->
<script src="<c:url value="/static/resources/js/blueimp/jquery.fileupload-ui.js"/> "></script>
<!-- The main application script -->
<script src="<c:url value="/static/resources/js/blueimp/main.js"/> "></script>
</body>
</html>
