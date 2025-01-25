package com.example.gym.Handlers;

public class CoachNotFoundException extends CustomException {
    @Override
    public String getMessage() {
        return "Coach not found";
    }

    @Override
    public int getCode() {
        return 404;
    }

    @Override
    public String getDescription() {
        return "Coach not found";
    }
}
