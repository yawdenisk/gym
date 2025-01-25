package com.example.gym.Handlers;

public class GymNotFoundException extends CustomException {
    @Override
    public String getMessage() {
        return "Gym not found";
    }

    @Override
    public int getCode() {
        return 404;
    }

    @Override
    public String getDescription() {
        return "Gym not found";
    }
}
