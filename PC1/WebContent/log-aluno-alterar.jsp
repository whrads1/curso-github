<%@page import="br.com.softtek.logAluno.model.LogAluno"%>
<jsp:include page="header.jsp"></jsp:include>

<% 
	LogAluno logAluno = (LogAluno) request.getAttribute("logAluno");
%>
	
<h1>Alterar log de aluno</h1>
<form novalidate="novalidate" name="formLogAluno"
	action="AlterarLogAluno" method="post">
	<div class="form-group">
		<label for="id">Id do Log do Aluno</label> 
		<input id="id" name="id" type="text" class="form-control" readonly="readonly" value="<%=logAluno.getId()%>"> 
		<small class="form-text text-muted">Id do registro do log de aluno.</small>
	</div>
	<div class="form-group">
		<label for="nomeAluno">Nome do Aluno</label> 
		<input id="nomeAluno" name="nomeAluno" type="text" class="form-control" placeholder="Entre o nome do Aluno"  value="<%=logAluno.getNome()%>"> 
		<small class="form-text text-muted">Nome do aluno do log de aluno.</small>
	</div>
	<div class="form-group">
		<label for="dataInclusao">Data de Inclusão</label> 
		<input id="dataInclusao" name="dataInclusao" type="text" class="form-control" readonly="readonly"  value="<%=logAluno.getDataInclusao()%>"> 
		<small class="form-text text-muted">Data de inclusão do registro do log de aluno.</small>
	</div>
	<div class="form-group">
		<label for="ip">IP</label> 
		<input id="ip" name="ip" type="text" class="form-control" readonly="readonly"  value="<%=logAluno.getIp()%>"> 
		<small class="form-text text-muted">Ip do registro do log de aluno.</small>
	</div>
	<a href="/PC1" class="btn btn-light">Voltar</a>
	<button type="submit" class="btn btn-primary">Alterar</button>
</form>
<jsp:include page="footer.jsp"></jsp:include>