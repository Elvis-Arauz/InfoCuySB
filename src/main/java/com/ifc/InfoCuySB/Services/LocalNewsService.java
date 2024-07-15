package com.ifc.InfoCuySB.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifc.InfoCuySB.Model.LocalNews;
import com.ifc.InfoCuySB.Repository.LocalNewsRepository;
import java.util.List;
import java.util.Optional;

@Service
public class LocalNewsService {

    private final LocalNewsRepository localNewsRepository;

    @Autowired
    public LocalNewsService(LocalNewsRepository localNewsRepository) {
        this.localNewsRepository = localNewsRepository;
    }

    public List<LocalNews> getAllLocalNews() {
        return localNewsRepository.findAll();
    }

    public Optional<LocalNews> getLocalNewsById(Long newsId) {
        return localNewsRepository.findById(newsId);
    }

    public LocalNews createLocalNews(LocalNews localNews) {
        return localNewsRepository.save(localNews);
    }

    public LocalNews updateLocalNews(Long newsId, LocalNews localNews) {
        localNews.setNewsId(newsId);
        return localNewsRepository.save(localNews);
    }
      

    public void deleteLocalNews(Long newsId) {
        localNewsRepository.deleteById(newsId);
    }
}
