package com.ifc.InfoCuySB.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifc.InfoCuySB.Model.ServiceTypes;
import com.ifc.InfoCuySB.Repository.ServiceTypesRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypesService {

    private final ServiceTypesRepository serviceTypesRepository;

    @Autowired
    public ServiceTypesService(ServiceTypesRepository serviceTypesRepository) {
        this.serviceTypesRepository = serviceTypesRepository;
    }

    public List<ServiceTypes> getAllServiceTypes() {
        return serviceTypesRepository.findAll();
    }

    public Optional<ServiceTypes> getServiceTypesById(Long serviceTypeId) {
        return serviceTypesRepository.findById(serviceTypeId);
    }

    public ServiceTypes createServiceTypes(ServiceTypes serviceTypes) {
        return serviceTypesRepository.save(serviceTypes);
    }

    public ServiceTypes updateServiceTypes(Long serviceTypeId, ServiceTypes serviceTypes) {
        serviceTypes.setServiceTypeId(serviceTypeId);
        return serviceTypesRepository.save(serviceTypes);
    }

    public void deleteServiceTypes(Long serviceTypeId) {
        serviceTypesRepository.deleteById(serviceTypeId);
    }
}
