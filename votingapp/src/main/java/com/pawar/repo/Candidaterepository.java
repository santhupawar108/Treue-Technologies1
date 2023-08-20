package com.pawar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawar.model.Candidate;

public interface Candidaterepository extends JpaRepository<Candidate, Long> {

}
