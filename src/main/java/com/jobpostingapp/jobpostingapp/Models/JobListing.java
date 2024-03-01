package com.jobpostingapp.jobpostingapp.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@AllArgsConstructor
@Builder
@Document("jobListing")
public class JobListing {

    @Id
    @NonNull
    private Long id;

    private String title;
    private String description;
    private String location;
    private Date deadline;
    private String contactPhone;
    private String contactEmail;

}
