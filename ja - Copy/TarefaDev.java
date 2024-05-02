/**
 * Representa uma tarefa de desenvolvimento que herda da classe Tarefa.
 */
public class TarefaDev extends Tarefa {
    private String linguagem;
    private char tipo;

    /**
     * Construtor da classe TarefaDev.
     * @param descricao a descrição da tarefa.
     * @param tempoEstimado o tempo estimado em horas para completar a tarefa.
     * @param responsavel o técnico responsável pela tarefa.
     * @param linguagem a linguagem de programação associada à tarefa de desenvolvimento.
     * @param tipo o tipo de tarefa ('N' para Nova Funcionalidade, 'C' para Correção).
     * @throws IllegalArgumentException se o campo 'tipo' não for 'N' ou 'C'.
     */
    public TarefaDev(String descricao, int tempoEstimado, Tecnico responsavel, String linguagem, char tipo) {
        super(descricao, tempoEstimado, responsavel);
        this.linguagem = linguagem;
        if (tipo == 'N' || tipo == 'C') {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("O campo 'tipo' deve ser 'N' ou 'C'.");
        }
    }

    /**
     * Obtém a linguagem de programação associada à tarefa de desenvolvimento.
     * @return a linguagem de programação.
     */
    public String getLinguagem() {
        return linguagem;
    }

    /**
     * Obtém o tipo de tarefa ('N' para Nova Funcionalidade, 'C' para Correção).
     * @return o tipo de tarefa.
     */
    public char getTipo() {
        return tipo;
    }
}
