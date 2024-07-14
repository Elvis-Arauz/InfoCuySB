package com.ifc.InfoCuySB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifc.InfoCuySB.Model.TouristAttraction;
import com.ifc.InfoCuySB.Services.TouristAttractionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tourist-attractions")
public class TouristAttractionController {

    @Autowired
    private TouristAttractionService service;

    @GetMapping
    public List<TouristAttraction> getAllTouristAttractions() {
        return service.getAllTouristAttractions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TouristAttraction> getTouristAttractionById(@PathVariable(value = "id") Long id) {
        Optional<TouristAttraction> touristAttraction = service.getTouristAttractionById(id);
        return touristAttraction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TouristAttraction createTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        return service.createTouristAttraction(touristAttraction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@PathVariable(value = "id") Long id, @RequestBody TouristAttraction touristAttractionDetails) {
        TouristAttraction updatedTouristAttraction = service.updateTouristAttraction(id, touristAttractionDetails);
        return ResponseEntity.ok(updatedTouristAttraction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTouristAttraction(@PathVariable(value = "id") Long id) {
        service.deleteTouristAttraction(id);
        return ResponseEntity.noContent().build();
    }
}
