package com.ifc.InfoCuySB.Controller;

import com.ifc.InfoCuySB.Model.EventType;
import com.ifc.InfoCuySB.Services.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventtypes")
public class EventTypeController {

    @Autowired
    private EventTypeService eventTypeService;

    @PostMapping
    public ResponseEntity<EventType> createEventType(@RequestBody EventType eventType) {
        if(eventType.getEventTypeName() == null || eventType.getEventTypeName().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        EventType createdEventType = eventTypeService.save(eventType);
        return ResponseEntity.ok(createdEventType);
    }

    @GetMapping
    public ResponseEntity<List<EventType>> getAllEventTypes() {
        List<EventType> eventTypes = eventTypeService.getAllEventTypes();
        return ResponseEntity.ok(eventTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventType> getEventTypeById(@PathVariable Long id) {
        EventType eventType = eventTypeService.getEventTypeById(id);
        if(eventType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(eventType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventType> updateEventType(@PathVariable Long id, @RequestBody EventType eventTypeDetails) {
        EventType eventType = eventTypeService.getEventTypeById(id);
        if(eventType == null) {
            return ResponseEntity.notFound().build();
        }
        eventType.setEventTypeName(eventTypeDetails.getEventTypeName());
        EventType updatedEventType = eventTypeService.save(eventType);
        return ResponseEntity.ok(updatedEventType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventType(@PathVariable Long id) {
        EventType eventType = eventTypeService.getEventTypeById(id);
        if(eventType == null) {
            return ResponseEntity.notFound().build();
        }
        eventTypeService.deleteEventType(id);
        return ResponseEntity.noContent().build();
    }
}
