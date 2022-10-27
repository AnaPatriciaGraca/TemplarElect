/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Security;

import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author aluno21370
 */
public class Authenticaton {
    
    public static void Verifyuser(String user, String passwd) {
        File f = new File(user.concat(".privKey"));
        if(f.exists() && !f.isDirectory()) { 
            PrivateKey keyPriv = Security.Register.readPrivateKey(user, passwd);
            PublicKey keyPub = Security.Register.readPublicKey(user);
            byte[] SimKey = Security.Register.readSimetricKey_Pub(user, keyPriv);
        }else{
            System.out.println("User does not exist");
        }
    }
    
    
    
    
    public static void main(String[] args) {
        //Register user  = new Register("Ana", "1234qwer");
        Verifyuser("Ana", "1234qwer");
        Verifyuser("Pna", "1234qwer");
        
    }
    
}
