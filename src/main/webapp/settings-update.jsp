<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" href="css/main.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" />

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
					class="nav-link active text-black d-flex justify-content-start">
						<span class="material-symbols-outlined"
						style="margin-right: 20px;"> settings </span>Settings
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
				<h4 style="text-align: left;">Profile</h4>
				<div class="jumbotron jumbotron-fluid d-flex align-items-center">

					<div class="form-floating">
						<p class="h3" style="padding: 0 0 0 100px; color: #FF4E5B;">Trust
							Care Center</p>
						<p style="font-size: 12px; color: grey; padding: 0 100px;">Thank
							you for your brilliant treatment.</p>
					</div>


				</div>
				<br>
				<div class="container">
					<div class="form-floating">
						<div class="py-2">
							<jsp:useBean id="docInfo" class="bean.Doctor"></jsp:useBean>
							<jsp:setProperty name="docInfo" property="*" />
							<form action="UpdateSetting" method="post">
								<div class="row py-2">
									<input name="id" type="text" class="bg-light form-control"
										value="<jsp:getProperty name="docInfo" property="id" />"
										hidden>
									<div class="col-md-6">
										<label for="fullname">Full Name</label> <input name="name"
											type="text" class=" form-control"
											value="<jsp:getProperty name="docInfo" property="name" />" required>
									</div>
									<div class="col-md-6 pt-md-0 pt-3">
										<label for="lastname">Specialization</label> <input
											name="specialization" type="text" class="form-control"
											value="<jsp:getProperty name="docInfo" property="specialization" />" required>
									</div>
								</div>
								<div class="row py-2">
									<div class="col-md-6">
										<label for="email">Email Address</label> <input name="email"
											type="text" class="bg-light form-control"
											value="<jsp:getProperty name="docInfo" property="email" />" readonly>
									</div>
									<div class="col-md-6 pt-md-0 pt-3">
										<label for="phone">Phone Number</label> <input name="phone"
											type="tel" class=" form-control"
											value="<jsp:getProperty name="docInfo" property="phone" />" required>
									</div>
								</div>
								<div class="row py-2">
									<%
									bean.Clinic clinic = new bean.Clinic();
									clinic.setName(request.getParameter("clinic_name"));
									clinic.setId(Integer.parseInt(request.getParameter("clinic_id")));
									%>
									<jsp:useBean id="clinInfo" class="bean.Clinic"></jsp:useBean>
									<jsp:setProperty name="clinInfo" property="*" />
									<input name="clinic_id" type="text"
										class="bg-light form-control" value="<%=clinic.getId()%>"
										hidden>
									<div class="col-md-6">

										<label for="clinicname">Clinic Name</label> <input
											name="clinic_name" type="text" class="form-control"
											value="<%=clinic.getName()%>" required>
									</div>
									<div class="col-md-6 pt-md-0 pt-3">
										<label for="clinicaddress">Clinic Address</label> <input
											name="address" type="text" class="form-control"
											value="<jsp:getProperty name="clinInfo" property="address" />" required>


									</div>

									<div class="py-3 pb-4 d-flex justify-content-between mt-5">
										<button type="button" class="btn btn-outline-danger"
											data-bs-toggle="modal" data-bs-target="#deleteModal">
											<i class="bi bi-trash3"></i>
										</button>
										<div>
											<a href="<%=request.getContextPath()%>/setting"
												style="text-decoration: none;">
												<button type="button" class="btn btn-outline-primary mr-3 ">cancel</button>
											</a>
											<button type="submit" class="btn btn-primary mr-3 ">Update
												profile</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Delete modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1"
		aria-labelledby="deleteModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<form action="DeleteAccount" method="post">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="deleteModalLabel">Are you
							sure?</h1>
						<input type="text" hidden name="id"
							value="<c:out value='${doc_profile.id}'/>" />
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						Do you really want to delete this account?<br> <b
							style="font-size: 12px">Note: This process will not delete
							clinic data and cannot be undo</b>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Cancel</button>
						<button type="submit" class="btn btn-danger">Yes, delete
							this account</button>
					</div>
				</form>
			</div>
		</div>
	</div>





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