package gabebuzato.com.github.CadastroAPI.Users.Controller.Service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private UserService userService;

   public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Usuário (CREATE)
    @PostMapping("/criar")
    public UserModel criarUsuario(@RequestBody  UserModel user)  { // annotation para quando o usuário precisa enviar algo no corpo da minha requisição
        return userService.cadastroUsuario(user);
    }


    // Procurar Usuario por ID (READ)
    @GetMapping("/listar/{id}")
    public UserModel listarPorID (@PathVariable Long id) { // O path varible é uma variavel quem vem pela requisição http, colocamos ela quando precisamos desse parametro na nossa função para retornar algo
        return userService.listarUsuarioPorId(id);
    }

    // Mostrar os Usuários (READ)
    @GetMapping("/listar")
    public List<UserModel> listarUsuarios() {
        return userService.listarUsuarios();
    }

    // Alterar dados do Usuário (UPDATE)
    @PutMapping ("/alterar/{id}")
    public UserModel alterarUsuarioPorID(@PathVariable Long id, @RequestBody  UserModel user) {
       return userService.atualizarUsuarioPorId(id, user);
    }

    // Deletar Usuário (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarUsuarioPorID(@PathVariable Long id) {
       userService.deletarUsuarioPorId(id);
    }

}
