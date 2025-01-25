package com.example.gym.Handlers;

public class UserNotFoundException extends CustomException {
    @Override
    public String getMessage() {
        return "User not found";
    }

    @Override
    public int getCode() {
        return 404;
    }

    @Override
    public String getDescription() {
        return "User not found";
    }
}
