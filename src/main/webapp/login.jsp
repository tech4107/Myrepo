<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel="icon" href="/images/logo.gif">
          <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
        <link href="bootstrap.min.js" />
</head>
<body>
	<div class="centraprise-logo">
                    <img src="/images/logo.gif" /><br>
                </div>
	<center>
		<c:if test="${not empty error}">
      user name or password are invalid
	</c:if>
		<form action="${pageContext.request.contextPath}/login"
			method="post">
			UserName:<input class="form-control" type="text" name="username"><br />
			Password:<input class="form-control" type="text" name="password"><br /> <input
				type="submit" value="login">
		</form>
	</center>
</body>
</html>
