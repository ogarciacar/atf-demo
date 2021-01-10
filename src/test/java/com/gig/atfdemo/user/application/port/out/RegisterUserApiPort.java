package com.gig.atfdemo.user.application.port.out;

import com.gig.atfdemo.user.application.port.in.RegisterUserUseCase;

public interface RegisterUserApiPort {
    RegisterUserUseCase.RegisterUserResponse register(String email, String password);
}
