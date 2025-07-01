package gustavo.Tarefas.Repository;


import gustavo.Tarefas.Classes.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Stack;

public interface TaskRepositorio extends CrudRepository<Task, Long> {

     Stack<Task> findBydescricaoContaining(String descricao);

}
