// Filtering tournaments when writing on the input
function filterTournaments() {
	$.ajax({ 
		type: "post", 
		url: "filterTournaments", 
		dataType: "json",
		cache: false,	 
		data:'name=' + $("#filterTournament").val(), 
		error: function() {alert('eerrrr');},
		success: function(tournaments){ 
			
			if (tournaments != null && tournaments.length > 0) {
				$("#tournament").removeAttr("disabled");
			} else {
				$("#tournament").attr("disabled", "disabled");
			}

			var options = '';
			for (var i = 0 ; i < tournaments.length ; i++) {
				options += '<option value="' + tournaments[i].id + '">' + tournaments[i].name + '</option>';
			}

			$("select#tournament").html(options);
		}
	});	
}

//Filtering tournaments when writing on the input
function filterPlayerOne() {
	$.ajax({ 
		type: "post", 
		url: "filterPlayerOne", 
		dataType: "json",
		cache: false,	 
		data:'name=' + $("#filterPlayerOne").val(), 
		error: function() {alert('eerrrr');},
		success: function(players){ 
			
			if (players != null && players.length > 0) {
				$("#playerOne").removeAttr("disabled");
			} else {
				$("#playerOne").attr("disabled", "disabled");
			}

			var options = '';
			for (var i = 0 ; i < players.length ; i++) {
				options += '<option value="' + players[i].id + '">' + players[i].name + '</option>';
			}

			$("select#playerOne").html(options);
		}
	});	
}

//Filtering tournaments when writing on the input
function filterPlayerTwo() {
	$.ajax({ 
		type: "post", 
		url: "filterPlayerTwo", 
		dataType: "json",
		cache: false,	 
		data:'name=' + $("#filterPlayerTwo").val(), 
		error: function() {alert('eerrrr');},
		success: function(players){ 
			
			if (players != null && players.length > 0) {
				$("#playerTwo").removeAttr("disabled");
			} else {
				$("#playerTwo").attr("disabled", "disabled");
			}

			var options = '';
			for (var i = 0 ; i < players.length ; i++) {
				options += '<option value="' + players[i].id + '">' + players[i].name + '</option>';
			}

			$("select#playerTwo").html(options);
		}
	});	
}

// Disable listBoxes (nothing to select) at form start
function disableListBoxes() {
	
	$("#tournament").attr("disabled", "disabled");
	$("#playerOne").attr("disabled", "disabled");
	$("#playerTwo").attr("disabled", "disabled");
}



$(document).ready(function() {
	
	// Disable listBoxes (nothing to select) at form start
	disableListBoxes();
	
	// Filtering tournaments when writing on the input
	$('#filterTournament').on("input", null, null, function(){
	    filterTournaments($(this).val());
	});
	
	// Filtering playerOne when writing on the input
	$('#filterPlayerOne').on("input", null, null, function(){
	    filterPlayerOne($(this).val());
	});
	
	// Filtering playerTwo when writing on the input
	$('#filterPlayerTwo').on("input", null, null, function(){
	    filterPlayerTwo($(this).val());
	});
	
});