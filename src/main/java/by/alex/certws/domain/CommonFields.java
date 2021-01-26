package by.alex.certws.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import by.alex.certws.utils.DateUtils;

@MappedSuperclass
public abstract class CommonFields implements Serializable {
	
	/**
	 * Serial. ID, generated
	 */
	private static final long serialVersionUID = 5618898539406697796L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	@Column(name = "id", nullable = false)
	private long id;

	@JsonProperty("name")
	@Column(name = "name", nullable = true)
	private String name;

	@JsonProperty("dateCreated")
	@Column(name = "dateCreated", nullable = false)
	private ZonedDateTime dateCreated;

	@JsonProperty("dateUpdated")
	@Column(name = "dateUpdated", nullable = false)
	private ZonedDateTime dateUpdated;

	protected CommonFields(long id, String name) {
		this.id = id;
		this.name = name;
		this.dateCreated = DateUtils.CurrentUTCDateTime();
		this.dateUpdated = this.dateCreated;
	}

	protected CommonFields() {

	}

	public void UpdateNotify() {
		this.dateUpdated = DateUtils.CurrentUTCDateTime();
	}

	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String target) {
		this.name = target;
		this.UpdateNotify();
	}

	public ZonedDateTime getDateCreated() {
		return this.dateCreated;
	}

	public ZonedDateTime getDateUpdated() {
		return this.dateUpdated;
	}

}
