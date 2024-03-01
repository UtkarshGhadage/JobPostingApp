package com.jobpostingapp.jobpostingapp.Services;

import com.jobpostingapp.jobpostingapp.Models.JobListing;
import com.jobpostingapp.jobpostingapp.Models.User;
import com.jobpostingapp.jobpostingapp.Repository.JobListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobListingService {

    @Autowired
    private JobListingRepository jobListingRepository;

    public JobListing createJobListing(JobListing jobListing) {
        return jobListingRepository.save(jobListing);
    }

    public JobListing getJobListing(Long jobId) {
        return jobListingRepository.findJobListingById(jobId);
    }

    public List<JobListing> getAllJobs(){
        return jobListingRepository.findAll();
    }
}
