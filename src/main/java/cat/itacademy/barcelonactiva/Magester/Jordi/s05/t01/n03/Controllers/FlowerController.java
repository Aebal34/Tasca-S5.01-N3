package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Dto.FlowerDto;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;


    @GetMapping("/clientAllFlowers")
    public ResponseEntity<List<FlowerDto>> getAll(){

        System.out.println(flowerService.getAllFlowers());

        if(flowerService.getAllFlowers().isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(flowerService.getAllFlowers());
        }
    }
}
