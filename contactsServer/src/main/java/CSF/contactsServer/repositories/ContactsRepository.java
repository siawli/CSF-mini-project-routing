package CSF.contactsServer.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import CSF.contactsServer.models.Contact;

import static CSF.contactsServer.repositories.Queries.*;

@Repository
public class ContactsRepository {

    @Autowired
    private JdbcTemplate template;

    public boolean saveContact(Contact c) {
        int added = 0;

        added = template.update(SQL_SAVE_CONTACT,
            c.getName(), c.getEmail(), c.getMobile());

        return added == 1;
    }

    public SqlRowSet getContactsList() {

        return template.queryForRowSet(SQL_GET_CONTACTS);

    }
}
