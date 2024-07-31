package games.sc_riber.FireOnYou.business.concretes;

import games.sc_riber.FireOnYou.business.abstracts.ModelService;
import games.sc_riber.FireOnYou.business.requests.CreateModelRequest;
import games.sc_riber.FireOnYou.business.responses.GetAllModelsResponse;
import games.sc_riber.FireOnYou.core.utilities.mappers.ModelMapperService;
import games.sc_riber.FireOnYou.dataAccess.abstracts.ModelRepository;
import games.sc_riber.FireOnYou.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> response = models.stream()
                .map(type -> this.modelMapperService.forResponse().map(type, GetAllModelsResponse.class)).toList();

        return response;
    }

    @Override
    public void add(CreateModelRequest request) {
        Model model = this.modelMapperService.forRequest().map(request, Model.class);
        this.modelRepository.save(model);
    }
}
