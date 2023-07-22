package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Domain.Flower;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Dto.FlowerDto;

import java.util.List;

public interface IFlowerService {

    public List<FlowerDto> getAllFlowers();

    public FlowerDto getFlower(Integer pk_ID);
}
