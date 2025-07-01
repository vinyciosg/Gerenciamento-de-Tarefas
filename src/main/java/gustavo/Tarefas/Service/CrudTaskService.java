package gustavo.Tarefas.Service;

import gustavo.Tarefas.Repository.TaskRepositorio;
import org.springframework.stereotype.Service;

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
           System.out.println("2- Listar dodas as tarefas");
           System.out.println("3- Buscar uma tarefa por ID");
           System.out.println("4- Atualizar uma tarefa existente");
           System.out.println("5- Marcar uma tarefa como concluida");
           int opcao = scanner.nextInt();

           switch (opcao){
               case 1:
                   this.criarTarefa(scanner);
                   break;
               default:
                   istrue = false;
                   break;
           }
       }
   }

   private void criarTarefa(Scanner scanner){

   }

}
