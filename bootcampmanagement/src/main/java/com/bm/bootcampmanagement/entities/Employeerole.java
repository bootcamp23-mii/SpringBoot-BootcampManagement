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
@Table(name = "tb_t_employeerole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeerole.findAll", query = "SELECT e FROM Employeerole e")
    , @NamedQuery(name = "Employeerole.findById", query = "SELECT e FROM Employeerole e WHERE e.id = :id")
    , @NamedQuery(name = "Employeerole.findByStartdate", query = "SELECT e FROM Employeerole e WHERE e.startdate = :startdate")
    , @NamedQuery(name = "Employeerole.findByEnddate", query = "SELECT e FROM Employeerole e WHERE e.enddate = :enddate")
    , @NamedQuery(name = "Employeerole.findByIsdeleted", query = "SELECT e FROM Employeerole e WHERE e.isdeleted = :isdeleted")})
public class Employeerole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Column(name = "isdeleted")
    private Short isdeleted;
    @JoinColumn(name = "role", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Employeerole(String id, Date startdate, Date enddate, Role role, Employee employee) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.role = role;
        this.employee = employee;
    }

    
    public Employeerole(String id, Date startdate, Date enddate, Short isdeleted, Role role, Employee employee) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.isdeleted = isdeleted;
        this.role = role;
        this.employee = employee;
    }

    public Employeerole() {
    }

    public Employeerole(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
        if (!(object instanceof Employeerole)) {
            return false;
        }
        Employeerole other = (Employeerole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Employeerole[ id=" + id + " ]";
    }
    
}
