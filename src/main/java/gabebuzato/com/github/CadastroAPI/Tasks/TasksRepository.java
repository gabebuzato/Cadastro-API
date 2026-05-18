package gabebuzato.com.github.CadastroAPI.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<TasksModel, Long> {

}
