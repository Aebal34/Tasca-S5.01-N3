package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Domain.Flower;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Dto.FlowerDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class FlowerService implements IFlowerService{

    private final WebClient webClient;

    public FlowerService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9001").build();
    }

    @Override
    public List<FlowerDto> getAllFlowers() {
        return webClient.get()
                .uri("/flowers/getAll")
                .retrieve()
                .bodyToFlux(FlowerDto.class)
                .collectList()
                .block();
    }
}
