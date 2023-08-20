package com.pawar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	

    @ManyToOne
    private User user;
    
    @ManyToOne
    private Candidate candidate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", user=" + user + ", candidate=" + candidate + "]";
	}
    
    
    
    
	
}
