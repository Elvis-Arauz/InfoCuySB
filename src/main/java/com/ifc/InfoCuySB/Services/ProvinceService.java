package com.ifc.InfoCuySB.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifc.InfoCuySB.Model.Province;
import com.ifc.InfoCuySB.Repository.ProvinceRepository;
import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    public Province getProvinceById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    public Province createProvince(Province province) {
        return provinceRepository.save(province);
    }

    public Province updateProvince(Long id, Province provinceDetails) {
        Province province = provinceRepository.findById(id).orElse(null);
        if (province != null) {
            province.setProvinceName(provinceDetails.getProvinceName());
            return provinceRepository.save(province);
        }
        return null;
    }

    public void deleteProvince(Long id) {
        provinceRepository.deleteById(id);
    }
}