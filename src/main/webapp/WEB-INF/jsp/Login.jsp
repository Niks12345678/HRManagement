<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Management Utility</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<div class="jumbotron text-center head-text"
		style="background-color: #809fff; color: white; font-size: 25px; font-weight: bold; height: 70px; padding: 1em;">
		<p>Image Management Utility</p>
		<hr
			style="height: 2px; border-width: 1; color: gray; background-color: gray; width: 100%">
	</div>
	<div class="container col-md-8 col-md-offset-2"
		style="overflow: auto; padding-top: .5em;">
		<div class="jumbotron text-center head-text"
			style="background-color: #ff66b3; color: white; font-size: 25px; font-weight: bold; height: 70px; padding: 1em;">
			<p>Login</p>
		</div>
		<form modelAttribute="user" action="login" method="post"
			data-toggle="validator">
			<div class="form-group row">
				<label for="uname" class="col-md-3 col-sm-3 col-form-label">
					User Name: </label>
				<div class="col-md-9 col-sm-8">
					<input type="text" autofocus class="form-control" id="userName"
						placeholder="Enter user name" name="userName" maxlength="50"
						minlength="5" data-error="Enter your user name." required /> <small>
						<div class="help-block with-errors"></div>
					</small>
					<p id="userNameError"></p>
				</div>
			</div>
			<div class="form-group row">
				<label for="uname" class="col-md-3 col-sm-3 col-form-label">
					Password: </label>
				<div class="col-md-9 col-sm-8">
					<input type="password" autofocus class="form-control" id="password"
						placeholder="Enter your password" name="password" minlength="5"
						maxlength="50" data-error="Enter your password." required /> <small>
						<div class="help-block with-errors"></div>
					</small>
					<p id="userPasswordError"></p>
				</div>
			</div>
			<label class="col-md-3 col-sm-3 col-form-label"></label>
			<div class="col-md-9 col-sm-8">
				<p style="color: red">${wrongIdPass}</p>
			</div>
			<div class="form-group row">
				<div class="col-md-8 col-sm-8 col-xs-8 col-offset-1 form-group">
					<a href="https://google.com">forgotten your password?</a>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-2 col-offset-2 form-group">
					<button type="submit" class="btn btn-primary">Login</button>
				</div>
			</div>
		</form>
		<footer>
			<div class="container-fluid"
				style="background-color: #ff66b3; color: white">
				<div class="text-center">
					<p>Copyright 2020-2021 by Fresher Training</p>
				</div>
			</div>
		</footer>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
</body>
</html>