package com.gig.atfdemo.user.application.service;

import com.gig.atfdemo.user.application.port.in.GetUserListUseCase;
import com.gig.atfdemo.user.application.port.out.GetUserListApiPort;
import io.cucumber.spring.ScenarioScope;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
@RequiredArgsConstructor
public class GetUserListService implements GetUserListUseCase {

    private final GetUserListApiPort getUserListApiPort;

    @Override
    public GetUserListResponse getUserList(int page) {
        return getUserListApiPort.listUsers(page);
    }
}
