<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container page__heading-container">
	<div class="page__heading">
	    <div class="d-flex align-items-center">
			<div>
			    <nav aria-label="breadcrumb">
			        <ol class="breadcrumb mb-0">
			            <li class="breadcrumb-item"><a href="#">Task</a></li>
			            <li class="breadcrumb-item active" aria-current="page">
			                Task Create
			            </li>
			        </ol>
			    </nav>
			    <h1 class="m-0">Task Create</h1>
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
	                <a href="/crm/task/task-list" class="text-dark">
	                    <strong>Task List</strong>
	                </a>
	            </div>
	        </div>
	    </div>
	</div>
	
	<!-- Page Content -->
	<form action="/crm/task/task-create" method="post">
	    <div class="form-group">
	        <label for="task_name">Name:</label>
	        <input name="task_name" class="form-control" type="text" id="task_name" required="" placeholder="CRM">
	    </div>
	    
	    <div class="form-group">
	        <label for="task_description">Description:</label>
	        <input name="task_description" class="form-control" type="text" id="task_description" required="" placeholder="CRM Appication using Servlet Java14">
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
			<label for="project">Project:</label>
			<select name="project" id="project" data-toggle="select" class="form-control">
				<c:forEach var="project" items="${ projects }">
					<option value="${ project.id }">${ project.name }</option>
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

