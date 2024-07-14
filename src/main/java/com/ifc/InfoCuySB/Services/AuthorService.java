package com.ifc.InfoCuySB.Services;

import com.ifc.InfoCuySB.Model.Author;
import com.ifc.InfoCuySB.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Long authorId) {
        return authorRepository.findById(authorId);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public void deleteById(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
