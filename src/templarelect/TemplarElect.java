/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package templarelect;

import Test.TemplarElectException;
import blockchain.utils.Block;
import blockchain.utils.BlockChain;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AnaGraca
 */
public class TemplarElect implements Serializable{

    private final BlockChain voteList;

    public TemplarElect() throws Exception {
        voteList = new BlockChain();
        //TemplarVote genesis = new TemplarVote("Master", "Tony");
        //voteList.add(genesis.toBase64(), DIFICULTY);
    }
    
    public List<TemplarVote> getVoteList(){
        //return voteList;
        List<TemplarVote> lst = new ArrayList<>();
        for (Block b : voteList.getChain()) {
            TemplarVote v = (TemplarVote.fromBase64(b.getData()));
            lst.add(v);
        }
        return lst;
    }

    //verify if the vote is valid (one person can only vote once)
    //se in the array if the voter already exists
    public boolean isValid(TemplarVote v) throws Exception {
        if( v.getVoter().equals(v.getCongressperson())){
            throw new Exception("The users are equal" );
        }
        if (v.getVoter().trim().isEmpty()) {
            throw new Exception("Voter is empty");
        }
        if (v.getCongressperson().trim().isEmpty()) {
            throw new Exception("Congress Person is empty");
        }
        //adicionar condição para verificar se a pessoa já votou ou não
        return true;
    }
    
    // method to add the votes on the election if the vote is valid
    public void add(TemplarVote v) throws TemplarElectException, Exception{
        if (isValid(v)) {
            voteList.add(v.toBase64(),DIFICULTY);
        } else {
            throw new Exception("Transaction not valid");
        }
    }
    
    //return the total number of votes
    public int totalVotes(){
        List<TemplarVote> voteList = getVoteList();
        return voteList.size();
    }
    
    // reutrn the total number of votes for the congress person
    public int totalVotes(String congressperson){
        int total = 0;
        List<TemplarVote> voteList = getVoteList();
        for (TemplarVote templarVote : voteList) {
            if (templarVote.getCongressperson().equals(congressperson)) {
                total += 1;
            }
        }
        return total;
    }
    
    // method to save the data in a file
    public void save(String fileName) throws IOException {
        try ( ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileName));) {
            out.writeObject(this);
        }
    }

    // mehtod to upload data from a file
    public static TemplarElect load(String fileName) throws IOException, ClassNotFoundException {
        try ( ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(fileName))) {
            return (TemplarElect) in.readObject();
        }
    }
    
    @Override
    //method only ti print on the screen
    //posteriormente é necessário alterar este método para StringBuilder em vez do StringBuffer (por causa do processamento paralelo)
    public String toString() {
        StringBuilder txt = new StringBuilder();
        List<TemplarVote> voteList = getVoteList();
        for (TemplarVote vote : voteList) {
            txt.append(vote.toString()).append("\n");
        }
        return txt.toString();
    }
    
    public static int DIFICULTY = 1;
    
}
