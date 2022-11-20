/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templarelect;

import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.SecurityUtils;

/**
 *
 * @author AnaGraca
 */
public class TemplarVote implements Serializable{

    private static final long serialVersionUID = 4904322526951122916L;


    private String voter;           //public key
    private String congressperson;  //string
    String signature;               //signature of the voter
    
    

    public void sign(PrivateKey priv) throws Exception{
        byte[]data = (voter + congressperson).getBytes();
        byte[] s = SecurityUtils.sign(data, priv);
        signature = Base64.getEncoder().encodeToString(s);
    }
    
    public boolean validateSignature() throws Exception{
        //dados da transacao
        byte[]data = (voter + congressperson).getBytes();
        //dados da assinatura
        byte [] sign = Base64.getDecoder().decode(signature);
        //chave publica do from
        byte [] pk = Base64.getDecoder().decode(voter);
        PublicKey pubKey = SecurityUtils. getPublicKey(pk);
        return SecurityUtils.verifySign(data, sign, pubKey);
    }
    
    public TemplarVote(String voter, String congressperson) {
        this.voter = voter;
        this.congressperson = congressperson;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    public String getCongressperson() {
        return congressperson;
    }

    public void setCongressperson(String congressperson) {
        this.congressperson = congressperson;
    }

    public String getSignature() {
        return signature;
    }
    
    @Override
    public String toString(){
        try {
//            User uVoter = User.getFromPublicKey(voter);
//            User uCongressPerson = User.getFromPublicKey(congressperson);
//            String txtVoter = uVoter!= null ? uVoter.getName() : "Unknown";
//            String txtCongressPerson = uCongressPerson!= null ? uCongressPerson.getName(): "Unknown";
            return String.format("\n%s has voted!", voter);
        } catch (Exception ex) {
            Logger.getLogger(TemplarVote.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ERROR TO STRING";
    }

        /**
     * convert this to base64
     * @return 
     */
    public String toBase64(){
        byte[] data = blockchain.utils.MerkleTree.objectToBytes(this);
        return Base64.getEncoder().encodeToString(data);  
    }
    /**
     * build an object with base64
     * @param b64
     * @return 
     */
    public static TemplarVote fromBase64(String b64){
        byte [] data = Base64.getDecoder().decode(b64);
        return (TemplarVote)blockchain.utils.MerkleTree.bytesToObject(data);
    }

}
    

