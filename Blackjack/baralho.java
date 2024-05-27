import java.util.ArrayList;
import packages.IO;
import java.util.Random;


// Classe que representa um baralho de cartas
abstract class Baralho {
    // Atributo
    protected ArrayList<Carta> baralho;
    // Construtor
    public Baralho() {
        baralho = new ArrayList<Carta>();
    }
    // Método: Criar Baralho para BlackJack
    public abstract void baralhoCreate();
    // Print baralho
    public void printCartas(){
        for(Carta item : baralho) {
            System.out.println(item);
        }
    }
    // Método: Embaralhar
    public void embaralhar() {
            int iterador = 0;
            Random random = new Random();         
            for(Carta item : baralho) {
                int numRandom = random.nextInt(baralho.size());
                Carta itemGuardado = item;
                Carta itemRandom = baralho.get(numRandom);
                baralho.set(iterador, itemRandom);
                baralho.set(numRandom, itemGuardado);
                iterador += 1;
            }
        }
    // Método: Get element do baralho
    public Carta getElemnt(int id) {
        Carta carta = baralho.get(id);
        return carta;
    }
    // Método: Remove element do baralho
    public void removeElemt(int id) {
        baralho.remove(id);
    }
     // Método: Resultar tamanho do baralho
     public int tamanho() {
        int tamanho = baralho.size();
        return tamanho;
    }
}
