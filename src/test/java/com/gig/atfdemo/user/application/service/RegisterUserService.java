package com.gig.atfdemo.user.application.service;

import com.gig.atfdemo.user.application.port.in.RegisterUserUseCase;
import com.gig.atfdemo.user.application.port.out.RegisterUserApiPort;
import io.cucumber.spring.ScenarioScope;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {

    private final RegisterUserApiPort registerUserApiPort;

    @Override
    public RegisterUserResponse registerUser(RegisterUserCommand registerUserCommand) {
        return registerUserApiPort.register(registerUserCommand.getEmail(), registerUserCommand.getPassword());
    }
}
