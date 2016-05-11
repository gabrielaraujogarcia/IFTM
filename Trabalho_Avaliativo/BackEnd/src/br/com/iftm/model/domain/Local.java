package br.com.iftm.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import br.com.iftm.model.util.ValidacaoException;

@Entity
@Table(name = "LOCAL")
public class Local implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DESCRICAO", nullable = false, unique = true)
	private String descricao;

	@Column(name = "PONTO_REFERENCIA", nullable = true)
	private String pontoReferencia;

	public Local() {
		super();
	}

	public Local(Long id, String descricao, String pontoReferencia) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.pontoReferencia = pontoReferencia;
	}

	public boolean validar() throws ValidacaoException {
		if (StringUtils.isNotBlank(this.descricao)) {
			throw new ValidacaoException("Campo 'Descrição' deve ser preenchido");
		}

		return true;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Local other = (Local) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
