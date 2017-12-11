<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true" %>

		<div class="navbar-inverse" role="navigation">
			<div class="container">
				<div class="navbar-header">

					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only"><spring:message code="menu.toggle" text="Toggle navigation"/></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>

				<!-- Nav Starts -->
				<div class="navbar-collapse  collapse">
					<ul id="mainMenu" class="nav navbar-nav navbar-right">
						<li>
						<section>
							<div class="pull-right" style="padding-right:50px">
								<a href="?language=en">English</a>|<a href="?language=kh">ខ្មែរ</a>
							</div>
						</section>
						</li>
						<li><a href="<c:url value="/index"/>"><spring:message code="menu.home" text="Home"/></a></li>
						<c:choose>
							<c:when test="${sessionScope.currentUser != null}">
								<li>
								<span>${sessionScope.currentUser.username}</span>
								</li>
								<li>
									<a href="<c:url value="/logout"/>"><spring:message code="menu.logout" text="Log Out"/></a>
								</li>
							</c:when>
							<c:otherwise>
								<li><a href="login"><spring:message code="menu.login" text="Log In"/></a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				<!-- #Nav Ends -->

			</div>
		</div>
