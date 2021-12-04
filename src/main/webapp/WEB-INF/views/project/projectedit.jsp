<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container page__heading-container">
	<div class="page__heading">
	    <div class="d-flex align-items-center">
			<div>
			    <nav aria-label="breadcrumb">
			        <ol class="breadcrumb mb-0">
			            <li class="breadcrumb-item"><a href="#">Project</a></li>
			            <li class="breadcrumb-item active" aria-current="page">
			                Project Edit
			            </li>
			        </ol>
			    </nav>
			    <h1 class="m-0">Project Edit</h1>
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
	                        add_alert
	                        </i>
	                    </span>
	                </div>
	                <a href="/crm/project/project-create" class="text-dark">
	                    <strong>Create New Project</strong>
	                </a>
	            </div>
	        </div>
	    </div>
	</div>
	
	<!-- Page Content -->
	<form action="" method="post">
	    <div class="form-group">
	        <label for="project_name">Name:</label>
	        <input value="${ project.name }" name="project_name" class="form-control" type="text" id="project_name" required="" placeholder="CRM">
	    </div>
	    
	    <div class="form-group">
	        <label for="project_description">Description:</label>
	        <input value="${ project.description }" name="project_description" class="form-control" type="text" id="project_description" required="" placeholder="CRM Appication using Servlet Java14">
	    </div>
	    
	    
	    <div class="form-group">
	        <label for="start_at">Start at:</label>
	        <input value="${ project.start }" name="start_at" id="start_at" type="text" class="form-control" placeholder="Flatpickr example" data-toggle="flatpickr" value="today">
	    </div>
	      	
	    <div class="form-group">
            <label for="end_at">End at:</label>
            <input value="${ project.end }" name="end_at" id="end_at" type="text" class="form-control" placeholder="Flatpickr example" data-toggle="flatpickr" value="today">
	    </div>
	    
	    <div class="form-group">
			<label for="created">Created by:</label>
			<select name="created" id="created" data-toggle="select" class="form-control">
				<c:forEach var="user" items="${ users }">
					<option value="${ user.id }" <c:if test="${ project.created.email == user.email }">selected=""</c:if>>${ user.name } - ${ user.role.name }</option>
				</c:forEach>
		    </select>
		</div>
	      	
	    <div class="form-group text-center">
	        <button class="btn btn-primary" type="submit">Update</button>
	    </div>
	</form>
</div>