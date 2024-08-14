package games.sc_riber.FireOnYou.business.concretes;

import games.sc_riber.FireOnYou.business.abstracts.UserService;
import games.sc_riber.FireOnYou.business.requests.CreateUserRequest;
import games.sc_riber.FireOnYou.business.requests.UpdateUserRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllUsersResponse;
import games.sc_riber.FireOnYou.business.responses.GetIdUserResponse;
import games.sc_riber.FireOnYou.business.rules.UserBusinessRules;
import games.sc_riber.FireOnYou.core.utilities.mappers.ModelMapperService;
import games.sc_riber.FireOnYou.dataAccess.abstracts.UserRepository;
import games.sc_riber.FireOnYou.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserBusinessRules userBusinessRules;
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllUsersResponse> getAll() {

        List<User> types = userRepository.findAll();
        List<GetAllUsersResponse> response = types.stream()
                .map(type -> modelMapperService.forResponse().map(type, GetAllUsersResponse.class)).toList();

        return response;
    }

    @Override
    public GetIdUserResponse getById(int id) {
        User type = this.userRepository.findById(id).orElseThrow();
        GetIdUserResponse response = modelMapperService.forResponse().map(type, GetIdUserResponse.class);
        return response;
    }

    @Override
    public int add(CreateUserRequest request) {
        // Business rules
        //this.userBusinessRules.checkIfVehicleTypeIsExists(request.getUserName());
        if (this.userRepository.existsByName(request.getUserName())) {
            User savedUser = this.userRepository.findByName(request.getUserName());
            return savedUser.getId();
        }
        User user = this.modelMapperService.forRequest().map(request, User.class);
        User savedUser = this.userRepository.save(user);
        return savedUser.getId();
    }

    @Override
    public void update(UpdateUserRequest request) {
        User type = this.modelMapperService.forRequest().map(request, User.class);
        this.userRepository.save(type);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }


}
