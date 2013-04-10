<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<link rel="stylesheet" href="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/assets/css/jqueryFileTree.css") %>" type="text/css">

<script type="text/javascript" src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/assets/js/jquery.min.js") %>"></script>
<script type="text/javascript" src="<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/assets/js/jqueryFileTree.js") %>"></script>
<script>
   function <portlet:namespace/>_openFile(file) {
      var form = document.createElement("form");
      form.setAttribute("method", "POST");
      form.setAttribute("action", "<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/FileManagerServlet") %>");
      form.setAttribute("target", "_blank");
    
      var hiddenField = document.createElement("input");
      hiddenField.setAttribute("type", "hidden");
      hiddenField.setAttribute("name", "fileName");
      hiddenField.setAttribute("value", file);

      form.appendChild(hiddenField);
    
      document.body.appendChild(form);
      form.submit();
      
   }
   
	$(document).ready( function() {
	    $('#<portlet:namespace/>jqueryFileTree').fileTree({ root: '<c:out value="${rootUrl}"/>', script: '<%= renderResponse.encodeURL(renderRequest.getContextPath() + "/FileBrowseServlet") %>' }, function(file) {
	        <portlet:namespace/>_openFile(file);
	    });
	});
</script>

<div id="<portlet:namespace/>jqueryFileTree" <c:out value='${inlineStyle}'/> ></div>
