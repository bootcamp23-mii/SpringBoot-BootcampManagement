/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FES
 */
@Entity
@Table(name = "tb_m_accesscard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accesscard.findAll", query = "SELECT a FROM Accesscard a")
    , @NamedQuery(name = "Accesscard.findById", query = "SELECT a FROM Accesscard a WHERE a.id = :id")
    , @NamedQuery(name = "Accesscard.findByAccessnumber", query = "SELECT a FROM Accesscard a WHERE a.accessnumber = :accessnumber")})
public class Accesscard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "accessnumber")
    private String accessnumber;

    public Accesscard() {
    }

    public Accesscard(String id) {
        this.id = id;
    }

    public Accesscard(String id, String accessnumber) {
        this.id = id;
        this.accessnumber = accessnumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessnumber() {
        return accessnumber;
    }

    public void setAccessnumber(String accessnumber) {
        this.accessnumber = accessnumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accesscard)) {
            return false;
        }
        Accesscard other = (Accesscard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Accesscard[ id=" + id + " ]";
    }
    
}
