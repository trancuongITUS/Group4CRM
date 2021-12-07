<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cybersoft.java14.backend.crm.util.UrlConst" %>

<div class="container page__heading-container">
	<div class="page__heading">
	    <div class="d-flex align-items-center">
			<div>
			    <nav aria-label="breadcrumb">
			        <ol class="breadcrumb mb-0">
			            <li class="breadcrumb-item"><a href="#">Project</a></li>
			            <li class="breadcrumb-item active" aria-current="page">
			                Project List
			            </li>
			        </ol>
			    </nav>
			    <h1 class="m-0">Project List</h1>
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
	                	<strong>Delete Project</strong>
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
					 <form action="/crm/project/project-delete" method="post" id="delete-form">
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
		
		                            <th style="width: 160px;">Name</th>
		                            <th style="width: 300px;">Description</th>
		                            <th style="width: 140px;">Start</th>
		                            <th style="width: 140px;">End</th>
		                            <th style="width: 160px;">Create by</th>
		                            <th style="width: 40px;">#</th>
		                            <th style="width: 40px;">#</th>
		                        </tr>
		                    </thead>
		                    <tbody class="list" id="staff">
		                    	<c:forEach var="project" items="${ projects }">
			                    	<tr>
										<td>
											<div class="custom-control custom-checkbox">
												<input name="chkSelected" value="${ project.id }" type="checkbox"
												class="custom-control-input js-check-selected-row"
												id="${ project.id }">
												<label class="custom-control-label" for="${ project.id }"><span
												            class="text-hide">Check</span></label>
											</div>
										</td>
			
			                            <td>
			                                <div class="media align-items-center">
			                                    <div class="media-body">
			                                        <span class="js-lists-values-employee-name">${ project.name }</span>
			                                    </div>
			                                </div>
			                            </td>
			                            <td><small class="text-muted">${ project.description }</small></td>
			                            <td>${ project.start }</td>
			                            <td>${ project.end }</td>
			                            <td>${ project.created.name }</td>
			                            <td>
			                            	<a href="/crm/project/project-edit?id=${ project.id }" class="text-primary">Edit</a>	
			                            </td>
			                            <td>
			                            	<a href="/crm/project/project-detail?id=${ project.id }" class="text-primary">Detail</a>	
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