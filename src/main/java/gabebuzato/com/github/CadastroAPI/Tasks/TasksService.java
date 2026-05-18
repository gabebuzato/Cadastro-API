package gabebuzato.com.github.CadastroAPI.Tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    private TasksRepository tasksRepository;
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<TasksModel> listarTarefas(){
        return tasksRepository.findAll();
    }

    public TasksModel listarTarefasPorId(Long id){
        Optional<TasksModel> task = tasksRepository.findById(id);
        return task.orElse(null);
    }

    public TasksModel criarTarefa(TasksModel task){
        return tasksRepository.save(task);
    }

    public void deltarTarefa(Long id){
        tasksRepository.deleteById(id);
    }

}
