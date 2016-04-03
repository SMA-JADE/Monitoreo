/**
 *
 * @author Erick
**/
package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;

public class Ag_monitoreo extends Agent {
    int temp;
    protected void setup (){
      addBehaviour(new TickerBehaviour(this, 5000) {
            protected void onTick() {
            Random rnd = new Random();
            temp = (int)(rnd.nextDouble() * 35 + 18);
            
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            String temper = Integer.toString(temp);
            msg.setContent(temper);
            msg.addReceiver(new AID("Ag_coordinador", AID.ISLOCALNAME));
            send(msg);
          } 
        });
  }
}
