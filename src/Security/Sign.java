/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Security;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import blockchain.utils.SecurityUtils;



/**
 *
 * @author aluno21370
 */
public class Sign {
    
    //assina ficheiro
    public static byte[] SignFile(String filename, PrivateKey key){
        try {
            byte[] data = Files.readAllBytes(Paths.get(filename));
            byte [] sign = SecurityUtils.sign(data, key); 
            return sign;
        } catch (IOException ex) {
            Logger.getLogger(Sign.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(Sign.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 

    }
   
    //verifica assinaturas
    public static void verifySignature(String filename, PublicKey key, byte[] sign) throws Exception{
        try {
            byte[] data = Files.readAllBytes(Paths.get(filename));
            if( SecurityUtils.verifySign(data, sign, key)){
                System.out.println("Signature OK");
            }else{
                System.out.println("Signature ERROR");
            }
        } catch (IOException ex) {
            Logger.getLogger(Sign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //esta a dar OK quando não devia
    public static void main(String[] args) {
        Register user = new Register("Ana", "1234qwer");
        PrivateKey keyPriv = Register.readPrivateKey(user.name, user.passwd);
        PublicKey keyPub = Register.readPublicKey(user.name);
        byte[] sign = SignFile("TemplarElectLogo.png", keyPriv);
        System.out.println("File Signed");
        try {
            verifySignature("TemplarElectLogo - Copy - Copy.png", keyPub, sign);
        } catch (Exception ex) {
            Logger.getLogger(Sign.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
