import java.util.ArrayList;

public class Relogio {
    private int tamanhoFrame;
    private ArrayList<Integer> frames;
    private ArrayList<Boolean> segundaChance;
    private int ponteiro;

    public Relogio(int tamanhoFrame) {
        this.tamanhoFrame = tamanhoFrame;
        this.frames = new ArrayList<>(tamanhoFrame);
        this.segundaChance = new ArrayList<>(tamanhoFrame);
        this.ponteiro = 0;
    }
    
    public int executar(int[] paginas) {
        int faltasDePagina = 0;

        for (int pagina : paginas) {
            if (!frames.contains(pagina)) {
                faltasDePagina++;
                while (segundaChance.size() > ponteiro && segundaChance.get(ponteiro)) {
                    segundaChance.set(ponteiro, false);
                    ponteiro = (ponteiro + 1) % tamanhoFrame;
                }
                if (frames.size() < tamanhoFrame) {
                    frames.add(pagina);
                    segundaChance.add(false);
                } else {
                    frames.set(ponteiro, pagina);
                    segundaChance.set(ponteiro, false);
                }
                ponteiro = (ponteiro + 1) % tamanhoFrame;
            } else {
                segundaChance.set(frames.indexOf(pagina), true);
            }
        }
        return faltasDePagina;
    }
}
