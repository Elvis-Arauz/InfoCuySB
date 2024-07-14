package com.ifc.InfoCuySB.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifc.InfoCuySB.Model.Services;
import com.ifc.InfoCuySB.Repository.ServicesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService {

    private final ServicesRepository servicesRepository;

    @Autowired
    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    public Optional<Services> getServicesById(Long serviceId) {
        return servicesRepository.findById(serviceId);
    }

    public Services createServices(Services services) {
        return servicesRepository.save(services);
    }

    public Services updateServices(Long serviceId, Services services) {
        services.setServiceId(serviceId);
        return servicesRepository.save(services);
    }

    public void deleteServices(Long serviceId) {
        servicesRepository.deleteById(serviceId);
    }
}
