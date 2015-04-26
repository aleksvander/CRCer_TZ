<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Каюсь мой косяк, знаю что надо было вынести во внешний файл js, но делал на скорость -->
<script type="text/javascript">
	function setCatIdBySearch(selectCat) {
		//alert(selectCat.selectedIndex);
		document.getElementById("setSelectedMenuInput").value = selectCat.selectedIndex;
	}
	function submitAdd() {
		var x = document.getElementById("priceId").value;
		if (isNumeric(x)) { 
			document.getElementById("priceVal").innerHTML = '';
			document.forms["addForm"].submit();
		} else {
			document.getElementById("priceVal").innerHTML = 'Неверный формат FLOAT';
		}
	}
	function isNumeric(n) {
		  return !isNaN(parseFloat(n)) && isFinite(n);
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="nav_menu.jsp" %>

	<form id = "addForm" action="sAddItem" method="post">
		<p>Enter name: </p><input type="text" name="name"/>
		<p>Enter price: </p><input id = "priceId" type="text" name="price"/> <div id = "priceVal" ></div>
		<p>Select category: </p>
		<input id="setSelectedMenuInput" type="hidden" name="catId" value="0" />
		<select id = "searchByCatListing" name="searchByCatListing" size="1" onChange="setCatIdBySearch(this)"> <!--  -->
			<option ${idItemCatEdit == 0 ? 'selected="selected"' : ''} value="0">Нет категории</option>
			<c:forEach var="cat" items="${catData}">
				<option value="${cat.id}">${cat.name}</option>
			</c:forEach>
		</select>
		<input type="hidden" value="add" />
		<a href="javascript: submitAdd()">ADD</a>
	</form>
	<h2>${result}</h2>
</body>
</html>