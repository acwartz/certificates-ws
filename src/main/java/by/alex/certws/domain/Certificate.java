package by.alex.certws.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize
@Entity
@Table(name = "certificates")
public class Certificate extends CommonFields {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3444580092047125843L;
	
	@JsonProperty("content")
	private String content;

	@JsonProperty("tags")
	@OneToMany(targetEntity=Tag.class, mappedBy="id",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	private List<Tag> tags = new ArrayList<>();

	public Certificate() {
		super();
	}

	public Certificate(long certId, String certName) {
		super(certId, certName);
	}

	public Certificate(long certId, String certName, String content) {
		super(certId, certName);
		this.setContent(content);
	}

	public Certificate(long id, String name, String content, String[] tags) {
		super(id, name);
		this.setContent(content);
		for (String tag : tags) {
			addTag(tag);
		}
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String target) {
		this.content = target;
		this.UpdateNotify();
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public Optional<Tag> findTagByName(String name) {
		return this.tags.stream().filter(Objects::nonNull)
				.filter(t -> (Objects.nonNull(t.getName()) && t.getName().compareTo(name) == 0)).findAny();
	}

	public long addTag(String tagName) {
		Optional<Tag> match = this.findTagByName(tagName);
		if (match.isPresent()) {
			return match.get().getId();
			// throw new ETagExistsException();
		} else {
			return 0;
		}
	}

	public Boolean removeTag(String target) {
		Optional<Tag> match = this.findTagByName(target);
		if (match.isPresent()) {
			return this.tags.remove(match.get());
		} else {
			// TODO: MUST throw exception
			return false;
		}
	}

}
