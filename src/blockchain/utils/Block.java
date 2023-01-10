//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2022   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package blockchain.utils;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 22/08/2022, 09:23:49
 * 
 * Block with consensus of Proof of Work
 *
 * @author IPT - computer
 * @version 1.0
 */
public class Block implements Serializable {

    private static final long serialVersionUID = -2260996302652781128L;

    String previousHash; // link to previous block
    String data;         // data in the block
    int nonce;           // proof of work 
    String currentHash;  // Hash of block

    public Block(String previousHash, String data, int nonce) throws Exception {
        this.previousHash = previousHash;
        this.data = data;
        this.nonce = nonce;
        this.currentHash = calculateHash();
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public int getNonce() {
        return nonce;
    }

    public String getCurrentHash() {
        return currentHash;
    }

    
    
    public String calculateHash() throws Exception {
        //return Hash.getHash(nonce + previousHash + data);
        return "";
    }

    public String toString() {
        try {
            return (isValid() ? "OK\t" : "ERROR\t")
                    + String.format("%8s", previousHash) + " <-[" +
                    String.format("%-10s", data) +  String.format(" %7d ] = ", nonce) +
                    String.format("%8s",currentHash);
        } catch (Exception ex) {
            Logger.getLogger(Block.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isValid() throws Exception {
        return currentHash.equals(calculateHash());
    }
    
    public String getFullInfo(){
        return "Previous :\n\t " + previousHash+
                "\ndata  :\n\t" + data+
                "\nNonce : " + nonce+
                "\nHash  :\n\t"+ currentHash;
    }


}
