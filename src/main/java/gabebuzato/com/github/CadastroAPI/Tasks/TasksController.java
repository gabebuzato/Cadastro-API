package gabebuzato.com.github.CadastroAPI.Tasks;

import org.springframework.web.bind.annotation.*;

@RestController // O rest controller basicamente é uma annotation que fala que tudo isso aqui são rotas para a minha API
@RequestMapping("missoes") // Fala que vai mapear a sua API
public class TasksController {

    // Adicionar Uma tarefa
    @PostMapping("/criar")
    public String criarTarefa(){
        return "Tarefa Criada com sucesso";
    }

    // Mostrar Uma tarefa
    @GetMapping ("/listar")
    public String listarTarefas(){
        return "Tarefas";
    }

    // Atualizar uma tarefa
    @PutMapping("/alterar")
    public String alterarTarefa(){
        return "Tarefa Atualizada com sucesso";
    }

    // Deletar uma tarefa
    @DeleteMapping("deletar")
    public String deletarTarefa(){
        return "Tarefa Deletada com sucesso";
    }
}
