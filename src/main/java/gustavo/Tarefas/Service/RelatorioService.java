package gustavo.Tarefas.Service;

import gustavo.Tarefas.Classes.Task;
import gustavo.Tarefas.Repository.TaskRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioService {
    private TaskRepositorio taskRepositorio;

    public RelatorioService(TaskRepositorio taskRepositorio) {
        this.taskRepositorio = taskRepositorio;
    }

    public void menu(Scanner scanner) {
        Boolean istrue = true;

        while (istrue) {
            System.out.println("------------");
            System.out.println("O que deseja fazer");
            System.out.println("1- Buscar tarefas pelo titulo");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.buscarTitulo(scanner);
                    break;
                default:
                    istrue = false;
                    break;
            }
        }
    }

    private void buscarTitulo(Scanner scanner){
        System.out.print("Titulo: ");
        String titulo = scanner.next();

        List<Task> tarefa = this.taskRepositorio.findBydescricaoContaining(titulo);
        for (Task task : tarefa){
            System.out.println(task);
        }

    }

}
