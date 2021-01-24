package by.alex.certws.domain;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import by.alex.certws.utils.DateUtils;

public class CommonFields {
	@JsonProperty("id")
	private long Id;

	@JsonProperty("name")
	private String Name;

	@JsonProperty("dateCreated")
	private ZonedDateTime DateCreated;

	@JsonProperty("lastUpdated")
	private ZonedDateTime DateUpdated;

	public CommonFields(long Id, String Name) {
		this.Id = Id;
		this.Name = Name;
		this.DateCreated = DateUtils.CurrentUTCDateTime();
		this.DateUpdated = this.DateCreated;
	}

	public CommonFields() {
		// TODO Auto-generated constructor stub
	}

	public void UpdateNotify() {
		this.DateUpdated = DateUtils.CurrentUTCDateTime();
	}

	public long getId() {
		return this.Id;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String target) {
		this.Name = target;
		this.UpdateNotify();
	}

	public ZonedDateTime getDateCreated() {
		return this.DateCreated;
	}

	public ZonedDateTime getDateUpdated() {
		return this.DateUpdated;
	}

}
