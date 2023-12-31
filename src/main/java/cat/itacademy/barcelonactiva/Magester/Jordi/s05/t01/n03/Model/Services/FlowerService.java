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

    @Override
    public FlowerDto getFlower(Integer pk_ID) {
        return webClient.get()
                .uri("/flowers/getOne/{id}", pk_ID)
                .retrieve()
                .bodyToMono(FlowerDto.class)
                .block();
    }

    @Override
    public void postFlower(FlowerDto flowerDto) {

        webClient.post()
                .uri("/flowers/add")
                .bodyValue(flowerDto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void deleteFlower(Integer pk_ID) {
        webClient.delete()
                .uri("/flowers/delete/{id}", pk_ID)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void updateFlower(Integer id, String name, String country) {

        FlowerDto flowerDto = getFlower(id);
        if (flowerDto != null){
            String newName = "";
            String newCountry = "";

            if(name != null){
                newName = "&name="+name;
            }
            if(country != null){
                newCountry = "&country="+country;
            }

            webClient.put()
                    .uri("/flowers/update?id="+id+newName+newCountry)
                    .retrieve()
                    .toBodilessEntity()
                    .block();
        }
    }

}
