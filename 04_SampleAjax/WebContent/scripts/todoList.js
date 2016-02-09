$(document).ready(function() {
	"use strict";
	
	var ENDPOINT = "http://localhost:3000/tasks";
	
	function taskEndpoint(taskId) {
		return ENDPOINT+"/" + taskId;
	}
	
	function showPanel(panelName) {
		var ALL_PANELS = ["emptyPanel", "readPanel", "updatePanel", "createPanel"];
		_.forEach(ALL_PANELS, function(nextValue) {
			$("#"+nextValue).hide();
		});
		$("#"+panelName).show();
	}
	
	function listTasks() {
		return $.ajax(ENDPOINT, {
			method: "GET",
			dataType: "json"
		});
	}
	
	function fillEditFields(response) {
		$("#updatePanel input").val(response.title);
		$("#updatePanel textArea").val(response.description);
	}
	
	function saveEditedTask(taskId) {
		$.ajax(taskEndpoint(taskId), {
			method: "PUT",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify({
				title: $("#updatePanel input").val() ,
				description: $("#updatePanel textArea").val()
			}),
			dataType: "json",
		});
	}
	
	function readTask(taskId) {
		return $.ajax(taskEndpoint(taskId), {
			method: "GET",
			dataType: "json",
		});
	}
	
	function createTask() {
		var task = {
			title: $("#createPanel input").val(),
			description: $("#createPanel textarea").val()
		}
		$.ajax(ENDPOINT, {
			method: "POST",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(task),
			dataType: "json",
		}).then(function(response) {
			window.location.reload();
		});
	}
	
	function deleteTask(taskId) {
		$.ajax(taskEndpoint(taskId), {
			method: "DELETE"
		});
	}
	
	function showTaskView(task) {
		$("#readPanel .task-title").text(task.title);
		$("#readPanel .task-description").text(task.description);
		showPanel("readPanel");
	}
	
	function reloadTasks() {
		listTasks().then(function(response) {
			function addTaskToList(task) {
				var newItem = $("<li />");
				newItem.text(task.title);
				newItem.addClass("list-group-item");
				newItem.attr("data-task-id", task.id);
				$("#tasksList").append(newItem);
			}
			$("#tasksList").html("");
			_.forEach(response, addTaskToList);
		});
	}
	
	function attachHandlers() {
		var clickedTaskId = null;
		$(document).on("click", "#tasksList [data-task-id]", function() {
			clickedTaskId = $(this).attr("data-task-id");
			readTask(clickedTaskId).then(showTaskView);
		});
		
		$(".task-action-cancel").click(function() {
			showPanel("emptyPanel");
		});
		
		$(".task-action-remove").click(function() {
			deleteTask(clickedTaskId);
			window.location.reload();
		});
		
		$("#readPanel .task-action-ok").click(function() {
			showPanel("updatePanel");
			readTask(clickedTaskId).then(fillEditFields);
		});
		
		$("#updatePanel .task-action-ok").click(function() {
			saveEditedTask(clickedTaskId);
			window.location.reload();
		});
		
		$("#addTaskButton").click(function() {
			$("#createPanel [name='title']").val("");
			$("#createPanel [name='description']").val("");
			showPanel("createPanel");
		});
		
		$("#createPanel .task-action-ok").click(function() {
			createTask();
		});
	}
	
	attachHandlers();
	reloadTasks();
});