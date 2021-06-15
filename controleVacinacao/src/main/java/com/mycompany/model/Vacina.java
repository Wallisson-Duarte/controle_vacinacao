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
@Table(name = "vacina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacina.findAll", query = "SELECT v FROM Vacina v")
    , @NamedQuery(name = "Vacina.findById", query = "SELECT v FROM Vacina v WHERE v.id = :id")
    , @NamedQuery(name = "Vacina.findByNome", query = "SELECT v FROM Vacina v WHERE v.nome = :nome")
    , @NamedQuery(name = "Vacina.findByFabricante", query = "SELECT v FROM Vacina v WHERE v.fabricante = :fabricante")
    , @NamedQuery(name = "Vacina.findByLote", query = "SELECT v FROM Vacina v WHERE v.lote = :lote")})
public class Vacina implements Serializable, EntidadeBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "fabricante")
    private String fabricante;
    @Basic(optional = false)
    @Column(name = "lote")
    private String lote;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacinaid")
    private List<Aplicacaovacina> aplicacaovacinaList;

    public Vacina() {
    }

    public Vacina(Integer id) {
        this.id = id;
    }

    public Vacina(Integer id, String nome, String fabricante, String lote) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.lote = lote;
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
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
        if (!(object instanceof Vacina)) {
            return false;
        }
        Vacina other = (Vacina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.Vacina[ id=" + id + " ]";
    }
    
}
