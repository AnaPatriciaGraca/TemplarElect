/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import templarelect.TemplarElect;
import templarelect.TemplarVote;

/**
 *
 * @author AnaGraca
 * Class to test the class "TemplarElect"
 */
public class TestTemplarElect {
    public static void main(String[] args) throws TemplarElectException, IOException {
        String fileName = "TemplarElect.obj";
        
        try{
            //create election
            TemplarElect election = new TemplarElect();
            
            //try to open file with the votes
            try {
                election = TemplarElect.load(fileName);
            } catch (IOException | ClassNotFoundException e) {
            }
            
            //test adding a vote to the elections
            //election.add(new TemplarVote("Pedro", "Antonio"));
            //election.add(new TemplarVote("Ana", "Antonio"));
            election.add(new TemplarVote("Miguel", "Antonio"));
            
            //save file with the votes
            election.save(fileName);
            
            //print votes added
            System.out.println(election.toString());
            //print total number of votes 
            System.out.println(election.totalVotes());

            
        } catch (TemplarElectException ex) {
            ex.show();  
        }
        
    }
}
