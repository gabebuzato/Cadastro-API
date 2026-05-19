package gabebuzato.com.github.CadastroAPI.Users.Controller.Service;

import gabebuzato.com.github.CadastroAPI.Tasks.TasksModel;
import jakarta.persistence.*;
import lombok.*;

// Entity transforma uma classe numa entidade do DB
// JPA = Java Persistence API

@Table( name = "tb_cadastro" )
@NoArgsConstructor // cria os construtores no args
@AllArgsConstructor // Cria os construtores all args
@Data //Cria automaticamente os getters e setters
@Entity
@ToString(exclude = "tasks")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column (name = "email", unique = true)
    private String email;

    @Column (name = "rank")
    private String rank;

    @Column (name = "idade")
    private Integer idade;

    //@ManyToOne um usuário vai ter apenas uma task
    @ManyToOne
    @JoinColumn(name = "tasks_id") // Foreign Key
    private TasksModel tasks;
}
