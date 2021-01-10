package com.gig.atfdemo.user.application.port.in;

import com.gig.atfdemo.user.domain.User;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

public interface GetUserListUseCase {
    GetUserListResponse getUserList(int page);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class GetUserListResponse {

        int status;
        List<User> users;

        public GetUserListResponse(int status, List<User> users) {
            this.status = status;
            this.users = users;
        }
    }
}
