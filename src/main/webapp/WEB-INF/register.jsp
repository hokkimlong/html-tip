<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	>

</head>
<body>

	<%-- 	<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	if (username != null && password != null) {
		User newUser = UserManager.register(username, password);
	}
	%>

	<%
	int totalAdmin = UserDao.getTotal();
	if (totalAdmin > 0) {
		response.sendRedirect("login.jsp");
	}
	%> --%>
	<jsp:include page="common/header.jsp"></jsp:include>


	<div class="container">

		<h2>Register for Admin only</h2>

		<div class="col-md-6 col-md-offset-3">

			<form method="post">

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
					value="register">Submit</button>

			</form>
		</div>
	</div>

	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>