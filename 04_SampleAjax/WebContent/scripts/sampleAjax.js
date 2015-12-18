$(document).ready(function() {
	"user strict";
	
	var ENDPOINT = "http://localhost:3000/tasks";
	
	// global error handler
	$(document).ajaxError(function() {
		console.log("error:", arguments);
		alert("Error!")
	});
	
	$.ajax(ENDPOINT, {
		method: "GET",
		// to add parameters to the request
		data: {
			title: "task1"
		},
		dataType: "json",
	}).then(function(response) {
		console.log(response);
	});
	
	$.ajax(ENDPOINT+"/"+2, {
		method: "GET",
		dataType: "json",
	}).then(function(response) {
		console.log(response);
	});
});