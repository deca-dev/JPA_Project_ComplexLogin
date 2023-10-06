package com.mycompany._proyecto_login.persistencia;

import com.mycompany._proyecto_login.logica.Rol;
import com.mycompany._proyecto_login.logica.User;
import com.mycompany._proyecto_login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    UserJpaController ujpac = new UserJpaController();
    RolJpaController rjpac = new RolJpaController();

    public List<User> traerUsuarios() {
       
        return ujpac.findUserEntities();
    }

    public List<Rol> traerRoles() {
        return rjpac.findRolEntities();
    }

    public void crearUsuario(User usu) {
        ujpac.create(usu);
    }

    public void borrarUsuario(int id_usuario) {
        try {
            ujpac.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User traerUsuario(int id_usuario) {
       return ujpac.findUser(id_usuario);
    }

    public void editarUsuario(User usu) {
        try {
            ujpac.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
