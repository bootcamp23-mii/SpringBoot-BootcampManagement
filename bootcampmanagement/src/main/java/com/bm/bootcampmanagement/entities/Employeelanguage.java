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
@Table(name = "tb_t_employeelanguage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeelanguage.findAll", query = "SELECT e FROM Employeelanguage e")
    , @NamedQuery(name = "Employeelanguage.findById", query = "SELECT e FROM Employeelanguage e WHERE e.id = :id")
    , @NamedQuery(name = "Employeelanguage.findByScore", query = "SELECT e FROM Employeelanguage e WHERE e.score = :score")
    , @NamedQuery(name = "Employeelanguage.findByIsactive", query = "SELECT e FROM Employeelanguage e WHERE e.isactive = :isactive")
    , @NamedQuery(name = "Employeelanguage.findByIsdeleted", query = "SELECT e FROM Employeelanguage e WHERE e.isdeleted = :isdeleted")})
public class Employeelanguage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "score")
    private Double score;
    @Column(name = "isactive")
    private Short isactive;
    @Column(name = "isdeleted")
    private Short isdeleted;
    @JoinColumn(name = "language", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Language language;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Employeelanguage() {
    }

    public Employeelanguage(String id) {
        this.id = id;
    }

    public Employeelanguage(String id, Double score, Short isactive, Short isdeleted, Language language, Employee employee) {
        this.id = id;
        this.score = score;
        this.isactive = isactive;
        this.isdeleted = isdeleted;
        this.language = language;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Short getIsactive() {
        return isactive;
    }

    public void setIsactive(Short isactive) {
        this.isactive = isactive;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
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
        if (!(object instanceof Employeelanguage)) {
            return false;
        }
        Employeelanguage other = (Employeelanguage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Employeelanguage[ id=" + id + " ]";
    }
    
}
