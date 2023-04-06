package com.project_one.apps.user.registration.resources.model;

public record UserRegistrationRequestSpec(
    String email,
    String password,
    String fullName
) {}