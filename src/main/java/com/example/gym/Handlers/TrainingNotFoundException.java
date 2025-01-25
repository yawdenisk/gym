package com.example.gym.Handlers;

public class TrainingNotFoundException extends CustomException {
    @Override
    public String getMessage() {
        return "Training not found";
    }

    @Override
    public int getCode() {
        return 404;
    }

    @Override
    public String getDescription() {
        return "Training not found";
    }
}
