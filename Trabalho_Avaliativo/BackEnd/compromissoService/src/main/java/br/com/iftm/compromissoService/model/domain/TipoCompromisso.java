package br.com.iftm.compromissoService.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_COMPROMISSO")
public class TipoCompromisso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "DESCRICAO")
	private String descricao;

	public TipoCompromisso() {
		super();
	}

	public TipoCompromisso(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return this.id;
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
		TipoCompromisso other = (TipoCompromisso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

}
