/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import javax.swing.JOptionPane;

/**
 *
 * @author AnaGraca
 */
public class TemplarElectException extends Exception{

    public TemplarElectException(String message) {
        super(message);
    }
    
    public void show(){
        JOptionPane.showMessageDialog(null, this.getMessage());
    }
    
}
