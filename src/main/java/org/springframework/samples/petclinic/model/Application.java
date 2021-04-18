package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "applications")
public class Application  extends BaseEntity{
	
	@NotBlank
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "adoption_id")
	private Adoption adoption;
	
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

}
