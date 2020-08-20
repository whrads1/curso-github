<%@page import="br.com.softtek.logAluno.model.LogAluno"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>

<h1>Listar Log de Alunos</h1>

<a href="IncluirLogAluno" class="btn btn-primary m-4">Incluir Log Aluno</a>

<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Nome</th>
			<th scope="col">Data</th>
			<th scope="col">Ip</th>
			<th scope="col">Ações</th>
		</tr>
	</thead>
	<tbody>
	<% 
	List<LogAluno> logAlunos = (List<LogAluno>) request.getAttribute("listaLogAluno");
	if(logAlunos.isEmpty()){
	%>
		<tr>
			<th scope="col" colspan="4">
				<h5>Não existem dados para exibição!</h5>
			</th>
		</tr>
	<% 
		}else{
			for(LogAluno logAluno : logAlunos){
	%>
	
		<tr>
			<th scope="row"><%=logAluno.getId() %></th>
			<td><%=logAluno.getNome() %></td>
			<td><%=logAluno.getDataInclusao() %></td>
			<td><%=logAluno.getIp() %></td>
			<td>								
				<form action="AlterarLogAluno" method="get" style="display: contents;">
					<input type="hidden" name="id"  value="<%=logAluno.getId()%>">				
					<button type="submit" class="btn btn-primary">Alterar</button>
				</form>
				<form action="ExcluirLogAluno" method="post" style="display: contents;">
					<input type="hidden" name="id"  value="<%=logAluno.getId()%>">				
					<button type="submit" class="btn btn-danger">Excluir</button>
				</form>
			</td>
		</tr>
			
	<%
			}
		}
	
	%>
		
	</tbody>
</table>
<jsp:include page="footer.jsp"></jsp:include>