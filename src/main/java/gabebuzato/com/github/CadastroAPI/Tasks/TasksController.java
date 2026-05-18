package gabebuzato.com.github.CadastroAPI.Tasks;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // O rest controller basicamente é uma annotation que fala que tudo isso aqui são rotas para a minha API
@RequestMapping("/missoes") // Fala que vai mapear a sua API
public class TasksController {

    private TasksService taskService;

    public void  TasksService(TasksService taskService) {
        this.taskService = taskService;
    }

    // Adicionar Uma tarefa
    @PostMapping("/criar")
    public TasksModel criarTarefa(TasksModel task){
        return taskService.criarTarefa(task);
    }

    // Mostrar Uma tarefa
    @GetMapping ("/listar")
    public List<TasksModel> listarTarefas(){
        return taskService.listarTarefas();
    }

    @GetMapping ("/listar/{id}")
    public TasksModel listarTarefaPorId(@PathVariable Long id){
        return taskService.listarTarefasPorId(id);
    }

    // Atualizar uma tarefa
    @PutMapping("/alterar")
    public String alterarTarefa(){
        return "";
    }

    // Deletar uma tarefa
    @DeleteMapping("/deletar/{id}")
    public void deletarTarefa(@PathVariable Long id){
        taskService.deltarTarefa(id);
    }
}
