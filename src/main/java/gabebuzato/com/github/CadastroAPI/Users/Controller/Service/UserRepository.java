package gabebuzato.com.github.CadastroAPI.Users.Controller.Service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
