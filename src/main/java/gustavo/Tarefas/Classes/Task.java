package gustavo.Tarefas.Classes;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tarefa")
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean completOUnao = false;

    private String descricao;

    // nao sera utilizado
    @Deprecated
    public Task() {
    }

    public Task(boolean completOUnao, String descricao) {
        this.completOUnao = completOUnao;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCompletOUnao() {
        return completOUnao;
    }

    public void setCompletOUnao(boolean completOUnao) {
        this.completOUnao = completOUnao;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", completOUnao=" + completOUnao +
                '}';
    }
}
