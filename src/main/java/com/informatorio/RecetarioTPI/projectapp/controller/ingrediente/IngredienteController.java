package com.informatorio.RecetarioTPI.projectapp.controller.ingrediente;

import com.informatorio.RecetarioTPI.projectapp.dto.ingrediente.IngredienteDto;
import com.informatorio.RecetarioTPI.projectapp.service.ingrediente.IngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/ingrediente")
public class IngredienteController {


    private final IngredienteService  ingredienteService;

    @GetMapping()
    public List<IngredienteDto> getIngredientes(
            @RequestParam(name = "idReceta") UUID idReceta,
            @RequestParam(required = false, name = "idPaso") UUID idPaso) {

        if (idPaso != null) {
            return ingredienteService.getIngredientesByPaso(idPaso);
        } else {
            return ingredienteService.getIngredientesByReceta(idReceta);
        }
    }
}
