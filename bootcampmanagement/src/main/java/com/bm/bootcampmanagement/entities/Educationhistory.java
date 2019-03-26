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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_t_educationhistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educationhistory.findAll", query = "SELECT e FROM Educationhistory e")
    , @NamedQuery(name = "Educationhistory.findById", query = "SELECT e FROM Educationhistory e WHERE e.id = :id")
    , @NamedQuery(name = "Educationhistory.findByGpa", query = "SELECT e FROM Educationhistory e WHERE e.gpa = :gpa")
    , @NamedQuery(name = "Educationhistory.findByIsdeleted", query = "SELECT e FROM Educationhistory e WHERE e.isdeleted = :isdeleted")})
public class Educationhistory implements Serializable {

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
    @Column(name = "gpa")
    private String gpa;
    @Column(name = "isdeleted")
    private Short isdeleted;
    @JoinColumn(name = "education", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Education education;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Educationhistory() {
    }

    public Educationhistory(String id) {
        this.id = id;
    }

    public Educationhistory(String id, String gpa) {
        this.id = id;
        this.gpa = gpa;
    }

    public Educationhistory(String id, String gpa, Education education, Employee employee) {
        this.id = id;
        this.gpa = gpa;
        this.education = education;
        this.employee = employee;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
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
        if (!(object instanceof Educationhistory)) {
            return false;
        }
        Educationhistory other = (Educationhistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Educationhistory[ id=" + id + " ]";
    }
    
}
