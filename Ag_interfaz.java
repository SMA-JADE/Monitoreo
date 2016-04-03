/**
 *
 * @author Erick
 **/
package agentes;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage; 
import jade.core.Agent;

public class Ag_interfaz extends Agent {
    protected void setup (){
        addBehaviour(new CyclicBehaviour(){
        public void action(){
            ACLMessage mensaje =  receive();
            if(mensaje != null){
                String msg = mensaje.getContent();
                System.out.println(msg);
            }else{
                block();
            }
        }    
        });
    }
}
