package CSF.contactsServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.core.HazelcastInstance;

import CSF.contactsServer.models.Contact;
import CSF.contactsServer.services.ContactsService;

@RestController
@RequestMapping("/contacts")
public class ContactsRestController {

    @Autowired
    private ContactsService contactsSvc;
    
    @PostMapping("/addContact")
    public ResponseEntity<String> saveContact(@RequestBody Contact c) {

        boolean contactSaved = contactsSvc.saveContactToRepo(c);
        
        if (contactSaved) {
            // System.out.println(">>>>> contact saved: " + contactSaved);
            return ResponseEntity.ok()
                    .body("{contact added}");
        } else {
            return ResponseEntity.badRequest()
                .body("{failed to save contact}");
        }
    }

    @GetMapping("/listContacts")
    public List<Contact> getContacts() {

        List<Contact> listOfContacts = contactsSvc.getContactsFromRepo();

        System.out.println(">>>> contacts list length: " + listOfContacts.size());

        return listOfContacts;
    }
    
}
