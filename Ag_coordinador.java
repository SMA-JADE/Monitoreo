import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import java.lang.Integer;

public class Ag_coordinador extends Agent {
    protected void setup (){
        // Líneas de código aquí
        // Debe escuchar constantemente al Ag_monitor.
        // y deliberar si es conveniente lanzar una alerta o no al Ag_interfaz

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    int temp = Integer.parseInt(msg.getContent());
                    if (temp >= 40) {
                        ACLMessage alerta = new ACLMessage();
                        alerta.addReceiver(new AID("Ag_interfaz", false));
                        alerta.setContent("Alerta!, la temperatura es de "+ temp +"c , alguien podra morir!");
                        send(alerta);
                    }
                } else {
                    block();
                }
            }
        } );
    }
}
