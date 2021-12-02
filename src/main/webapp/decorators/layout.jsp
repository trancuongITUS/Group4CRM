<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			<dec:title />
		</title>
		<jsp:include page="/WEB-INF/views/layout/header.jsp" />
		<dec:head />
	</head>
	<body class="layout-fixed">
	 	<div class="preloader"></div>
	 	
	 	<!-- Header Layout -->
    	<div class="mdk-header-layout js-mdk-header-layout">
    		<jsp:include page="/WEB-INF/views/layout/topbar.jsp" />
    		<div class="mdk-header-layout__content page">
	    		<jsp:include page="/WEB-INF/views/layout/navbar.jsp" />
	    		<dec:body />	
    		</div>
    	</div>
    	
		<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
		<dec:getProperty property="page.scripts"></dec:getProperty>

		<div id="modal-create-user" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
		        <div class="modal-dialog modal-dialog-centered">
		            <div class="modal-content">
		                <div class="modal-body">
		                    <div class="px-3">
		                        <div class="d-flex justify-content-center mt-2 mb-4 navbar-light">
		                            <a href="home" class="navbar-brand" style="min-width: 0">
		                            <img class="navbar-brand-icon" src="assets/images/logo.png" width="250" alt="Cybersoft">
		                        </a>
		                    </div>
		
		                    <form action="/crm/user/user-create" method="post">
		                        <div class="form-group">
		                            <label for="full_name">Full name:</label>
		                            <input name="user_name" class="form-control" type="text" id="full_name" required="" placeholder="Trần Cường">
		                        </div>
		                        
		                        <div class="form-group">
	                                <label for="role_select">Role</label>
	                                <select name="user_role" id="role_select" data-toggle="select" class="form-control">
	                                	<c:forEach var="role" items="${ roles }">
	                                		<option>${ role.name }</option>
	                                    </c:forEach>
	                                </select>
                            	</div>
                            	
                            	<div class="form-group">
		                            <label for="email">Email:</label>
		                            <input name="user_email" class="form-control" type="email" id="email" required="" placeholder="ktc1311@gmail.com">
		                        </div>
                            	
		                        <div class="form-group">
		                            <label for="password_2">Password:</label>
		                            <input name="user_pass" class="form-control" type="password" required="" id="password_2" placeholder="Enter your password">
		                        </div>
		                        
		                        <div class="form-group">
		                            <label for="phone">Phone:</label>
		                            <input name="user_phone" class="form-control" type="text" id="phone" required="" placeholder="0xxxxxxxxx">
		                        </div>
		                        
		                        <div class="form-group">
		                            <label for="address">Address:</label>
		                            <input name="user_address" class="form-control" type="text" id="address" required="" placeholder="Quảng Ngãi">
		                        </div>
		                        
		                        <div class="form-group text-center">
		                            <button class="btn btn-primary" type="submit">Create</button>
		                        </div>
		                    </form>
		                </div>
		            </div>
		            <!-- // END .modal-body -->
		        </div>
		        <!-- // END .modal-content -->
		    </div>
		    <!-- // END .modal-dialog -->
		</div>
		<!-- // END .modal -->
	</body>
</html>