$(document).ready(function() {
	"use strict"
	// define function:
	function removeByClassName() {
		$(".name-column").remove();
	}
	
	function removeById() {
		$("#studentsTable").remove();
	}
	
	function removeByType() {
		$("ol").remove();
	}
	
	function removeByDescendant() {
		// remove list items children of ul, but not the ul
		$("ul li").remove();
	}
	
	function removeByFind(parent) {
		parent.find("li").remove();
	}
	
	// debugger; -> breakpoint
	
	// call function:
	// removeByClassName();
	// removeById();
	// removeByType();
	// removeByDescendant();
	// removeByFind($("ol"));
	
	// add new row to the table
	$("table").append("<tr><td>3</td><td>Georgi</td></tr>");
	
	// listen for event of type click on selected element
	$("#removeMountain").click(function() {
		$("ul li:first-child").remove();
	});
	
	var nextFreeMountainId = 1;
	
	$("#addMountain").click(function() {
		var newMountainElement = $("<li />")
		var newMountainName = $("#mountainNameInput").val();
		$("#mountainNameInput").val("");
		newMountainElement.text(newMountainName);
		newMountainElement.attr("id", "mountain"+(nextFreeMountainId++));
		$("ul").append(newMountainElement);
	});
	
	// this works only for already created elements
	/* $("ul li").click(function() {
		alert("asdf");
	}); */
	
	$(document).on("click", "ul li", function() {
		alert($(this).attr("id"));
	});
	
	// $("#removeMountain").on("mousemove", function() {
	//	alert("removing mountain mousemove");
	// });
});