package mapa;
import java.lang.Math;

public class Mapa {
    public final Celula[][] mapa;
    private final int LIMITE_DO_MAPA;

    public Mapa(int LIMITE_DO_MAPA){
        this.LIMITE_DO_MAPA = LIMITE_DO_MAPA;
        mapa = new Celula[LIMITE_DO_MAPA][LIMITE_DO_MAPA];
    }

    public void inserirCelula(int posicaoEixoX, int posicaoEixoY, double rugosidadeDaCelula, double concentracaoDeHelio3){

        mapa[posicaoEixoX][posicaoEixoY] = new Celula();
        mapa[posicaoEixoX][posicaoEixoY].setRugosidadeDaCelula(rugosidadeDaCelula);
        mapa[posicaoEixoX][posicaoEixoY].setCoeficienteDeErro(Math.random()/10);
        double armazenaErro = mapa[posicaoEixoX][posicaoEixoY].getCoeficienteDeErro();
        mapa[posicaoEixoX][posicaoEixoY].setConcentracaoDeHelio3(concentracaoDeHelio3 + armazenaErro);
    }


    public int getLIMITE_DO_MAPA() {
        return LIMITE_DO_MAPA;
    }
}
