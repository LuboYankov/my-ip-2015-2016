$(document).ready(function() {
	"use strict"
	
	function showPanel(panelName) {
		var ALL_PANELS = ["emptyPanel", "readPanel", "updatePanel", "createPanel"];
		_.forEach(ALL_PANELS, function(nextValue) {
			$("#"+nextValue).hide();
		});
		$("#"+panelName).show();
	}
	
	var ENDPOINT = "http://localhost:3000/tasks";
	
	$.ajax(ENDPOINT, {
		method: "GET",
		dataType: "json"
	}).then(function(response) {
		function addTaskToList(task) {
			var newItem = $("<li />");
			newItem.text(task.title);
			newItem.addClass("list-group-item");
			newItem.attr("data-task-id", task.id);
			$("#tasksList").append(newItem);
		}
		$("#taskList").html("");
		_.forEach(response, addTaskToList);
	});
	
	$(document).on("click", "#tasksList [data-task-id]", function() {
		// var taskId = $(this).attr("data-task-id");
		showPanel("readPanel");
	});
});