package com.ifc.InfoCuySB.Services;

import java.util.List;
import java.util.Optional;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifc.InfoCuySB.Model.TouristAttraction;
import com.ifc.InfoCuySB.Repository.TouristAttractionRepository;

@Service
public class TouristAttractionService {

    @Autowired
    private TouristAttractionRepository repository;

    public List<TouristAttraction> getAllTouristAttractions() {
        return repository.findAll();
    }

    public Optional<TouristAttraction> getTouristAttractionById(Long id) {
        return repository.findById(id);
    }

    public TouristAttraction createTouristAttraction(TouristAttraction touristAttraction) {
        return repository.save(touristAttraction);
    }

    public TouristAttraction updateTouristAttraction(Long id, TouristAttraction touristAttractionDetails) {
        TouristAttraction touristAttraction = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TouristAttraction not found for this id :: " + id));

        touristAttraction.setDistrictId(touristAttractionDetails.getDistrictId());
        touristAttraction.setTouristAttractionTypeId(touristAttractionDetails.getTouristAttractionTypeId());
        touristAttraction.setTouristAttractionName(touristAttractionDetails.getTouristAttractionName());
        touristAttraction.setDescription(touristAttractionDetails.getDescription());
        touristAttraction.setPhoto(touristAttractionDetails.getPhoto());
        touristAttraction.setAddress(touristAttractionDetails.getAddress());
        touristAttraction.setOpeningHours(touristAttractionDetails.getOpeningHours());
        touristAttraction.setPhoneNumber(touristAttractionDetails.getPhoneNumber());
        touristAttraction.setEmail(touristAttractionDetails.getEmail());
        touristAttraction.setWebsiteUrl(touristAttractionDetails.getWebsiteUrl());
        touristAttraction.setDeleted(touristAttractionDetails.isDeleted());

        return repository.save(touristAttraction);
    }

    public void deleteTouristAttraction(Long id) {
        TouristAttraction touristAttraction = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TouristAttraction not found for this id :: " + id));
        repository.delete(touristAttraction);
    }
}
