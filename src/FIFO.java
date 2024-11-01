import java.util.LinkedList;
import java.util.Queue;

public class FIFO {
    private int tamanhoFrame;

    public FIFO(int tamanhoFrame) {
        this.tamanhoFrame = tamanhoFrame;
    }

    public int executar(int[] paginas) {
        Queue<Integer> frames = new LinkedList<>();
        int faltasDePagina = 0;

        for (int pagina : paginas) {
            if (!frames.contains(pagina)) {
                if (frames.size() == tamanhoFrame) {
                    frames.poll(); // para remover a página mais antiga
                }
                frames.add(pagina);
                faltasDePagina++;
            }
        }

        return faltasDePagina;
    }
}
