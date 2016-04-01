import jade.core.Agent;
import java.util.Random;
import jade.core.behaviours.TickerBehaviour;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import java.lang.Integer;

public class Ag_monitoreo extends Agent {
    protected void setup (){
        // Líneas de código aquí
        // Este agente debe checar cada 5 segundos la temperatura (simular los cambios de temperatura).
        // Además debe enviar el valor de la temperatura al Ag_coordinador.

        addBehaviour(new TickerBehaviour(this, 5000) {
            protected void onTick() {
                Random rand = new Random();
                int random_temp = rand.nextInt((50 - 30) + 1) + 30;
                ACLMessage temp = new ACLMessage();
                temp.addReceiver(new AID("Ag_coordinador", false));
                temp.setContent(Integer.toString(random_temp));
                send(temp);
            }
        });
    }
}
