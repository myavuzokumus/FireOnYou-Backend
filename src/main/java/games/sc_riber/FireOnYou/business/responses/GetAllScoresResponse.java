package games.sc_riber.FireOnYou.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllScoresResponse {

    private int id;
    private int score;
    private String userName;

}
