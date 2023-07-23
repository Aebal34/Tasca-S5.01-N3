package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Domain.Flower;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Dto.FlowerDto;

import java.util.List;

public interface IFlowerService {

    List<FlowerDto> getAllFlowers();

    FlowerDto getFlower(Integer pk_ID);

    void postFlower(FlowerDto flowerDto);

    void deleteFlower(Integer pk_ID);

    void updateFlower(Integer pk_ID, String name, String country);
}
