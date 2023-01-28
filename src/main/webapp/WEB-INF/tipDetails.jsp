<%@page import="com.itstep.htmltip.model.Tip"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%
Tip tip = (Tip) request.getAttribute("tip");
%>
<title><%=tip.title%></title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>

	<jsp:include page="common/header.jsp"></jsp:include>


	<div class="container">


		<div class="overflow-auto">
			<div class="card w-85 mt-3">
				<div class="card">
					<div class="card-body">
						<h3 class="card-title"><%=tip.title%></h3>
						<h4 class="card-title"><%=tip.description%></h4>
						<h6 class="card-title">Tip example in HTML</h6>
						<p class="card-text">
							<c:out value="<%=tip.exampleHtmlEscape%>" escapeXml="true"></c:out>
						</p>

					</div>
				</div>

			</div>
		</div>


	</div>




	<jsp:include page="common/footer.jsp"></jsp:include>

</body>
</html>