<!--Đây là code của ProjectCreate anh đang định làm thêm nhưng mới phần giao diện còn upload dữ liệu vẫn chưa được -->
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
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
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
			                Project Create
			            </li>
			        </ol>
			    </nav>
			    <h1 class="m-0">Project Create</h1>
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
      * {
      box-sizing: border-box;
      }
      html, body {
      min-height: 100vh;
      padding: 0;
      margin: 0;
      font-family: Roboto, Arial, sans-serif;
      font-size: 14px; 
      color: #666;
      }
      input, textarea { 
      outline: none;
      }
      body {
      display: block;
      justify-content: center;
      align-items: center;
      }
      h1 {
      margin-top: 0;
      font-weight: 500;
      }
      form {
      position: relative;
      width: 80%;
      border-radius: 30px;
      background: #fff;
      }
      .form-left-decoration,
      .form-right-decoration {
      content: "";
      position: absolute;
      width: 50px;
      height: 20px;
      border-radius: 20px;
      background: #5a7233;
      }
      .form-left-decoration {
      bottom: 60px;
      left: -30px;
      }
      .form-right-decoration {
      top: 60px;
      right: -30px;
      }
      .form-left-decoration:before,
      .form-left-decoration:after,
      .form-right-decoration:before,
      .form-right-decoration:after {
      content: "";
      position: absolute;
      width: 50px;
      height: 20px;
      border-radius: 30px;
      background: #fff;
      }
      .form-left-decoration:before {
      top: -20px;
      }
      .form-left-decoration:after {
      top: 20px;
      left: 10px;
      }
      .form-right-decoration:before {
      top: -20px;
      right: 0;
      }
      .form-right-decoration:after {
      top: 20px;
      right: 10px;
      }
      .circle {
      position: absolute;
      bottom: 80px;
      left: -55px;
      width: 20px;
      height: 20px;
      border-radius: 50%;
      background: #fff;
      }
      .form-inner {
      padding: 40px;
      }
      .form-inner input,
      .form-inner textarea {
      display: block;
      width: 100%;
      padding: 15px;
      margin-bottom: 10px;
      border: none;
      border-radius: 20px;
      background: #d0dfe8;
      }
      .form-inner textarea {
      resize: none;
      }
      button {
      width: 100%;
      padding: 10px;
      margin-top: 20px;
      border-radius: 20px;
      border: none;
      border-bottom: 4px solid #3e4f24;
      background: #5a7233; 
      font-size: 16px;
      font-weight: 400;
      color: #fff;
      }
      button:hover {
      background: #3e4f24;
      } 
      @media (min-width: 568px) {
      form {
      width: 60%;
      }
      }
      .form-bg
      {
      	padding-left: 260px;
      }
    </style>
<div class="container">
	<div class="form-bg">
		<form action="/" class="decor">
		     <div class="form-left-decoration"></div>
			     <div class="form-right-decoration"></div>
			     <div class="circle"></div>
			     <div class="form-inner">
			       <input type="text" placeholder="Project name">
			       <input type="text" placeholder="Create user">
		       <textarea placeholder="Project decryption..." rows="5"></textarea>
		    <button type="submit" href="<%= request.getContextPath() + UrlConst.PROJECT_ADD %>?id=${ project.id }">Submit</button> <!-- Chỗ này chưa xong  -->    
      </div>
		</form>
	</div>
</div>
</body>