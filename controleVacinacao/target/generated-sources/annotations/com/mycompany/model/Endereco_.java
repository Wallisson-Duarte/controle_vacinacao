package com.mycompany.model;

import com.mycompany.model.Paciente;
import com.mycompany.model.Posto;
import com.mycompany.model.Vacinador;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-11T14:51:42")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile SingularAttribute<Endereco, String> cidade;
    public static volatile SingularAttribute<Endereco, String> estado;
    public static volatile ListAttribute<Endereco, Vacinador> vacinadorList;
    public static volatile SingularAttribute<Endereco, Integer> numero;
    public static volatile SingularAttribute<Endereco, Integer> id;
    public static volatile ListAttribute<Endereco, Paciente> pacienteList;
    public static volatile SingularAttribute<Endereco, String> rua;
    public static volatile SingularAttribute<Endereco, String> cep;
    public static volatile ListAttribute<Endereco, Posto> postoList;

}