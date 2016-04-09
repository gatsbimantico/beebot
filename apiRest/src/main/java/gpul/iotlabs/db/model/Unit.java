package gpul.iotlabs.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DATA_TYPE")
public class Unit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7123994241578947928L;

	@Id
	@Column(name="DATA_TYPE_ID")
	@GeneratedValue
	private Long id;
	
	@Column(name="DESCRIPTION")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descripcion) {
		this.description = descripcion;
	}
	
}
