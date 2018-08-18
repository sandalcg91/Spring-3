<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<style type="text/css">

.error{ color: red;}
.tab{color: blue; column-span: 2;
}
</style>

<title>Insert title here</title>
</head>
<body>
	<form:form action="registration.do" method="post" modelAttribute="userMap" >
		<table class="tab" border="2" cellpadding="2" cellspacing="2" align="center" width="100%" height="100%">
			<tr>
			<td colspan="2"><spring:message code="label.lang"/> : <a href="?language=en">English</a>|<a href="?language=hi">Hindi</a>|<a href="?language=ch">Chinese</a></td>
			</tr>
			<tr>
				<td><spring:message code="label.fn"/></td>
				<td><form:input path="firstname"/></td>
				<td><form:errors path="firstname" class="error"/></td>
			</tr>
			<tr>
				<td><spring:message code="label.ln"/></td>
				<td><form:input path="lastname"/></td>
				<td><form:errors path="lastname" class="error"/></td>
			</tr>
			<tr>
				<td><spring:message code="label.em"/></td>
				<td><form:input path="email"/></td>
				<td><form:errors path="email" class="error"/></td>
			</tr>
			<tr>
				<td><spring:message code="label.pw"/></td>
				<td><form:password path="password"/></td>
				<td><form:errors path="password" class="error"/></td>
			</tr>
			<tr>
				<td><spring:message code="label.mn"/></td>
				<td><form:input path="mobileNo"/></td>
				<td><form:errors path="mobileNo" class="error"/></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>