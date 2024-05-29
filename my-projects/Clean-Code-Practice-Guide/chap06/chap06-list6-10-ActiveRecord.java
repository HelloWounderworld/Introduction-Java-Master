// Active Record - A kind of specific DTO.

// Uma boa pratica de utilizar o Active Record seria em trata-lo como uma estrutura de dados e
// separadamente, criar um outro objeto que nela esteja contido as devidas regras de negocios.
// Ou seja, metodos que segue a Lei de Demeter, encapsulando os metodos nativos que vem do Active Records.

// https://objsql.hashnode.dev/active-record-pattern-in-java

@DomainModel
public class Member {
    private String no;

    @Queryable
    private String name;
    private Integer gender;
    private String mobile;
    private String otherInfo;

    @Relation(relationType = RelationType.HAS_MANY)
    private List<Order> orders;
}
