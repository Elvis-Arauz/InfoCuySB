package com.ifc.InfoCuySB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifc.InfoCuySB.Model.District;
import com.ifc.InfoCuySB.Services.DistrictService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping
    public List<District> getAllDistricts() {
        return districtService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable Long id) {
        Optional<District> district = districtService.findById(id);
        return district.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public District createDistrict(@RequestBody District district) {
        return districtService.save(district);
    }

    @PutMapping("/{id}")
    public ResponseEntity<District> updateDistrict(@PathVariable Long id, @RequestBody District districtDetails) {
        Optional<District> district = districtService.findById(id);

        if (district.isPresent()) {
            District updatedDistrict = district.get();
            updatedDistrict.setDistrictName(districtDetails.getDistrictName());
            updatedDistrict.setUpdatedAt(districtDetails.getUpdatedAt());
            return ResponseEntity.ok(districtService.save(updatedDistrict));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Long id) {
        if (districtService.findById(id).isPresent()) {
            districtService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}