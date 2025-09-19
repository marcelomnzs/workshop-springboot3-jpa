package com.marcelomnzs.course.services;

import com.marcelomnzs.course.entities.User;
import com.marcelomnzs.course.repositories.UserRepository;
import com.marcelomnzs.course.services.exceptions.DatabaseException;
import com.marcelomnzs.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        User userReference = repository.getReferenceById(id);
        updateData(userReference, user);
        return repository.save(userReference);
    }

    private void updateData(User userReference, User user) {
        userReference.setName(user.getName());
        userReference.setEmail(user.getEmail());
        userReference.setPhone(user.getPhone());
    }
}
