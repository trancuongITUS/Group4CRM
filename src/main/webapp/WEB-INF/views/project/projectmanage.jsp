<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<div class="container page__heading-container">
	<div class="page__heading">
	    <div class="d-flex align-items-center">
			<div>
			    <nav aria-label="breadcrumb">
			        <ol class="breadcrumb mb-0">
			            <li class="breadcrumb-item"><a href="#">Project</a></li>
			            <li class="breadcrumb-item active" aria-current="page">
			                Project Manage
			            </li>
			        </ol>
			    </nav>
			    <h1 class="m-0">Project Manage</h1>
			</div>
	        <div class="ml-auto">
	            <a href="" class="btn btn-light"><i class="material-icons icon-16pt text-muted mr-1">settings</i>
					Settings
				</a>
	        </div>
	    </div>
	 </div>
</div>
<style>
	.card {
    box-shadow: 0 0.46875rem 2.1875rem rgba(4, 9, 20, 0.03), 0 0.9375rem 1.40625rem rgba(4, 9, 20, 0.03), 0 0.25rem 0.53125rem rgba(4, 9, 20, 0.05), 0 0.125rem 0.1875rem rgba(4, 9, 20, 0.03);
    border-width: 0;
    transition: all .2s
}

.card-header:first-child {
    border-radius: calc(0.25rem - 1px) calc(0.25rem - 1px) 0 0
}

.card-header {
    display: flex;
    align-items: center;
    border-bottom-width: 1px;
    padding-top: 0;
    padding-bottom: 0;
    padding-right: 0.625rem;
    height: 3.5rem;
    background-color: #fff
}
.widget-subheading {
    color: #858a8e;
    font-size: 10px
}
.card-header.card-header-tab .card-header-title {
    display: flex;
    align-items: center;
    white-space: nowrap
}

.card-header .header-icon {
    font-size: 1.65rem;
    margin-right: 0.625rem
}

.card-header.card-header-tab .card-header-title {
    display: flex;
    align-items: center;
    white-space: nowrap
}

.btn-actions-pane-right {
    margin-left: auto;
    white-space: nowrap
}

.text-capitalize {
    text-transform: capitalize !important
}

.scroll-area-sm {
    height: 288px;
    overflow-x: hidden
}

.list-group-item {
    position: relative;
    display: block;
    padding: 0.75rem 1.25rem;
    margin-bottom: -1px;
    background-color: #fff;
    border: 1px solid rgba(0, 0, 0, 0.125)
}

.list-group {
    display: flex;
    flex-direction: column;
    padding-left: 0;
    margin-bottom: 0
}

.todo-indicator {
    position: absolute;
    width: 4px;
    height: 60%;
    border-radius: 0.3rem;
    left: 0.625rem;
    top: 20%;
    opacity: .6;
    transition: opacity .2s
}

.bg-warning {
    background-color: #f7b924 !important
}

.widget-content {
    padding: 1rem;
    flex-direction: row;
    align-items: center
}

.widget-content .widget-content-wrapper {
    display: flex;
    flex: 1;
    position: relative;
    align-items: center
}

.widget-content .widget-content-right.widget-content-actions {
    visibility: hidden;
    opacity: 0;
    transition: opacity .2s
}

.widget-content .widget-content-right {
    margin-left: auto
}

.widget-time-start{
	color: red;
	font-size: 10px
}

.widget-time-end{
	color: blue;
	font-size: 10px
}
.btn:not(:disabled):not(.disabled) {
    cursor: pointer
}

.btn {
    position: relative;
    transition: color 0.15s, background-color 0.15s, border-color 0.15s, box-shadow 0.15s
}

.btn-outline-success {
    color: #3ac47d;
    border-color: #3ac47d
}

.btn-outline-success:hover {
    color: #fff;
    background-color: #3ac47d;
    border-color: #3ac47d
}

.btn-outline-success:hover {
    color: #fff;
    background-color: #3ac47d;
    border-color: #3ac47d
}

.btn-primary {
    color: #fff;
    background-color: #3f6ad8;
    border-color: #3f6ad8
}

.btn {
    position: relative;
    transition: color 0.15s, background-color 0.15s, border-color 0.15s, box-shadow 0.15s;
    outline: none !important
}

.card-footer {
    background-color: #fff
}

