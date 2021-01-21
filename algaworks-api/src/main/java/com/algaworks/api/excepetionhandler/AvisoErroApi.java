package com.algaworks.api.excepetionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class AvisoErroApi {

	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campos;
	
	public List<Campo> getCampos() {
		return campos;
	}
	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
	public static class Campo{
		String nomeCampo;
		String mensagemDeErro;
		
		public Campo(String nomeCampo, String mensagemDeErro) {
			super();
			this.nomeCampo = nomeCampo;
			this.mensagemDeErro = mensagemDeErro;
		}
		public String getNomeCampo() {
			return nomeCampo;
		}
		public void setNomeCampo(String nomeCampo) {
			this.nomeCampo = nomeCampo;
		}
		public String getMensagemDeErro() {
			return mensagemDeErro;
		}
		public void setMensagemDeErro(String mensagemDeErro) {
			this.mensagemDeErro = mensagemDeErro;
		}
		
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
