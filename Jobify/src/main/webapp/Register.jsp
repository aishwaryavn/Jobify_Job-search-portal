<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Jobify</title>

<!-- Font Icon -->
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> &ensp; &ensp; JOBIFY</a>
		</div>
	</nav>

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-image">
						<img src="https://t3.ftcdn.net/jpg/04/51/83/22/360_F_451832202_e1QKPBz6HJm25BlNZwi0OT1404WGMs1i.jpg"
							style="border-radius: 20%; width: 100%;" alt="sing up image">
						<img src="images/signup.png" width="100%" alt="sing up image">
					</div>
					<div style="margin-left: 40px; border-left: 1px dotted #5f656d; /* Border on the left */ width: 1px;"></div>
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
						<h2>${saved}</h2>
						<h3>${accExists }</h3>
						<form action="save" method="POST" class="register-form" id="register-form">
							<div class="form-group">
								<label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label> 
								<input type="text" name="name" id="name" placeholder="Your Name" />
								<p style="color:Tomato;">${nameInvalid}</p>
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> 
								<input type="email" name="email" id="email" placeholder="Your Email" />
								<p style="color:Tomato;">${emailInvalid}</p>
                        		<p style="color:Tomato;">${emailExists}</p>
								<!-- <h3>${accExists }</h3> -->
							</div>
							<div class="form-group">
								<label for="Mobile"><i class="zmdi zmdi-account material-icons-name"></i></label> 
								<input type="tel" name="mobile" id="mobile" placeholder="Mobile Number" />
								<p style="color:Tomato;">${mobileInvalid}</p>
							</div>

							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> 
								<input type="password" name="password" id="pass" placeholder="Password" />
								<p style="color:Tomato;">${passwordInvalid}</p>
							</div>

							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="confirmPass" id="re_pass" placeholder="Repeat your password" />
								<p style="color:Tomato;">${confirmPasswordInvalid}</p>
							</div>

							<div class="form-group">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="account" id="inlineRadio1" value="JobSeeker">Job Seeker
								</div>

								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="account" id="inlineRadio2" value="JobProvider">Job Provider
								</div>
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I agree all statements in 
									<a href="#" class="term-service">Terms of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup" class="form-submit" value="Register" />
							</div>
							<div class="form-group">
                        		<!-- <input type="" id="sigin" name="sigin"> -->
                        		<label for="signin">Already have an account? <a href="Signin.jsp">Sign in</a></label>
                    		</div>
						</form>
					</div>

				</div>
			</div>

		</section>
	</div>
	<br>
	<footer>
		<div class="text-center">
			<p>Copyright &copy; 2023 All rights reserved</p>
		</div>
	</footer>

</body>
</html>