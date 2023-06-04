<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Appointment</title>
<link rel="stylesheet" href="css/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar">
		<div class="d-flex flex-row justify-content-between"
			style="width: 100%">
			<a class="navbar-brand" href="#"> <img
				src="images/logo/logo-doctorange.png" alt="Logo" width="85"
				height="44" class="d-inline-block align-text-top">
			</a>
		</div>
	</nav>
<br>
	<div
		class="d-flex flex-column justify-content-start align-items-center"
		style="height: 100vh;">
		<img src="images/doctor-dashboard-bg.png" alt="image" /><br><br>
		<form class="form-container">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email Address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="your@doc.email.com">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label"></label>Password<input
					type="password" class="form-control" id="exampleInputPassword1"
					placeholder="password">
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Remember
					me</label>
			</div>
			<div class="d-grid gap-2 col-6 mx-auto">
				<button type="submit" class="btn btn-primary justify-content-center">Sign
					In</button>
				<br>
			</div>
			<p class="register-login">
				Don't have an account? <a href="#!" class="register"
					style="color: grey">Sign Up</a>
			</p>
		</form>
	<hr style="margin-bottom: 0px !important;">
		<div class="card-footer d-flex justify-content-center"
			style="width: 100%">
			<p style="font-size: 14px; margin: 0px !important;">
			Doctorange @ copyright 2023. All rights reserved.</p></div>

	</div>



	<!-- Script -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
		integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
		crossorigin="anonymous"></script>
</body>
</html>