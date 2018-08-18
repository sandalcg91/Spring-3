<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.jqueryui.min.css" />
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>

</head>
<body>
	<a style="align-self: flex-end;" href="logout.do">Logout</a>
	<form:form action="product.do" method="post" modelAttribute="prodMap">
		<pre>
 				<form:errors path="prodname" class="error" />
				Product name      : <form:input path="prodname" />
 				<form:errors path="proddesc" class="error" />
				Product Desc      : <form:input path="proddesc" />
 				<form:errors path="prodprice" class="error" />
				Product Price     : <form:input path="prodprice" />
				<form:errors path="prodqty" class="error" />
				Product Quantity  : <form:input path="prodqty" />
							 <input type="submit" value="Submit">
		</pre>
	</form:form>
	<hr>

	<table id="example" class="display" border="2" align="center">
		<thead>
			<tr>
				<td><B>Product Id</td>
				<td><B>Product Name</td>
				<td><B>Product Description</td>
				<td><B>Product Price</td>
				<td><B>Product Quantity</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${prodList}" var="prod">
				<tr>
					<td><c:out value="${prod.prodid}" /></td>
					<td><c:out value="${prod.prodname}" /></td>
					<td><c:out value="${prod.proddesc}" /></td>
					<td><c:out value="${prod.prodprice}" /></td>
					<td><c:out value="${prod.prodqty}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td><B>Product Id</td>
				<td><B>Product Name</td>
				<td><B>Product Description</td>
				<td><B>Product Price</td>
				<td><B>Product Quantity</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>