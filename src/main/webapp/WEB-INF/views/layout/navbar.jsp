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
                        <a class="nav-link active" href='<c:url value="home" />'>
                            Home</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
                            Project
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="project/project-manage">Manage</a>
                            <a class="dropdown-item" href="project/project-create">Create</a>
                            <a class="dropdown-item" href="project/project-assignment">Assignment</a>
                            <a class="dropdown-item" href="project/project-statistics">Statistics</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
                            User
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="user/user-list">List</a>
                            <a class="dropdown-item" href="user/user-create">Create</a>
                            <a class="dropdown-item" href="user/user-authorization">Authorization</a>
                        </div>
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