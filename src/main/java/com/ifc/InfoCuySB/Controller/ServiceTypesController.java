package com.ifc.InfoCuySB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ifc.InfoCuySB.Model.ServiceTypes;
import com.ifc.InfoCuySB.Services.ServiceTypesService;

import java.util.List;

@RestController
@RequestMapping("/api/servicetypes")
public class ServiceTypesController {

    private final ServiceTypesService serviceTypesService;

    @Autowired
    public ServiceTypesController(ServiceTypesService serviceTypesService) {
        this.serviceTypesService = serviceTypesService;
    }

    @GetMapping
    public ResponseEntity<List<ServiceTypes>> getAllServiceTypes() {
        return ResponseEntity.ok(serviceTypesService.getAllServiceTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceTypes> getServiceTypesById(@PathVariable Long id) {
        return serviceTypesService.getServiceTypesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ServiceTypes> createServiceTypes(@RequestBody ServiceTypes serviceTypes) {
        ServiceTypes createdServiceTypes = serviceTypesService.createServiceTypes(serviceTypes);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdServiceTypes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceTypes> updateServiceTypes(@PathVariable Long id, @RequestBody ServiceTypes serviceTypes) {
        ServiceTypes updatedServiceTypes = serviceTypesService.updateServiceTypes(id, serviceTypes);
        return ResponseEntity.ok(updatedServiceTypes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceTypes(@PathVariable Long id) {
        serviceTypesService.deleteServiceTypes(id);
        return ResponseEntity.noContent().build();
    }
}
