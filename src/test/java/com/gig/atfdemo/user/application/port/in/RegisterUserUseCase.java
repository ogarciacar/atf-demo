package com.gig.atfdemo.user.application.port.in;

import lombok.EqualsAndHashCode;
import lombok.Value;

public interface RegisterUserUseCase {

    RegisterUserResponse registerUser(RegisterUserCommand registerUserCommand);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class RegisterUserCommand {

        String email;
        String password;

        public RegisterUserCommand(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    class RegisterUserResponse {

        int status;
        String token;
        String error;

        public RegisterUserResponse(int status, String token, String error) {
            this.status = status;
            this.token = token;
            this.error = error;
        }
    }
}
