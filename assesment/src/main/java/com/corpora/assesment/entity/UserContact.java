package com.corpora.assesment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usercontact")
public class UserContact {
    @Id
    @Column(name = "contact-id")
    private String id;

    @Column(name = "address")
    private String address;
    
    @OneToOne(optional = false) 
    @MapsId()
    private User user;

    public UserContact() {
    }

    public UserContact(String id, String address, User user) {
        this.id = id;
        this.address = address;
        this.user = user;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
