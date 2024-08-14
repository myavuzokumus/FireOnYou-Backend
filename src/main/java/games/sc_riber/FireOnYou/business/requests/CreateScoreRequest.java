package games.sc_riber.FireOnYou.business.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateScoreRequest {
    @NotNull
    private int score;

    @NotNull
    private int userId;
}