package com.ifc.InfoCuySB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifc.InfoCuySB.Model.Province;
import com.ifc.InfoCuySB.Services.ProvinceService;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping
    public List<Province> getAllProvinces() {
        return provinceService.getAllProvinces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> getProvinceById(@PathVariable Long id) {
        Province province = provinceService.getProvinceById(id);
        if (province != null) {
            return ResponseEntity.ok(province);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Province> createProvince(@RequestBody Province province) {
        if (province.getProvinceName() == null || province.getProvinceName().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Province savedProvince = provinceService.createProvince(province);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProvince);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Province> updateProvince(@PathVariable Long id, @RequestBody Province provinceDetails) {
        Province updatedProvince = provinceService.updateProvince(id, provinceDetails);
        if (updatedProvince != null) {
            return ResponseEntity.ok(updatedProvince);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvince(@PathVariable Long id) {
        provinceService.deleteProvince(id);
        return ResponseEntity.noContent().build();
    }
}