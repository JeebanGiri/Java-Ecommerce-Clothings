<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
form {
	max-width: 600px;
	margin: 0 auto;
}

h2 {
	text-align: center;
}

.form-group {
	margin-bottom: 20px;
}

label {
	display: block;
	margin-bottom: 5px;
}

input[type="text"], input[type="email"], input[type="password"],
	textarea {
	width: 100%;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
	font-size: 16px;
}

input[type="tel"] {
	width: 100%;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
	font-size: 16px;
}

button[type="submit"] {
	display: block;
	margin: 0 auto;
	padding: 10px 20px;
	background-color: #008CBA;
	color: #fff;
	border-radius: 5px;
	border: none;
	font-size: 16px;
	cursor: pointer;
}

p {
	text-align: center;
}

a {
	color: #008CBA;
}
</style>
</head>
<body>
	<form action="../register" method="post" enctype="multipart/form-data">
		<h2>Register</h2>
		<div class="form-group">
			<label for="user-image">User Image</label> <input type="file"
				id="user-image" name="user-image">
		</div>
		<div class="form-group">
			<label for="name">Name</label> <input type="text" id="name"
				name="name" required>
		</div>
		<div class="form-group">
			<label for="phone">Phone</label> <input type="tel" id="phone"
				name="phone" pattern="[0-9]{10}" required>
		</div>
		<div class="form-group">
			<label for="email">Email</label> <input type="email" id="email"
				name="email" required>
		</div>
		<div class="form-group">
			<label for="address">Address</label> <input type="text" id="address"
				name="address" required>
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				id="password" name="password" required>
		</div>
		<button type="submit">Register</button>
		<p>
			Have an account? <a href="#">Sign in</a>
		</p>
	</form>

</body>
</html>