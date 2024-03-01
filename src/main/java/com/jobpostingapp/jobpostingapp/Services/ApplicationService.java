package com.jobpostingapp.jobpostingapp.Services;

import com.jobpostingapp.jobpostingapp.CustomExceptions.JobListingNotFoundException;
import com.jobpostingapp.jobpostingapp.Models.Application;
import com.jobpostingapp.jobpostingapp.Models.JobListing;
import com.jobpostingapp.jobpostingapp.Models.User;
import com.jobpostingapp.jobpostingapp.Repository.ApplicationRepository;
import com.jobpostingapp.jobpostingapp.Repository.JobListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private JobListingRepository jobListingRepository;

    public void applyForJob(Long listingId, User user) throws JobListingNotFoundException {
        JobListing jobListing = jobListingRepository.findJobListingById(listingId);
        if(jobListing == null){
            throw new JobListingNotFoundException("Job Not Found");
        }

        Application application = Application.builder()
                .jobListing(jobListing)
                .applicant(user)
                .build();

        applicationRepository.save(application);
    }

    public List<Application> getApplications(Long listingId){
        JobListing jobListing = jobListingRepository.findJobListingById(listingId);
        if(jobListing == null){
            throw new JobListingNotFoundException("Job Not Found");
        }
        return applicationRepository.findByJobId(listingId);
    }
}
