package com.example.contactappdb.repository;

import com.example.contactappdb.rowmapper.ContactRowMapper;
import com.example.contactappdb.dao.Contact;
import com.example.contactappdb.exception.ContactNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class DataBaseContactRepository implements ContactRepository {
    private final JdbcTemplate jdbcTemplate;
    private int idCounter ;

    @Override
    public List<Contact> findAll() {
        log.debug("Calling findAll in DataBase");
        String sql = "select * from contact";
        return jdbcTemplate.query(sql, new ContactRowMapper());
    }

    @Override
    public Optional<Contact> findById(Long id) {
        log.debug("Calling findById in DataBase");
        String sql = "select * from contact where id = ?";
        Contact contact = DataAccessUtils.singleResult(jdbcTemplate.query(sql,
                new ArgumentPreparedStatementSetter(new Object[]{id}),
                new RowMapperResultSetExtractor<>(new ContactRowMapper(), 1)));
        return Optional.ofNullable(contact);
    }

    @Override
    public Contact save(Contact contact) {
        log.debug("Calling save in DataBase");
        idCounter=idCounter+1;
        contact.setId(idCounter);
        String sql = "Insert into contact (id, firstName,lastName,email,phone) values (?,?,?,?,?)";
        jdbcTemplate.update(sql, contact.getId(), contact.getFirstName(),
                contact.getLastName(), contact.getEmail(), contact.getPhone());
        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        log.debug("Calling update in DataBase");
        Contact existContact = findById(contact.getId()).orElse(null);
        if (existContact != null) {
            String sql = "Update contact set firstName = ?, lastName = ?, email = ? , phone =? where id = ?";
            jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(),
                    contact.getEmail(), contact.getPhone(), contact.getId());
            return contact;
        }
        log.warn("Task not found");
        throw new ContactNotFound("Contact not found");
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Calling deleteById in DataBase");
        String sql = "Delete from contact where id = ?";
        jdbcTemplate.update(sql,id);
    }
}
