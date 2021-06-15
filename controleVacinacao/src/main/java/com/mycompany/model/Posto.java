/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mycompany.dao.EntidadeBase;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wallisson
 */
@Entity
@Table(name = "posto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posto.findAll", query = "SELECT p FROM Posto p")
    , @NamedQuery(name = "Posto.findById", query = "SELECT p FROM Posto p WHERE p.id = :id")
    , @NamedQuery(name = "Posto.findByNome", query = "SELECT p FROM Posto p WHERE p.nome = :nome")})
public class Posto implements Serializable, EntidadeBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "Endereco_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Endereco enderecoid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postoid")
    private List<Aplicacaovacina> aplicacaovacinaList;

    public Posto() {
    }

    public Posto(Integer id) {
        this.id = id;
    }

    public Posto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEnderecoid() {
        return enderecoid;
    }

    public void setEnderecoid(Endereco enderecoid) {
        this.enderecoid = enderecoid;
    }

    @XmlTransient
    public List<Aplicacaovacina> getAplicacaovacinaList() {
        return aplicacaovacinaList;
    }

    public void setAplicacaovacinaList(List<Aplicacaovacina> aplicacaovacinaList) {
        this.aplicacaovacinaList = aplicacaovacinaList;
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
        if (!(object instanceof Posto)) {
            return false;
        }
        Posto other = (Posto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.Posto[ id=" + id + " ]";
    }
    
}
