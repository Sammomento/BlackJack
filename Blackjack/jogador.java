import packages.IO;
import java.util.ArrayList;


// Classe principal dos jogadores
class DealerPlayer {
    // Atributos
    private ArrayList<Carta> baralhoJogador;
    // Construtor
    public DealerPlayer() {
        baralhoJogador = new ArrayList<Carta>(2);
    }
    // Print baralho do Player
    public void printCartasPlayer(String jogador, int index){
        for(Carta item : baralhoJogador) {
            IO.prin(
                "\n----------------------------------------"
                + "\n\tCarta N° " + index + " do " + jogador  
                + "\n----------------------------------------"    
                + "\nNúmero: " + item.getNumeroCarta()
                + "\nCor: " + item.getCorCarta()
                + "\nSimbolo: " + item.getSimboloCarta()
            );
            index += 1;
        }
    }
    // Print carta comprada
    public void printCartasComprada(String jogador, int index){
        for(int i = 2; i < baralhoJogador.size(); i++) {
            IO.prin(
                "\n----------------------------------------------"
                + "\n\tCarta comprada N° " + index + " do " + jogador  
                + "\n----------------------------------------------"    
                + "\nNúmero: " + baralhoJogador.get(i).getNumeroCarta()
                + "\nCor: " + baralhoJogador.get(i).getCorCarta()
                + "\nSimbolo: " + baralhoJogador.get(i).getSimboloCarta()
            );
            index += 1;
        }
    }
    // Print baralho do Dealer
    public void printCartasDealer(String jogador, int index){
        for(int i = 0; i < baralhoJogador.size(); i++) {
            if (i == 0) {
                IO.prin(
                    "\n----------------------------------------"
                    + "\n\tCarta N° " + index + " do " + jogador  
                    + "\n----------------------------------------"    
                    + "\nNúmero: " + baralhoJogador.get(i).getNumeroCarta()
                    + "\nCor: " + baralhoJogador.get(i).getCorCarta()
                    + "\nSimbolo: " + baralhoJogador.get(i).getSimboloCarta()
                );
                index += 1;
            } else {
                IO.prin(
                    "\n----------------------------------------"
                    + "\n\tCarta N° " + index + " do " + jogador  
                    + "\n----------------------------------------"    
                    + "\nNúmero: Oculto" 
                    + "\nCor: Oculto"
                    + "\nSimbolo: Oculto" 
                );
                index += 1;
            }
        }
    }
    // Método Suma
    public int sumarNumeros() {
        int total = 0;
        for(Carta item: baralhoJogador) {
            total += item.getNumeroCarta();
        }
        return total;
    }
    // Método: Comprar carta
    public void comprar(Baralho bj) {
        if(baralhoJogador.size() == 0 || baralhoJogador.size() == 1) {
            int index = 0;
            while (baralhoJogador.size() < 2) {
                if (bj.getElemnt(index).getNumeroCarta() < 10) {
                    baralhoJogador.add(bj.getElemnt(index));
                    bj.removeElemt(index);
                }
                index += 1;
            }
        } else {
            for(int i = 0; i < 1; i++) {
                baralhoJogador.add(bj.getElemnt(i));
                bj.removeElemt(i);
            }
        }
    }
    // Método: Verificar AS
    public void verificarAS(String jogador, boolean DouP) {
        int total = 0;
        int contadorAS = 0;
        for(int i = 0; i < baralhoJogador.size(); i++) { 
            if (baralhoJogador.get(i).getNumeroCarta() == 1) {
                for(Carta item: baralhoJogador) {
                    total += item.getNumeroCarta();
                }
                contadorAS += 1;
                total = total + 10;
                if (contadorAS == 1) {
                    if (DouP == true) {
                        if (total == 21) {
                            IO.prin(
                            "\n----------------------------------------"
                            + "\n\tCarta AS do " + jogador  
                            + "\n----------------------------------------"    
                            + "\nNúmero: 11"
                            + "\nCor: " + baralhoJogador.get(i).getCorCarta()
                            + "\nSimbolo: " + baralhoJogador.get(i).getSimboloCarta()
                            );
                            baralhoJogador.get(i).setNumero(11);
                            IO.prin("\nBLACK JACK: TUA CARTA AS VIROU 11!");
                        } else if (total < 21) {
                            IO.prin(
                            "\n----------------------------------------"
                            + "\n\tCarta AS do " + jogador  
                            + "\n----------------------------------------"    
                            + "\nNúmero: 11"
                            + "\nCor: " + baralhoJogador.get(i).getCorCarta()
                            + "\nSimbolo: " + baralhoJogador.get(i).getSimboloCarta()
                            );
                            baralhoJogador.get(i).setNumero(11);
                            IO.prin("\nTUA CARTA AS VIROU 11!");
                        } 
                    } else if (DouP == false) {
                        if (total == 21) {
                            IO.prin(
                            "\n----------------------------------------"
                            + "\n\tCarta AS do " + jogador
                            + "\n----------------------------------------"    
                            + "\nNúmero: 11"
                            + "\nCor: " + baralhoJogador.get(i).getCorCarta()
                            + "\nSimbolo: " + baralhoJogador.get(i).getSimboloCarta()
                            );
                            baralhoJogador.get(i).setNumero(11);
                            IO.prin("\nBLACK JACK: CARTA AS DO DEALER VIROU 11!");
                        } else if (total < 21) {
                            IO.prin(
                            "\n----------------------------------------"
                            + "\n\tCarta AS do " + jogador  
                            + "\n----------------------------------------"    
                            + "\nNúmero: 11"
                            + "\nCor: " + baralhoJogador.get(i).getCorCarta()
                            + "\nSimbolo: " + baralhoJogador.get(i).getSimboloCarta()
                            );
                            baralhoJogador.get(i).setNumero(11);
                            IO.prin("\nCARTA AS DO DEALER VIROU 11!");
                        }
                    }
                }
            }
        }
    }
}
