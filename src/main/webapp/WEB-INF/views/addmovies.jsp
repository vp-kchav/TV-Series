<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="body">
	
	<div class="inside-banner">
		<div class="container">
			<span class="pull-right"><a href="/home">Home</a> / Add Movie</span>
			<h2><spring:message code="add.new.movie" text="Add New Movies"/></h2>
		</div>
	</div>
	<!-- banner -->
	<div class="container">
		<div class="spacer">
			<div class="row register">
				<div class="col-lg-6 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-12 ">
					<%-- <c:if test="${not empty msg}">
						<div class="alert alert-danger alert-dismissable">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>${msg}
						</div>
					</c:if> --%>
					<form:form modelAttribute="newMovie" action="/saveMovie" method="POST">
					<div class="form-group row">
							<div class="col-lg-6">
								<spring:message code="form.movie.name"   text="Name :" var="name"/> 
								<form:input class="form-control" path="name"  placeholder="${name}"/> 
								<form:errors path="name"/>
							</div>
							<div class="col-lg-6">
								<spring:message code="form.movie.descirption"  text="Descirption:" var="descirption"/> 
								<form:input class="form-control" path="descirption"  placeholder="${descirption}" />
								<form:errors path="descirption"/>
							</div>
							<div class="col-lg-6">
								<spring:message code="form.movie.rating"  text="Rating:" var="rating"/> 
								<form:input class="form-control" path="rating"  placeholder="${rating}" />
								<form:errors path="descirption"/>
							</div>
						</div>
<!-- 						<div class="form-group"> -->
<%-- 							<form:select  class="form-control" items="${roles}" path="role.id" itemLabel="roleName" itemValue="id"/> --%>
<!-- 						</div> -->
						
<!-- 						<div class="form-group"> -->
<%-- 							<spring:message code="user.email" text="Email:" var="email"/>  --%>
<%-- 							<form:input  class="form-control" placeholder="${email}"  path="email" /> --%>
<%-- 							<form:errors path="email"/> --%>
<!-- 						</div> -->
						
<!-- 						<div class="form-group"> -->
<%-- 							<spring:message code="user.password" text="Password:" var="password"/> --%>
<%-- 							<form:input type="password"  class="form-control" placeholder="${password}" path="password"/> --%>
<%-- 							<form:errors path="password"/> --%>
<!-- 						</div> -->
						
<!-- 						<div class="form-group"> -->
<%-- 							<spring:message code="user.mobile" text="Mobile:" var="mobile"/> --%>
<%-- 							<form:input class="form-control" placeholder="${mobile}" path="mobile" /> --%>
<%-- 							<form:errors path="mobile"/> --%>
<!-- 						</div> -->
						
						<%-- <div class="form-group">
							<form:input type="password" class="form-control" placeholder="Confirm Password" path="confirm_password"
								required="required"/>
						</div> --%>
						
<!-- 						<div class="form-group"> -->
<%-- 							<spring:message code="address.street" text="Street:" var="street"/> --%>
<%-- 							<form:input class="form-control"  placeholder="${street}" path="address.street"/> --%>
<%-- 							<form:errors path="address.street"/> --%>
<!-- 						</div> -->
<!-- 						<div class="form-group"> -->
<%-- 							<spring:message code="address.city" text="City:" var="city"/> --%>
<%-- 							<form:input  class="form-control"  placeholder="${city}" path="address.city"/> --%>
<%-- 							<form:errors path="address.city"/> --%>
<!-- 						</div> -->
<!-- 						<div class="form-group"> -->
<%-- 							<spring:message code="address.state" text="State:" var="state"/> --%>
<%-- 							<form:input  class="form-control" placeholder="${state}" path="address.state"/> --%>
<%-- 							<form:errors path="address.state"/> --%>
<!-- 						</div> -->
<!-- 							<div class="form-group"> -->
<%-- 							<spring:message code="address.zipcode" text="Zipcode:" var="zipcode"/> --%>
<%-- 							<form:input class="form-control"  placeholder="${zipcode}" path="address.zipcode"/> --%>
<%-- 							<form:errors path="address.zipcode"/> --%>
<!-- 						</div> -->
						<button type="submit" class="btn btn-success" name="Submit"><spring:message code="form.movie.add" text="Add Movie"/></button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>