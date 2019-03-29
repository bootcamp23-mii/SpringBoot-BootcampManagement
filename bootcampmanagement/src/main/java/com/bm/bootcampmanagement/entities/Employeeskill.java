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
@Table(name = "tb_t_employeeskill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employeeskill.findAll", query = "SELECT e FROM Employeeskill e")
    , @NamedQuery(name = "Employeeskill.findById", query = "SELECT e FROM Employeeskill e WHERE e.id = :id")
    , @NamedQuery(name = "Employeeskill.findByScore", query = "SELECT e FROM Employeeskill e WHERE e.score = :score")
    , @NamedQuery(name = "Employeeskill.findByIsdeleted", query = "SELECT e FROM Employeeskill e WHERE e.isdeleted = :isdeleted")})
public class Employeeskill implements Serializable {

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
    @Column(name = "isdeleted")
    private Short isdeleted;
    @JoinColumn(name = "skill", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Skill skill;
    @JoinColumn(name = "employee", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Employeeskill() {
    }

    public Employeeskill(String id) {
        this.id = id;
    }

    public Employeeskill(String id, Double score, Skill skill, Employee employee) {
        this.id = id;
        this.score = score;
        this.skill = skill;
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

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
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
        if (!(object instanceof Employeeskill)) {
            return false;
        }
        Employeeskill other = (Employeeskill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Employeeskill[ id=" + id + " ]";
    }
    
}
