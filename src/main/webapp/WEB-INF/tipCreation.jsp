<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tip creation</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	>

</head>
<body>

	<jsp:include page="common/header.jsp"></jsp:include>


	<div class="container">

		<h2>Tip creation</h2>

		<div class="col-md-6 col-md-offset-3">

			<form  method="post">

				<div class="form-group">
					<label for="title">Title:</label> <input type="text"
						class="form-control" id="title" placeholder="Title" name="title"
						required>
				</div>

				<div class="form-group">
					<label for="description">Description:</label> <input type="text"
						class="form-control" id="description" placeholder="Description"
						name="description" required>
				</div>

				<div class="form-group">
					<label for="exampleHtmlEscape">Example:</label>
					<textarea class="form-control" id="exampleHtmlEscape" rows="3"
						placeholder="Example HTML" name="exampleHtmlEscape" required></textarea>
				</div>


				<button type="submit" class="btn btn-primary" name="action" value="create">Submit</button>

			</form>
		</div>
		
	</div>




	<jsp:include page="common/footer.jsp"></jsp:include>

</body>
</html>