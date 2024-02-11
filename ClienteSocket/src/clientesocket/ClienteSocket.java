
package clientesocket;

import proxy.IChistesTCP;
import proxy.ProxyChistesTCP;

/**
 *
 * @author gilberto.borrego
 */
public class ClienteSocket {
 
    public static void main(String[] args) {
        IChistesTCP proxy = new ProxyChistesTCP(); 
        proxy.conectar();
    }
    
}
