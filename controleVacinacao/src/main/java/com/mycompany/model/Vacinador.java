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
@Table(name = "vacinador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacinador.findAll", query = "SELECT v FROM Vacinador v")
    , @NamedQuery(name = "Vacinador.findById", query = "SELECT v FROM Vacinador v WHERE v.id = :id")
    , @NamedQuery(name = "Vacinador.findByNome", query = "SELECT v FROM Vacinador v WHERE v.nome = :nome")
    , @NamedQuery(name = "Vacinador.findByIdade", query = "SELECT v FROM Vacinador v WHERE v.idade = :idade")
    , @NamedQuery(name = "Vacinador.findByCpf", query = "SELECT v FROM Vacinador v WHERE v.cpf = :cpf")
    , @NamedQuery(name = "Vacinador.findByTelefone", query = "SELECT v FROM Vacinador v WHERE v.telefone = :telefone")})
public class Vacinador implements Serializable, EntidadeBase {

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
    @Column(name = "idade")
    private int idade;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacinadorid")
    private List<Aplicacaovacina> aplicacaovacinaList;
    @JoinColumn(name = "Endereco_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Endereco enderecoid;

    public Vacinador() {
    }

    public Vacinador(Integer id) {
        this.id = id;
    }

    public Vacinador(Integer id, String nome, int idade, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @XmlTransient
    public List<Aplicacaovacina> getAplicacaovacinaList() {
        return aplicacaovacinaList;
    }

    public void setAplicacaovacinaList(List<Aplicacaovacina> aplicacaovacinaList) {
        this.aplicacaovacinaList = aplicacaovacinaList;
    }

    public Endereco getEnderecoid() {
        return enderecoid;
    }

    public void setEnderecoid(Endereco enderecoid) {
        this.enderecoid = enderecoid;
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
        if (!(object instanceof Vacinador)) {
            return false;
        }
        Vacinador other = (Vacinador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.Vacinador[ id=" + id + " ]";
    }
    
}
