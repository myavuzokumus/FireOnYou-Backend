package games.sc_riber.FireOnYou.webAPI.controllers;

import games.sc_riber.FireOnYou.business.abstracts.ModelService;
import games.sc_riber.FireOnYou.business.requests.CreateModelRequest;
import games.sc_riber.FireOnYou.business.requests.CreateVehicleTypeRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllModelsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Annotation - Bu classın bir controller olduğunu belirtir.
@RequestMapping("/api/models") // Bu controller'ın hangi path'ta çalışacağını belirtir.
@AllArgsConstructor
public class ModelsController {

    private ModelService modelService;

    @GetMapping
    public List<GetAllModelsResponse> getAll() {
        return this.modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED) // Bu metodun bir GET request'i karşılayacağını belirtir.
    public void add(@RequestBody @Valid CreateModelRequest request) {
        this.modelService.add(request);
    }

}
