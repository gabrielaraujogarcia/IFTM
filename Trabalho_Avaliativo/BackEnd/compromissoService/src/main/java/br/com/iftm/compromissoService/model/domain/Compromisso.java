package br.com.iftm.compromissoService.model.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;

import br.com.iftm.compromissoService.model.util.ValidacaoException;

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_HORA")
	private Date dataHora;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "PARTICIPANTES_COMPROMISSO", joinColumns = {
			@JoinColumn(name = "ID_COMPROMISSO", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_PARTICIPANTE", referencedColumnName = "id") })
	private List<Participante> participantes;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "ID_LOCAL", referencedColumnName = "ID")
	@PrimaryKeyJoinColumn
	private Local local;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "ID_TIPO_COMPROMISSO", referencedColumnName = "ID")
	@PrimaryKeyJoinColumn
	private TipoCompromisso tipoCompromisso;

	public Compromisso() {
		super();
	}

	public boolean validar() throws ValidacaoException {
		if (StringUtils.isNotBlank(this.descricao)) {
			throw new ValidacaoException("Campo 'Descrição' deve ser preenchido");
		}

		// if (this.dataHora == null) {
		// throw new ValidacaoException("Campo 'Data/Hora' deve ser
		// preenchido");
		// }

		if (this.dataHora.before(Calendar.getInstance().getTime())) {
			throw new ValidacaoException("Campo 'Data/Hora' posterior à data atual");
		}

		if (this.local == null) {
			throw new ValidacaoException("Campo 'Local' deve ser preenchido");
		}

		if (this.tipoCompromisso == null) {
			throw new ValidacaoException("Campo 'Tipo de Compromisso' deve ser preenchido");
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

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date data) {
		this.dataHora = data;
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