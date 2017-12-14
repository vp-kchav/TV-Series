<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script src="<c:url value="/resources/assets/imageAjax.js"/>"></script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script src="<c:url value="/resources/assets/ajax.js"/>"></script>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="body">

		<!-- banner -->
		<!-- banner -->
		<div class="container">
			<div class="properties-listing spacer">
				<form:form modelAttribute="searchDto" role="form"	action="searchMovie" method="POST">
					<div class="row">
						<div class="col-lg-3 col-sm-4 ">
							<div class="search-form">
								<h4>
									<span class="glyphicon glyphicon-search"></span> Search Movies
								</h4>
								<input type="text" name="textSearch" class="form-control" placeholder="Search your movies">
								<div class="row">
									<div class="col-lg-12">
										<select name="type" class="form-control">
											<option value="all">-- search type --</option>
											<option value="name">Name</option>
											<option value="genre">Genre</option>
											<option value="rate">Rate</option>
											<option value="artist">Name of Artist</option>
											<option value="director">Name of Director</option>
										</select>
									</div>
								</div>
								<button type="submit" id="searchBtnHomeList"
									class="btn btn-primary col-lg-4 col-sm-5">Find Now</button>
							</div>
							<!-- start of high rated movies-->
							<div class="hot-properties hidden-xs">
								<h4>Hot Movies</h4>
								<c:forEach var="property"
									items="${propertyListModel.hotPropertyList}">
									<div class="row">
										<div class="col-lg-4 col-sm-5">
											<img
												src="<c:url value="/uploadimage/${property.mainPicturePath}"/>"
												class="img-responsive img-circle" alt="properties">
										</div>
										<div class="col-lg-8 col-sm-7">
											<h5>
												<a href="<c:url value="/property?id=${property.id}"/>">${property.name}</a>
											</h5>
											<p class="price">
												Price:
												<fmt:formatNumber
													value="${property.purposeType.calculatePrice()}"
													type="currency" />
											</p>
										</div>
									</div>
								</c:forEach>
							</div>
							<!-- end of high rated movies -->
						</div>

						<div class="col-lg-9 col-sm-8">
							<div class="sortby clearfix">
								<c:set var="pagerCount" value="12" />
								<c:set var="startPageNum" value="1" />
								<c:set var="currentPage"	value="1" />
								<div class="pull-left result">
									Showing:
									<c:out value="${startPageNum} - ${currentPage}" />
									of
									<c:out value="1" />
								</div>
							</div>
							<div class="row" id="searchResult">
								<!-- start of listing movies-->
								<c:forEach var="movie"	 items="${listMovies}">
									<!-- properties -->
									<div class="col-lg-4 col-sm-6">
										<div class="properties">
<%-- 											<c:if test="${movie.getClass().simpleName == 'TVSeries'}"> --%>
<!-- 											<div class="image-holder"> -->
<%-- 												<img src="<c:url value="/resources/images/movie1.jpg"/>" --%>
<!-- 													class="img-responsive" alt="movies"> -->
<!-- 											</div> -->
<%-- 											</c:if> --%>
<%-- 											<c:if test="${movie.getClass().simpleName == 'Movie'}"> --%>
											<div class="image-holder">
												<img src="data:image/jpeg;base64,${movie.base64Image}"
													class="img-responsive" alt="movies">
											</div>
<%-- 											</c:if> --%>
											<p><strong>${movie.getClass().simpleName}</strong></p>
											<h4>
<%-- 												<a href="<c:url value="/property/propertyList?id=${property.id}"/>"></a> --%>
												${movie.name}
											</h4>
											<p> ${movie.descirption}</p>
											<p>	${movie.buildGeneresAsString()}</p>
											<p><em>Director:</em> ${movie.director.name} </p>
											<div class="listing-detail">
												<p>
													<img alt="ratting" src="<c:url value="/resources/images/star.jpg"/>" width="30" height="25">
													<strong>rating:</strong>
															<span data-toggle="tooltip" data-placement="bottom" 
															data-original-title="Ratting">${movie.rating}
														</span>
												</p>			
											</div>
											<c:if test="${movie.getClass().simpleName == 'TVSeries'}">
												<div class="listing-detail">
													<p><em>No of Seasons :</em> 
															<span data-toggle="tooltip" data-placement="bottom" 
															data-original-title="Seasons">${movie.seasons.size()} 
													</span>
													</p>
												</div>
											</c:if>
											<a class="btn btn-primary" href="<c:url value="/property/propertyList?id=${property.id}"/>">View Details</a>
										</div>
									</div>
									<!-- properties -->
								</c:forEach>
								<!-- end of MAIN PROPERTY -->

							</div>

							<div class="row">

								<!-- start of PAGER -->
								<div class="center">
									<input type="hidden" name="currentPage" id="currentPageId"
										value="${propertyListModel.currentPage}">
									<ul class="pagination">
										<li><a href="#"
											onclick="changePage(${propertyListModel.currentPage - 1})">«</a></li>
										<c:choose>
											<c:when
												test="${propertyListModel.totalItemCount % pagerCount == 0}">
												<c:set var="totalPageCount"
													value="${propertyListModel.totalItemCount/pagerCount}" />
											</c:when>
											<c:otherwise>
												<c:set var="totalPageCount"
													value="${propertyListModel.totalItemCount/pagerCount+1}" />
											</c:otherwise>
										</c:choose>
										<c:forEach var="pageNum" begin="1" end="${totalPageCount}">
											<c:choose>
												<c:when test="${pageNum == propertyListModel.currentPage}">
													<li class="active"><a href="#"
														onclick="changePage(${pageNum})">${pageNum}</a></li>
												</c:when>
												<c:otherwise>
													<li><a href="#" onclick="changePage(${pageNum})">$pageNum</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<li><a href="#"
											onclick="changePage(${propertyListModel.currentPage + 1})">»</a></li>
									</ul>
								</div>
								<!-- end of PAGER -->
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
</html>