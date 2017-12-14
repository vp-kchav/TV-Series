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
			<span class="pull-right"><a href="home">Home</a> / Add Movie</span>
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
					<form:form modelAttribute="newMovie" action="saveMovie" method="POST"  enctype="multipart/form-data">
					<div class="form-group row">
							<div class="col-lg-12">
								<spring:message code="form.movie.name"   text="Name :" var="name"/> 
								<form:input class="form-control" path="name"  placeholder="${name}"/> 
								<form:errors path="name"/>
							</div>
							<div class="col-lg-12">
								<spring:message code="form.movie.descirption"  text="Descirption:" var="descirption"/> 
								<form:input class="form-control" path="descirption"  placeholder="${descirption}" />
								<form:errors path="descirption"/>
							</div>
							<div class="col-lg-12">
								<spring:message code="form.movie.rating"  text="Rating:" var="rating"/> 
								<form:input class="form-control" path="rating"  placeholder="${rating}" />
								<form:errors path="rating"/>
							</div>
							<div class="col-lg-12">
								<form:select  class="form-control" items="${directors}" path="director.id" itemLabel="name" itemValue="id"/>
							</div>
							<div class="form-group row" id="addImg">
								<div class="col-lg-12">
									<form:input id="addImg" path="image" type="file" required="required" />
								</div>
							</div>
						<button type="submit" class="btn btn-success" name="Submit"><spring:message code="form.movie.add" text="Add Movie"/></button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>