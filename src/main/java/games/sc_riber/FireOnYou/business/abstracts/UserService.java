package games.sc_riber.FireOnYou.business.abstracts;

import games.sc_riber.FireOnYou.business.requests.CreateUserRequest;
import games.sc_riber.FireOnYou.business.requests.UpdateUserRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllUsersResponse;
import games.sc_riber.FireOnYou.business.responses.GetIdUserResponse;

import java.util.List;

public interface UserService {

    List<GetAllUsersResponse> getAll();

    GetIdUserResponse getById(int id);
    int add(CreateUserRequest request);
    void update(UpdateUserRequest request);
    void delete(int id);
}
