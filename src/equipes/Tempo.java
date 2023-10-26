package equipes;

public class Tempo {

    long tempoInicial;
    long tempoFinal;

    public Tempo(){
        this.tempoInicial = System.currentTimeMillis();
        this.tempoFinal = System.currentTimeMillis();
    }

    public void setTempoFinal(){

        this.tempoFinal = System.currentTimeMillis();
    }

    public long tempoTotalDeJogo(){
        setTempoFinal();
        return (tempoFinal - tempoInicial);
    }

}
