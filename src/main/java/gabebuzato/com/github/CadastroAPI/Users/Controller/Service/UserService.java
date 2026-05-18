package gabebuzato.com.github.CadastroAPI.Users.Controller.Service;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // Listar todos os meus usuários
    public List<UserModel> listarUsuarios() {
        return userRepository.findAll();
    }

    public UserModel listarUsuarioPorId(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElse(null); // Ou retorna o user ou retorna null
    }

    public UserDTO cadastroUsuario(UserDTO userDTO) {
        UserModel user = userMapper.map(userDTO);
        user = userRepository.save(user);
        return userMapper.map(user);
    }

    public void deletarUsuarioPorId(Long id) {
    userRepository.deleteById(id);
    }

    //Atualizar Usuário
    public UserModel atualizarUsuarioPorId(Long id, UserModel user) {
        Optional<UserModel> userModel = userRepository.findById(id);
        if(userRepository.existsById(id)){
            user.setId(id);
            userRepository.save(user);
        } else {
            return null;
        }
        return userModel.get();
    }
}
