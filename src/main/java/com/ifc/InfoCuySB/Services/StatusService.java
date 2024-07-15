package com.ifc.InfoCuySB.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifc.InfoCuySB.Model.Status;
import com.ifc.InfoCuySB.Repository.StatusRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository repository) {
        statusRepository = repository;
    }

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    public Optional<Status> getStatusById(Long id) {
        return statusRepository.findById(id);
    }

    public Status saveStatus(Status status) {
        return statusRepository.save(status);
    }

    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
}
