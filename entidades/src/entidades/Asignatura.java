package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the asignatura database table.
 * 
 */
@Entity
@NamedQuery(name="Asignatura.findAll", query="SELECT a FROM Asignatura a")
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_asignatura")
	private Integer idAsignatura;

	@Column(name="nombre_asignatura")
	private String nombreAsignatura;

	@Column(name="numero_creditos_asignatura")
	private Integer numeroCreditosAsignatura;

	//bi-directional many-to-one association to Periodo
	@OneToMany(mappedBy="asignatura")
	private List<Periodo> periodos;

	public Asignatura() {
	}

	public Integer getIdAsignatura() {
		return this.idAsignatura;
	}

	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getNombreAsignatura() {
		return this.nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public Integer getNumeroCreditosAsignatura() {
		return this.numeroCreditosAsignatura;
	}

	public void setNumeroCreditosAsignatura(Integer numeroCreditosAsignatura) {
		this.numeroCreditosAsignatura = numeroCreditosAsignatura;
	}

	public List<Periodo> getPeriodos() {
		return this.periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}

	public Periodo addPeriodo(Periodo periodo) {
		getPeriodos().add(periodo);
		periodo.setAsignatura(this);

		return periodo;
	}

	public Periodo removePeriodo(Periodo periodo) {
		getPeriodos().remove(periodo);
		periodo.setAsignatura(null);

		return periodo;
	}

}