package com.ifc.InfoCuySB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ifc.InfoCuySB.Model.Services;
import com.ifc.InfoCuySB.Services.ServicesService;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

    private final ServicesService servicesService;

    @Autowired
    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping
    public ResponseEntity<List<Services>> getAllServices() {
        return ResponseEntity.ok(servicesService.getAllServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Services> getServicesById(@PathVariable Long id) {
        return servicesService.getServicesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Services> createServices(@RequestBody Services services) {
        Services createdServices = servicesService.createServices(services);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdServices);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Services> updateServices(@PathVariable Long id, @RequestBody Services services) {
        Services updatedServices = servicesService.updateServices(id, services);
        return ResponseEntity.ok(updatedServices);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServices(@PathVariable Long id) {
        servicesService.deleteServices(id);
        return ResponseEntity.noContent().build();
    }
}
