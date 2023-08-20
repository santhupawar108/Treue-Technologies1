package com.pawar.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String name;
	
	private float percentage;
	

    @OneToMany(mappedBy = "candidate")
    private Set<Vote> votes;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Vote> getVotes() {
		return votes;
	}


	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}


	public float getPercentage() {
		return percentage;
	}


	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

    
    
    
}
