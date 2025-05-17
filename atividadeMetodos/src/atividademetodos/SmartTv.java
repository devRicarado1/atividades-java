package atividademetodos;

public class SmartTv {

    boolean tvLigada = false;
    int canal = 1;
    int volumeTv = 50;

    public void ligar() {
        tvLigada = true;

    }

    public void desligar() {
        tvLigada = false;
    }

    public void aumentaVolume() {
        volumeTv++;
        System.out.println("Volume Aumentado para: " + volumeTv);
    }

    public void diminuirVolume() {
        volumeTv--;
        System.out.println("Volume Diminuido para: " + volumeTv);
    }
    public void aumentarCanal() {
        canal++;
        System.out.println("Canal Aumentado para: " + canal);
    }
    public void diminuirCanal() {
        canal--;
        System.out.println("Canal Diminuido para: " + canal);
    }
    public void mudarCanal (int mudarCanal) {
        System.out.println("Canal Alterado para: " + mudarCanal);
    }
    
}
