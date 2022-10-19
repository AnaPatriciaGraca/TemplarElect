/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package register;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import utils.SecurityUtils;

/**
 *
 * @author AnaGraca
 */
public class Register {
    
    public Register(String user, String passwd){
        try {
            KeyPair kp = SecurityUtils.generateRSAKeyPair(2048);
            savePublicKey(user, kp);
            savePrivateKey(user, kp, passwd);
            
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
        
    
    public static void savePublicKey(String user, KeyPair kp){
        try {
            SecurityUtils.saveKey(kp.getPublic(), user.concat(".pubkey"));
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void savePrivateKey(String user, KeyPair kp, String passwd){

        try {
            //Encriptar chave Privada com pass do user
            byte[] keyPriv = SecurityUtils.encrypt(kp.getPrivate().getEncoded(), passwd);
            //guardar chave no ficheiro
            Files.write(Paths.get(user.concat(".privkey")), keyPriv);
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static PublicKey readPublicKey(String user){
        String filename = user.concat(".pub");
        try {
            PublicKey key = SecurityUtils.loadPublicKey(filename);
            return key;
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void readPrivateKey(String user, String passwd){
        String filename = user.concat(".pub");
        try {
            byte[] cipher = Files.readAllBytes(Paths.get(filename));
            try {
                byte[] key = SecurityUtils.decrypt(cipher, passwd);
            } catch (Exception ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
            
//    public static void main(String[] args) {
//        String user = "Ana";
//        String passwd = "12qweasd!#";     
//        
//        Register r = new Register(user, passwd);
//    }
    
    
}
