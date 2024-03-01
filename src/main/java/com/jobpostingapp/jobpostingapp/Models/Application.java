package com.jobpostingapp.jobpostingapp.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @NonNull
    private Long id;
    private JobListing jobListing;
    private User applicant;
}
