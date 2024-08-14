package games.sc_riber.FireOnYou.business.abstracts;

import games.sc_riber.FireOnYou.business.requests.CreateScoreRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllScoresResponse;

import java.util.List;

public interface ScoreService {

    List<GetAllScoresResponse> getAll();
    void add(CreateScoreRequest request);

}
