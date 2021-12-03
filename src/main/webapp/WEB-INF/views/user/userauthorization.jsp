<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container page__heading-container">
	<div class="page__heading">
	    <div class="d-flex align-items-center">
			<div>
			    <nav aria-label="breadcrumb">
			        <ol class="breadcrumb mb-0">
			            <li class="breadcrumb-item"><a href="#">User</a></li>
			            <li class="breadcrumb-item active" aria-current="page">
			                User Authorization
			            </li>
			        </ol>
			    </nav>
			    <h1 class="m-0">User Authorization</h1>
			</div>
	        <div class="ml-auto">
	            <a href="" class="btn btn-light"><i class="material-icons icon-16pt text-muted mr-1">settings</i>
					Settings
				</a>
	        </div>
	    </div>
	 </div>
</div>

<div class="container page__container">
	<div class="row card-group-row">
	    <div class="col-lg-3 col-md-4 card-group-row__col">
	        <div class="card card-group-row__card card-shadow">
	            <div class="p-2 d-flex flex-row align-items-center">
	                <div class="avatar avatar-xs mr-2">
	                    <span class="avatar-title rounded-circle text-center bg-primary">
	                        <i class="material-icons text-white icon-18pt">
	                        person_add
	                        </i>
	                    </span>
	                </div>
	                <a href="/crm/user" class="text-dark">
	                    <strong>User List</strong>
	                </a>
	            </div>
	        </div>
	    </div>
	</div>
	
	<!-- Page Content -->
	<form action="" method="post">
	    <div class="form-group">
	        <label for="full_name">Full name:</label>
	        <input value="${ user.name }" name="user_name" class="form-control" type="text" id="full_name" required="" placeholder="Trần Cường">
	    </div>
	    
	    <div class="form-group">
	           <label for="role_select">Role</label>
	           <select name="user_role" id="role_select" data-toggle="select" class="form-control">
	           	<c:forEach var="role" items="${ roles }">
	           		<option <c:if test="${ user.role.name == role.name }">selected=""</c:if>>${ role.name }</option>
	               </c:forEach>
	           </select>
	      	</div>
	      	
	      	<div class="form-group">
	        <label for="email">Email:</label>
	        <input value="${ user.email }" name="user_email" class="form-control" type="email" id="email" required="" placeholder="ktc1311@gmail.com">
	    </div>
	      	
	    <div class="form-group">
	        <label for="phone">Phone:</label>
	        <input value="${ user.phone }" name="user_phone" class="form-control" type="text" id="phone" required="" placeholder="0xxxxxxxxx">
	    </div>
	    
	    <div class="form-group">
	        <label for="address">Address:</label>
	        <input value="${ user.address }" name="user_address" class="form-control" type="text" id="address" required="" placeholder="Quảng Ngãi">
	    </div>
	    
	    <div class="form-group text-center">
	        <button class="btn btn-primary" type="submit">Update</button>
	    </div>
	</form>
</div>