package gabebuzato.com.github.CadastroAPI.Tasks;

import gabebuzato.com.github.CadastroAPI.Users.Controller.Service.UserModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class TasksModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private char dificuldade;

    //Uma task pode ter vários usuários
    @OneToMany(mappedBy = "tasks")
    private List<UserModel> user;
}
