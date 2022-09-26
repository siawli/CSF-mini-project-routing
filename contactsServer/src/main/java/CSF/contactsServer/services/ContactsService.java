package CSF.contactsServer.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import CSF.contactsServer.models.Contact;
import CSF.contactsServer.repositories.ContactsRepository;

@Service
public class ContactsService {

    @Autowired
    private ContactsRepository contactsRepo;

    public boolean saveContactToRepo(Contact c) {
        return contactsRepo.saveContact(c);
    }

    public List<Contact> getContactsFromRepo() {

        List<Contact> listContacts = new LinkedList<>();

        SqlRowSet rs = contactsRepo.getContactsList();

        while(rs.next()) {
            Contact c = Contact.createContact(rs);
            listContacts.add(c);
        }

        return listContacts;
    }
    
}
