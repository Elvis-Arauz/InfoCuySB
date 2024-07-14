package com.ifc.InfoCuySB.Services;

import com.ifc.InfoCuySB.Model.Tag;
import com.ifc.InfoCuySB.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Optional<Tag> findById(Long tagId) {
        return tagRepository.findById(tagId);
    }

    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    public void deleteById(Long tagId) {
        tagRepository.deleteById(tagId);
    }
}
