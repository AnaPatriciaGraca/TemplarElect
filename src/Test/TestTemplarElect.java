/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import templarelect.TemplarElect;
import templarelect.TemplarVote;

/**
 *
 * @author AnaGraca
 * Class to test the class "TemplarElect"
 */
public class TestTemplarElect {
    public static void main(String[] args) throws TemplarElectException {
        //create election
        TemplarElect election = new TemplarElect();
        try{
            //test adding a vote to the elections
            election.add(new TemplarVote("Ana", "Antonio"));
            election.add(new TemplarVote("Maria", "Manuel"));
            System.out.println(election);
            
        }catch (TemplarElectException e){
            e.show();
        }
        
    }
}
