package gabebuzato.com.github.CadastroAPI.Users.Controller.Service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Usuário (CREATE)
    @PostMapping("/criar")
    public String criarUsuario() {
        return "Usuário criado com sucesso";
    }


    // Procurar Usuario por ID (READ)
    @GetMapping("/todosId")
    public String mostrarTodosOsUsuariosPorId() {
        return "Mostrar Usuário por Id";
    }

    // Mostrar os Usuários (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsUsuarios() {
        return "Mostrar Usuarios";
    }

    // Alterar dados do Usuário (UPDATE)
    @PutMapping("/alterarID")
    public String alterarUsuarioPorID() {
        return "Informações alteradas com sucesso";
    }

    // Deletar Usuário (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarUsuarioPorID() {
        return "Usuario deletado com sucesso";
    }

}
