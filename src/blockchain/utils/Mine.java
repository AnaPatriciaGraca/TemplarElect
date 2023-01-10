///**************************************************************************/
///****     Copyright (C) 2014                                           ****/
///****     Antonio Manuel Rodrigues Manso                               ****/
///****     e-mail: manso@ipt.pt                                         ****/
///****     url   : http://orion.ipt.pt/~manso    manso@ipt.pt           ****/
///****     Instituto Politecnico de Tomar                               ****/
///****     Escola Superior de Tecnologia de Tomar                       ****/
///****                                                                  ****/
///**************************************************************************/
///****     This software was build with the purpose of learning.        ****/
///****     Its use is free and is not provided any guarantee            ****/
///****     or support.                                                  ****/
///****     If you met bugs, please, report them to the author           ****/
///****                                                                  ****/
///**************************************************************************/
///**************************************************************************/
package blockchain.utils;

//import aula.*;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manso
 */
public class Mine extends Thread {
    public static int MAX_NONCE = (int) 1E9;
    int ini;
    int fin;
    String data;
    String zeros;
    String hash;
    static int nonce;
    private Object lock1 = new Object();
    
    
    public Mine(){
        
    }
    public Mine(int ini, int fin, String data, String zeros){
        this.fin = fin;
        this.ini = ini;
        this.data = data;
        this.zeros = zeros;
    }
    
//    public static void main(String[] args) throws Exception {
//        String message = "Hello Blockchain world";
//        long timePar = System.currentTimeMillis();
//        Mine a = new Mine();
//        int nonce2 = a.getNonce(message, 2);
//        timePar = System.currentTimeMillis() - timePar;
//        
//        
//        System.out.println("Mensagem2 : " + message);
//        System.out.println("Nonce2    : " + nonce2);
//        System.out.println("Hash2     : " + getHash(nonce2 + message));
//        
//
//    }
    

    
    // ################################################################
    // ############# P A R A L L E L ##################################
    // ################################################################
    public synchronized int getNonce(String data, int dificulty) throws Exception {
        //fazer um array de threads
        int procs = Runtime.getRuntime().availableProcessors();
        Mine thr[] = new Mine[procs];
        
        //String of zeros
        String zeros = String.format("%0" + dificulty + "d", 0);
        this.hash = "a";
        int dim = MAX_NONCE/ procs;
        //esperar que todas as threads iniciem
        for (int i = 0; i < thr.length; i++) {
            thr[i] = new Mine(i * dim + 1, (i + 1) * dim + 1, data, zeros);
            thr[i].start();
            if (hash.startsWith(zeros)) {
                return nonce;
            }
        }
        
        //esperar que todas as threads terminem
        for (int i = 0; i < thr.length; i++) {
            thr[i].join(); 
        }
        return nonce;
    }
    
    
    public void run(){
        try {
            for (int i = ini ; i < fin; i++) {
                synchronized (lock1) {
                    hash = getHash(nonce + data);
                    System.out.println(nonce + " - " + hash);
                    nonce++;
                    
                }
                if (hash.startsWith(zeros)) {
                    Thread.interrupted();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Mine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getHash(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] h = md.digest(data.getBytes());
        return Base64.getEncoder().encodeToString(h);
    }

}
