package com.mycompany._proyecto_login.logica;

import com.mycompany._proyecto_login.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    ControladoraPersistencia cp = new ControladoraPersistencia();
    String mensaje = "";

    public User validarUsuario(String user, String pass) {
        User usr = null;
        List<User> listaUsuarios = cp.traerUsuarios();
        System.out.println("Controladora");
        System.out.println("User recibido: " + user);
        System.out.println("Pass recibido: " + pass);
        for(User u : listaUsuarios) {
            System.out.println( u);
            
            if(u.getUser().equals(user) && u.getPassword().equals(pass)) {
                usr = u;
                return usr;
            }  else {
                usr = null;
                             
            }

        }
        return usr;
        
    }


    
    
    
}
