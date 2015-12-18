$(document).ready(function() {
	"use strict"

	var buttonId = 0; 
	
	function addButtons() {
		var rows = $("tbody tr");
		_.forEach(rows, function(value) {
			$(value).children().last().append("<button id=\"button"+buttonId+"\">Button</button>");
			buttonId++;
		});
	}
	
	function button1() {
		$("#button0").click(function() {
			$("#name1").remove();
		});
	}
	
	function button2() {
		$("#button1").click(function() {
			var inputValue = $("input").val();
			$(".filter").attr("data-filter-value", inputValue);
		});
	}
	
	function button3() {
		$("#button2").click(function() {
			var rows = $(".row-number");
			var i = 0;
			_.forEach(rows, function(value) {
				$(value).append(i);
				i++;
			});
		});
	}
	
	addButtons();
	button1();
	button2();
	button3();
	
});