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
@Table(name = "tb_t_employee_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeAccess.findAll", query = "SELECT e FROM EmployeeAccess e")
    , @NamedQuery(name = "EmployeeAccess.findById", query = "SELECT e FROM EmployeeAccess e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeAccess.findByReceiveDate", query = "SELECT e FROM EmployeeAccess e WHERE e.receiveDate = :receiveDate")
    , @NamedQuery(name = "EmployeeAccess.findByReturnDate", query = "SELECT e FROM EmployeeAccess e WHERE e.returnDate = :returnDate")})
public class EmployeeAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "receiveDate")
    @Temporal(TemporalType.DATE)
    private Date receiveDate;
    @Column(name = "returnDate")
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "notes")
    private String notes;
    @JoinColumn(name = "accessCard", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private AccessCard accessCard;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public EmployeeAccess() {
    }

    public EmployeeAccess(String id) {
        this.id = id;
    }

    public EmployeeAccess(String id, Date receiveDate) {
        this.id = id;
        this.receiveDate = receiveDate;
    }

    public EmployeeAccess(String id, Date receiveDate, Date returnDate, String notes, AccessCard accessCard, Employee employee) {
        this.id = id;
        this.receiveDate = receiveDate;
        this.returnDate = returnDate;
        this.notes = notes;
        this.accessCard = accessCard;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
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
        if (!(object instanceof EmployeeAccess)) {
            return false;
        }
        EmployeeAccess other = (EmployeeAccess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.EmployeeAccess[ id=" + id + " ]";
    }
    
}
