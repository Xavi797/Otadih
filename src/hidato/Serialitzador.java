/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidato;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author usuario
 */
public class Serialitzador {
  
    private String logerror;
    private ObjectOutputStream escriptorOb;
    private ObjectInputStream lectorOb;

    public String getLogerror() {
        return logerror;
    }

    public void setLogerror(String logerror) {
        this.logerror = logerror;
    }
    
    public boolean SerialitzarObjecte (Object obj, String name) {
        try {
            escriptorOb = new ObjectOutputStream(new FileOutputStream(name));
            escriptorOb.writeObject(obj);
            escriptorOb.close();
            return true;
        } catch (Exception ex) {
            this.logerror = ex.getMessage();
            return false;
        }
    }
    
    public Object DeserialitzarObjecte (String archiu) {
        try{
            File f = new File(archiu);
            lectorOb = new ObjectInputStream(new FileInputStream(f));
            Object obj;
            obj = lectorOb.readObject();
            return obj;
        }catch (Exception ex) {
            this.logerror = ex.getMessage();
            return new Object();    //Si hi ha error retorna un objecte buit
        }
    }
}


