package com.jobpostingapp.jobpostingapp.Controllers;

import com.jobpostingapp.jobpostingapp.CustomExceptions.JobListingNotFoundException;
import com.jobpostingapp.jobpostingapp.Models.JobListing;
import com.jobpostingapp.jobpostingapp.Models.User;
import com.jobpostingapp.jobpostingapp.Services.ApplicationService;
import com.jobpostingapp.jobpostingapp.Services.JobListingService;
import com.jobpostingapp.jobpostingapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private JobListingService jobListingService;

    @Autowired
    private UserService userService;

    @PostMapping("/{listingId}/apply")
    public String applyForJob(@PathVariable Long listingId, User user) throws JobListingNotFoundException {
        User applicant = userService.getUser(user.getId());
        JobListing jobListing = jobListingService.getJobListing(listingId);
        if(jobListing == null){
            throw new JobListingNotFoundException("Job Not Found");
        }
        applicationService.applyForJob(jobListing.getId(), applicant);

        return "Applied Successfully";
    }
}
