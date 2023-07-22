package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Dto.FlowerDto;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Flow;

@RestController
@RequestMapping("/flower")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;


    @GetMapping("/clientAllFlowers")
    public ResponseEntity<List<FlowerDto>> getAll(){

        if(flowerService.getAllFlowers().isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(flowerService.getAllFlowers());
        }
    }

    @GetMapping("/clientGetOneFlower/{id}")
    public ResponseEntity<FlowerDto> getOne(@PathVariable("id") Integer pk_ID){

        if(flowerService.getFlower(pk_ID) != null){
            return ResponseEntity.ok(flowerService.getFlower(pk_ID));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/clientPostFlower")
    public void add(@RequestBody FlowerDto flowerDto){
        flowerService.postFlower(flowerDto);
    }

    @DeleteMapping("clientDeleteFlower/{id}")
    public void delete(@PathVariable("id") Integer id){

            flowerService.deleteFlower(id);
    }
}
