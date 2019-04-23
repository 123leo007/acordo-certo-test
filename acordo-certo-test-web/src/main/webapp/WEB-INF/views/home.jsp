<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AcordoCertoTest</title>
</head>
<body>
	<div class="form-group col-md-4">
		<form action="" method="Post">
			<label>Nome:</label>
			<input type="text" name="name" class="form-control" id="name">
			<br /> <label>Faixa etária:</label> 
			<select class="form-control" name="agerange" onchange="" id="agerange">
				<option value="Menor18">Menos de 18 anos</option>
				<option value="de18a24">De 18 a 24</option>
				<option value="de25a35">De 25 a 35</option>
				<option value="de35a45">De 35 a 45</option>
				<option value="Maior45">Mais de 45</option>
			</select> <br />
			<div class="form-group form-check">
				<input type="checkbox" name="websitemail" id="websitemail" />I
				<label>don't want to receive email from this website</label> <br />
			</div>
			<button class="btn btn-primary" type="button" onclick='sendForm()'>Submit</button>
		</form>
	</div>
	<div class="col-md-6">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">Age Range</th>
					<th scope="col">Receive Email?</th>
				</tr>
			</thead>
			<tbody id="table">
			</tbody>
		</table>
	</div>
</body>
</html>


<script>
	$(document).ready(loadForm());

	function sendForm() {
		var url = "/saveform";
		var data = new Object();
		data.name = $('#name').val();
		data.ageRange = $('#agerange').val();
		data.websitemail = $('#websitemail').is(":checked");
		$.ajax({
			url : url,
			type : 'POST',
			data : JSON.stringify(data),
			contentType : 'application/json',
			dataType : 'json',
			async : false,
			success : loaded()
		}).then(success());

	}

	function success() {
		loadForm();
		alert("Added a new line");
	}

	function loadForm() {
		var html = '';
		var url = "/loadform";
		$.ajax({
			url : url,
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			success : function(result) {
				for ( var data in result) {
					var receivemail = 'no';
					if (result[data].websitemail === 'false') {
						receivemail = 'yes'
					}
					html += "<tr><th scope='row'>" + result[data].id + "</th>" + "<td>" + result[data].name + "</td>"
							+ "<td>" + result[data].ageRange + "</td>" + "<td>"
							+ receivemail + "</td>" + "</tr>";
				}
				$('#table').html(html);
			},
			async : false
		});
	}

	function loaded() {
		console.log("ajax request running");
		location.reload();
	}
</script>