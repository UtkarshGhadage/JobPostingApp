package com.jobpostingapp.jobpostingapp.Repository;

import com.jobpostingapp.jobpostingapp.Models.Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends MongoRepository<Application, Long> {

    public List<Application> findAllByJobListing(Long id);
}
