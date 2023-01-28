<%@page import="java.util.ArrayList"%>
<%@page import="com.itstep.htmltip.model.Tip"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>HTML Tips</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	<jsp:include page="common/header.jsp"></jsp:include>
	<div class="container">
		<div class="row">

			<%
			List<Tip> tips = (ArrayList)request.getAttribute("tips");
			%>

			<%
			for (Tip tip : tips) {
			%>
			<div class="col-sm-3 mt-3">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title"><%=tip.title%></h5>
						<p class="card-text"><%=tip.description%></p>
						<a href="<%=request.getContextPath()%>/tips/<%=tip.id %>"
							class="btn btn-primary">Details</a>
					</div>
				</div>
			</div>
			<%
			}
			%>

		</div>
	</div>

	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>