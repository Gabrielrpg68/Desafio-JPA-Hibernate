package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_FILME")
@SequenceGenerator(name="filme", sequenceName = "SQ_TB_filme",allocationSize = 1)
public class Filme {

	@Id
	@Column(name="cd_filme")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_filme", nullable = false, length = 50)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", length = 20)
	private GeneroFilme genero;
	
	@Column(name="ds_duracao", length = 5)
	private String duracao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_lancamento")
	private Calendar dataLancamento;
	
	public Filme() {}

	public Filme(String nome, GeneroFilme genero, String duracao, Calendar dataLancamento) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.duracao = duracao;
		this.dataLancamento = dataLancamento;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GeneroFilme getGenero() {
		return genero;
	}

	public void setGenero(GeneroFilme genero) {
		this.genero = genero;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	
}


//TB_MUSICA
//
//cd_musica number PK not null
//nm_musica varchar2(50) not null
//ds_genero varchar2(20), Enum no java
//dt_lancamento date
//ds_duracao varchar2(4)
//nm_artista varchar2(50) not null
//ds_tamanho number (tamanho do arquivo bytes)
//
//Sequence: SQ_TB_MUSICA