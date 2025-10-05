package com.turkcell.library_cqrs.domain.member.model;

import java.util.Objects;

public record Password(String password) {
    public Password{
        Objects.requireNonNull(password,"Password cannot be null");

        if (password.length() < 8)
            throw new IllegalArgumentException("Password must be at least 8 characters");
        if (!password.matches(".*[A-Z].*"))
            throw new IllegalArgumentException("Password must contain uppercase letter");
        if (!password.matches(".*\\W.*"))
            throw new IllegalArgumentException("Password must contain special character");
    }
}
