package com.ifc.InfoCuySB.Controller;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{provinceId}")
    public Province getProvinceById(@PathVariable Long provinceId) {
        return provinceService.getProvinceById(provinceId);
    }

    @PostMapping
    public Province createProvince(@RequestBody Province province) {
        return provinceService.createProvince(province);
    }

    @PutMapping("/{provinceId}")
    public Province updateProvince(@PathVariable Long provinceId, @RequestBody Province provinceDetails) {
        return provinceService.updateProvince(provinceId, provinceDetails);
    }

    @DeleteMapping("/{provinceId}")
    public void deleteProvince(@PathVariable Long provinceId) {
        provinceService.deleteProvince(provinceId);
    }
}