</style>
<div class="container">
<div class="row ml-0 mr-0 d-flex justify-content-center container">
    <div class="col-md-12">
        <div class="card-hover-shadow-2x mb-3 card">
            <div class="card-header-tab card-header">
                <div class="card-header-title font-size-lg text-capitalize font-weight-normal"><i class="fa fa-tasks"></i>&nbsp;Project Lists</div>
            </div>
            <div class="scroll-area-sm">
                <perfect-scrollbar class="ps-show-limits">
                    <div style="position: static;" class="ps ps--active-y">
                        <div class="ps-content">
                            <ul class=" list-group list-group-flush">
                                <li class="list-group-item">
                                    <div class="todo-indicator bg-warning"></div>
                                    <div class="widget-content p-0">
                                        <div class="widget-content-wrapper">
                                            <div class="widget-content-left mr-2">
                                                <div class="custom-checkbox custom-control"> <input class="custom-control-input" id="exampleCustomCheckbox12" type="checkbox"><label class="custom-control-label" for="exampleCustomCheckbox12">&nbsp;</label> </div>
                                            </div>
                                            <div class="widget-content-left">
                                                <div class="widget-heading">Call Sam For payments <div class="badge badge-danger ml-2">Rejected</div>
                                                </div>
                                                <div class="widget-subheading"><i>By Bob</i></div>
                                                <div class="widget-time-start">Start at: </div>
                                            	<div class="widget-time-end">Date end: </div>
                                            </div>
                                            <div class="widget-content-right"> <button class="border-0 btn-transition btn btn-outline-success"> <i class="fa fa-check"></i></button> <button class="border-0 btn-transition btn btn-outline-danger"> <i class="fa fa-trash"></i> </button> </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="todo-indicator bg-focus"></div>
                                    <div class="widget-content p-0">
                                        <div class="widget-content-wrapper">
                                            <div class="widget-content-left mr-2">
                                                <div class="custom-checkbox custom-control"><input class="custom-control-input" id="exampleCustomCheckbox1" type="checkbox"><label class="custom-control-label" for="exampleCustomCheckbox1">&nbsp;</label></div>
                                            </div>
                                            <div class="widget-content-left">
                                                <div class="widget-heading">Make payment to Bluedart</div>
                                                <div class="widget-subheading">  
                                                    <div>By Johnny <div class="badge badge-pill badge-info ml-2">NEW</div>
                                                    </div>
                                                </div>
                                                <div class="widget-time-start">Start at: </div>
                                                <div class="widget-time-end">Date end: </div>
                                            </div>
                                            <div class="widget-content-right"> <button class="border-0 btn-transition btn btn-outline-success"> <i class="fa fa-check"></i></button> <button class="border-0 btn-transition btn btn-outline-danger"> <i class="fa fa-trash"></i> </button> </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="todo-indicator bg-primary"></div>
                                    <div class="widget-content p-0">
                                        <div class="widget-content-wrapper">
                                            <div class="widget-content-left mr-2">
                                                <div class="custom-checkbox custom-control"><input class="custom-control-input" id="exampleCustomCheckbox4" type="checkbox"><label class="custom-control-label" for="exampleCustomCheckbox4">&nbsp;</label></div>
                                            </div>
                                            <div class="widget-content-left flex2">
                                                <div class="widget-heading">Office rent </div>
                                                <div class="widget-subheading">By Samino!</div>
                                                <div class="widget-time-start">Start at: </div>
                                                <div class="widget-time-end">Date end: </div>
                                            </div>
                                            <div class="widget-content-right"> <button class="border-0 btn-transition btn btn-outline-success"> <i class="fa fa-check"></i></button> <button class="border-0 btn-transition btn btn-outline-danger"> <i class="fa fa-trash"></i> </button> </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="todo-indicator bg-info"></div>
                                    <div class="widget-content p-0">
                                        <div class="widget-content-wrapper">
                                            <div class="widget-content-left mr-2">
                                                <div class="custom-checkbox custom-control"><input class="custom-control-input" id="exampleCustomCheckbox2" type="checkbox"><label class="custom-control-label" for="exampleCustomCheckbox2">&nbsp;</label></div>
                                            </div>
                                            <div class="widget-content-left">
                                                <div class="widget-heading">Office grocery shopping</div>
                                                <div class="widget-subheading">By Tida</div>
                                                <div class="widget-time-start">Start at: </div>
                                                <div class="widget-time-end">Date end: </div>
                                            </div>
                                            <div class="widget-content-right"> <button class="border-0 btn-transition btn btn-outline-success"> <i class="fa fa-check"></i></button> <button class="border-0 btn-transition btn btn-outline-danger"> <i class="fa fa-trash"></i> </button> </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="todo-indicator bg-success"></div>
                                    <div class="widget-content p-0">
                                        <div class="widget-content-wrapper">
                                            <div class="widget-content-left mr-2">
                                                <div class="custom-checkbox custom-control"><input class="custom-control-input" id="exampleCustomCheckbox3" type="checkbox"><label class="custom-control-label" for="exampleCustomCheckbox3">&nbsp;</label></div>
                                            </div>
                                            <div class="widget-content-left flex2">
                                                <div class="widget-heading">Ask for Lunch to Clients</div>
                                                <div class="widget-subheading">By Office Admin</div>
                                                <div class="widget-time-start">Start at: </div>
                                                <div class="widget-time-end">Date end: </div>
                                            </div>
                                            <div class="widget-content-right"> <button class="border-0 btn-transition btn btn-outline-success"> <i class="fa fa-check"></i></button> <button class="border-0 btn-transition btn btn-outline-danger"> <i class="fa fa-trash"></i> </button> </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="todo-indicator bg-success"></div>
                                    <div class="widget-content p-0">
                                        <div class="widget-content-wrapper">
                                            <div class="widget-content-left mr-2">
                                                <div class="custom-checkbox custom-control"><input class="custom-control-input" id="exampleCustomCheckbox10" type="checkbox"><label class="custom-control-label" for="exampleCustomCheckbox10">&nbsp;</label></div>
                                            </div>
                                            <div class="widget-content-left flex2">
                                                <div class="widget-heading">Client Meeting at 11 AM</div>
                                                <div class="widget-subheading">By CEO</div>
                                                <div class="widget-time-start">Start at: </div>
                                                <div class="widget-time-end">Date end: </div>
                                            </div>
                                            <div class="widget-content-right"> <button class="border-0 btn-transition btn btn-outline-success"> <i class="fa fa-check"></i></button> <button class="border-0 btn-transition btn btn-outline-danger"> <i class="fa fa-trash"></i> </button> </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </perfect-scrollbar>
            </div>
            <div class="d-block text-right card-footer"><button class="mr-2 btn btn-link btn-sm">Cancel</button><button class="btn btn-primary">Add Project</button></div>
        </div>
    </div>
