$(document).ready(function() {
	"user strict";
	
	var ENDPOINT = "http://localhost:3000/tasks";
	
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
});