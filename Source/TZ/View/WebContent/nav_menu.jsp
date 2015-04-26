<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
function submitformMenu(nameId)
{ document.forms[nameId].submit(); }
</script>

<ul>
 <li>
	 <form id="myMenu" action="sGetAllMenu" method="post">
	 	<input type="hidden" name="setMenuId" value="0">
	 	<a href="javascript: submitformMenu('myMenu')">Menu</a>
	 </form>
 </li>
 <li>
 	<!-- Сначала получаем данные (по категориям) в сервлете, затем перекидываем на страницу -->
  	 <form id="myAdd" action="sGetAllMenu" method="post">
	 	<input type="hidden" name="SetNewItem">
	 	<a href="javascript: submitformMenu('myAdd')">Add menu</a>
	 </form>
 </li>
</ul>