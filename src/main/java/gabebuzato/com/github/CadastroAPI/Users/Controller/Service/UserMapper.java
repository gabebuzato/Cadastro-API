package gabebuzato.com.github.CadastroAPI.Users.Controller.Service;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel map(UserDTO userDTO) {
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setNome(userDTO.getNome());
        userModel.setEmail(userDTO.getEmail());
        userModel.setIdade(userDTO.getIdade());
        userModel.setRank(userDTO.getRank());
        userModel.setTasks(userDTO.getTasks());
        return userModel;
    }

    public UserDTO map(UserModel userModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setNome(userModel.getNome());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setRank(userModel.getRank());
        userDTO.setIdade(userModel.getIdade());
        userDTO.setTasks(userModel.getTasks());
        return userDTO;
    }
}
