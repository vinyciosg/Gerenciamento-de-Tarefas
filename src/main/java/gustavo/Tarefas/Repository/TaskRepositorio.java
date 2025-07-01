package gustavo.Tarefas.Repository;


import gustavo.Tarefas.Classes.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepositorio extends CrudRepository<Task, Long> {
}
