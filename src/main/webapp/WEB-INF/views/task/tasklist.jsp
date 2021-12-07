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
			                Task List
			            </li>
			        </ol>
			    </nav>
			    <h1 class="m-0">Task List</h1>
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
	                <a href="/crm/task/task-create" class="text-dark">
	                    <strong>Create New Task</strong>
	                </a>
	            </div>
	        </div>
	    </div>
	    <div class="col-lg-3 col-md-4 card-group-row__col">
	        <div class="card card-group-row__card card-shadow">
	            <div class="p-2 d-flex flex-row align-items-center">
	                <div class="avatar avatar-xs mr-2">
	                    <span class="avatar-title rounded-circle text-center">
	                        <i class="material-icons text-white icon-18pt">
	                        clear
	                        </i>
	                    </span>
	                </div>
	                <button type="submit" class="btn btn-light text-dark border border-light" form="delete-form">
	                	<strong>Delete Task</strong>
	                </button>
	            </div>
	        </div>
	    </div>
	    
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
	                <a href="#" class="text-dark" data-toggle="modal" data-target="#modal-task-status" >
	                    <strong>Change Progress</strong>
	                </a>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- Page Content -->
	<div class="card card-form">
	    <div class="row no-gutters">
	        <div class="card-form__body">
	            <div class="table-responsive border-bottom" data-toggle="lists"
	                data-lists-values='["js-lists-values-employee-name"]'>
					 <form action="/crm/task/task-delete" method="post" id="delete-form">
						<table class="table mb-0 thead-border-top-0">
		                    <thead>
		                        <tr>
		                            <th style="width: 8px;">
		                                <div class="custom-control custom-checkbox">
		                                    <input type="checkbox"
		                                        class="custom-control-input js-toggle-check-all"
		                                        data-target="#staff" id="customCheckAll">
		                                    <label class="custom-control-label" for="customCheckAll"><span
		                                            class="text-hide">Toggle all</span></label>
		                                </div>
		                            </th>
		
		                            <th style="width: 120px;">Name</th>
		                            <th style="width: 200px;">Description</th>
		                            <th style="width: 140px;">Start</th>
		                            <th style="width: 140px;">End</th>
		                            <th style="width: 150px;">Assignee</th>
		                            <th style="width: 150px;">Project</th>
		                            <th style="width: 40px;">Status</th>
		                        </tr>
		                    </thead>
		                    <tbody class="list" id="staff">
		                    	<c:forEach var="task" items="${ tasks }">
			                    	<tr>
										<td>
											<div class="custom-control custom-checkbox">
												<input name="chkSelected" value="${ task.id }" type="checkbox"
												class="custom-control-input js-check-selected-row"
												id="${ task.id }">
												<label class="custom-control-label" for="${ task.id }"><span
												            class="text-hide">Check</span></label>
											</div>
										</td>
			
			                            <td>
			                                <div class="media align-items-center">
			                                    <div class="media-body">
			                                        <span class="js-lists-values-employee-name">${ task.name }</span>
			                                    </div>
			                                </div>
			                            </td>
			                            <td><small class="text-muted">${ task.description }</small></td>
			                            <td>${ task.start }</td>
			                            <td>${ task.end }</td>
			                            <td>${ task.assignee.name }</td>
			                            <td>${ task.project.name }</td>
			                            <td>
			                            	<c:choose>
			                            		<c:when test="${ task.status.id == 1}"><span class="badge badge-warning" style="text-transform: uppercase;">${ task.status.name }</span></c:when>
			                            		<c:when test="${ task.status.id == 2}"><span class="badge badge-primary" style="text-transform: uppercase;">${ task.status.name }</span></c:when>
			                            		<c:otherwise><span class="badge badge-success" style="text-transform: uppercase;">${ task.status.name }</span></c:otherwise>
			                            	</c:choose>
			                            </td>
			                        </tr>
		                        </c:forEach>
		                    </tbody>
		                </table>
					</form>
	            </div>
	        </div>
	    </div>
	</div> <!-- href="project/project-edit?id=${ project.id }" -->
</div> <!-- href="user/user-authorization?email=${ user.email }" -->