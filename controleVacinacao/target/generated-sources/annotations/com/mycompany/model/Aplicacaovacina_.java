package com.mycompany.model;

import com.mycompany.model.Paciente;
import com.mycompany.model.Posto;
import com.mycompany.model.Vacina;
import com.mycompany.model.Vacinador;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-11T14:51:42")
@StaticMetamodel(Aplicacaovacina.class)
public class Aplicacaovacina_ { 

    public static volatile SingularAttribute<Aplicacaovacina, String> dose;
    public static volatile SingularAttribute<Aplicacaovacina, String> data;
    public static volatile SingularAttribute<Aplicacaovacina, Posto> postoid;
    public static volatile SingularAttribute<Aplicacaovacina, Vacinador> vacinadorid;
    public static volatile SingularAttribute<Aplicacaovacina, Integer> id;
    public static volatile SingularAttribute<Aplicacaovacina, Paciente> pacienteid;
    public static volatile SingularAttribute<Aplicacaovacina, Vacina> vacinaid;

}