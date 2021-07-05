<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">
	<div class="columns is-centered">
		<div class="column is-8">
			<table class="table is-hovered is-bordered is-fullwidth">
				<thead class="has-background-primary">
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Empresa</th>
						<th>Región</th>
						<th>Estado</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="asistente" items="${asistentes}">
						<tr>
							<td>${asistente.nombre}</td>
							<td>${asistente.apellido}</td>
							<td>${asistente.empresa}</td>
							<td>${asistente.region}</td>
							<td>${asistente.estado}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
</body>
</html>