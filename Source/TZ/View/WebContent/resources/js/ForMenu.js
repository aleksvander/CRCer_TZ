function setIdBySearch(selectobj) {
	//alert((selectobj.selectedIndex + 1 == 3));
	document.getElementById("searchIdInput").value = selectobj.selectedIndex + 1;
	if (selectobj.selectedIndex + 1 != 3) {
		document.getElementById("setSelectedMenuInput").style.visibility = "visible"; 
		document.getElementById("searchByCatListing").style.visibility = "hidden";
	} else {
		document.getElementById("setSelectedMenuInput").style.visibility = "hidden";
		document.getElementById("searchByCatListing").style.visibility = "visible"; 
	}
	//alert(document.getElementById("searchByCatListing").style.visibility);
}

function setCatIdBySearch(selectCat) {
	//alert(selectCat.selectedIndex);
	document.getElementById("setSelectedMenuInput").value = selectCat.selectedIndex;
}

function submitformEdit(id)
{ 
	document.forms["editUse_" + id].submit(); 
}

function submitformDelete(id)
{ 
	document.forms["deleteUse_" + id].submit();
	//alert("deleteUse_" + id);
	//submitformMenu();
}