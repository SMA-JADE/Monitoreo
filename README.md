# Monitoreo
SMA para monitorear la temperatura y alertar en caso de que dicha temperatura este por arriba de los 35 grados.

El sistema se compone de los siguientes agentes:
- Agente monitoreo (Ag_monitoreo). Es el agente encargado de leer la temperatura. Dicho agente cada 5 segundos debe estar leyendo la temperatura y comunicarle al Ag_coordinador el valor de la temperatura.
- Agente coordinador(Ag_coordinador). Es el agente encargado de deliberar si la temperatura alcanzó el nivel como para lanzar alertas (>=35). Dichas alertas son enviadas al agente Ag_interfaz.
- Agente interfaz (Ag_interfaz). Es el agente que muestra las alertas al usuario.
