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

    public List<User> traerUsuarios() {
        return cp.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return cp.traerRoles();
    }

    public void crearUsuario(String usuario, String contra, String rolRecibido) {
        User usu = new User();
        usu.setUser(usuario);
        usu.setPassword(contra);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        
        if(rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }
        
        cp.crearUsuario(usu);
    }

    private Rol traerRol(String rolRecibido) {
        cp.traerRoles();
        List<Rol> listaRoles = cp.traerRoles();
        
        for(Rol rol : listaRoles) {
            if(rol.getNombreRol().equals(rolRecibido)) {
                return rol;
            }
        }
        return null;
    }

    public void borrarUsuario(int id_usuario) {
        cp.borrarUsuario(id_usuario);
    }

    public User traerUsuario(int id_usuario) {
       return cp.traerUsuario(id_usuario);
    }

    public void editarUsuario(User usu, String usuario, String contra, String rolRecibido) {
        usu.setUser(usuario);
        usu.setPassword(contra);
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        
        if(rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }
        
        cp.editarUsuario(usu);
    }

  

    


    
    
    
}
