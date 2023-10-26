package equipes;

public class Equipes {
    private int QTD_EQUIPES;
    public Robo[] equipes;

    public Equipes(int QTD_EQUIPES){
        this.QTD_EQUIPES = QTD_EQUIPES;
        this.equipes = new Robo[QTD_EQUIPES];
    }

    public void defineVencedor() {
        double maiorQuantidadeH3 = 0;
        int indiceVencedor = 0;
        for (int i = 1; i < QTD_EQUIPES; i++) {
            if (equipes[i].getQuantidadeH3() > maiorQuantidadeH3) {
                maiorQuantidadeH3 = equipes[i].getQuantidadeH3();
                indiceVencedor = i;
            }
        }
        equipes[indiceVencedor].setVencedor();
    }

    public String checarVencedor(){
        for(int i = 1; i < QTD_EQUIPES; i++){
            if(equipes[i].getVencedor() == 1){
                return equipes[i].getNomeEquipe();
            }
        }
        return null;
    }

    public void insereRobo(String nomeEquipe, int posicaoEixoX, int posicaoEixoY, int indice){

            this.equipes[indice] = new Robo(nomeEquipe, posicaoEixoX, posicaoEixoY);
    }

    public void setQTD_EQUIPES(int QTD_EQUIPES) {
        this.QTD_EQUIPES = QTD_EQUIPES;
    }
}