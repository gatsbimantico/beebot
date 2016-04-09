package gpul.iotlabs.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DATA")
public class Data implements Serializable{

	private static final long serialVersionUID = 92983642032L;

	@Id
	@Column(name="DATA_ID")
	@GeneratedValue
	private Long id;
	
	@Column(name="VALUE")
	private Double value;
	
	@Column(name="DATA_TYPE_ID")
	private Long tipo;
	
	@Column(name="TIME")
	private Date date;
	
	@Column(name="SENSOR_ID")
	private Long sensor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getTipo() {
		return tipo;
	}

	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getSensor() {
		return sensor;
	}

	public void setSensor(Long sensor) {
		this.sensor = sensor;
	}	
	
}
