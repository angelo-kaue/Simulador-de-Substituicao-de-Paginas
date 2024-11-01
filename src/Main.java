import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // entrada de páginas que serão usadas
        System.out.print("Digite a sequência de páginas (separadas por espaço): ");
        String[] input = scanner.nextLine().split(" ");
        int[] paginas = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            paginas[i] = Integer.parseInt(input[i]);
        }

        System.out.print("Digite o tamanho dos frames: ");
        int tamanhoFrame = scanner.nextInt();

        // aqui irá executar os algoritmos e calcular as faltas de página
        FIFO fifo = new FIFO(tamanhoFrame);
        int fifoFaltas = fifo.executar(paginas);
        System.out.println("FIFO: " + fifoFaltas + " faltas de página.");

        LRU lru = new LRU(tamanhoFrame);
        int lruFaltas = lru.executar(paginas);
        System.out.println("LRU: " + lruFaltas + " faltas de página.");

        Relogio relogio = new Relogio(tamanhoFrame);
        int relogioFaltas = relogio.executar(paginas);
        System.out.println("Relógio: " + relogioFaltas + " faltas de página.");

        NFU nfu = new NFU(tamanhoFrame);
        int nfuFaltas = nfu.executar(paginas);
        System.out.println("NFU: " + nfuFaltas + " faltas de página.");
        
        scanner.close();
    }
}
