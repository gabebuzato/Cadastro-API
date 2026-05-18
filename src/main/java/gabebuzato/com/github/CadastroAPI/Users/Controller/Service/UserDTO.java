package gabebuzato.com.github.CadastroAPI.Users.Controller.Service;

import gabebuzato.com.github.CadastroAPI.Tasks.TasksModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String nome;
    private String email;
    private String rank;
    private Integer idade;
    private TasksModel tasks;
}