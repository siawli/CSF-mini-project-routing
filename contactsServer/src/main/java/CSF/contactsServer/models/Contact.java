package CSF.contactsServer.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Contact {
    private String name;
    private String email;
    private Integer mobile;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getMobile() {
        return mobile;
    }
    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public static Contact createContact(SqlRowSet rs) {
        Contact c = new Contact();
        c.setName(rs.getString("name"));
        c.setEmail(rs.getString("email"));
        c.setMobile(rs.getInt("mobile"));

        return c;
    }
}
