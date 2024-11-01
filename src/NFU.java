import java.util.HashMap;

public class NFU {
    private int tamanhoFrame;

    public NFU(int tamanhoFrame) {
        this.tamanhoFrame = tamanhoFrame;
    }

    public int executar(int[] paginas) {
        HashMap<Integer, Integer> frames = new HashMap<>();
        int faltasDePagina = 0;

        for (int pagina : paginas) {
            if (!frames.containsKey(pagina)) {
                faltasDePagina++;
                if (frames.size() == tamanhoFrame) {
                    // substitui a página com menor contador
                    int paginaMenosUsada = frames.entrySet().stream().min((e1, e2) -> e1.getValue() - e2.getValue()).get().getKey();
                    frames.remove(paginaMenosUsada);
                }
                frames.put(pagina, 1);
            } else {
                frames.put(pagina, frames.get(pagina) + 1);
            }
        }

        return faltasDePagina;
    }
}
