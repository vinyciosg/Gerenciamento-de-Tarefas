package gustavo.Tarefas.Service;

import gustavo.Tarefas.Classes.Task;
import gustavo.Tarefas.Repository.TaskRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudTaskService {
    private TaskRepositorio taskRepositorio;

    public CrudTaskService(TaskRepositorio taskRepositorio) {
        this.taskRepositorio = taskRepositorio;
    }

   public void menu(Scanner scanner){
       Boolean istrue = true;

       while (istrue){
           System.out.println("------------");
           System.out.println("O que deseja fazer");
           System.out.println("1- Criar uma nova tarefa");
           System.out.println("2- Listar todas as tarefas");
           System.out.println("3- Buscar uma tarefa por ID");
           System.out.println("4- Atualizar uma tarefa existente");
           System.out.println("5- Marcar uma tarefa como concluida");
           System.out.println("6- Deletar uma tarefa");
           int opcao = scanner.nextInt();

           switch (opcao){
               case 1:
                   this.criarTarefa(scanner);
                   break;
               case 2:
                   this.listarTarefas();
                   break;
               case 3:
                   this.buscaPorId(scanner);
                   break;
               case 4:
                   this.attTarefa(scanner);
                   break;
               case 5:
                   this.conOuNao(scanner);
                   break;
               case 6:
                   this.deletarTarefa(scanner);
               default:
                   istrue = false;
                   break;
           }
       }
   }

   private void criarTarefa(Scanner scanner){
       System.out.print("Tarefa: ");
       String tarefa = scanner.next();

       Task task = new Task();
       task.setDescricao(tarefa);

       this.taskRepositorio.save(task);
       System.out.println("Tarefa salva!!");
   }

   private void listarTarefas(){
        Iterable<Task> task = this.taskRepositorio.findAll();
        for (Task tarefa : task){
            System.out.println(tarefa);
        }
   }

   private void buscaPorId(Scanner scanner){
       System.out.print("ID: ");
       Long id = scanner.nextLong();

       Optional<Task> optional = this.taskRepositorio.findById(id);
       if (optional.isPresent()){
           Task task = optional.get();
           System.out.println("ID: " + task.getId());
           System.out.println("Descrição: " + task.getDescricao());
       }
   }

   private void attTarefa(Scanner scanner){
       System.out.println("ID da tarefa para ser atualizada: ");
       Long id = scanner.nextLong();

       System.out.println("Descrição: ");
       String descricao = scanner.next();

       Optional<Task> optional = this.taskRepositorio.findById(id);
       if (optional.isPresent()){
           Task tarefa = optional.get();
           tarefa.setDescricao(descricao);
           this.taskRepositorio.save(tarefa);
           System.out.println("Atualizado!!!");
       }
   }

   private void conOuNao(Scanner scanner){
       System.out.print("ID da tarefa para marcar como concluida: ");
       Long id = scanner.nextLong();
       boolean concluida = true;

       Optional<Task> optional = this.taskRepositorio.findById(id);
       if (optional.isPresent()){
           Task tarefa = optional.get();
           tarefa.setCompletOUnao(concluida);
           this.taskRepositorio.save(tarefa);
           System.out.println("Tarefa do ID " + id + " Concluida!!");
       }
   }

   private void deletarTarefa(Scanner scanner) {
       System.out.print("ID da tarefa para deletar: ");
       Long id = scanner.nextLong();
       this.taskRepositorio.deleteById(id);
       System.out.println("Tarefa deletada!!");
   }
}
