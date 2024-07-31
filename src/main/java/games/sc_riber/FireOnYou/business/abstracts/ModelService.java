package games.sc_riber.FireOnYou.business.abstracts;

import games.sc_riber.FireOnYou.business.requests.CreateModelRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {

    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest request);

}
