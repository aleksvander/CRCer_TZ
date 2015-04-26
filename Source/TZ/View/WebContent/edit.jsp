<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Каюсь мой косяк, знаю что надо было вынести во внешний файл js, но делал на скорость -->
<script language="javascript" type="text/javascript">
function setCatIdBySearch(selectCat) {
	document.getElementById("setSelectedMenuInput").value = selectCat.selectedIndex;
}
function submitEdits() {
	var x = document.getElementById("priceId").value;
	if (isNumeric(x)) { 
		document.getElementById("priceVal").innerHTML = '';
		document.forms["editForm"].submit();
	} else {
		document.getElementById("priceVal").innerHTML = 'Неверный формат FLOAT';
	}
}
function isNumeric(n) {
	  return !isNaN(parseFloat(n)) && isFinite(n);
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
</head>
<body>
	<%@ include file="nav_menu.jsp" %>
	<form id ="editForm" action="sEditItem" method="post">
		<input type="hidden" name="idItemEdit" value="${idItemEdit}"/>
		<p>Enter name: </p><input type="text" name="name" value="${editableElement[0].name}"/>
		<p>Enter price: </p><input id = "priceId" type="text" name="price" value="${editableElement[0].price}"/> <div id = "priceVal" ></div>
		<p>Select category: </p>
		<input id="setSelectedMenuInput" type="hidden" name="catId" value="${idItemCatEdit}" />
		<select id = "searchByCatListing" name="searchByCatListing" size="1" onChange="setCatIdBySearch(this)"> <!--  -->
			<option ${idItemCatEdit == 0 ? 'selected="selected"' : ''}">Нет категории</option>
			<c:forEach var="cat" items="${catData}">
				<option ${idItemCatEdit == cat.id ? 'selected="selected"' : ''} value="${cat.id}">${cat.name}</option>
			</c:forEach>
		</select>
		
		<a href="javascript: submitEdits()">EDIT</a>
	</form>
	<h2>${result}</h2>
</body>
</html>