create database if not exists crm;

use crm;

create table if not exists crm_role
(
	role_id int auto_increment,
    role_name varchar(255) not null,
    role_description varchar(255),
    
    constraint PK_Role primary key (role_id)
);

create table if not exists crm_user
(
	user_id int auto_increment,
    user_role int,
    user_name varchar(255) not null,
    email varchar(100) not null,
    usr_password varchar(255) not null,
    phone varchar(36),
    address varchar(255),
    
    constraint PK_User primary key (user_id)
);

create table if not exists crm_project
(
	project_id int auto_increment,
    project_name varchar(255) not null,
    project_description varchar(255),
    start_at date,
    end_date date,
    create_user int,
    
    constraint PK_Project primary key (project_id)
);

create table if not exists crm_status
(
	status_id int auto_increment,
    status_name varchar(255) not null,
    status_description varchar(255),
    
    constraint PK_Status primary key (status_id)
);

create table if not exists crm_task
(
	task_id int auto_increment,
    asssignee int,
    task_name varchar(255) not null,
    task_description varchar(255),
    start_at date,
    end_at date,
    task_status int,
    task_project int,
    
    constraint PK_Task primary key (task_id)
);

alter table crm_user
add constraint FK_user_role
foreign key (user_role) references crm_role(role_id);

alter table crm_project
add constraint FK_project_user
foreign key (create_user) references crm_user(user_id);

alter table crm_task
add constraint FK_task_user
foreign key (asssignee) references crm_user(user_id);

alter table crm_task
add constraint FK_task_project
foreign key (task_project) references crm_project(project_id);

alter table crm_task
add constraint FK_task_status
foreign key (task_status) references crm_status(status_id);