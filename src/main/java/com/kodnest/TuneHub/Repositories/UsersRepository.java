package com.kodnest.TuneHub.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.TuneHub.Entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	public Users findByEmail(String email);
}
