package gabebuzato.com.github.CadastroAPI;

import jakarta.persistence.*;

// Entity transforma uma classe numa entidade do DB
// JPA = Java Persistence API

@Table( name = "tb_cadastro" )
@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nome;
    private String email;
    private int idade;

    public UserModel() {
    }
    public UserModel(String nome, String email, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
