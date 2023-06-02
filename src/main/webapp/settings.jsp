<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
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
					<h5 style="margin: 0px;">Doc. Mirul</h5>
					<span style="color: #bfbfbf;">mirul@doc.email.com</span>
					<span  style="color: #bfbfbf;">Joined January 01, 2023</span>
				</div>
			</div>

			<div
				class="d-flex justify-content-center align-items-center mt-3 mb-3"
				style="width: 100%;">
				<button class="btn btn-primary col-8" type="button">Log out</button>
			</div>
			<hr class="hr-line">
			<div class="justify-content-center align-items-center p-3">
			<p style="text-align:center;">A Little About Me</p>
			<p style="font-size:10px;">Compassionate and systematic professional with 
			5 years of experience in pharmaceutical services. Highly proficient in carrying out doctor's prescriptions precisely to 
			prevent adverse drug interactions and ascertain effective treatments.</p>
			<p style="text-align:center;">Work Experience</p>
			<p style="font-size:12px; text-align:center;">Ultimate Hospital & Healthcare Services</p>
			<p style="font-size:8px; text-align:center;">01/2017-12/22</p>
			<p style="font-size:12px; text-align:center;">Doctorange Clinic</p>
			<p style="font-size:8px; text-align:center;">01/2023-Present</p>
		
			</div>	
			<hr style="margin-bottom: 0px !important;">
			<div class="d-flex justify-content-center align-items-center p-3">
				<p style="font-size: 14px; margin: 0px !important;">Doctorange @ copyright 2023</p>
			</div>
		</div>
		<div
			class="dashboard-con d-flex flex-column justify-content-left align-items-center offset-3 col-9">
			<div>
				<h4 style="text-align: left;">Profile</h4>
			</div>
			<form class="row g-3 d-flex flex-row justify-content-center">
			<div class="col-md-5">
    <label for="firstname" class="form-label">First Name</label>
    <input type="text" class="form-control" id="inputFirstName" value="Doc." readonly>
  </div><br>
  <div class="col-md-5">
    <label for="lastname" class="form-label">Last Name</label>
    <input type="text" class="form-control" id="inputLastName" value="Mirul" >
  </div>
  <div class="col-md-5">
    <label for="inputEmail4" class="form-label">Email</label>
    <input type="email" class="form-control" id="inputEmail4" value="mirul@doc.email.com" disabled="">
  </div>
   <div class="col-md-5">
    <label for="phonenumber" class="form-label">Phone Number</label>
    <input type="text" class="form-control" id="inputPhoneNumber" value="010-90909090">
  </div>
  <div class="col-md-5">
    <label for="inputNewPassword4" class="form-label">New Password</label>
    <input type="newpassword" class="form-control" id="inputNewPassword4" >
  </div>
   <div class="col-md-5">
    <label for="inputPassword4" class="form-label">Confirm Password</label>
    <input type="password" class="form-control" id="inputPassword4" >
  </div>
  <div class="col-md-5">
    <label for="" class="form-label">Address 1</label>
    <input type="text" class="form-control" id="inputAddress" value="48,Jalan Jasa Merdeka 48" >
  </div>
  <div class="col-5">
  <label for="" class="form-label">Address 2</label>
    <input type="text" class="form-control" id="inputAddress" value="">
  </div>
  <div class="col-md-5">
    <label for="inputState" class="form-label">State</label>
    <select id="inputState" class="form-select">
      <option selected>Melaka Tengah</option>
      <option>Alor Gajah</option>
      <option>Jasin</option>
    </select>
  </div>
  <div class="col-md-5">
    <label for="inputZip" class="form-label">Zip</label>
    <input type="text" class="form-control" id="inputZip" value="98909" >
  </div>
  
  <div class="btn-settings justify-content-center ">
    <button type="submit" class="btn btn-primary">Update Info</button>
  </div>
   <p style="text-align:center; font-size:10px;">Doctorange Clinic<br>48,Jalan Jasa Merdeka 48, Bukit Baru, 74676, Melaka.</p>
</form>
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