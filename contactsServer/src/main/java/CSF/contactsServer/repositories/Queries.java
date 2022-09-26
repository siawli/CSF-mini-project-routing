package CSF.contactsServer.repositories;

public interface Queries {

    public static final String SQL_SAVE_CONTACT = 
        "insert into contacts (name, email, mobile) values (?, ?, ?)";

    public static final String SQL_GET_CONTACTS = 
        "select * from contacts";
        // select * from contacts;
    
}
