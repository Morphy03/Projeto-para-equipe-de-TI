/**
 * Representa uma tarefa de suporte que herda da classe Tarefa.
 */
public class TarefaSuporte extends Tarefa {
    private int tempoMax;
    private char urgente;

    /**
     * Construtor da classe TarefaSuporte.
     * @param descricao a descrição da tarefa.
     * @param tempoEstimado o tempo estimado em horas para completar a tarefa.
     * @param responsavel o técnico responsável pela tarefa.
     * @param tempoMax o tempo máximo em dias para a conclusão da tarefa de suporte.
     * @param urgente indica se a tarefa de suporte é urgente ('S' para Sim, 'N' para Não).
     * @throws IllegalArgumentException se o campo 'tempoMax' for menor ou igual a zero
     *                                ou se o campo 'urgente' não for 'S' ou 'N'.
     */
    public TarefaSuporte(String descricao, int tempoEstimado, Tecnico responsavel, int tempoMax, char urgente) {
        super(descricao, tempoEstimado, responsavel);
        if (tempoMax > 0) {
            this.tempoMax = tempoMax;
        } else {
            throw new IllegalArgumentException("O tempo máximo deve ser maior que zero.");
        }
        if (urgente == 'S' || urgente == 'N') {
            this.urgente = urgente;
        } else {
            throw new IllegalArgumentException("O campo 'urgente' deve ser 'S' ou 'N'.");
        }
    }

    /**
     * Obtém o tempo máximo em dias para a conclusão da tarefa de suporte.
     * @return o tempo máximo em dias.
     */
    public int getTempoMax() {
        return tempoMax;
    }

    /**
     * Obtém se a tarefa de suporte é urgente ('S' para Sim, 'N' para Não).
     * @return 'S' se a tarefa de suporte for urgente, 'N' caso contrário.
     */
    public char getUrgente() {
        return urgente;
    }
}
