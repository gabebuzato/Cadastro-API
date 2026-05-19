package gabebuzato.com.github.CadastroAPI.Users.Controller.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserService userService;

   public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Usuário (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarUsuario(@RequestBody  UserDTO user)  { // annotation para quando o usuário precisa enviar algo no corpo da minha requisição
        UserDTO userDTO = userService.cadastroUsuario(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário criado com sucesso! " + userDTO.getNome() + " (ID): " + userDTO.getId());
    }


    // Procurar Usuario por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorID (@PathVariable Long id) { // O path varible é uma variavel quem vem pela requisição http, colocamos ela quando precisamos desse parametro na nossa função para retornar algo

       if (userService.listarUsuarioPorId(id) != null) {
           UserDTO user = userService.listarUsuarioPorId(id);
           return ResponseEntity.ok(user);
       } else  {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário com o id: " + id + " não encontrado!");
       }

    }

    // Mostrar os Usuários (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<UserDTO>> listarUsuarios() {
         List<UserDTO> users = userService.listarUsuarios();
         return ResponseEntity.ok(users);
    }

    // Alterar dados do Usuário (UPDATE)
    @PatchMapping ("/alterar/{id}")
    public ResponseEntity<String> alterarUsuarioPorID(@PathVariable Long id, @RequestBody  UserDTO user) {
        if(userService.listarUsuarioPorId(id) != null){
            userService.atualizarUsuarioPorId(id, user);
            return ResponseEntity.ok("Dados do usuário com o ID: " + id + " alterados com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário de ID: " + id + " não encontrado!");
        }
    }

    // Deletar Usuário (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarUsuarioPorID(@PathVariable Long id) {
       if(userService.listarUsuarioPorId(id) != null){
           userService.deletarUsuarioPorId(id);
           return ResponseEntity.ok("Usuário com o ID: " + id + " deletado com sucesso!");
       } else  {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário de ID: " + id + " não encontrado!");
       }
    }

}
