package com.jobpostingapp.jobpostingapp.Repository;

import com.jobpostingapp.jobpostingapp.Models.JobListing;
import com.jobpostingapp.jobpostingapp.Services.JobListingService;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.JobName;
import java.util.List;
import java.util.Optional;

@Repository
public interface JobListingRepository extends MongoRepository<JobListing, Long> {
    @Override
    List<JobListing> findAll();

     JobListing findJobListingById(@NonNull Long id);
}
