<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Appointment</title>
<link rel="stylesheet" href="css/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
</head>
<body>
	<div class="d-flex flex-row" style="height: 100%;">
		<!-- Start sidebar  -->
		<div id="sidebar"
			class="d-flex flex-column flex-shrink-0 text-black bg-white col-3 position-fixed"
			style="height: 100%;">
			<div
				class="d-flex flex-row justify-content-center align-items-center mt-5">
				<div class="avatar-circle">
					<span class="material-symbols-outlined" style="font-size: 50px;">
						person </span>
				</div>
				<div
					class="d-flex flex-column justify-content-center align-items-right"
					style="padding-left: 15px;">
					<h5 style="margin: 0px;">
						Doc. <c:out value='${doctor.name}' /></h5>
					<span style="color: #bfbfbf;"><%=session.getAttribute("email")%></span>
				</div>
			</div>
			<a href="/BugSlayerProject/"
				class="d-flex justify-content-center align-items-center mt-3 mb-3"
				style="width: 100%; text-decoration: none;">
				<button class="btn btn-primary col-8" type="button">Log out</button>
			</a>
			<hr class="hr-line">
			<ul class="nav nav-underline flex-column mb-auto"
				style="padding-left: 40px;">
				<li class="nav-item"><a
					href="<%=request.getContextPath()%>/dashboard"
					class="nav-link text-black d-flex justify-content-start"
					aria-current="page"><span class="material-symbols-outlined"
						style="margin-right: 20px;"> dashboard </span> Dashboard </a></li>
				<li class="nav-item"><a
					href="<%=request.getContextPath()%>/my-appointment"
					class="nav-link active text-black d-flex justify-content-start"> <span
						class="material-symbols-outlined" style="margin-right: 20px;">
							event </span>My Appointments
				</a></li>
				<li class="nav-item"><a
					href="<%=request.getContextPath()%>/my-patient"
					class="nav-link text-black d-flex justify-content-start"><span
						class="material-symbols-outlined" style="margin-right: 20px;">
							patient_list </span> My Patients</a></li>
				<li class="nav-item"><a
					href="<%=request.getContextPath()%>/setting"
					class="nav-link text-black d-flex justify-content-start"> <span
						class="material-symbols-outlined" style="margin-right: 20px;">
							settings </span>Settings
				</a></li>
			</ul>
			<hr style="margin-bottom: 0px !important;">
			<div class="d-flex justify-content-center align-items-center p-3">
				<p style="font-size: 14px; margin: 0px !important;">Doctorange @
					copyright 2023</p>
			</div>
		</div>
		<!-- End sidebar  -->
		<div
			class="dashboard-con d-flex flex-column justify-content-center align-items-center offset-3 col-9">
			<div style="width: 100% !important;">
				<h4 style="text-align: left;">Create Appointment</h4>
			</div>
			<div
				class="d-flex flex-crow justify-content-center align-items-center"
				style="height: 80vh !important;">
				<img src="images/booking.png" alt="image" class="col-5" />
				<form class="container-fluid formCreateApp col-7">

					<div class="mb-3 col-12">
						<label for="exampleInputName" class="form-label">Name</label> <input
							type="text" class="form-control" id="name"
							aria-describedby="name">
					</div>
					<div class="mb-3 col-12">
						<label for="exampleEmail" class="form-label">Email</label> <input
							type="email" class="form-control" id="exampleEmail">
					</div>
					<div class="row col-12">
						<div class="mb-3 col-6">
							<label for="exampleIc" class="form-label">IC number <i>without
									(-)</i>
							</label> <input type="text" class="form-control" id="exampleIc">
						</div>
						<div class="mb-3 col-6">
							<label for="exampledate" class="form-label">Date</label> <input
								type="date" class="form-control" id="exampledate"
								value="2013-01-08">
						</div>
					</div>
					<div class="row col-12">
						<div class="mb-3 col-6">
							<label for="exampletime" class="form-label">Time</label> <input
								type="time" class="form-control" id="exampleTime" value="10:00">
						</div>
						<div class="mb-3 col-6">
							<label for="exampleduration" class="form-label">Duration</label>
							<input type="text" class="form-control" id="exampleduration"
								value="1 hour">
						</div>
					</div>
					<div class="d-flex justify-content-between">
						<!-- <button type="button" class="btn btn-outline-danger"
							data-bs-toggle="modal" data-bs-target="#deleteModal">
							<i class="bi bi-trash3"></i>
						</button> -->
						<button type="reset" class="btn btn-outline-danger">Reset</button>
						<button type="submit" class="btn btn-primary">Create</button>

					</div>
				</form>
			</div>
		</div>
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