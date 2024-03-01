package com.jobpostingapp.jobpostingapp.Models;

import com.jobpostingapp.jobpostingapp.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@Document("Users")
public class User {

    @Id
    @NonNull
    private Long id;
    private String email;
    private String password;
    private Role role;
}
