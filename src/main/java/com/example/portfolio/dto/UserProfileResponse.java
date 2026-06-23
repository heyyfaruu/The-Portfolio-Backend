package com.example.portfolio.dto;

import com.example.portfolio.entity.User;

public class UserProfileResponse {

    private Long id;
    private String fullName;
    private String email;
    private String companyName;
    private String designation;

    public UserProfileResponse(
            Long id,
            String fullName,
            String email,
            String companyName,
            String designation) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.companyName = companyName;
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDesignation() {
        return designation;
    }
}