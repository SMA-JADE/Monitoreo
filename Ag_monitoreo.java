import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Random;

public class Ag_monitoreo extends Agent {

  Random random;
  int temp;

  protected void setup (){
    // Líneas de código aquí
    // Este agente debe checar cada 5 segundos la temperatura (simular los cambios de temperatura).
    // Además debe enviar el valor de la temperatura al Ag_coordinador.
    random = new Random();
    addBehaviour(new TickerBehaviour(this,500) {
        @Override
        protected void onTick() {
            temp = random.nextInt(50);
            System.out.println(""+temp);
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.setContent(""+temp);
            msg.addReceiver(new AID("coor",false));
            send(msg);
        }
    });
  }
}
