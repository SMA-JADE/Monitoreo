import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag_interfaz extends Agent {
    protected void setup (){
        // Líneas de código aquí
        // Recibe las alertas del Ag_coordinador y se las hace llegar al usuario (Envía un mensaje a la consola).

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println(msg.getContent());
                } else {
                    block();
                }
            }
        } );
    }
}
