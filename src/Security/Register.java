/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Security;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.SecurityUtils;

/**
 *
 * @author aluno21370
 * 
 * Classe Register permite:
 *  - Gerar um par de chaves
 *  - Guardar a chave privada no ficheiro USER.priv (onde USER corresponde ao nome do utilizador)
 *  - Guardar a chave publica no ficheiro USER.pub (onde USER corresponde ao nome do utilizador)
 *  - a chave privada do utilizador pode é encriptada por uma password escolhida pelo utilizador
 *  - guardar uma chave simétrica e guardar essa chave encriptada com a chave publica (do ficheiro USER.pub)  
 * 
 */
public class Register {
    String name;
    String passwd;
    public Register(String user, String passwd){
        try {
            this.name = user;
            this.passwd = passwd;
            //gerar par de chaves
            KeyPair kp = SecurityUtils.generateRSAKeyPair(2048);
            //guardar chaves
            savePublicKey(user, kp);
            savePrivateKey(user, kp, passwd);
            saveSimetricKey_Pub(kp.getPublic(), user);
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    // ler chave publica do ficheiro USER.pub
    public static void savePublicKey(String user, KeyPair kp){
        try {
            SecurityUtils.saveKey(kp.getPublic(), user.concat(".pubkey"));
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // guardar chave privada no ficheiro USER.priv, a chave privada fica encriptada com a password do user
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
    
    // gerar chave simetrica, encriptar com a chave publica e guardar em USER.sim
    public static void saveSimetricKey_Pub(PublicKey kPub, String user){
        try {
            //gerar chave simetrica
            Key k = SecurityUtils.generateAESKey(256);
            System.out.println(k);
            //encriptar
            byte[] secret = SecurityUtils.encrypt(k.getEncoded(), kPub);
            // guardar num ficheiro
            Files.write(Paths.get(user.concat(".sim")), secret);
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    //guardar chave publica no ficheiro desencriptado USER.pub 
    public static PublicKey readPublicKey(String user){
        String filename = user.concat(".pubkey");
        try {
            //Ler ficheiro da chave publica
            PublicKey key = SecurityUtils.loadPublicKey(filename);
            System.out.println(key.getEncoded());
            return key;
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   
    public static PrivateKey readPrivateKey(String user, String passwd){
        String filename = user.concat(".privkey");
        try {
            byte[] file = Files.readAllBytes(Paths.get(filename));
            try {
                byte[] key = SecurityUtils.decrypt(file, passwd);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(key);
                PrivateKey privateKey2 = keyFactory.generatePrivate(privateKeySpec);
                return privateKey2;
            } catch (Exception ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    // ler chave simetrica
    public static byte[] readSimetricKey_Pub(String user, PrivateKey keyP){
        String filename = user.concat(".sim");
        try {
            //ler ficheiro
            byte[] secret = Files.readAllBytes(Paths.get(user.concat(".sim")));
            
            //desencriptar os dados
            byte[] plain = SecurityUtils.decrypt(secret, keyP);
//            KeyFactory keyFactory = KeyFactory.getInstance("AES");
//            EncodedKeySpec KeySpec = new PKCS8EncodedKeySpec(plain);
//            Key simKey = keyFactory.generatePrivate(KeySpec);          
            //retornar chave simetrica
            return plain;
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    } 
    
    public static void main(String[] args) {
        Register user = new Register("123", "1234qwer");
        PrivateKey privK = readPrivateKey(user.name, user.passwd);
        System.out.println(readSimetricKey_Pub(user.name, privK));
    }
    
}
