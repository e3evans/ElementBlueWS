<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<form method="post" action="<portlet:actionURL />">
   <h3>Enter the starting path of the directory</h3>
   <input type="hidden" name="javax.portlet.action" value="saveConfiguration" />

	<label for="rootUrl">Root Path:</label>
	<input type="text" id="rootUrl" name="rootUrl" value="<c:out value='${rootUrl}'/>" />
	
	

	<div>
		<p><b>Local directory Example:</b><br/>
		/myfolder/docs<br>
		d:/myfolder/docs</p>
		
		<p><b>UNC path directory Example:</b><br/>
		////myfolder/docs</p>
	</div>
	
	<br><br>
	
	<h3>Enter the maximum height in pixels of the portlet content</h3>
	<p>
		<label for="rootUrl">Maximum Height:</label>
		<input type="text" id="maxHeight" name="maxHeight" value="<c:out value='${maxHeight}'/>" />&nbsp; <span>px</span>
	</p>
	
	<input type="submit" value="Save Configuration" />
</form>