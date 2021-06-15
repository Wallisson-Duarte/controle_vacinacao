package com.mycompany.model;

import com.mycompany.model.Aplicacaovacina;
import com.mycompany.model.Endereco;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-11T14:51:42")
@StaticMetamodel(Posto.class)
public class Posto_ { 

    public static volatile SingularAttribute<Posto, Endereco> enderecoid;
    public static volatile SingularAttribute<Posto, String> nome;
    public static volatile SingularAttribute<Posto, Integer> id;
    public static volatile ListAttribute<Posto, Aplicacaovacina> aplicacaovacinaList;

}