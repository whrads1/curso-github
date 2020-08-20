<jsp:include page="header.jsp"></jsp:include>
<h1>Incluir log de aluno</h1>
<form novalidate="novalidate" name="formLogAluno"
	action="IncluirLogAluno" method="post">
	<div class="form-group">
		<label for="nomeAluno">Nome do Aluno</label> 
		<input id="nomeAluno" name="nomeAluno" type="text" class="form-control" placeholder="Entre com o nome do Aluno"> 
		<small class="form-text text-muted">Nome do aluno do log de aluno.</small>
	</div>
	<a href="/PC1" class="btn btn-light">Voltar</a>
	<button type="submit" class="btn btn-primary">Incluir</button>
</form>
<jsp:include page="footer.jsp"></jsp:include>