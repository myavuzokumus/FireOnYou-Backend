package games.sc_riber.FireOnYou.business.concretes;

import games.sc_riber.FireOnYou.business.abstracts.ScoreService;
import games.sc_riber.FireOnYou.business.requests.CreateScoreRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllScoresResponse;
import games.sc_riber.FireOnYou.core.utilities.mappers.ModelMapperService;
import games.sc_riber.FireOnYou.dataAccess.abstracts.ScoreRepository;
import games.sc_riber.FireOnYou.entities.concretes.Score;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScoreManager implements ScoreService {

    private ScoreRepository scoreRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllScoresResponse> getAll() {
        List<Score> scores = scoreRepository.findAll();
        List<GetAllScoresResponse> response = scores.stream()
                .map(type -> this.modelMapperService.forResponse().map(type, GetAllScoresResponse.class)).toList();

        return response;
    }

    @Override
    public void add(CreateScoreRequest request) {

        Score score = this.modelMapperService.forRequest().map(request, Score.class);
        this.scoreRepository.save(score);
    }
}
