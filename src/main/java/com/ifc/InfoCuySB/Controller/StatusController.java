package com.ifc.InfoCuySB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ifc.InfoCuySB.Model.Status;
import com.ifc.InfoCuySB.Services.StatusService;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/statuses")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public List<Status> getAllStatuses() {
        return statusService.getAllStatuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable Long id) {
        Optional<Status> status = statusService.getStatusById(id);
        return status.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
        System.out.println("Received Status: " + status); // Log the received status
        if (status.getStatusName() == null || status.getStatusName().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        Status createdStatus = statusService.saveStatus(status);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status status) {
        if (!statusService.getStatusById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        status.setStatusId(id);
        Status updatedStatus = statusService.saveStatus(status);
        return ResponseEntity.ok(updatedStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        if (!statusService.getStatusById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        statusService.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }
}
