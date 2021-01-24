package by.alex.certws.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Certificate extends CommonFields {

	@JsonProperty("content")
	private String Content;

	@JsonProperty("tags")
	private ArrayList<Tag> Tags;

	public Certificate() {
		super();
		this.Tags = new ArrayList<Tag>();
	}

	public Certificate(long Id, String Name) {
		super(Id, Name);
		this.Tags = new ArrayList<Tag>(); // TODO: Avoid code duplication..
	}

	public Certificate(long Id, String Name, String Content) {
		super(Id, Name);
		this.Tags = new ArrayList<Tag>(); // TODO: Avoid code duplication..
		this.setContent(Content);
	}

	public Certificate(long Id, String Name, String Content, String[] Tags) {
		super(Id, Name);
		this.Tags = new ArrayList<Tag>(); // TODO: Avoid code duplication..
		this.setContent(Content);
		for (String tag : Tags) {
			addTag(tag);
		}
	}

	public String getContent() {
		return this.Content;
	}

	public void setContent(String target) {
		this.Content = target;
		this.UpdateNotify();
	}

	public ArrayList<Tag> getTags() {
		return this.Tags;
	}

	public Optional<Tag> findTagByName(String name) {
		Collection<Tag> list = (Collection<Tag>) this.Tags;
		return list.stream().filter(Objects::nonNull)
				.filter(t -> (Objects.nonNull(t.getName()) && t.getName().compareTo(name) == 0)).findAny();
	}

	public long addTag(String TagName) {
		Optional<Tag> match = this.findTagByName(TagName);
		if (match.isPresent()) {
			return match.get().getId();
			// throw new ETagExistsException();
		} else {
			return 0;
		}
	}

	public Boolean removeTag(String Target) {
		Optional<Tag> match = this.findTagByName(Target);
		if (match.isPresent()) {
			return this.Tags.remove(match.get());
		} else {
			// TODO: MUST throw exception
			return false;
		}
	}

}
