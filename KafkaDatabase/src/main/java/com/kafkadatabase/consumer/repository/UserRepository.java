package com.kafkadatabase.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafkadatabase.consumer.common.User;

@Repository
public interface UserRepository extends JpaRepository<User , Integer>{


	
}




