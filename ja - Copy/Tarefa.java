/**
 * Representa uma tarefa a ser realizada.
 */
public class Tarefa {
    private String descricao;
    private int tempoEstimado;
    private Tecnico responsavel;

    /**
     * Construtor da classe Tarefa.
     * @param descricao a descrição da tarefa.
     * @param tempoEstimado o tempo estimado em horas para completar a tarefa.
     * @param responsavel o técnico responsável pela tarefa.
     * @throws IllegalArgumentException se o tempo estimado for menor ou igual a zero.
     */
    public Tarefa(String descricao, int tempoEstimado, Tecnico responsavel) {
        this.descricao = descricao;
        if (tempoEstimado > 0) {
            this.tempoEstimado = tempoEstimado;
        } else {
            throw new IllegalArgumentException("O tempo estimado deve ser maior que zero.");
        }
        this.responsavel = responsavel;
    }

    /**
     * Obtém a descrição da tarefa.
     * @return a descrição da tarefa.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Obtém o tempo estimado em horas para completar a tarefa.
     * @return o tempo estimado em horas.
     */
    public int getTempoEstimado() {
        return tempoEstimado;
    }

    /**
     * Obtém o técnico responsável pela tarefa.
     * @return o técnico responsável pela tarefa.
     */
    public Tecnico getResponsavel() {
        return responsavel;
    }
}
