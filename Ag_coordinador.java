import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Ag_coordinador extends Agent {

  protected void setup (){
    // Líneas de código aquí
    // Debe escuchar constantemente al Ag_monitor.
    // y deliberar si es conveniente lanzar una alerta o no al Ag_interfaz
      addBehaviour(new CyclicBehaviour() {
          @Override
          public void action() {
              ACLMessage msg = receive();
              if(msg != null){
                  int temp = Integer.parseInt(msg.getContent());
                  if(temp > 40){
                      ACLMessage alert = new ACLMessage(ACLMessage.CONFIRM);
                      alert.setContent("Alerta, evitar actividades al aire libre");
                      alert.addReceiver(new AID("inter",false));
                      send(alert);
                  }
              }else{

              }
          }
      });
  }
}
