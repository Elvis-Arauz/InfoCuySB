package com.ifc.InfoCuySB.Services;

import com.ifc.InfoCuySB.Model.EventType;
import com.ifc.InfoCuySB.Repository.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeService {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    public EventType save(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    public List<EventType> getAllEventTypes() {
        return eventTypeRepository.findAll();
    }

    public EventType getEventTypeById(Long id) {
        return eventTypeRepository.findById(id).orElse(null);
    }

    public void deleteEventType(Long id) {
        eventTypeRepository.deleteById(id);
    }
}
