<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My appointments</title>
<link rel="stylesheet" href="css/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">


</head>
<body style="width: 100%; overflow-y: hidden;">
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
						Doc.
						<%=session.getAttribute("doc_surname")%></h5>
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
					class="nav-link active text-black d-flex justify-content-start">
						<span class="material-symbols-outlined"
						style="margin-right: 20px;"> event </span>My Appointments
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
				<h4 style="text-align: left;">My appointments</h4>
				<div class="alert alert-info" role="alert">Click on the row to
					update and delete the appointment</div>
				<div class="d-flex flex-row justify-content-between m-2">
					<section class="d-flex flex-row align-items-center col-8">
						<div class="form-check form-switch">
							<input class="form-check-input" type="checkbox" role="switch"
								id="flexSwitchCheckDefault" checked> <label
								class="form-check-label" for="flexSwitchCheckDefault">Today
								appointments</label>
						</div>
						<div class="form-check form-switch" style="margin-left: 10px;">
							<input class="form-check-input" type="checkbox" role="switch"
								id="flexSwitchCheckDefault"> <label
								class="form-check-label" for="flexSwitchCheckDefault">by
								Date</label>
						</div>
						<div class="form-check form-switch" style="margin-left: 10px;">
							<input class="form-check-input" type="checkbox" role="switch"
								id="flexSwitchCheckDefault"> <label
								class="form-check-label" for="flexSwitchCheckDefault">by
								Time</label>
						</div>
					</section>
					<a href="<%=request.getContextPath()%>/create-appointment"
						style="text-decoration: none;">
						<button type="button" class="btn btn-outline-primary">
							<i class="bi bi-plus-circle"></i> Create appointment
						</button>
					</a>
				</div>
			</div>
			<div class="table-responsive container-fluid" id="infinite-table">
				<table class="table table-hover align-middle">
					<thead class="header">
						<tr>
							<th scope="col"></th>
							<th scope="col">Patient Name</th>
							<th scope="col">Date</th>
							<th scope="col">Time</th>
							<th scope="col">Duration</th>
							<th scope="col">Description</th>
							<th scope="col">Status</th>
							<th scope="col">Bill</th>
							<!-- 				<th></th> -->
							<!-- <th></th> -->
						</tr>
					</thead>
					<tbody>
						<c:forEach var="app" items="${listAppointment}">
							<tr key="<c:out value="${app.appointment_id}" />"
								onclick="myFunction(<c:out value="${app.appointment_id}" />, '<%=request.getContextPath()%>/edit-appointment')">

								<th scope="row" style="color: #FF4E5B !important;"><c:out
										value="${app.appointment_id}" /></th>
								<td><c:out value="${app.patient_name}" /></td>
								<td><c:out value="${app.date}" /></td>
								<td><c:out value="${app.time}" /></td>
								<td><c:out value="${app.duration}" /></td>
								<td><c:out
										value="${app.description eq null ? '-' : app.description	}" /></td>
								<td style="text-align: center;"><c:out
										value="${app.status eq 'pending' ? '🕒' : '✅'}" /></td>
								<td style="text-align: center;"><c:out
										value="${app.bill_status eq 'pending' ? '🕒' : '✅'}" /></td>
								<!-- <td><button type="button" class="btn">
									<i class="bi bi-pencil-square"></i>
								</button></td> -->
								<!-- <td><button type="button" class="btn" style="z-index: 20;">
									<i class="bi bi-trash3-fill"></i>
								</button></td> -->

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<!-- Script section -->
	<!-- <script src="js/script.js"></script> -->
	<script>
		function myFunction(x,y) {
			console.log("Row index is: " + x); 
			window.location.href= y + "?id=" + x;
			sessionStorage.setItem("key", x);
			console.log("Session key : " + sessionStorage.getItem("key"));
		}
	</script>
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