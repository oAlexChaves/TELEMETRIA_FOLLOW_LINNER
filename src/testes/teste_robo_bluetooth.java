package testes;

import java.util.Random;

public class teste_robo_bluetooth {
	
    public  double P = 1 + (2 - 1) * random.nextDouble();
    public  double I = 0.0001 + (0.0005 - 0.0001) * random.nextDouble(); 
    public  double D = 1.5 + (4 - 1.5) * random.nextDouble();
    public  double Initial_speed = 80 + (120 - 80) * random.nextDouble();
    

    private static final String[] STRINGS = {
            "2500 2500 2500 2500 2500 2500 2500 2500",
            "2500 2500 2500 2500 2500 2500 2500 2500",
            "2500 2500 2500 2500 2500 2500 2500 2500",
            "2500 2500 2500 2500 2500 2500 2500 2500",
            "2200 2300 2400 2500 2500 2500 2500 2500",
            "2500 2500 2500 2500 2400 2300 2200 2100",
            "2500 2500 2500 2500 2400 2500 2500 2400",
            "2400 2500 2500 2500 2500 2500 2500 2500"
    };

    private static final Random random = new Random();

    public static String randomizarString() {
        int indiceSelecionado = random.nextInt(STRINGS.length);
        return STRINGS[indiceSelecionado];
    }
}
