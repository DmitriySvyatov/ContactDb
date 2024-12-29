package com.example.contactappdb.service;

import com.example.contactappdb.dao.Contact;
import com.example.contactappdb.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        log.info("Calling findAll in ContactServiceImpl");
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> findById(Long id) {
        log.debug("Calling findById in ContactServiceImpl");
        return contactRepository.findById(id);
    }

    @Override
    public Contact save(Contact contact) {
        log.debug("Calling save in ContactServiceImpl");
        return contactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        log.debug("Calling update in ContactServiceImpl");
        return contactRepository.update(contact);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Calling deleteById in ContactServiceImpl");
        contactRepository.deleteById(id);
    }
}
