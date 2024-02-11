/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proxy;

public class ProxyChistesTCP implements IChistesTCP{

    private ChistesTCP objetoReal;

    public ProxyChistesTCP() {
        this.objetoReal = new ChistesTCP();
    }
    
    @Override
    public void conectar() {
        this.objetoReal.conectar();
    }
    
}
