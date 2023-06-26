<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctorange | Registration</title>
<link rel="stylesheet" href="css/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
</head>
<body style="height: 100vh;">
	<div class="d-flex flex-row" style="height: 10%;">

		<!-- Start navbar  -->

		<nav class="navbar navbar-reg fixed-top ">
			<div class="container-fluid">
				<a class="navbar-brand" href="<%=request.getContextPath()%>"> <img
					src="images/logo/logo-doctorange.png" alt="Logo" width="150"
					height="50" height="40" class="d-inline-block align-text-top">
				</a> <a href="<%=request.getContextPath()%>"
					style="text-decoration: none;"><button
						class="btn btn-outline-danger me-2" type="button">Sign in</button>
				</a>

			</div>
		</nav>
	</div>
	<!-- End navbar  -->

	<!-- Start form -->
	<div class="container col-12">
		<div style="padding: 0 60px;">
			<div
				class="d-flex flex-row justify-content-center align-items-center g-0 card mt-5 container-fluid">
				<div class="col-md-4">
					<img src="images/register-logo.jpg" class="img-fluid rounded-start"
						width="1000px" alt="register-logo">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h2>Registration</h2>
						<br>
						<form class="row g-3" action="register" method="post">
							<div class="col-md-6">
								<label for="inputName4" class="form-label">Full Name</label> <input
									name="name" type="text" class="form-control" id="inputName4"
									required>
							</div>
							<!-- <div class="col-md-6">
								<label for="inputUsername4" class="form-label">Username</label>
								<input name="username" type="text" class="form-control" id="inputUsername4"
									required>
							</div> -->
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Email</label> <input
									name="email" type="email" class="form-control" id="inputEmail4"
									placeholder="ex: abc@xyz.com" required>
							</div>
							<div class="col-md-6">
								<label for="inputPhone4" class="form-label">Phone Number</label>
								<input name="phone" type="text" class="form-control"
									id="inputPhone4" placeholder="ex: 0123456789" required>
							</div>
							<div class="col-md-6">
								<label for="inputSpecial4" class="form-label">Specialization</label>
								<input name="specialization" type="text" class="form-control"
									id="inputSpecial4" required>
							</div>
							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Password</label>
								<input name="password" type="password" class="form-control"
									id="inputPassword4" placeholder="minimum 8 character" required>
							</div>
							<div class="col-md-6">
								<label for="inputCPassword4" class="form-label">Confirm
									Password</label> <input name="cPassword" type="password"
									class="form-control" id="inputCPassword4"
									placeholder="must be the same as password" required>
							</div>
							<div class="col-md-6">
								<label for="inputClinicName" class="form-label">Clinic
									Name</label> <input name="clinicName" list="datalistOptions"
									type="text" class="form-control" id="inputClinicName"
									placeholder="new clinic or choose existing clinic" required>
								<datalist id="datalistOptions">
									<c:forEach var="clinic" items="${clinicList}">
										<option value="<c:out value="${clinic.name}" />">
									</c:forEach>
								</datalist>
							</div>
							<!-- <div class="col-12">
								<label for="inputAddress" class="form-label">Clinic
									Address</label> <input type="text" class="form-control"
									id="inputAddress" placeholder="1234 Main St">
							</div> -->
							<div class="col-12 text-center">
								<button class="btn btn-outline-danger me-2" type="submit">Register</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- <div class="card-footer text-body-secondary text-center">
			<h8>Doctorange @ copyright 2023</h8>
		</div> -->
	</div>
	<!-- End form -->

	<!-- Script section -->
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