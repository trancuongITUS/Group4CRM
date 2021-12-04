<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="page__header mb-0">
    <div class="container page__container">
        <div class="navbar navbar-secondary navbar-light navbar-expand-sm p-0">
            <button class="navbar-toggler navbar-toggler-right" data-toggle="collapse" data-target="#navbarsExample03" type="button">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="navbar-collapse collapse" id="navbarsExample03">
                <ul class="nav navbar-nav flex">
                    <li class="nav-item">
                        <a class="nav-link active" href="/crm/home">
                            Home</a>
                    </li>
                    
                    <li class="nav-item">
                    	<a href="/crm/project" class="nav-link">Project Management</a>
                    </li>
                    
                    <li class="nav-item">
                    	<a href="/crm/user" class="nav-link">User Management</a>
                    </li>
                    
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
                            Task
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="task/task-list">List</a>
                            <a class="dropdown-item" href="task/task-progress">Progress</a>
                            <a class="dropdown-item" href="task/task-statistics">Statistics</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>