package br.com.acordocerto.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Register")
public class RegisteredData {

	
	@Id
	@GeneratedValue
	@Column(name="id", nullable = false)
	private Long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="agerange")
	private String ageRange;
	
	@Column(name="websitemail")
	private String websitemail;

	public String getWebsitemail() {
		return websitemail;
	}

	public void setWebsitemail(String websitemail) {
		this.websitemail = websitemail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
}
