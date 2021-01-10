package com.gig.atfdemo.user.application.port.out;

import static com.gig.atfdemo.user.application.port.in.GetUserListUseCase.*;

public interface GetUserListApiPort {
    GetUserListResponse listUsers(int page);
}
