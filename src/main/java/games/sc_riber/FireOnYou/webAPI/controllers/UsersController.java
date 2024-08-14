package games.sc_riber.FireOnYou.webAPI.controllers;

import games.sc_riber.FireOnYou.business.abstracts.UserService;
import games.sc_riber.FireOnYou.business.requests.CreateUserRequest;
import games.sc_riber.FireOnYou.business.requests.UpdateUserRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllUsersResponse;
import games.sc_riber.FireOnYou.business.responses.GetIdUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Annotation - Bu classın bir controller olduğunu belirtir.
@RequestMapping("/api/users") // Bu controller'ın hangi path'ta çalışacağını belirtir.
@AllArgsConstructor
public class UsersController {

    private UserService userService;

    @GetMapping() // Bu metodun bir GET request'i karşılayacağını belirtir.
    public List<GetAllUsersResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}") // Bu metodun bir GET request'i karşılayacağını belirtir.
    public GetIdUserResponse getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED) // Bu metodun bir GET request'i karşılayacağını belirtir.
    public int add(@RequestBody() @Valid() CreateUserRequest request) {
        return this.userService.add(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateUserRequest request) {
        this.userService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.userService.delete(id);
    }

}
