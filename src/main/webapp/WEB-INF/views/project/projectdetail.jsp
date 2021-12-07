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
			                Project Detail
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
	<div style="border-bottom: 1px solid rgba(147, 159, 173, 0.3); margin-bottom: 15px">
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
		                <a href="#" class="text-dark" data-toggle="modal" data-target="#modal-add-employee" >
		                    <strong>Add employee</strong>
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
		                <button type="submit" class="btn btn-light text-dark border border-light" form="delete-form-emp">
		                	<strong>Delete employee</strong>
		                </button>
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
						 <form action="/crm/project/project-detail/project-employees/delete?project_id=${ project.id }" method="post" id="delete-form-emp"> <!-- Sửa đường dẫn, thêm hai nút -->
							<table class="table mb-0 thead-border-top-0">
			                    <thead>
			                        <tr>
			                            <th style="width: 12px;">
			                                <div class="custom-control custom-checkbox">
			                                    <input type="checkbox"
			                                        class="custom-control-input js-toggle-check-all"
			                                        data-target="#staff" id="customCheckAll">
			                                    <label class="custom-control-label" for="customCheckAll"><span
			                                            class="text-hide">Toggle all</span></label>
			                                </div>
			                            </th>
			
			                            <th style="width: 220px;">Employee</th>
			                            <th style="width: 50px;">Role</th>
			                            <th style="width: 250px;">Email</th>
			                            <th style="width: 150px;">Phone</th>
			                            <th style="width: 200px;">Address</th>
			                        </tr>
			                    </thead>
			                    <tbody class="list" id="staff">
			                    	<c:forEach var="employee" items="${ employees }">
				                    	<tr>
				                            <td>
		                                       <div class="custom-control custom-checkbox">
		                                           <input name="chkSelected" value="${ employee.id }" type="checkbox"
		                                               class="custom-control-input js-check-selected-row"
		                                               id="${ employee.id }">
		                                           <label class="custom-control-label" for="${ employee.id }"><span
		                                                   class="text-hide">Check</span></label>
		                                       </div>
			                                </td>
				
				                            <td>
				                                <div class="media align-items-center">
				                                    <div class="media-body">
				                                        <span class="js-lists-values-employee-name">${ employee.name }</span>
				                                    </div>
				                                </div>
				                            </td>
				                            <td>
				                            	<c:choose>
				                            		<c:when test="${ employee.role.id == 1}"><span class="badge badge-warning" style="text-transform: uppercase;">${ employee.role.name }</span></c:when>
				                            		<c:when test="${ employee.role.id == 2}"><span class="badge badge-primary" style="text-transform: uppercase;">${ employee.role.name }</span></c:when>
				                            		<c:otherwise><span class="badge badge-success" style="text-transform: uppercase;">${ employee.role.name }</span></c:otherwise>
				                            	</c:choose>
				                            	
				                            </td>
				                            <td><small class="text-muted">${ employee.email }</small></td>
				                            <td>${ employee.phone }</td>
				                            <td>${ employee.address }</td>
				                        </tr>
			                        </c:forEach>
			                    </tbody>
			                </table>
						</form>
		            </div>
		        </div>
		    </div>
		</div>
	</div>
	
	<div style="margin-top: 15px;">
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
		                <a href="/crm/project/project-detail/project-tasks/create?project_id=${ project.id }" class="text-dark">
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
		                <button type="submit" class="btn btn-light text-dark border border-light" form="delete-form-task">
		                	<strong>Delete Task</strong>
		                </button>
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
						 <form action="/crm/project/project-detail/project-tasks/delete?project_id=${ project.id }" method="post" id="delete-form-task">
							<table class="table mb-0 thead-border-top-0">
			                    <thead>
			                        <tr>
			                            <th style="width: 12px;">
			                                <div class="custom-control custom-checkbox">
			                                    <input type="checkbox"
			                                        class="custom-control-input js-toggle-check-all"
			                                        data-target="#staff" id="customCheckAll">
			                                    <label class="custom-control-label" for="customCheckAll"><span
			                                            class="text-hide">Toggle all</span></label>
			                                </div>
			                            </th>
			
			                            <th style="width: 120px;">Name</th>
			                            <th style="width: 300px;">Description</th>
			                            <th style="width: 140px;">Start</th>
			                            <th style="width: 140px;">End</th>
			                            <th style="width: 200px;">Assignee</th>
			                            <th style="width: 40px;">Status</th>
			                            <th style="width: 40px;">#</th>
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
				                            
				                            <td><small class="text-muted">${ task.start }</small></td>
				                            <td><small class="text-muted">${ task.end }</small></td>
				                            <td>${ task.assignee.name }</td>
				                            <td>
				                            	<c:choose>
				                            		<c:when test="${ task.status.id == 1}"><span class="badge badge-warning" style="text-transform: uppercase;">${ task.status.name }</span></c:when>
				                            		<c:when test="${ task.status.id == 2}"><span class="badge badge-primary" style="text-transform: uppercase;">${ task.status.name }</span></c:when>
				                            		<c:otherwise><span class="badge badge-success" style="text-transform: uppercase;">${ task.status.name }</span></c:otherwise>
				                            	</c:choose>
				                            </td>
				                            <td>
			                            		<a href="project-detail/project-tasks/edit?id=${ task.id }&project_id=${ project.id }" class="text-primary">Edit</a>	
			                            	</td>
				                        </tr>
			                        </c:forEach>
			                    </tbody>
			                </table>
						</form>
		            </div>
		        </div>
		    </div>
		</div>
	</div>
</div>

