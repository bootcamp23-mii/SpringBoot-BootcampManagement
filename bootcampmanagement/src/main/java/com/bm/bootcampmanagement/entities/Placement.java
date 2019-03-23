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
@Table(name = "tb_t_placement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Placement.findAll", query = "SELECT p FROM Placement p")
    , @NamedQuery(name = "Placement.findById", query = "SELECT p FROM Placement p WHERE p.id = :id")
    , @NamedQuery(name = "Placement.findByAddress", query = "SELECT p FROM Placement p WHERE p.address = :address")
    , @NamedQuery(name = "Placement.findByDepartment", query = "SELECT p FROM Placement p WHERE p.department = :department")
    , @NamedQuery(name = "Placement.findByStartDate", query = "SELECT p FROM Placement p WHERE p.startDate = :startDate")
    , @NamedQuery(name = "Placement.findByFinishDate", query = "SELECT p FROM Placement p WHERE p.finishDate = :finishDate")
    , @NamedQuery(name = "Placement.findByIsdeleted", query = "SELECT p FROM Placement p WHERE p.isdeleted = :isdeleted")})
public class Placement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 200)
    @Column(name = "address")
    private String address;
    @Size(max = 200)
    @Column(name = "department")
    private String department;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "finishDate")
    @Temporal(TemporalType.DATE)
    private Date finishDate;
    @Column(name = "isdeleted")
    private Short isdeleted;
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Placement() {
    }

    public Placement(String id) {
        this.id = id;
    }

    public Placement(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Placement(String id, String description, String address, String department, Date startDate, Date finishDate, Short isdeleted, Company company, Employee employee) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.department = department;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.isdeleted = isdeleted;
        this.company = company;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        if (!(object instanceof Placement)) {
            return false;
        }
        Placement other = (Placement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Placement[ id=" + id + " ]";
    }
    
}
