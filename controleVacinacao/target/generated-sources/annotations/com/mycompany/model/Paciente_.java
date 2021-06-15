package com.mycompany.model;

import com.mycompany.model.Aplicacaovacina;
import com.mycompany.model.Endereco;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-11T14:51:42")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, String> idade;
    public static volatile SingularAttribute<Paciente, String> telefone;
    public static volatile SingularAttribute<Paciente, String> fatorRisco;
    public static volatile SingularAttribute<Paciente, Endereco> enderecoid;
    public static volatile SingularAttribute<Paciente, String> cpf;
    public static volatile SingularAttribute<Paciente, String> nome;
    public static volatile SingularAttribute<Paciente, Integer> id;
    public static volatile ListAttribute<Paciente, Aplicacaovacina> aplicacaovacinaList;

}