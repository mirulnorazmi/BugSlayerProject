<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
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
					class="nav-link active text-black d-flex justify-content-start"
					aria-current="page"><span class="material-symbols-outlined"
						style="margin-right: 20px;"> dashboard </span> Dashboard </a></li>
				<li class="nav-item"><a
					href="<%=request.getContextPath()%>/my-appointment"
					class="nav-link text-black d-flex justify-content-start"> <span
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
			class="dashboard-con d-flex flex-column justify-content-left align-items-center offset-3 col-9">
			<div style="width: 100%;">
				<h4 style="text-align: left;">Dashboard</h4>
				<div class="banner-welcome mb-3 col-12">
					<img src="images/logo/logo-doctorange.png" alt="logo" width="350px" />
				</div>
			</div>

			<div class="d-flex flex-row mt-2" style="width: 100%;">
				<div class="col-8">
					<h4 style="text-align: left;">Status</h4>
					<div class="d-flex flex-wrap">
						<div class="card col-10 mb-2" style="margin-right: 10px;">
							<div
								class="card-body d-flex flex-row justify-content-between align-items-center">
								<div>
									<h5 class="card-title">7</h5>
									<p class="card-text">Appointments due</p>
								</div>
								<div class="border-icon-status">
									<span class="material-symbols-outlined"> today </span>
								</div>
							</div>
						</div>
						<div class="card col-5 mb-2" style="margin-right: 10px;">
							<div
								class="card-body d-flex flex-row justify-content-between align-items-center">
								<div>
									<h5 class="card-title">12</h5>
									<p class="card-text">All doctor</p>
								</div>
								<div class="border-icon-status">
									<span class="material-symbols-outlined"> stethoscope </span>
								</div>
							</div>
						</div>
						<div class="card col-5 mb-2" style="margin-right: 10px;">
							<div
								class="card-body d-flex flex-row justify-content-between align-items-center">
								<div>
									<h5 class="card-title">30</h5>
									<p class="card-text">Registered patients</p>
								</div>
								<div class="border-icon-status">
									<span class="material-symbols-outlined"> ward </span>
								</div>
							</div>
						</div>
						<div class="card col-5 mb-2" style="margin-right: 10px;">
							<div
								class="card-body d-flex flex-row justify-content-between align-items-center">
								<div>
									<h5 class="card-title">7</h5>
									<p class="card-text">Clinic</p>
								</div>
								<div class="border-icon-status">
									<span class="material-symbols-outlined"> home_health </span>
								</div>
							</div>
						</div>
						<div class="card col-5 mb-2" style="margin-right: 10px;">
							<div
								class="card-body d-flex flex-row justify-content-between align-items-center">
								<div>
									<h5 class="card-title">10</h5>
									<p class="card-text">Generated bills</p>
								</div>
								<div class="border-icon-status">
									<span class="material-symbols-outlined"> receipt </span>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="col-4">
					<h4 style="text-align: left;">Shortcut</h4>
					<div
						class="d-flex flex-column justify-content-left align-items-top"
						style="width: 100% !important;">
						<a href="/BugSlayerProject/create-appointment.jsp"
							style="text-decoration: none;" class="mb-3">
							<button type="button" class="btn btn-outline-primary"
								style="width: 100% !important;">Create appointment</button>
						</a> <a href="/BugSlayerProject/create-patient.jsp"
							style="text-decoration: none;" class="mb-3">
							<button type="button" class="btn btn-outline-primary"
								style="width: 100% !important;">Create patients</button>
						</a>
						<!-- <button type="button" class="btn btn-outline-primary mb-3">
							Display doctors</button>
						<button type="button" class="btn btn-outline-primary mb-3">
							Display bills</button>
						<button type="button" class="btn btn-outline-primary mb-3">
							Display clinic</button> -->
					</div>
				</div>
			</div>
		</div>
	</div>


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