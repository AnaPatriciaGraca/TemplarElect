/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package templarelect;

import Test.TemplarElectException;
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

    List<TemplarVote> voteList = new ArrayList<>();

    //verify if the vote is valid (one person can only vote once)
    //se in the array if the voter already exists
    public boolean isValid(TemplarVote v) {
        for (TemplarVote vote : voteList) {
            if (vote.getVoter().equals(v.getVoter())) {
                return false;
            }
        }
        return true;
    }
    
    // method to add the votes on the election if the vote is valid
    public void add(TemplarVote v) throws TemplarElectException{
        if(isValid(v)){
            voteList.add(v);
        }else {
            throw new TemplarElectException("Invalid vote!\n" + v.getVoter() + " already voted.");
        }
        
    }
    
    // return the total number of votes
    public int totalVotes(){
        return voteList.size();
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
        StringBuffer txt = new StringBuffer();
        for (TemplarVote vote : voteList) {
            txt.append(vote.toString()).append("\n");
        }
        return txt.toString();

    }
    
}
