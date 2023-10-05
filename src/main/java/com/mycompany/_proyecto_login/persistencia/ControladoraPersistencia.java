package com.mycompany._proyecto_login.persistencia;

import com.mycompany._proyecto_login.logica.User;
import java.util.List;

public class ControladoraPersistencia {
    UserJpaController ujpac = new UserJpaController();
    RolJpaController rjpac = new RolJpaController();

    public List<User> traerUsuarios() {
       
        return ujpac.findUserEntities();
    }
    
    
    
}
