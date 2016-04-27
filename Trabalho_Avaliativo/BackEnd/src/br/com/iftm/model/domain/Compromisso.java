package br.com.iftm.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "COMPROMISSO")
public class Compromisso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DESCRICAO")
	private String descricao;

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "PARTICIPANTES_COMPROMISSO", 
		joinColumns = {@JoinColumn(name = "ID_COMPROMISSO", referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name = "ID_PARTICIPANTE", referencedColumnName = "id")})
	private List<Participante> participantes;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.DETACH)
	@PrimaryKeyJoinColumn
	private Local local;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.DETACH)
	@PrimaryKeyJoinColumn
	private TipoCompromisso tipoCompromisso;
	
	public Compromisso() {
		super();
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

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public TipoCompromisso getTipoCompromisso() {
		return tipoCompromisso;
	}

	public void setTipoCompromisso(TipoCompromisso tipoCompromisso) {
		this.tipoCompromisso = tipoCompromisso;
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
		Compromisso other = (Compromisso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
