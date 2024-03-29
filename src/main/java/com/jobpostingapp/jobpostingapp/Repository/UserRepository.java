package com.jobpostingapp.jobpostingapp.Repository;

import com.jobpostingapp.jobpostingapp.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {


    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);
}
