<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="vendor/bulma/css/bulma.min.css" rel="stylesheet" />
</head>
<body>
	<header>
		<nav class="navbar has-background-warning" role="navigation"
			aria-label="main navigation">
			<div class="navbar-brand">
				<a class="navbar-item" href="index.jsp"> <img src="img/logo.png">
				</a> <a role="button" class="navbar-burger" aria-label="menu"
					aria-expanded="false" data-target="navbarBasicExample"> <span
					aria-hidden="true"></span> <span aria-hidden="true"></span> <span
					aria-hidden="true"></span>
				</a>
			</div>

			<div id="navbarBasicExample" class="navbar-menu">
				<div class="navbar-start">
					<a class="navbar-item"> Home </a>

					<div class="navbar-item has-dropdown is-hoverable">
						<a class="navbar-link"> Asistentes </a>

						<div class="navbar-dropdown">
							<a class="navbar-item" href="RegistrarAsistenteController.do"> Registrar Asistente </a>
							 <a class="navbar-item" href="MostrarAsistentesController.do">
								 Mostrar Resumen </a>
						</div>
					</div>
				</div>

			</div>
		</nav>
	</header>