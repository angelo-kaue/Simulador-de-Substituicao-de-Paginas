import java.util.LinkedList;

public class LRU {
    private int tamanhoFrame;

    public LRU(int tamanhoFrame) {
        this.tamanhoFrame = tamanhoFrame;
    }
    public int executar(int[] paginas) {
        LinkedList<Integer> frames = new LinkedList<>();
        int faltasDePagina = 0;

        for (int pagina : paginas) {
            if (!frames.contains(pagina)) {
                if (frames.size() == tamanhoFrame) {
                    frames.removeFirst();            // remove a pagina "menos recentemente" usada
                }
                faltasDePagina++;
            } else {
                frames.remove((Integer) pagina);    // "reinsere" a pagina usada
            }
            frames.addLast(pagina);
        }
        return faltasDePagina;
    }
}
