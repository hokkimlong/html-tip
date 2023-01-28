<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Login</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>

	<jsp:include page="common/header.jsp"></jsp:include>


	<div class="container">

		<h2>Login for Admin only</h2>

		<div class="col-md-6 col-md-offset-3">



			<form action="admin" method="post">

				<%
				if (request.getParameter("action") != null && request.getParameter("action").equals("login")) {
				%>

				<div class="alert alert-danger" role="alert">Wrong username or
					password</div>

				<%
				}
				%>


				<div class="form-group">
					<label for="uname">User Name:</label> <input type="text"
						class="form-control" id="username" placeholder="User Name"
						name="username" required>
				</div>

				<div class="form-group">
					<label for="uname">Password:</label> <input type="password"
						class="form-control" id="password" placeholder="Password"
						name="password" required>
				</div>

				<button type="submit" class="btn btn-primary" name="action"
					value="login">Submit</button>

			</form>
		</div>
	</div>




	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>