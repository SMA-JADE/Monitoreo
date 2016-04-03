/**
 *
 * @author Erick
**/
package agentes;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage; 
import jade.core.Agent;


public class Ag_coordinador extends Agent {
    public final static String Alerta1 = " es soportable, aun así ten cuidado.";
    public final static String Alerta2 = " es muy alta, mucho cuidado.";
    public final static String Alerta3 = " no slagas de la casa, sin bloqueador y agua.";
    
    protected void setup (){
        addBehaviour(new CyclicBehaviour(){
        public void action(){
            ACLMessage mensaje =  receive();
            if(mensaje != null){
                String msg = mensaje.getContent();
                int temperatura = Integer.parseInt(msg);
                if(temperatura >= 35){
                    ACLMessage nuevoMensaje = new ACLMessage(ACLMessage.INFORM);
                    nuevoMensaje.setContent(temperatura<=40? "La temperatura es " + msg + Alerta1 :(temperatura <=45 ?"La temperatura es " + msg +Alerta2 : "La temperatura es " + msg +Alerta3));
                    nuevoMensaje.addReceiver(new AID("Ag_interfaz", AID.ISLOCALNAME));
                    send(nuevoMensaje);
                }
            }else{
                block();
            }
        }    
        });
    }
}