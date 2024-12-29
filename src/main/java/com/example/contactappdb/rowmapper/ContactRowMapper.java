package com.example.contactappdb.rowmapper;

import com.example.contactappdb.dao.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRowMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setId(rs.getInt(Contact.Fields.id));
        contact.setFirstName(rs.getString(Contact.Fields.firstName));
        contact.setLastName(rs.getString(Contact.Fields.lastName));
        contact.setEmail(rs.getString(Contact.Fields.email));
        contact.setPhone(rs.getLong(Contact.Fields.phone));
        return contact;
    }
}
