<%@ include file="/WEB-INF/jsp/include.jsp" %>
<portlet:actionURL var="actionURL" name="doSavePrefs"/>

<form:form method="post" action="${actionURL }" commandName="editForm" id="editForm">
	<form:label path="webserver_url">WebServer URL:  <form:input path="webserver_url" size="100"/></form:label>
	<br/>
	<form:label path="directory">Directory Location:  <form:input path="directory" size="100"/></form:label>
	
	
	<input type="submit" value="Save Preferences"/>
</form:form>