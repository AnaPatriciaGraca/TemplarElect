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

import blockchain.miner.Miner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import blockchain.p2p.miner.IminerRemoteP2P;
import java.awt.Color;
import myUtils.GuiUtils;


/**
 * Created on 22/08/2022, 10:09:17
 *
 * @author IPT - computer
 * @version 1.0
 */
public class BlockChain implements Serializable {

    private static final long serialVersionUID = 2607355451049953806L;
    IminerRemoteP2P miner;
    
    ArrayList<Block> chain = new ArrayList<>();
    
    public ArrayList<Block> getChain() {
        return chain;
    }
    
    public String getLastBlockHash() {
        if (chain.isEmpty()) {
            return String.format("%08d", 0);
        }
        return chain.get(chain.size() - 1).currentHash;
    }

    public void add(String data, int dificulty, int nonce) throws Exception {
        //hash of previous block
        String prevHash = getLastBlockHash();
        //mining block
        //int nonce = n.getNonce(prevHash + data, dificulty);
        //build new block
        System.out.println(nonce);
        Block newBlock = new Block(prevHash, data, nonce);
        chain.add(newBlock);
        
    }

    public Block get(int index) {
        return chain.get(index);
    }

    public String toString() {
        StringBuilder txt = new StringBuilder();
        txt.append("Blochain size = " + chain.size() + "\n");
        for (Block block : chain) {
            txt.append(block.toString() + "\n");
        }
        return txt.toString();
    }

    public void save(String fileName) throws Exception {
        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(chain);
        }
    }

    public void load(String fileName) throws Exception {
        try ( ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            this.chain = (ArrayList<Block>) in.readObject();
        }
    }

    public boolean isValid() throws Exception {
        //Validate blocks
        for (Block block : chain) {
            if (!block.isValid()) {
                return false;
            }
        }
        //validate Links
        for (int i = 1; i < chain.size(); i++) {
            //previous hash !=  hash of previous
            if (chain.get(i).previousHash != chain.get(i - 1).currentHash) {
                return false;
            }
        }
        return true;
    }
    
//    public static void main(String[] args) throws Exception {
//        BlockChain b = new BlockChain();
//        b.add("data", 5);
//    }

    private void onException(String mining, Exception ex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
