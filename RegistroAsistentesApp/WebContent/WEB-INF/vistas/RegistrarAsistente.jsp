<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">

	<c:if test="${mensaje != null}">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-info">
					<p>${mensaje}</p>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${errores != null}">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-danger">
					<h6>Existen errores en el formulario de registro</h6>
					<div class="content">
						<ul>
							<c:forEach var="error" items="${errores}">
								<li>${error}</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<div class="columns is-centered">
		<div class="column is-6">
			<form method="POST" action="RegistrarAsistenteController.do">
				<div class="card">
					<div class="card-header has-background-warning">
						<span class="card-header-title">Registrar Asistente</span>
					</div>
					<div class="card-content">
						<div class="field">
							<label class="label" for="Rut-txt">Rut</label>
							<div class="control">
								<input type="text" class="input" id="rut-txt" name="rut-txt" min="10"/>
							</div>
						</div>
						<div class="field">
							<label class="label" for="nombre-txt">Nombre</label>
							<div class="control">
								<input type="text" class="input" id="nombre-txt"
									name="nombre-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="apellido-txt">Apellido</label>
							<div class="control">
								<input type="text" class="input" id="apellido-txt"
									name="apellido-txt" />
							</div>
						</div>
						
<!-- 						ASIGNANDO MINIMO DE EDAD, AUTOMATICAMENTE NO PODRA PONER UNA EDAD MENOR -->
						<div class="field">
							<label class="label" for="edad-number">Edad</label>
							<div class="control">
								<input type="number" class="input" id="edad-number"
									name="edad-number" min="18"/>
							</div>
						</div>
						<div class="field">
							<label class="label" for="empresa-txt">Empresa</label>
							<div class="control">
								<input type="text" class="input" id="empresa-txt"
									name="empresa-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="estado-select">Estado</label>
							<div class="control">
								<div class="select">
									<select name="estado-select" id="estado-select">
										<option>Pagada</option>
										<option>Con Deuda</option>
									</select>
								</div>
							</div>
						</div>
						<div class="field">
							<label class="label" for="region-select">Región</label>
							<div class="control">
								<div class="select">
									<select name="region-select" id="region-select">
										<option>Valparaiso</option>
										<option>Santiago</option>
										<option>Norte de chile</option>
										<option>Sur de chile</option>
										<option>Internacional</option>
									</select>
								</div>
							</div>
						</div>

					</div>
					<div class="card-footer has-text-centered">
						<div class="card-footer-item">
							<button type="submit" class="button is-primary">Registrar</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

</main>
</body>
</html>