</div>
</div> -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cybersoft.java14.backend.crm.util.UrlConst" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container page__heading-container">
	<div class="page__heading">
	    <div class="d-flex align-items-center">
			<div>
			    <nav aria-label="breadcrumb">
			        <ol class="breadcrumb mb-0">
			            <li class="breadcrumb-item"><a href="#">Project</a></li>
			            <li class="breadcrumb-item active" aria-current="page">
			                Project Manage
			            </li>
			        </ol>
			    </nav>
			    <h1 class="m-0">Project Manage</h1>
			</div>
	        <div class="ml-auto">
	            <a href="" class="btn btn-light"><i class="material-icons icon-16pt text-muted mr-1">settings</i>
					Settings
				</a>
	        </div>
	    </div>
	 </div>
</div>

	<div class="container-fluid">		
		<table class="table mt-5">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Start date</th>
					<th>End date</th>
					<th>User</th>
					<th>Add</th>
					<th>Remove</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${projects}">
					<tr>
					<td scope="row">${project.id}</td>
					<td>${project.name}</td>
					<td>${project.description}</td>
					<!-- Chỗ này còn thiếu date -->
					<%-- <td>${project.start_date}</td>
					<td>${project.end_date}</td>
					<td></td> --%>
					<td><a class="btn  btn-success" href="<%= request.getContextPath() + UrlConst.PROJECT_CREATE %>" style="color: white">Add</a></td>
					<td><a class="btn btn-sm btn-danger" href="<%= request.getContextPath() + UrlConst.PROJECT_REMOVE %>?id=${ project.id }" style="color: white">Remove</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

