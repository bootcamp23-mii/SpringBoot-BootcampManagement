/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bootcampmanagement.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FES
 */
@Entity
@Table(name = "tb_m_evaluation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e")
    , @NamedQuery(name = "Evaluation.findById", query = "SELECT e FROM Evaluation e WHERE e.id = :id")
    , @NamedQuery(name = "Evaluation.findByIsdaily", query = "SELECT e FROM Evaluation e WHERE e.isdaily = :isdaily")
    , @NamedQuery(name = "Evaluation.findByEvaluationdate", query = "SELECT e FROM Evaluation e WHERE e.evaluationdate = :evaluationdate")
    , @NamedQuery(name = "Evaluation.findByIsdeleted", query = "SELECT e FROM Evaluation e WHERE e.isdeleted = :isdeleted")})
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Column(name = "isdaily")
    private Short isdaily;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluationdate")
    @Temporal(TemporalType.DATE)
    private Date evaluationdate;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "note")
    private String note;
    @Column(name = "isdeleted")
    private Short isdeleted;
    @OneToMany(mappedBy = "evaluation", fetch = FetchType.LAZY)
    private List<Score> scoreList;
    @JoinColumn(name = "lesson", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;
    @JoinColumn(name = "topic", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Topic topic;
    @JoinColumn(name = "participant", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee participant;

    public Evaluation() {
    }

    public Evaluation(String id) {
        this.id = id;
    }

    public Evaluation(String id, Date evaluationdate) {
        this.id = id;
        this.evaluationdate = evaluationdate;
    }

    public Evaluation(String id, Short isdaily, Date evaluationdate, String note, Short isdeleted, Lesson lesson, Topic topic, Employee participant) {
        this.id = id;
        this.isdaily = isdaily;
        this.evaluationdate = evaluationdate;
        this.note = note;
        this.isdeleted = isdeleted;
        this.lesson = lesson;
        this.topic = topic;
        this.participant = participant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getIsdaily() {
        return isdaily;
    }

    public void setIsdaily(Short isdaily) {
        this.isdaily = isdaily;
    }

    public Date getEvaluationdate() {
        return evaluationdate;
    }

    public void setEvaluationdate(Date evaluationdate) {
        this.evaluationdate = evaluationdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    @XmlTransient
    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Employee getParticipant() {
        return participant;
    }

    public void setParticipant(Employee participant) {
        this.participant = participant;
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
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bm.bootcampmanagement.entities.Evaluation[ id=" + id + " ]";
    }

}
