
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--   -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>

    <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
 
</head>
<body style="background-color:powderblue;">
<nav class="navbar " style="background-color:#56f7a1;margin-left:0;left:0;">
  <div class="container-fluid">
    <div class="navbar-header"  style="background-color:#ffab1c;width:180px;margin-left:0">
      <a class="navbar-brand" href="#">Dubai Shopieee</a>
    </div>
    <ul class="nav navbar-nav" >
      <li class="active"><a href="<c:url value='/'></c:url>">Home</a></li>
      <li class="active"><a href="<c:url value='/all/getallproducts'></c:url>">Browse All Products</a></li>
      
<!--          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="Product">Products by Category <span class="caret"></span></a>  -->
<!--          <ul class="dropdown-menu" style="background-color:#25e8ce;">  -->
<%--           <li><a href="<c:url value='/Product#menPage'></c:url>">Men</a></li> --%>
<%--           <li><a href="<c:url value='/Product#womenPage'></c:url>">Women</a></li> --%>
<!--            <li><a href="#">Kids</a></li>  -->
<!--          </ul>  -->
<!--   </li>  -->

      <li><a href="<c:url value='/AboutUs'></c:url>">About us</a></li>
      <li><a href="<c:url value='/ContactUs'></c:url>">Contact us</a></li>
      
       <security:authorize access="hasRole('ROLE_ADMIN')">
       <li><a href="<c:url value='/admin/getproductform'></c:url>">Add Product</a></li>
       </security:authorize>
       
       <li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Select By Category<span class="caret"></span></a>
					
				<ul class="dropdown-menu">
				<c:forEach items="${categories }" var="category">
				<li><a href="<c:url value='/all/searchByCategory?searchCondition=${category.categoryName }'></c:url>">${category.categoryName }</a>
				</li>
				
				</c:forEach>
				<li>
				<a href="<c:url value='/all/searchByCategory?searchCondition=All'></c:url>">All</a>
				</li>
				</ul>
			   </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     
			    <security:authorize access="hasRole('ROLE_USER')">
			   <li><a href="<c:url value='/cart/getcart'></c:url>"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
			   </security:authorize>
			   
			   <c:if test="${pageContext.request.userPrincipal.name==null }">
      <li><a href="<c:url value='/all/registrationform'></c:url>"><span class="glyphicon glyphicon-user"></span> Register</a></li>
      <li><a href="<c:url value='/Login'></c:url>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      
				
				<c:if test="${pageContext.request.userPrincipal.name!=null }">
				<li><a href="#">Welcome ${pageContext.request.userPrincipal.name }</a></li>
				<li><a href="<c:url value='/j_spring_security_logout'></c:url>">Sign out</a></li>
			    </c:if>
    </ul>
  </div>
</nav>
<!--  
<div class="sidebar">
  <a class="active" href="#">Home</a>
  <a href="#">New</a>
  <a href="#">Contact</a>
  <a href="#">About</a>
</div>
-->
  



</body>
</html>