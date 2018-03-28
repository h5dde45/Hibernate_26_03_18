package com.hbrnt.models;

import javax.persistence.*;

@Entity
@Table(name = "contact_tel_detail")
public class ContactTelDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "tel_type", nullable = false, length = 20)
    private String telType;

    @Column(name = "tel_number", nullable = false, length = 20)
    private String telNumber;

    @Column(name = "version", nullable = false)
    private int version;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactTelDetail that = (ContactTelDetail) o;

        if (version != that.version) return false;
        if (telType != null ? !telType.equals(that.telType) : that.telType != null) return false;
        return telNumber != null ? telNumber.equals(that.telNumber) : that.telNumber == null;
    }

    @Override
    public int hashCode() {
        int result = telType != null ? telType.hashCode() : 0;
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }
}
