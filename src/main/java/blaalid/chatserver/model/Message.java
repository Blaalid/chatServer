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
@Table(name = "MESSAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findByMid", query = "SELECT m FROM Message m WHERE m.mid = :mid"),
    @NamedQuery(name = "Message.findByMessagetext", query = "SELECT m FROM Message m WHERE m.messagetext = :messagetext"),
    @NamedQuery(name = "Message.findByConversationid", query = "SELECT m FROM Message m WHERE m.conversationid = :conversationid"),
    @NamedQuery(name = "Message.findByAuthor", query = "SELECT m FROM Message m WHERE m.author = :author")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MID")
    private Long mid;
    @Column(name = "MESSAGETEXT")
    private String messagetext;
    @Column(name = "CONVERSATIONID")
    private int conversationid;
    @Column(name = "AUTHOR")
    private String author;

    public Message() {
    }

    public Message(Long mid, String messagetext, int conversationid, String author) {
        this.mid = mid;
        this.messagetext = messagetext;
        this.conversationid = conversationid;
        this.author = author;
    }
    
    public Message(Long mid) {
        this.mid = mid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    public int getConversationid() {
        return conversationid;
    }

    public void setConversationid(int conversationid) {
        this.conversationid = conversationid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mid != null ? mid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.mid == null && other.mid != null) || (this.mid != null && !this.mid.equals(other.mid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "blaalid.chatserver.Message[ mid=" + mid + " ]";
    }
    
}
