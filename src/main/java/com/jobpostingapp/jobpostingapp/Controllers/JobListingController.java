package com.jobpostingapp.jobpostingapp.Controllers;

import com.jobpostingapp.jobpostingapp.Models.JobListing;
import com.jobpostingapp.jobpostingapp.Services.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joblistings")
public class JobListingController {

    @Autowired
    private JobListingService jobListingService;

    @PostMapping
    public ResponseEntity<JobListing> createJobListing(@RequestBody JobListing jobListing) {
        JobListing createdJobListing = jobListingService.createJobListing(jobListing);
        return ResponseEntity.ok(createdJobListing);
    }

    @GetMapping
    public ResponseEntity<List<JobListing>> getAllJobListings() {
        List<JobListing> jobListings = jobListingService.getAllJobs();
        return ResponseEntity.ok(jobListings);
    }
}
