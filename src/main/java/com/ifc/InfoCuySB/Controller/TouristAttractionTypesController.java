package com.ifc.InfoCuySB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ifc.InfoCuySB.Model.TouristAttractionTypes;
import com.ifc.InfoCuySB.Services.TouristAttractionTypesService;

import java.util.List;

@RestController
@RequestMapping("/api/touristattractiontypes")
public class TouristAttractionTypesController {

    private final TouristAttractionTypesService touristAttractionTypesService;

    @Autowired
    public TouristAttractionTypesController(TouristAttractionTypesService touristAttractionTypesService) {
        this.touristAttractionTypesService = touristAttractionTypesService;
    }

    @GetMapping
    public ResponseEntity<List<TouristAttractionTypes>> getAllTouristAttractionTypes() {
        return ResponseEntity.ok(touristAttractionTypesService.getAllTouristAttractionTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TouristAttractionTypes> getTouristAttractionTypeById(@PathVariable Long id) {
        return touristAttractionTypesService.getTouristAttractionTypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TouristAttractionTypes> createTouristAttractionType(@RequestBody TouristAttractionTypes touristAttractionType) {
        TouristAttractionTypes createdTouristAttractionType = touristAttractionTypesService.createTouristAttractionType(touristAttractionType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTouristAttractionType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TouristAttractionTypes> updateTouristAttractionType(@PathVariable Long id, @RequestBody TouristAttractionTypes touristAttractionType) {
        TouristAttractionTypes updatedTouristAttractionType = touristAttractionTypesService.updateTouristAttractionType(id, touristAttractionType);
        return ResponseEntity.ok(updatedTouristAttractionType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTouristAttractionType(@PathVariable Long id) {
        touristAttractionTypesService.deleteTouristAttractionType(id);
        return ResponseEntity.noContent().build();
    }
}
