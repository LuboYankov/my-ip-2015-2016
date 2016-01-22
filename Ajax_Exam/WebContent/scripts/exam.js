$(document).ready(function() {
	"use strict";
	
	var ENDPOINT = "http://localhost:3000/pois";
	
	function getPoi() {
		return $.ajax(ENDPOINT, {
			method: "GET",
			data: {
				type: $("#filter").val()
			},
			dataType: "json"
		});
	}
	
	$("#search").click(function() {
		getPoi().then(function(response) {
			function addPoiToTable(poi) {
				$("#result").append("<tr><td>"+poi.type+"</td><td>"+poi.name+"</td></tr>");
			}
			_.forEach(response, addPoiToTable);
		});
	});
});