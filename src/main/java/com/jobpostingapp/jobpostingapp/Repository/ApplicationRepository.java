package com.jobpostingapp.jobpostingapp.Repository;

import com.jobpostingapp.jobpostingapp.Models.Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends MongoRepository<Application, Long> {

    public List<Application> findByJobId(Long jobId);
}
