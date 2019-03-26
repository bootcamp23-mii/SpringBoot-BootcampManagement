/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FES
 */
@Entity
@Table(name = "tb_t_idcard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idcard.findAll", query = "SELECT i FROM Idcard i")
    , @NamedQuery(name = "Idcard.findById", query = "SELECT i FROM Idcard i WHERE i.id = :id")
    , @NamedQuery(name = "Idcard.findByReceivedate", query = "SELECT i FROM Idcard i WHERE i.receivedate = :receivedate")
    , @NamedQuery(name = "Idcard.findByReturndate", query = "SELECT i FROM Idcard i WHERE i.returndate = :returndate")
    , @NamedQuery(name = "Idcard.findByNote", query = "SELECT i FROM Idcard i WHERE i.note = :note")})
public class Idcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "receivedate")
    @Temporal(TemporalType.DATE)
    private Date receivedate;
    @Column(name = "returndate")
    @Temporal(TemporalType.DATE)
    private Date returndate;
    @Size(max = 300)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Idcard() {
    }

    public Idcard(String id) {
        this.id = id;
    }

    public Idcard(String id, Date receivedate) {
        this.id = id;
        this.receivedate = receivedate;
    }

    public Idcard(String id, Date receivedate, Date returndate, String note, Employee employee) {
        this.id = id;
        this.receivedate = receivedate;
        this.returndate = returndate;
        this.note = note;
        this.employee = employee;
    }
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(Date receivedate) {
        this.receivedate = receivedate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Idcard)) {
            return false;
        }
        Idcard other = (Idcard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Idcard[ id=" + id + " ]";
    }
    
}
