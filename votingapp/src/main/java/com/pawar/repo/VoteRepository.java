package com.pawar.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pawar.model.Candidate;
import com.pawar.model.User;
import com.pawar.model.Vote;

import jakarta.persistence.Tuple;

public interface VoteRepository extends JpaRepository<Vote, Long> {

	boolean existsByUser(User user);

	boolean existsByUser(Optional<User> user);


	Vote findByUser(Optional<User> user);

	Candidate findByCandidate(Optional<Candidate> candidate);

	List<Vote> findByCandidate(Candidate theCandidate);

	

	
	
	

	

}
