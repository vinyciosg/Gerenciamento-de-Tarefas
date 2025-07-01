package gustavo.Tarefas;

import gustavo.Tarefas.Service.CrudTaskService;
import gustavo.Tarefas.Service.RelatorioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TarefasApplication implements CommandLineRunner {
	private CrudTaskService crudTaskService;
	private RelatorioService relatorioService;

	public TarefasApplication(CrudTaskService crudTaskService, RelatorioService relatorioService) {
		this.crudTaskService = crudTaskService;
		this.relatorioService = relatorioService;
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
			System.out.println("2- Abrir Relatorio");
			int opcao = box.nextInt();

			switch (opcao){
				case 1:
					this.crudTaskService.menu(box);
					break;
				case 2:
					this.relatorioService.menu(box);
					break;
				default:
					istrue = false;
					break;
			}
		}
	}
}
