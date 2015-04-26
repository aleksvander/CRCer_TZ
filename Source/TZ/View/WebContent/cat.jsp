<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function submitformSearch(id)
{ 
	alert("searched_" + id);
	document.getElementById("setSearchCatValue_" + id).value = id;
	document.forms["searched_" + id].submit(); 
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All cat</title>
</head>
<body>
	<%@ include file="nav_menu.jsp" %>
	
		<table border="1">
		<tr>
			<th>Name</th>
		</tr>
		<c:forEach var="cat" items="${catData}">
			<tr id="${cat.id}">
				<td>
					<form action="sGetAllMenu" method="post">
						<input type="hidden" name="setSearchCatValue_${cat.id}" value = "0"/>
						<input id = "searched_${cat.id}" type="hidden" name="getSearchAtCat" value="0"/>
						<a href="javascript: submitformSearch(${cat.id})">
							<c:out value="${cat.name}" />
						</a>
					</form>
				</td>				
			</tr>
		</c:forEach>
	</table>
</body>
</html>