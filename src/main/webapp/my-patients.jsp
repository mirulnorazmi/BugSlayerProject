<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Patients</title>
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
					<h5 style="margin: 0px;">Doc. Mirul</h5>
					<span style="color: #bfbfbf;">mirul@doc.email.com</span>
				</div>
			</div>
			<div
				class="d-flex justify-content-center align-items-center mt-3 mb-3"
				style="width: 100%;">
				<button class="btn btn-primary col-8" type="button">Log out</button>
			</div>
			<hr class="hr-line">
			<ul class="nav nav-underline flex-column mb-auto"
				style="padding-left: 40px;">
				<li><a href="/loginServlet"
					class="nav-link text-black d-flex justify-content-start"
					aria-current="page"><span class="material-symbols-outlined"
						style="margin-right: 20px;"> dashboard </span> Dashboard </a></li>
				<li class="nav-item"><a href="#"
					class="nav-link text-black d-flex justify-content-start">
						<span class="material-symbols-outlined"
						style="margin-right: 20px;"> event </span>My Appointments
				</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link active text-black d-flex justify-content-start"><span
						class="material-symbols-outlined" style="margin-right: 20px;">
							patient_list </span> My Patients</a></li>
				<li class="nav-item"><a href="#"
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
				<h4 style="text-align: left;">My Patients</h4>
				<div class="input-group mb-3 mt-4" style="height: 40px;">
					<input type="text" class="form-control"
						placeholder="Enter Patient Name" aria-label="Patient Name"
						aria-describedby="button-addon2">
					<button class="btn btn-outline-danger me-2" type="button">Search</button>
				</div>
				<div class="alert alert-info" role="alert">Click on the row to
					update and delete the patient details</div>
				<div class="d-flex flex-row m-2">
					<div class="form-check form-switch">
						<input class="form-check-input" type="checkbox" role="switch"
							id="flexSwitchCheckDefault" checked> <label
							class="form-check-label" for="flexSwitchCheckDefault">sort a-z</label>
					</div>
					<div class="form-check form-switch" style="margin-left: 10px;">
						<input class="form-check-input" type="checkbox" role="switch"
							id="flexSwitchCheckDefault"> <label
							class="form-check-label" for="flexSwitchCheckDefault">all patients</label>
					</div>
				</div>
			</div>
			<div class="table-responsive container-fluid" id="infinite-table">
				<table class="table table-hover align-middle">
					<thead class="header">
						<tr>
							<th scope="col"></th>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Phone</th>
							<th scope="col">Address</th>
							<!-- 				<th></th> -->
							<!-- <th></th> -->
						</tr>
					</thead>
					<tbody>
						<%
						String[][] patients = {{"Anwar Dollah", "anwardollah@gmail.com", "019-9823721", "A-0-12 Perumahan Awam, Bukit Jalil, 57000, Kuala Lumpur"},
								{"Aqilah Wahid", "qilalala@gmail.com", "014-4322211", "B-12-01 Perumahan Awam, Bukit Jalil, 57000, Kuala Lumpur"},
								{"Ghaffar Ali", "ghafferally@gmail.com", "012-1223322", "P2 Jalan Makmur, Ampang, 53100, Kuala Lumpur"},
								{"Jason Laravel", "jasonlaravel@gmail.com", "017-9853556", "K9 Jalan 3, Ampang, 53300, Kuala Lumpur"},
								{"Kamariah Jumaat", "cammyjumaat@gmail.com", "011-13221122", "No.3 Jalan Damai 2/9c, Cheras, 43200, Selangor"},
								{"Kelvin Kumar", "kelvinkumar@ymail.com", "016-888765", "No. 9 Jalan Suasa 2/6b, Bangi, 43000, Selangor"},
								{"Khalid Mydin", "KhalidMy@hotmail.com", "013-3321227", "L-0-9 Bandar Putra, Bangi, 43000, Selangor"},
								{"Lee Ah Teh", "ahtehlee@gmail.com", "018-9081128", "No. 10 Jalan Suasa 2/5a, Cheras, 43200, Selangor"},
								{"Munir Ahmad", "muniramat@yahoo.com", "012-2233355", "Blok F-1-10 Pangsapuri Permai, Sungai Besi, 57000, Kuala Lumpur"}};

						for (int i = 0; i < patients.length; i++) {
							int j = 0;
						%>
						<tr key="<%=i + 1%>" onclick="myFunction(<%=i + 1%>)">
							<th scope="row" style="color: #FF4E5B !important;"><%=i + 1%></th>
							<td><%=patients[i][j]%></td>
							<td><%=patients[i][j + 1]%></td>
							<td><%=patients[i][j + 2]%></td>
							<td><%=patients[i][j + 3]%></td>
							
							<!-- <td><button type="button" class="btn">
									<i class="bi bi-pencil-square"></i>
								</button></td> -->
							<!-- <td><button type="button" class="btn" style="z-index: 20;">
									<i class="bi bi-trash3-fill"></i>
								</button></td> -->
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<!-- Script section -->
	<!-- <script src="js/script.js"></script> -->
	<script>
		function myFunction(x) {
			alert("Row index is: " + x);
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