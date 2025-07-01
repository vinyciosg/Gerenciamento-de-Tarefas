package gustavo.Tarefas.Classes;

import jakarta.persistence.*;

@Entity
@Table(name = "tb-tarefa")
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false)
    private String descricao;

    private boolean completOUnao;

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
