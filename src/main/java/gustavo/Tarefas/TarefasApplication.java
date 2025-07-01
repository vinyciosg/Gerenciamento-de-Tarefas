package gustavo.Tarefas;

import gustavo.Tarefas.Service.CrudTaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TarefasApplication implements CommandLineRunner {
	private CrudTaskService crudTaskService;

	public TarefasApplication(CrudTaskService crudTaskService) {
		this.crudTaskService = crudTaskService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TarefasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Boolean istrue = true;
		Scanner box = new Scanner(System.in);

		while (istrue){
			System.out.println("------------");
			System.out.println("O que deseja fazer");
			System.out.println("1- Abrir Tarefas");
			int opcao = box.nextInt();

			switch (opcao){
				case 1:
					this.crudTaskService.menu(box);
					break;
				default:
					istrue = false;
					break;
			}

		}

	}
}
