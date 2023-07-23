package cat.itacademy.barcelonactiva.Magester.Jordi.s05.t01.n03.Model.Domain;

import io.swagger.v3.oas.annotations.media.Schema;

public class Flower {

    @Schema(name = "Flower id", example = "1")
    private Integer pk_ID;

    @Schema(name = "Flower name", example = "Sunflower")
    private String name;

    @Schema(name = "Flower's country of procedence", example = "Italy")
    private String country;
}
