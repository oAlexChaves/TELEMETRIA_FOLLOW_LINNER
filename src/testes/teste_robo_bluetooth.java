package testes;
import java.util.Random;

public class teste_robo_bluetooth {
    public static void main(String[] args) {
        int[] array = new int[6];
        Random random = new Random();

        for (int i = 1; i <= 30; i++) { // 30 iterações como exemplo
            // Preencher o array com 2500 inicialmente
            for (int j = 0; j < array.length; j++) {
                array[j] = 2500;
            }

            // Introduzir variação em índices específicos
            if (i % 3 == 0 || i % 5 == 0) {
                int variationIndex1 = random.nextInt(3); // 0, 1 ou 2
                int variationIndex2 = variationIndex1 + 1;

                int variation = random.nextInt(300) - 50; // Variação entre -50 e 250

                array[variationIndex1] -= variation;
                array[variationIndex2] -= variation;
            }

            // Imprimir o array a cada iteração
            System.out.print("Iteração " + i + ": ");
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}



