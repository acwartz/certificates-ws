package by.alex.certws.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tags")
public class Tag extends CommonFields {
	
	@JsonProperty("references")
	@OneToMany(targetEntity=Certificate.class, mappedBy="id",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	private List<Certificate> refs = new ArrayList<>();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2535451222904563266L;

	public Tag() {
		super();
	}

	public Tag(long id, String name) {
		super(id, name);
	}
	
	List<Certificate> getReferences() {
		return this.refs;
	}

}
