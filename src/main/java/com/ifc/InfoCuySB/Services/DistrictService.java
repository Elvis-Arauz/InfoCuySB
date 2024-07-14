package com.ifc.InfoCuySB.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifc.InfoCuySB.Model.District;
import com.ifc.InfoCuySB.Repository.DistrictRepository;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public List<District> findAll() {
        return districtRepository.findAll();
    }

    public Optional<District> findById(Long id) {
        return districtRepository.findById(id);
    }

    public District save(District district) {
        return districtRepository.save(district);
    }

    public void deleteById(Long id) {
        districtRepository.deleteById(id);
    }
}