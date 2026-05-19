package gabebuzato.com.github.CadastroAPI.Users.Controller.Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // Listar todos os meus usuários
    public List<UserDTO> listarUsuarios() {
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    public UserDTO listarUsuarioPorId(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.map(userMapper::map).orElse(null); // Ou retorna o user ou retorna null
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
    public UserDTO atualizarUsuarioPorId(Long id, UserDTO user) {
        Optional<UserModel> usuarioExistente = userRepository.findById(id);
        if (usuarioExistente.isPresent()) {
        UserModel usuarioAtualizado = userMapper.map(user);
        usuarioAtualizado.setId(id);
        UserModel usuarioSalvo = userRepository.save(usuarioAtualizado);
        return userMapper.map(usuarioSalvo);
        }
        return null;
    }
}
