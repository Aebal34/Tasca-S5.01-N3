package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Domain.Flower;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Dto.FlowerDto;
import cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Services.FlowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Gets all flowers from database.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Flowers successfully retrieved.",
                            content = {@Content(mediaType = "application/json",
                                        schema = @Schema(implementation = List.class))
                            }),
            @ApiResponse(responseCode = "404", description = "No flower has been found.",
                            content = @Content)
    })
    @GetMapping("/clientAllFlowers")
    public ResponseEntity<List<FlowerDto>> getAll(){

        if(flowerService.getAllFlowers().isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(flowerService.getAllFlowers());
        }
    }

    @Operation(summary = "Get a flower by it's ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Flower found.",
                            content = {@Content(mediaType = "application/json",
                                        schema = @Schema(implementation = FlowerDto.class))
                            }),
            @ApiResponse(responseCode = "404", description = "Flower not found.",
                            content = @Content),
            @ApiResponse(responseCode = "400", description = "Id not valid.",
                            content = @Content)
    })
    @GetMapping("/clientGetOneFlower/{id}")
    public ResponseEntity<FlowerDto> getOne(@PathVariable("id") Integer pk_ID){

        if(flowerService.getFlower(pk_ID) != null){
            return ResponseEntity.ok(flowerService.getFlower(pk_ID));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Post a flower into database.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Flowers successfully saved into database.",
                            content = {@Content(mediaType = "application/json",
                                        schema = @Schema(implementation = Flower.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request, information provided is wrong.",
                            content = @Content)
    })
    @PostMapping("/clientPostFlower")
    public void add(@RequestBody FlowerDto flowerDto){
        flowerService.postFlower(flowerDto);
    }

    @Operation(summary = "Deletes a Flower from database.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Flower successfully deleted",
                            content = {@Content(mediaType = "application/json",
                                        schema = @Schema(implementation = Flower.class))}),
            @ApiResponse(responseCode = "404", description = "Flower not found",
                            content = @Content),
            @ApiResponse(responseCode = "400", description = "Wrong id format.",
                            content = @Content)
    })
    @DeleteMapping("clientDeleteFlower/{id}")
    public void delete(@PathVariable("id") Integer id){

            flowerService.deleteFlower(id);
    }

    @Operation(summary = "Edits a Flower from database.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Flower successfully edited",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Flower.class))}),
            @ApiResponse(responseCode = "404", description = "Flower not found",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Wrong provided information.",
                    content = @Content)
    })
    @PutMapping("clientUpdateFlower")
    public void update(@RequestParam Integer id, @RequestParam(required = false) String name, @RequestParam(required = false) String country){

        flowerService.updateFlower(id, name, country);
    }
}
