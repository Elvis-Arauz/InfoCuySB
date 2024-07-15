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

    public Province getProvinceById(Long provinceId) {
        return provinceRepository.findById(provinceId).orElse(null);
    }

    public Province createProvince(Province province) {
        return provinceRepository.save(province);
    }

    public Province updateProvince(Long provinceId, Province provinceDetails) {
        Province province = provinceRepository.findById(provinceId).orElse(null);
        if (province != null) {
            province.setProvinceName(provinceDetails.getProvinceName());
            return provinceRepository.save(province);
        }
        return null;
    }

    public void deleteProvince(Long provinceId) {
        provinceRepository.deleteById(provinceId);
    }
}
