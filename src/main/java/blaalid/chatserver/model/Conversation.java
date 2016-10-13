/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blaalid.chatserver.model;

import java.io.Serializable;
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
@Table(name = "CONVERSATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conversation.findAll", query = "SELECT c FROM Conversation c"),
    @NamedQuery(name = "Conversation.findByCid", query = "SELECT c FROM Conversation c WHERE c.cid = :cid"),
    @NamedQuery(name = "Conversation.findByMessage", query = "SELECT c FROM Conversation c WHERE c.message = :message")})
public class Conversation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CID")
    private Boolean cid;
    @Column(name = "MESSAGE")
    private Character message;

    public Conversation() {
    }

    public Conversation(Boolean cid) {
        this.cid = cid;
    }

    public Boolean getCid() {
        return cid;
    }

    public void setCid(Boolean cid) {
        this.cid = cid;
    }

    public Character getMessage() {
        return message;
    }

    public void setMessage(Character message) {
        this.message = message;
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
        if (!(object instanceof Conversation)) {
            return false;
        }
        Conversation other = (Conversation) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "blaalid.chatserver.Conversation[ cid=" + cid + " ]";
    }
    
}
