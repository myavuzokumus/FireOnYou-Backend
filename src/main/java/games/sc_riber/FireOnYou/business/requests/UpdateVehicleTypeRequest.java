package games.sc_riber.FireOnYou.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVehicleTypeRequest {
    private int id;
    private String vehicleName;

}
