import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import mapa.Mapa;
import equipes.Equipes;
import equipes.Tempo;
public class MoonExplorer3 {
    public static void main(String[] args) {
        Gson gson = new Gson();


        try (FileReader reader = new FileReader("C:\\Users\\davig\\IdeaProjects\\helio3\\src\\entrada.json")) {

            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            int QTD_EQUIPES = jsonObject.get("QTD_EQUIPES").getAsInt();
            Equipes equipes = new Equipes(QTD_EQUIPES+1);
            int LIMITE_DO_MAPA = jsonObject.get("LIMITE_DO_MAPA").getAsInt();
            Mapa mapa = new Mapa(LIMITE_DO_MAPA);
            Tempo tempo = new Tempo();

            JsonArray equipesArray = jsonObject.getAsJsonArray("equipes");
            int i = 0;
            for (JsonElement equipeElement : equipesArray) {

                JsonObject equipe = equipeElement.getAsJsonObject();
                String nome = equipe.get("nome").getAsString();
                int posicaoEixoX = equipe.get("posicaoEixoX").getAsInt();
                int posicaoEixoY = equipe.get("posicaoEixoY").getAsInt();
                i++;
                equipes.insereRobo(nome, posicaoEixoX, posicaoEixoY, i);
            }

            JsonArray mapaArray = jsonObject.getAsJsonArray("mapa");
            int celulaIndex = 0;
            for (JsonElement celulaElement : mapaArray) {
                JsonObject celula = celulaElement.getAsJsonObject();
                double rugosidadeDaCelula = celula.get("rugosidade").getAsDouble();
                double concentracaoHelio3 = celula.get("quantidadeHelio3").getAsDouble();

                i = celulaIndex / LIMITE_DO_MAPA;
                int j = celulaIndex % LIMITE_DO_MAPA;

                mapa.inserirCelula(i, j, rugosidadeDaCelula, concentracaoHelio3);

                celulaIndex++;
            }

            int execucao = 1;
            Scanner entrada = new Scanner(System.in);

            while(execucao == 1){
                for(i = 1; i < QTD_EQUIPES+1; i++){

                    System.out.printf("Vez de: %s\n", equipes.equipes[i].getNomeEquipe());
                    System.out.println("Digite o comando:");
                    equipes.equipes[i].setComandoRobo(entrada.nextInt());
                    equipes.equipes[i].comandaRobo(mapa, tempo);
                }
                if(tempo.tempoTotalDeJogo() > 100000){
                    execucao = 0;
                }
            }



            equipes.defineVencedor();
            System.out.printf("Fim de Jogo!\nDuracao Total: %d segundos\n", tempo.tempoTotalDeJogo()/1000);
            System.out.printf("Vencedor: %s\n", equipes.checarVencedor());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
