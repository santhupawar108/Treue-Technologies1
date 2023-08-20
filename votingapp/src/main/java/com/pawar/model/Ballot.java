package com.pawar.model;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import com.pawar.model.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
//@Entity
public class Ballot{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private User user;
	
	private String name;
	
	//@Column(nullable = false)
	///private LocalDate startDate;
	
	//@Column(nullable = false)
	//private LocalDate endDate;
	
	@OneToMany(mappedBy = "ballot")
	private Set<Candidate> candidate= new HashSet<>();
	
	
	@OneToMany(mappedBy = "ballot")
	private Set<Vote> votes= new HashSet<>();


	public Ballot() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	

	public Ballot(long id, User user, String name,  Set<Candidate> candidate,
			Set<Vote> votes) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.candidate = candidate;
		this.votes = votes;
	}






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





	public Set<Candidate> getCandidate() {
		return candidate;
	}


	public void setCandidate(Set<Candidate> candidate) {
		this.candidate = candidate;
	}


	public Set<Vote> getVotes() {
		return votes;
	}


	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}






	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	@Override
	public String toString() {
		return "Ballot [id=" + id + ", user=" + user + ", name=" + name + ", candidate=" + candidate + ", votes="
				+ votes + "]";
	}







	
	

	
	
	

}
