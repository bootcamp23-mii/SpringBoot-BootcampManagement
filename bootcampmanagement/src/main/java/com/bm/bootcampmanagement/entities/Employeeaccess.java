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
import javax.persistence.Lob;
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
@Table(name = "tb_t_employeeaccess")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeeaccess.findAll", query = "SELECT e FROM Employeeaccess e")
    , @NamedQuery(name = "Employeeaccess.findById", query = "SELECT e FROM Employeeaccess e WHERE e.id = :id")
    , @NamedQuery(name = "Employeeaccess.findByReceivedate", query = "SELECT e FROM Employeeaccess e WHERE e.receivedate = :receivedate")
    , @NamedQuery(name = "Employeeaccess.findByReturndate", query = "SELECT e FROM Employeeaccess e WHERE e.returndate = :returndate")})
public class Employeeaccess implements Serializable {

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
    @Lob
    @Size(max = 2147483647)
    @Column(name = "notes")
    private String notes;
    @JoinColumn(name = "accesscard", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Accesscard accesscard;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Employeeaccess() {
    }

    public Employeeaccess(String id) {
        this.id = id;
    }

    public Employeeaccess(String id, Date receivedate) {
        this.id = id;
        this.receivedate = receivedate;
    }

    public Employeeaccess(String id, Date receivedate, Date returndate, String notes, Accesscard accesscard, Employee employee) {
        this.id = id;
        this.receivedate = receivedate;
        this.returndate = returndate;
        this.notes = notes;
        this.accesscard = accesscard;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Accesscard getAccesscard() {
        return accesscard;
    }

    public void setAccesscard(Accesscard accesscard) {
        this.accesscard = accesscard;
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
        if (!(object instanceof Employeeaccess)) {
            return false;
        }
        Employeeaccess other = (Employeeaccess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Employeeaccess[ id=" + id + " ]";
    }

}
