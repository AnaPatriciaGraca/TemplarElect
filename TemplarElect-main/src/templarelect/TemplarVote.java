/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templarelect;

import java.io.Serializable;

/**
 *
 * @author AnaGraca
 */
public class TemplarVote implements Serializable{
    private String voter;
    private String congressperson;

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
    
    @Override
    public String toString(){
        return "Vote from " + voter + " confirmed.";
    }
}
    

