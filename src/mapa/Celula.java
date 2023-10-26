package mapa;


public class Celula {
    //atributos

    private double rugosidadeDaCelula;
    private double concentracaoDeHelio3;
    private double coeficienteDeErro;
    private int temRoboAqui;
    private int estaSendoSondada;
    //construct
    public Celula(){
        this.rugosidadeDaCelula = 1;
        this.concentracaoDeHelio3 = 0;
        this.coeficienteDeErro = 0.02;
        this.temRoboAqui = 0;
        this.estaSendoSondada = 0;
    }

    public double getRugosidadeDaCelula(){
        return this.rugosidadeDaCelula;
    }

    public void setRugosidadeDaCelula(double rugosidadeDaCelula){

        this.rugosidadeDaCelula = rugosidadeDaCelula;
    }

    public double getConcentracaoDeHelio3(){
        return this.concentracaoDeHelio3;
    }

    public void setConcentracaoDeHelio3(double concentracaoDeHelio3){
        this.concentracaoDeHelio3 = concentracaoDeHelio3;
    }


    public double getCoeficienteDeErro() {
        return coeficienteDeErro;
    }

    public void setCoeficienteDeErro(double coeficienteDeErro) {
        this.coeficienteDeErro = coeficienteDeErro;
    }

    public int getTemRoboAqui() {
        return temRoboAqui;
    }

    public void setTemRoboAqui(int temRoboAqui) {
        this.temRoboAqui = temRoboAqui;
    }

    public int getEstaSendoSondada() {
        return estaSendoSondada;
    }

    public void setEstaSendoSondada(int estaSendoSondada) {
        this.estaSendoSondada = estaSendoSondada;
    }
}