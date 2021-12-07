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
			                Project Employee
			            </li>
			        </ol>
			    </nav>
			    <h1 class="m-0">${ project.name }</h1>
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
	<!-- Page Content -->
	<form action="/crm/project/project-detail/project-tasks/create?project_id=${ project.id }" method="post">
	    <div class="form-group">
	        <label for="task_name">Name:</label>
	        <input name="task_name" class="form-control" type="text" id="task_name" required="" placeholder="CRUD">
	    </div>
	    
	    <div class="form-group">
	        <label for="task_description">Description:</label>
	        <input name="task_description" class="form-control" type="text" id="task_description" required="" placeholder="CRUD for Application">
	    </div>
	    
	    
	    <div class="form-group">
	        <label for="start_at">Start at:</label>
	        <input name="start_at" id="start_at" type="text" class="form-control" placeholder="Flatpickr example" data-toggle="flatpickr" value="today">
	    </div>
	      	
	    <div class="form-group">
            <label for="end_at">End at:</label>
            <input name="end_at" id="end_at" type="text" class="form-control" placeholder="Flatpickr example" data-toggle="flatpickr" value="today">
	    </div>
	    
	    <div class="form-group">
			<label for="assignee">Assignee:</label>
			<select name="assignee" id="assignee" data-toggle="select" class="form-control">
				<c:forEach var="employee" items="${ employees }">
					<option value="${ employee.email }">${ employee.name }</option>
				</c:forEach>
		    </select>
		</div>
	    
	    <div class="form-group">
			<label for="status">Status:</label>
			<select name="status" id="status" data-toggle="select" class="form-control">
				<c:forEach var="stt" items="${ status }">
					<option value="${ stt.id }">${ stt.name }</option>
				</c:forEach>
		    </select>
		</div>
	      	
	    <div class="form-group text-center">
	        <button class="btn btn-primary" type="submit">Create</button>
	    </div>
	</form>
</div>

