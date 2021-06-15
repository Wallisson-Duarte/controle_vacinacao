/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mycompany.dao.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wallisson
 */
@Entity
@Table(name = "aplicacaovacina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aplicacaovacina.findAll", query = "SELECT a FROM Aplicacaovacina a")
    , @NamedQuery(name = "Aplicacaovacina.findById", query = "SELECT a FROM Aplicacaovacina a WHERE a.id = :id")
    , @NamedQuery(name = "Aplicacaovacina.findByData", query = "SELECT a FROM Aplicacaovacina a WHERE a.data = :data")
    , @NamedQuery(name = "Aplicacaovacina.findByDose", query = "SELECT a FROM Aplicacaovacina a WHERE a.dose = :dose")})
public class Aplicacaovacina implements Serializable, EntidadeBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @Column(name = "dose")
    private String dose;
    @JoinColumn(name = "Paciente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paciente pacienteid;
    @JoinColumn(name = "Posto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Posto postoid;
    @JoinColumn(name = "Vacina_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vacina vacinaid;
    @JoinColumn(name = "Vacinador_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vacinador vacinadorid;

    public Aplicacaovacina() {
    }

    public Aplicacaovacina(Integer id) {
        this.id = id;
    }

    public Aplicacaovacina(Integer id, String data, String dose) {
        this.id = id;
        this.data = data;
        this.dose = dose;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Paciente getPacienteid() {
        return pacienteid;
    }

    public void setPacienteid(Paciente pacienteid) {
        this.pacienteid = pacienteid;
    }

    public Posto getPostoid() {
        return postoid;
    }

    public void setPostoid(Posto postoid) {
        this.postoid = postoid;
    }

    public Vacina getVacinaid() {
        return vacinaid;
    }

    public void setVacinaid(Vacina vacinaid) {
        this.vacinaid = vacinaid;
    }

    public Vacinador getVacinadorid() {
        return vacinadorid;
    }

    public void setVacinadorid(Vacinador vacinadorid) {
        this.vacinadorid = vacinadorid;
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
        if (!(object instanceof Aplicacaovacina)) {
            return false;
        }
        Aplicacaovacina other = (Aplicacaovacina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.Aplicacaovacina[ id=" + id + " ]";
    }
    
}
