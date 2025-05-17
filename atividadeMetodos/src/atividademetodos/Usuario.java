package atividademetodos;

import java.util.Scanner;

// Atividade Propostas pelo Curso da Dio - METODOS
// Vamos criar um exemplo de uma classse para representar uma SmarTv onde:
// Ela tenha caracteristica: ligadas (boolean), canal (int) e volume (int)
// Nossa TV poderá ligar e desligar e assim mudar o estado ligada
// Nossa TV poderá mudar de canal de 1 em 1 ou definido o numero correspondente

public class Usuario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        SmartTv smartTv = new SmartTv();
        
        System.out.print("A Tv está ligada? " + smartTv.tvLigada + "\n");
        System.out.print("Canal Atual? " + smartTv.canal + "\n");
        System.out.print("Volume Atual? " + smartTv.volumeTv + "\n");
        
        smartTv.ligar();
        System.out.print("A Tv está ligada? " + smartTv.tvLigada + "\n");
        
        smartTv.desligar();
        System.out.print("A Tv está ligada? " + smartTv.tvLigada + "\n");
        
        smartTv.diminuirVolume();
        smartTv.diminuirVolume();
        smartTv.diminuirVolume();
        
        smartTv.mudarCanal(14);
        
    }
    
}
