package com.ifc.InfoCuySB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifc.InfoCuySB.Model.LocalNews;
import com.ifc.InfoCuySB.Services.LocalNewsService;

import java.util.List;

@RestController
@RequestMapping("/api/localnews")
public class LocalNewsController {

    private final LocalNewsService localNewsService;

    @Autowired
    public LocalNewsController(LocalNewsService localNewsService) {
        this.localNewsService = localNewsService;
    }

    @GetMapping
    public ResponseEntity<List<LocalNews>> getAllLocalNews() {
        return ResponseEntity.ok(localNewsService.getAllLocalNews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalNews> getLocalNewsById(@PathVariable Long id) {
        return localNewsService.getLocalNewsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LocalNews> createLocalNews(@RequestBody LocalNews localNews) {
        LocalNews createdLocalNews = localNewsService.createLocalNews(localNews);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLocalNews);
    }

    @PutMapping("/{id}")
public ResponseEntity<LocalNews> updateLocalNews(@PathVariable Long id, @RequestBody LocalNews localNews) {
    LocalNews updatedLocalNews = localNewsService.updateLocalNews(id, localNews);
    return ResponseEntity.ok(updatedLocalNews);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocalNews(@PathVariable Long id) {
        localNewsService.deleteLocalNews(id);
        return ResponseEntity.noContent().build();
    }
}
