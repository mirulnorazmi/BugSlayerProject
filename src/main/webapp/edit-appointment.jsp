<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Appointment</title>
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
		<%
		String[][] patients = { { "Kamsiah haidar", "2023-06-24", "10:00", "1 hour", "not yet", "not yet", "unpaid" } };
		%>
		<div
			class="dashboard-con d-flex flex-column justify-content-left align-items-center offset-3 col-9">
			<div style="width: 100% !important;">
				<h4 style="text-align: left;">Edit Appointments</h4>
			</div>
			<form class="container-fluid formCreateApp" action="EditAppointment"
				method="post">
				<div class="row col-12">
					<div class="mb-3 col-6">
						<c:if test="${appointment != null}">
							<input type="hidden" name="appointmentId"
								value="<c:out value='${appointment.appointment_id}' />" />
						</c:if>
						<label for="exampleInputName" class="form-label">Patient
							Name <i style="font-size: 12px;">(edit in My Patients)</i>
						</label> <input type="text" class="form-control" id="name"
							aria-describedby="name"
							value="<c:out value='${appointment.patient_name}' />" disabled>
					</div>
					<div class="mb-3 col-6">
						<label for="exampleBill" class="form-label">Bill status</label>
						<div class="input-group mb-3">
							<input type="text" class="form-control" id="exampleBill"
								value="<c:out value='${appointment.bill_status eq "pending" ? "Pending 🕒" : "Done ✅"}' />"
								disabled>
							<button class="btn btn-outline-primary" type="button"
								id="button-addon2" data-bs-toggle="modal"
								data-bs-target="#billModal">Edit bill</button>
						</div>
					</div>

				</div>
				<div class="row col-12">
					<div class="mb-3 col-6">
						<label for="exampledate" class="form-label">Date</label> <input
							type="date" name="date" class="form-control" id="exampledate"
							value="<c:out value='${appointment.date}' />">
					</div>
					<div class="mb-3 col-6">
						<label for="exampletime" class="form-label">Time</label> <input
							type="time" name="appointmentTime" class="form-control"
							id="exampleTime" step="1"
							value="<c:out value='${appointment.time}' />">
					</div>

				</div>
				<div class="row col-12">
					<div class="mb-3 col-6">
						<label for="exampleduration" class="form-label">Duration</label>
						<%-- <input
							type="text" class="form-control" id="exampleduration"
							value="<%=patients[0][3]%>"> --%>
						<select class="form-select" aria-label="Duration select"
							name="duration">

							<option value="<c:out value="${appointment.duration }"/>"><c:out
									value="${appointment.duration }" /></option>

							<c:if test="${appointment.duration != '30 minute'}">
								<option value="30 minute">30 minute</option>
							</c:if>
							<c:if test="${appointment.duration != '1 hour'}">
								<option value="1 hour">1 hour</option>
							</c:if>
							<c:if test="${appointment.duration != '1 and half hour'}">
								<option value="1 and half hour">1 and half hour</option>
							</c:if>
							<c:if test="${appointment.duration != '2 hour'}">
								<option value="2 hour">2 hour</option>
							</c:if>
						</select>
					</div>
					<div class="mb-3 col-6">
						<label for="exampleStatus" class="form-label">Status</label>
						<%-- input
							type="text" class="form-control" id="exampleStatus"
							value="<%=patients[0][4]%>"> --%>
						<select class="form-select" aria-label="Status select"
							name="status">
							<c:if test="${appointment.status == 'done'}">
								<option value="<c:out value="${appointment.status}"/>" selected>Done
									✅</option>
							</c:if>
							<c:if test="${appointment.status == 'pending'}">
								<option value="<c:out value="${appointment.status}"/>" selected>Pending
									🕒</option>
							</c:if>
							<c:if test="${appointment.status == 'pending'}">
								<option value="done">Done ✅</option>
							</c:if>
							<c:if test="${appointment.status == 'done'}">
								<option value="pending">Pending 🕒</option>
							</c:if>

						</select>
					</div>


				</div>
				<div class="mb-3">
					<label for="exampleDescription" class="form-label">Description</label>
					<textarea class="form-control" name="description"
						aria-label="With textarea" rows="7"><c:out
							value='${appointment.description }' /></textarea>
					<%-- <c:if test='${appointment.description != null}'>
					<c:out value='${appointment.description }' />
					</c:if> --%>

				</div>
				<div class="d-flex justify-content-between">
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#deleteModal">
						<i class="bi bi-trash3"></i>
					</button>
					<button type="submit" class="btn btn-primary">Update</button>
				</div>
			</form>
		</div>
		<!-- Delete modal -->
		<div class="modal fade" id="deleteModal" tabindex="-1"
			aria-labelledby="deleteModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<form action="DeleteAppointment" method="post">
						<div class="modal-header">
							<h1 class="modal-title fs-5" id="deleteModalLabel">Are you
								sure?</h1>
							<input type="text" hidden name="appointmentId"
								value="<c:out value="${appointment.appointment_id}"/>" /> <input
								type="text" hidden name="billId"
								value="<c:out value="${appointment.bill_id}"/>" />
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">Do you really want to delete this
							record? This process cannot be undo</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-danger">Yes, delete
								appointment</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--Modal bill  -->
		<div class="modal fade" id="billModal" tabindex="-1"
			aria-labelledby="billModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<form
						action="<%=request.getContextPath()%>/update-bill?id=<c:out value='${appointment.appointment_id }'/>"
						method="post">
						<div class="modal-header">
							<h1 class="modal-title fs-5" id="billModalLabel">Bill
								information</h1>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<div>
								<label for="exampleBill" class="form-label">Bill ID</label> <input
									type="text" class="form-control" id="exampleBill"
									value="<c:out value='${bill.bill_id }' />" disabled> <input
									type="text" name="billId" class="form-control" id="exampleBill"
									value="<c:out value='${bill.bill_id }' />" hidden>
							</div>
							<div>
								<label for="exampledate" class="form-label">Date</label> <input
									type="date" name="date" class="form-control" id="exampledate"
									value="<c:out value='${bill.date }' />">
							</div>

							<div>
								<label for="exampleStatus" class="form-label">Status</label> <select
									class="form-select" aria-label="bill status" name="status">
									<option selected value="<c:out value='${bill.status }' />"><c:out
											value='${bill.status eq "pending" ? "Pending 🕒" : "Done ✅"}' /></option>
									<c:if test="${bill.status == 'pending'}">
										<option value="done">Done ✅</option>
									</c:if>
									<c:if test="${bill.status == 'done'}">
										<option value="pending">Pending 🕒</option>
									</c:if>
								</select>
							</div>
							<div>
								<label for="exampleAmount" class="form-label">Amount</label>
								<div class="input-group mb-3">
									<span class="input-group-text">RM</span> <input type="text"
										name="amount" class="form-control" id="exampleAmount"
										value="<c:out value='${bill.amount }'/>">
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-success">Save bill</button>
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