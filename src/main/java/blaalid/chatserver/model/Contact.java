/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blaalid.chatserver.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Blaalid
 */
@Entity
@Table(name = "CONTACT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByContactname", query = "SELECT c FROM Contact c WHERE c.contactname = :contactname"),
    @NamedQuery(name = "Contact.findByCid", query = "SELECT c FROM Contact c WHERE c.cid = :cid"),
    @NamedQuery(name = "Contact.findByContactnumber", query = "SELECT c FROM Contact c WHERE c.contactnumber = :contactnumber")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CONTACTNAME")
    private String contactname;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CID")
    private Long cid;
    @Column(name = "CONTACTNUMBER")
    private int contactnumber;

    public Contact() {
    }

    public Contact(Long cid) {
        this.cid = cid;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public int getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(int contactnumber) {
        this.contactnumber = contactnumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "blaalid.chatserver.Contact[ cid=" + cid + " ]";
    }
    
}
