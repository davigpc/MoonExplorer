package equipes;
import mapa.Mapa;
import mapa.Celula;
import java.util.concurrent.TimeUnit;
import equipes.Tempo;


public class Robo {

    private final String nomeEquipe;
    private int posicaoEixoX;
    private int posicaoEixoY;
    private double quantidadeH3;
    private int comandoRobo; // -> TimeUnit.SECONDS.sleep(1);
    private int frenteRobo;
    private int vencedor;


    public Robo(String nomeEquipe, int posicaoEixoX, int posicaoEixoY){
        this.nomeEquipe = nomeEquipe;
        this.posicaoEixoX = posicaoEixoX;
        this.posicaoEixoY = posicaoEixoY;
        this.quantidadeH3 = 0;
        this.vencedor = 0;
    }

    public int getVencedor(){
        return this.vencedor;
    }

    public void setVencedor(){
        this.vencedor = 1;
    }
    public int getPosicaoEixoX() {
        return posicaoEixoX;
    }

    public int getPosicaoEixoY() {
        return posicaoEixoY;
    }

    public double getQuantidadeH3(){
        return quantidadeH3;
    }

    public void setQuantidadeH3(double quantidadeH3) {
        this.quantidadeH3 = quantidadeH3;
    }

    public long getTempoDeslocamento(Celula celula){
        return (long) (3 + (3 * celula.getRugosidadeDaCelula()));
    }

    public long getTempoSonda(Celula celula){

        return (long) (5 + (5 * celula.getConcentracaoDeHelio3()));
    }

    public void imprimeConcentracao(Celula celula){
        System.out.printf("Concentracao de H3: %f\n", celula.getConcentracaoDeHelio3());
    }

    public void imprimePosicao(){
        System.out.printf("Posicoes: (%d, %d)\n", getPosicaoEixoX(), getPosicaoEixoY());
    }

    public void imprimeRugosidade(Celula celula){
        System.out.printf("Rugosidade da Celula: %f\n", celula.getRugosidadeDaCelula());
    }

    // 0 aponta para baixo, 1 aponta para direita, 2 aponta para cima, 3 aponta para esquerda
    public void movimentarParaDireita(){
        if(this.frenteRobo == 0){
            this.frenteRobo = 3;
            System.out.println("Girou para direita.");
        }
        else{
            this.frenteRobo--;
            System.out.println("Girou para direita.");
        }

    }
    public void movimentarParaEsquerda(){
        if(this.frenteRobo == 3){
            this.frenteRobo = 0;
            System.out.println("Girou para esquerda.");
        }
        else{
            this.frenteRobo++;
            System.out.println("Girou para esquerda.");
        }
    }
    public int movimentarParaFrente(Mapa mapa){
        if(this.frenteRobo == 0){
            if(this.posicaoEixoY == 0){
                return 0;
            }
            else if(mapa.mapa[posicaoEixoX][posicaoEixoY-1].getTemRoboAqui() == 1){
                return 0;
            }
            else{
                this.posicaoEixoY--;
                System.out.println("Acelerou.");
                return 1;
            }
        }
        else if(this.frenteRobo == 1){
            if(this.posicaoEixoX == mapa.getLIMITE_DO_MAPA()){
                return 0;
            }
            else if(mapa.mapa[posicaoEixoX+1][posicaoEixoY].getTemRoboAqui() == 1){
                return 0;
            }
            else{
                this.posicaoEixoX++;
                System.out.println("Acelerou.");
                return 1;
            }
        }
        else if(this.frenteRobo == 2){
            if(this.posicaoEixoY == mapa.getLIMITE_DO_MAPA()){
                return 0;
            }
            else if(mapa.mapa[posicaoEixoX][posicaoEixoY+1].getTemRoboAqui() == 1){
                return 0;
            }
            else{
                this.posicaoEixoY++;
                System.out.println("Acelerou.");
                return 1;
            }
        }
        else{
            if(this.posicaoEixoX == 0){
                return 0;
            }
            else if(mapa.mapa[posicaoEixoX-1][posicaoEixoY].getTemRoboAqui() == 1){
                return 0;
            }
            else{
                this.posicaoEixoX--;
                System.out.println("Acelerou.");
                return 1;
            }
        }
    }

    public int verificaSondasVizinhas(Mapa mapa) {
        return 0;
    }

    public void sondar(Mapa mapa){
        if(verificaSondasVizinhas(mapa) == 0){
            System.out.printf("Iniciando prospeccao!\nTempo esperado: %d.\n", getTempoSonda(mapa.mapa[posicaoEixoX][posicaoEixoY]));
            this.quantidadeH3 += mapa.mapa[posicaoEixoX][posicaoEixoY].getConcentracaoDeHelio3();
            mapa.mapa[posicaoEixoX][posicaoEixoY].setConcentracaoDeHelio3(0);
        }
    }

    public void imprimirTempoDeJogo(Tempo tempo){

        System.out.printf("Tempo decorrido: %d segundos\n", tempo.tempoTotalDeJogo()/1000);
    }


    public int getComandoRobo() {
        return comandoRobo;
    }

    public void setComandoRobo(int comandoRobo) {
        this.comandoRobo = comandoRobo;
    }

    public void comandaRobo(Mapa mapa, Tempo tempo){
        switch (this.comandoRobo){
            case 0:
                imprimePosicao();
                break;
            case 1:
                imprimeConcentracao(mapa.mapa[posicaoEixoX][posicaoEixoY]);
                break;
            case 2:
                imprimeRugosidade(mapa.mapa[posicaoEixoX][posicaoEixoY]);
                break;
            case 3:
                imprimirTempoDeJogo(tempo);
                break;
            case 4:
                movimentarParaFrente(mapa);
                try {
                    TimeUnit.SECONDS.sleep(getTempoDeslocamento(mapa.mapa[posicaoEixoX][posicaoEixoY]));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;

            case 5:
                movimentarParaDireita();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 6:
                movimentarParaEsquerda();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 7:
                sondar(mapa);
                try {
                    TimeUnit.SECONDS.sleep(getTempoSonda(mapa.mapa[posicaoEixoX][posicaoEixoY]));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                break;
        }
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }
}