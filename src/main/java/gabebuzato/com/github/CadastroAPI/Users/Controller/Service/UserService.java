package gabebuzato.com.github.CadastroAPI.Users.Controller.Service;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Listar todos os meus usuários
    public List<UserModel> listarUsuarios() {
        return userRepository.findAll();
    }

    public UserModel listarUsuarioPorId(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElse(null); // Ou retorna o user ou retorna null
    }
}
