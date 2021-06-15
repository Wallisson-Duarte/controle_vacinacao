package com.mycompany.model;

import com.mycompany.model.Aplicacaovacina;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-11T14:51:42")
@StaticMetamodel(Vacina.class)
public class Vacina_ { 

    public static volatile SingularAttribute<Vacina, String> lote;
    public static volatile SingularAttribute<Vacina, String> nome;
    public static volatile SingularAttribute<Vacina, Integer> id;
    public static volatile SingularAttribute<Vacina, String> fabricante;
    public static volatile ListAttribute<Vacina, Aplicacaovacina> aplicacaovacinaList;

}