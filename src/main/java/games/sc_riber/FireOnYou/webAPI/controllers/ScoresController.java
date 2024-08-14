package games.sc_riber.FireOnYou.webAPI.controllers;

import games.sc_riber.FireOnYou.business.abstracts.ScoreService;
import games.sc_riber.FireOnYou.business.requests.CreateScoreRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllScoresResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Annotation - Bu classın bir controller olduğunu belirtir.
@RequestMapping("/api/scores") // Bu controller'ın hangi path'ta çalışacağını belirtir.
@AllArgsConstructor
public class ScoresController {

    private ScoreService scoreService;

    @GetMapping
    public List<GetAllScoresResponse> getAll() {
        return this.scoreService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED) // Bu metodun bir GET request'i karşılayacağını belirtir.
    public void add(@RequestBody @Valid CreateScoreRequest request) {
        this.scoreService.add(request);
    }

}
