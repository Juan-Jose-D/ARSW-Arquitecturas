# Ejemplos de Arquitecturas de Comunicación en Java - ARSW

Este proyecto implementa y ejemplifica varias arquitecturas de comunicación en Java: HTTP, RMI, TCP, UDP y acceso a recursos vía URL. Cada una se encuentra en su respectivo paquete y archivo.


### Requisitos 

- Maven
- Java 8 o superior

Antes de todo compila el proyecto con (`mvn package`).

## 1. HTTP

**Archivo:** `src/main/java/edu/eci/arsw/HTTP/HttpServer.java`

Implementa un servidor HTTP básico que escucha en el puerto 8080, recibe peticiones y responde con una página HTML. Muestra el método y la petición recibida.

**Ejemplo de ejecución:**
```bash
java -cp target/classes edu.eci.arsw.HTTP.HttpServer
# Luego accede a http://localhost:8080 desde tu navegador
```

## 2. RMI

**Archivos:**
- `EchoServer.java` (interfaz remota)
- `EchoServerImpl.java` (implementación y registro)
- `EchoClient.java` (cliente)

Permite invocar métodos remotos usando Java RMI. El cliente envía un mensaje y el servidor responde con eco.

**Ejemplo de ejecución:**
```bash
# En una terminal inicia el servidor:
java -cp target/classes edu.eci.arsw.RMI.EchoServerImpl
# En otra terminal ejecuta el cliente:
java -cp target/classes edu.eci.arsw.RMI.EchoClient
```

## 3. TCP

**Archivos:**
- `TCPServer.java` (servidor)
- `TCPClient.java` (cliente)

Comunicación bidireccional por sockets TCP. El servidor responde a cada mensaje recibido.

**Ejemplo de ejecución:**
```bash
# En una terminal inicia el servidor:
java -cp target/classes edu.eci.arsw.TCP.TCPServer
# En otra terminal ejecuta el cliente:
java -cp target/classes edu.eci.arsw.TCP.TCPClient
# Escribe mensajes en la terminal del cliente para recibir respuestas.
```

## 4. UDP

**Archivos:**
- `UDPServer.java` (servidor)
- `UDPClient.java` (cliente)

Intercambio de mensajes usando datagramas UDP. El cliente solicita y el servidor responde con la fecha/hora.

**Ejemplo de ejecución:**
```bash
# En una terminal inicia el servidor:
java -cp target/classes edu.eci.arsw.UDP.UDPServer
# En otra terminal ejecuta el cliente:
java -cp target/classes edu.eci.arsw.UDP.UDPClient
```

## 5. URLClient

**Archivo:** `src/main/java/edu/eci/arsw/URLClient/URLClient.java`

Accede a una URL, muestra información de la misma y descarga el contenido HTML.

**Ejemplo de ejecución:**
```bash
java -cp target/classes edu.eci.arsw.URLClient.URLClient
```

---


**Autor:** Juan José Díaz (github)

**Institución:** Escuela Colombiana de Ingeniería Julio Garavito