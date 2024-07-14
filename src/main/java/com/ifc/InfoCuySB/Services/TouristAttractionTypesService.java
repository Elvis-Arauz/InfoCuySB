package com.ifc.InfoCuySB.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifc.InfoCuySB.Model.TouristAttractionTypes;
import com.ifc.InfoCuySB.Repository.TouristAttractionTypesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TouristAttractionTypesService {

    private final TouristAttractionTypesRepository touristAttractionTypesRepository;

    @Autowired
    public TouristAttractionTypesService(TouristAttractionTypesRepository touristAttractionTypesRepository) {
        this.touristAttractionTypesRepository = touristAttractionTypesRepository;
    }

    public List<TouristAttractionTypes> getAllTouristAttractionTypes() {
        return touristAttractionTypesRepository.findAll();
    }

    public Optional<TouristAttractionTypes> getTouristAttractionTypeById(Long touristAttractionTypeId) {
        return touristAttractionTypesRepository.findById(touristAttractionTypeId);
    }

    public TouristAttractionTypes createTouristAttractionType(TouristAttractionTypes touristAttractionType) {
        return touristAttractionTypesRepository.save(touristAttractionType);
    }

    public TouristAttractionTypes updateTouristAttractionType(Long touristAttractionTypeId, TouristAttractionTypes touristAttractionType) {
        touristAttractionType.setTouristAttractionTypeId(touristAttractionTypeId);
        return touristAttractionTypesRepository.save(touristAttractionType);
    }

    public void deleteTouristAttractionType(Long touristAttractionTypeId) {
        touristAttractionTypesRepository.deleteById(touristAttractionTypeId);
    }
}
