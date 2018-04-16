<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>etnShop</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
<body>

<h3>Product detail</h3>
		
	<div>
		<form:form action="saveProduct" modelAttribute="product" method="POST">
			<!-- NECESSARY! otherwise it creates new product - not to loose context -->
			<form:hidden path="id" />
		
			<table>
				<tbody>
				<tr>
					<td><label>Name:</label></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><label>Serial Number:</label></td>
					<td><form:input path="serialNo" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"></td>
				</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/product/list">Back to list</a>
		</p>
	</div>

</body>
</html>