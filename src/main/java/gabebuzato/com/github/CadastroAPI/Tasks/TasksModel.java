package gabebuzato.com.github.CadastroAPI.Tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gabebuzato.com.github.CadastroAPI.Users.Controller.Service.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data              // ✅ adicione
@NoArgsConstructor // ✅ adicione
@AllArgsConstructor // ✅ adicione
public class TasksModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Character dificuldade;

    @OneToMany(mappedBy = "tasks")
    @JsonIgnore
    private List<UserModel> user;
}