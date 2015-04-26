<%@page import="javax.swing.ImageIcon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script src="resources/js/ForMenu.js">

</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
</head>
<body>
	
	<%@ include file="nav_menu.jsp" %>

	<table>
		<tr> 
			<td><h2>Search by: </h2></td>
			<td> 
			<select name="searchByColumn" size="1" onChange="setIdBySearch(this)">
				<option value="1">Name</option>
				<option value="2">Price</option>
				<option value="3">Categ</option>
			</select>
			</td>
		</tr>
		<tr>
			<td colspan="2"> 
				<form action="sSearchItem" method="post">
					<input id = "searchIdInput" type="hidden" name="setMenuId" value = "1"/>
					<input id = "setSelectedMenuInput" name="setSelectedMenuInput" type="text" value=""/> <!--  -->
					<select id = "searchByCatListing" name="searchByCatListing" size="1" value="0" onChange="setCatIdBySearch(this)" style="visibility: hidden;"> <!--  -->
						<option selected="selected" value="0">Нет категории</option>
						<c:forEach var="cat" items="${catData}">
							<option value="${cat.id}">${cat.name}</option>
						</c:forEach>
					</select>
					<input type="submit" name="getSearch" value="Search"/>
				</form>
			</td>
		</tr>
	</table>

	<br/>
	<hr/>

	<table border="1">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Cat</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="menu" items="${menuData}">
			<tr id="${menu.id}">
				<td><c:out value="${menu.name}" /></td>
				<td><c:out value="${menu.price}" /></td>
				<td>
					<c:out value="${menu.cat.id == null ? 'Нет категории' : menu.cat.name}" /> <%-- ${idItemCatEdit == 0 ? 'selected="selected"' : ''} --%>
				</td>
				<td>
					<form id="editUse_${menu.id}" action="sGetAllMenu" method="post">
		 				<input type="hidden" name="idItemEdit" value="${menu.id}">
		 				<input type="hidden" name="idItemCatEdit" value="${menu.cat.id}">
	 				</form>
					<a href="javascript: submitformEdit(${menu.id})">
						<img src="resources/image/edit.ico" style="height: 50px;"/>
					</a>
				</td>
				<td>
					<form id="deleteUse_${menu.id}" action="sDeleteItem" method="post">
		 				<input type="hidden" name="IdItemDelete" value="${menu.id}">
	 				</form>
					<a href="javascript: submitformDelete(${menu.id})">
						<img src="resources/image/delete.ico" style="height: 50px;"/>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>