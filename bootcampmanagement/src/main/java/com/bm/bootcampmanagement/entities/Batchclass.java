/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FES
 */
@Entity
@Table(name = "tb_m_batchclass")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Batchclass.findAll", query = "SELECT b FROM Batchclass b")
    , @NamedQuery(name = "Batchclass.findById", query = "SELECT b FROM Batchclass b WHERE b.id = :id")
    , @NamedQuery(name = "Batchclass.findByIsdeleted", query = "SELECT b FROM Batchclass b WHERE b.isdeleted = :isdeleted")})
public class Batchclass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Column(name = "isdeleted")
    private Short isdeleted;
    @JoinColumn(name = "batch", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Batch batch;
    @JoinColumn(name = "room", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
    @JoinColumn(name = "classes", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Classes classes;
    @JoinColumn(name = "trainer", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee trainer;
    @OneToMany(mappedBy = "batchclass", fetch = FetchType.LAZY)
    private List<Participant> participantList;

    public Batchclass() {
    }

    public Batchclass(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Employee getTrainer() {
        return trainer;
    }

    public void setTrainer(Employee trainer) {
        this.trainer = trainer;
    }

    @XmlTransient
    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
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
        if (!(object instanceof Batchclass)) {
            return false;
        }
        Batchclass other = (Batchclass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Batchclass[ id=" + id + " ]";
    }
    
}
