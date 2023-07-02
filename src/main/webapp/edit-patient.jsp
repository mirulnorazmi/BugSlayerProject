<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Patient</title>
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
						Doc. <%=session.getAttribute("doc_surname") %></h5>
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
					class="nav-link text-black d-flex justify-content-start"> <span
						class="material-symbols-outlined" style="margin-right: 20px;">
							event </span>My Appointments
				</a></li>
				<li class="nav-item"><a
					href="<%=request.getContextPath()%>/my-patient"
					class="nav-link active text-black d-flex justify-content-start"><span
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
		<%
		String[][] patients = {{"Anwar Dollah", "anwardollah@gmail.com", "019-9823721",
		"A-0-12 Perumahan Awam, Bukit Jalil, 57000, Kuala Lumpur"}};
		%>
		<div
			class="dashboard-con d-flex flex-column justify-content-left align-items-center offset-3 col-9">
			<div style="width: 100% !important;">
				<h4 style="text-align: left;">Edit patient</h4>
			</div>
			<form class="container-fluid formCreateApp" action="EditPatient"
				method="post">
				<div class="col-12 mb-3">
				<c:if test="${patient != null}">
							<input type="hidden" name="patientId"
								value="<c:out value='${patient.patient_id}' />" />
				</c:if>
				</div>
				<div class="col-12 mb-3">
					<label for="exampleInputName" class="form-label">Name</label> <input
						type="text" class="form-control" id="name" name="name" aria-describedby="name"
						value='${patient.name}' maxlength="50">
				</div>
				<div class="col-12 mb-3">
					<label for="exampleInputEmail" class="form-label">Email</label> <input
						type="email" class="form-control" id="email" name="email"
						aria-describedby="email" value='${patient.email}'>
				</div>
				<div class="col-12 mb-3">
					<label for="exampleInputIc" class="form-label">Ic Number
						</label> <input type="text" class="form-control" name="ic" id="ic"
						aria-describedby="ic" value='${patient.ic}' maxlength="12">
				</div>
				<div class="col-12 mb-3">
					<label for="exampleInputPhone" class="form-label">Phone
						number</label> <input type="text" class="form-control" name="phone" id="phone"
						aria-describedby="phone" value='${patient.phone}' maxlength="11">
				</div>
				<div class="col-12 mb-3">
					<label for="exampleInputAddress" class="form-label">Address</label>
					<input type="text" class="form-control" name="address" id="address"
						aria-describedby="address"
						value='${patient.address}'>
				</div> 
				<div class="d-flex justify-content-between mt-3">
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#deleteModal">
						<i class="bi bi-trash3"></i>
					</button>
					<button type="submit" class="btn btn-primary">Update</button>

				</div>
			</form>
		</div>
	</div>
	<!-- Delete modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1"
			aria-labelledby="deleteModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<form action="DeletePatient" method="post">
						<div class="modal-header">
							<h1 class="modal-title fs-5" id="deleteModalLabel">Are you
								sure?</h1>
							<input type="text" hidden name="appointmentId"
								value="<c:out value="${patient.patient_id}"/>" />
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">Do you really want to delete this
							record? This process cannot be undo</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-danger">Yes, delete
								patient</button>
						</div>
					</form>
				</div>
			</div>
		</div>

	<!-- Script -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/
  bootstrap.bundle.min.js"
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