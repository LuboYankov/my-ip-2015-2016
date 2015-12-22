$(document).ready(function() {
	"user strict";
	
	var ENDPOINT = "http://localhost:3000/tasks";
	
	function taskEndpoint(taskId) {
		return ENDPOINT+"/" + taskId;
	}
	
	// global error handler
	$(document).ajaxError(function() {
		console.log("error:", arguments);
		alert("Error!");
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
	
	$.ajax(taskEndpoint(1), {
		method: "GET",
		dataType: "json",
	}).then(function(response) {
		console.log(response);
	});
	
	var task = {
			title: "hello",
			description: "some text"
	};
	var createPromise = $.ajax(ENDPOINT, {
		method: "POST",
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify(task),
		dataType: "json",
	}).then(function(response) {
		console.log(response);
		return response;
	});
	
	$.ajax(taskEndpoint(2), {
		method: "PUT",
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify({
			title: "updated",
			description: "updated description"
		}),
		dataType: "json",
	}).then(function(response) {
		console.log(response);
	});
	
	createPromise.then(function(response) {
		$.ajax(taskEndpoint(response.id), {
			method: "DELETE"
		});
	});
	
//	$("#submit-button").click(function() {
//		var task = {
//				title: $("#title").val(),
//				description: $("#description").val()
//		};
//		$("#title").val("");
//		$("#description").val("");
//		$.ajax(ENDPOINT, {
//			method: "POST",
//			contentType: "application/json; charset=utf-8",
//			data: JSON.stringify(task),
//			dataType: "json",
//		}).then(function(response) {
//			console.log(response);
//		});
//	});
});