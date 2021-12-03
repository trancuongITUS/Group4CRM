use crm;

insert into 
	crm_role(role_name, role_description)
values
	('Admin', 'Quản trị viên hệ thống'),
    ('Leader', 'Trưởng một dự án'),
    ('Employee', 'Nhân viên');

insert into
	crm_user(user_role, user_name, email, usr_password, phone, address)
values
	(1, 'Trần Cường', 'ktc1311@gmail.com', 'admin123', '0337543594', 'Quảng Ngãi'),
    (1, 'Nguyên Phan', 'khoinguyen16399@gmail.com', 'admin123', '0xxxxxxxxx', 'TP Hồ Chí Minh'),
    (1, 'Lan Lê', 'phuonglanyds@gmail.com', 'admin123', '0xxxxxxxxx', 'TP Hồ Chí Minh'),
    (2, 'Tuấn Phan', 'contact@tuanphan.dev', 'leader123', '0xxxxxxxxx', 'TP Hồ Chí Minh'),
    (3, 'Nguyễn Văn A', 'NVA@gmail.com', 'emp123', '0xxxxxxxxx', 'Hà Nội'),
    (3, 'Trần Văn B', 'TVB@gmail.com', 'emp123', '0xxxxxxxxx', 'Hà Nội');
    
insert into
	crm_status(status_name, status_description)
values
    ('Not yet started', 'Công việc chưa được bắt đầu.'),
    ('In progress', 'Công việc đang được giải quyết.'),
    ('Done', 'Đã hoàn thành 100% công việc.');
    
insert into 
	crm_project(project_name, project_description, start_at, end_at, create_user)
values
	('CRM Servlet', 'CRM Appication using Servlet Java14', '2021-11-21', '2021-12-5', 4),
    ('CRM Spring', 'CRM Application using Spring Framework', '2021-12-7', '2021-12-21', 3),
    ('Laptop Website', 'Laptop Website using NodeJS', '2021-10-1', '2021-12-28', 1);

insert into
	crm_task(assignee, task_name, task_description, start_at, end_at, task_status, task_project)
values
	(3, 'Create database', 'Create database for project', '2021-11-21', '2021-11-22', 3, 1),
    (3, 'Mock data', 'Fake data for database of project', '2021-11-23', '2021-11-24', 3, 1),
    (4, 'CRUD ', 'CRUD for project', '2021-11-25', '2021-12-2', 3, 1),
    (4, 'Testing', 'Testing for project', '2021-12-3', '2021-12-5', 2, 1),
    (3, 'Project Structure', 'Create project and download libraries.', '2021-12-7', '2021-12-8', 1, 2),
    (4, 'Coding', 'Coding project.', '2021-12-9', '2021-12-19', 1, 2),
    (4, 'Release', 'Test and release', '2021-12-20', '2021-12-21', 1, 2),
    (3, 'Create database', 'Create database and mock data', '2021-10-1', '2021-10-3', 3, 3),
    (3, 'Coding admin page', 'Admin page for website', '2021-10-4', '2021-11-1', 3, 3),
    (4, 'Coding client page', 'Client page for website', '2021-10-4', '2021-11-1', 3, 3);