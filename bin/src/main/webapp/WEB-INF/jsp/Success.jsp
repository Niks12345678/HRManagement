<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body style="background-color: white;">
	<div class="jumbotron text-center head-text"
		style="background-color: #809fff; color: white; height: 70px; padding: 1em;">
		<div class="container">
			<div class="form-group row">
				<p style="font-size: 25px; font-weight: bold; text-align: left;"
					class="col-md-5 col-sm-5 col-md-offset-1">Employee Details</p>

				<p style="font-size: 20px; font-weight: bold; text-align: right;"
					class="col-md-3 col-sm-3 col-md-offset-2">Welcome ${userName}</p>

				<form method="post" action="logout" style="vertical-align: top;">
					<input type="submit" class="btn btn-danger col-md-1 col-sm-1"
						value="Logout">
				</form>
			</div>
		</div>
		<hr
			style="height: 2px; border-width: 1; color: gray; background-color: gray; width: 100%">
	</div>
	<div class="container" style="overflow: auto; padding-top: .5em;">
		<div class="form-group row">
			<div class="col-md-6 col-sm-6">
				<p>Upload in CSV format to upload employee details</p>
				<form method="post" action="employee" enctype="multipart/form-data">
					<input type="file" class="col-md-6 col-sm-6" name="file"
						required="required" />
					<button class="btn btn-primary col-md-3 col-sm-3 col-md-offset-1">Upload</button>
				</form>
			</div>
			<div class="col-md-6 col-sm-6">
				<p>Click to Download all employee details in CSV format</p>
				<form method="post" action="employee/download"
					enctype="multipart/form-data">
					<input type="submit" class="btn btn-danger col-md-offset-3"
						value="Download">
				</form>
			</div>
		</div>
		<div class="form-group row">
			<table class="table table-responsive table-bordered table-striped"
				border="1" style="background-color: #809fff;">
				<tr>
					<th>Employee Code</th>
					<th>Employee Name</th>
					<th>Location</th>
					<th>Email</th>
					<th>Date Of Birth</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.employeeCode}</td>
						<td>${employee.employeeName}</td>
						<td>${employee.location}</td>
						<td>${employee.email}</td>
						<td>${employee.dateOfBirth}</td>
						<td>
							<button type="button" class="btn btn-info btn-lg"
								data-toggle="modal" data-target="#myModal"
								onclick="fill(${employee.employeeCode},'${employee.employeeName}','${employee.location}','${employee.email}','${employee.dateOfBirth}');">Edit</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Welcome ${userName}</h4>
				</div>
				<div class="modal-body">
					<form modelAttribute="employee"
						action="<%=request.getContextPath()%>/employee/edit" method="post">
						<div class="form-group row">
							<label class="col-md-4 col-sm-4 col-form-label">Employee
								Code: </label> <input class=" col-md-7 col-sm-7" id="employeeCode"
								name="employeeCode" type="text" required readonly>
						</div>
						<div class="form-group row">
							<label class="col-md-4 col-sm-4 col-form-label">Employee
								Name: </label> <input class=" col-md-7 col-sm-7" id="employeeName"
								name="employeeName" type="text" required>
						</div>
						<div class="form-group row">
							<label class="col-md-4 col-sm-4 col-form-label">Location:
							</label> <input class=" col-md-7 col-sm-7 " id="employeeLocation"
								name="location" type="text" required>
						</div>
						<div class="form-group row">
							<label class="col-md-4 col-sm-4 col-form-label">Email: </label> <input
								class=" col-md-7 col-sm-7 " id="employeeEmail" type="text"
								name="email" required>
						</div>
						<div class="form-group row">
							<label class="col-md-4 col-sm-4 col-form-label">Date of
								Birth: </label> <input class=" col-md-7 col-sm-7 " name="dateOfBirth"
								id="employeeBirthDate" type="text" required>
						</div>
						<div class="modal-footer justify-content-center">
							<button type="submit" class="btn btn-success">Save</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
    function fill(code,name,location,email,dateOfBirth){
        document.getElementById("employeeCode").value=code;
        document.getElementById("employeeName").value=name;
        document.getElementById("employeeLocation").value=location;
        document.getElementById("employeeEmail").value=email;
        document.getElementById("employeeBirthDate").value=dateOfBirth;
    }
</script>
</body>
</html>