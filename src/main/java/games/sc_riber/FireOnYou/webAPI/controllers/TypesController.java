package games.sc_riber.FireOnYou.webAPI.controllers;

import games.sc_riber.FireOnYou.business.abstracts.TypeService;
import games.sc_riber.FireOnYou.business.requests.CreateVehicleTypeRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllVehicleTypesResponse;
import games.sc_riber.FireOnYou.entities.concretes.VehicleType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Annotation - Bu classın bir controller olduğunu belirtir.
@RequestMapping("/api/types") // Bu controller'ın hangi path'ta çalışacağını belirtir.
@AllArgsConstructor
public class TypesController {

    private TypeService typeService;

    @GetMapping("/getall") // Bu metodun bir GET request'i karşılayacağını belirtir.
    public List<GetAllVehicleTypesResponse> getAll() {
        return typeService.getAll();
    }

    @PostMapping("/add") // Bu metodun bir GET request'i karşılayacağını belirtir.
    public void add(CreateVehicleTypeRequest request) {
        this.typeService.add(request);
    }

}
