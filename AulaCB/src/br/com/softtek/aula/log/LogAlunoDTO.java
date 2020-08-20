package br.com.softtek.aula.log;

import java.sql.Timestamp;
import java.util.Date;

public class LogAlunoDTO {

	private int id;
	private String nome;
	private String ip;
	private Date dataInclusao;
	
	//Define os campos 
	public LogAlunoDTO(String nome, Timestamp dataInclusao, String ip) {
		this.nome = nome;
		this.dataInclusao = dataInclusao;
		this.ip = ip;
	}
	public LogAlunoDTO(String nome, Date dataInclusao, String ip) {
		this(nome, new Timestamp(dataInclusao.getTime()), ip);
	}
	public LogAlunoDTO(int id, String nome, Timestamp dataInclusao, String ip) {
		this(nome, dataInclusao,ip);
		this.id = id;
	}
	public LogAlunoDTO() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
	@Override
	public String toString() {
		return "LogAlunoDTO [id=" + id + ", nome=" + nome + ", dataInclusao=" + dataInclusao + "]";
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
