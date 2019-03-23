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
@Table(name = "tb_t_workexperience")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workexperience.findAll", query = "SELECT w FROM Workexperience w")
    , @NamedQuery(name = "Workexperience.findById", query = "SELECT w FROM Workexperience w WHERE w.id = :id")
    , @NamedQuery(name = "Workexperience.findByName", query = "SELECT w FROM Workexperience w WHERE w.name = :name")
    , @NamedQuery(name = "Workexperience.findByPosition", query = "SELECT w FROM Workexperience w WHERE w.position = :position")
    , @NamedQuery(name = "Workexperience.findByStartdate", query = "SELECT w FROM Workexperience w WHERE w.startdate = :startdate")
    , @NamedQuery(name = "Workexperience.findByEnddate", query = "SELECT w FROM Workexperience w WHERE w.enddate = :enddate")
    , @NamedQuery(name = "Workexperience.findByIsdeleted", query = "SELECT w FROM Workexperience w WHERE w.isdeleted = :isdeleted")})
public class Workexperience implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "position")
    private String position;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Column(name = "isdeleted")
    private Short isdeleted;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Workexperience() {
    }

    public Workexperience(String id) {
        this.id = id;
    }

    public Workexperience(String id, String name, String description, Date startdate, Date enddate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
        if (!(object instanceof Workexperience)) {
            return false;
        }
        Workexperience other = (Workexperience) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Workexperience[ id=" + id + " ]";
    }
    
}
