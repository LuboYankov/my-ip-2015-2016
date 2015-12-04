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
	
	// debugger; -> breakpoint
	
	// call function:
	removeByClassName();
	removeById();
	removeByType();
	
	// add new row to the table
	$("table").append("<tr><td>3</td><td>Georgi</td></tr>");
	
	
});