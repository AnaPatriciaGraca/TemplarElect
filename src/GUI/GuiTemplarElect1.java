/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Test.TemplarElectException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import templarElect.User;
import templarelect.TemplarElect;
import templarelect.TemplarVote;

/**
 *
 * @author AnaGraca
 */
public class GuiTemplarElect1 extends javax.swing.JFrame {

    private static final long serialVersionUID = 4891176181486442877L;

    public static String fileName = "TemplarElectChain.obj";
    TemplarElect election;
    User myUser;
    List<String> congressPersonList = Arrays.asList("Ronald Reagan", "George H. W. Bush",
            "Bill Cliton", "George W. Bush", "Barack Obama", "Donald J. Trump", "Joe Biden");
    
    /**
     * Creates new form GuiTemplarElect
     */
    public GuiTemplarElect1(User user) {
        initComponents();

        try {
            this.myUser = user;
            election = TemplarElect.load(fileName);
        } catch (IOException ex) {
            try {
                election = new TemplarElect();
            } catch (Exception ex1) {
                JOptionPane.showMessageDialog(this, "Error creating a new Election");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error openning the Election");
        }
  
        //carrgar dados dos user
        displayUser();
        //carregar dados da eleição
        txtElection.setText(election.toString());
        setSize(800,600);
        setLocationRelativeTo(null);
        
    }
    
    public void displayUser(){
        String pubB64 = Base64.getEncoder().encodeToString(
                myUser.getPubKey().getEncoded());
        txtVoter.setText(pubB64);
        //adicionar as pessoas do congresso à combo BOX
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addAll(congressPersonList);
        cbCongressPerson.setModel(model);
        UserData.setText("User: \n\t" + myUser.getName() + "\nFiles: \n" + 
                "\t/users/" + myUser.getName() + ".pub\n" +
                "\t/users/" + myUser.getName() + ".priv\n" +
                "\t/users/" + myUser.getName() + ".sim\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btElectionTotals = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtElection = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtVoter = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        cbCongressPerson = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        btVote = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSignature = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        UserData = new javax.swing.JTextPane();
        txtTotalVotes = new javax.swing.JLabel();

        btElectionTotals.setText("Election Totals");
        btElectionTotals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btElectionTotalsActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        txtElection.setColumns(20);
        txtElection.setRows(5);
        txtElection.setText(" ");
        txtElection.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Votes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Microsoft PhagsPa", 1, 12))); // NOI18N
        jScrollPane3.setViewportView(txtElection);

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        txtVoter.setEditable(false);
        txtVoter.setBackground(new java.awt.Color(255, 255, 255));
        txtVoter.setColumns(20);
        txtVoter.setRows(5);
        txtVoter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Voter", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Microsoft PhagsPa", 1, 12))); // NOI18N
        txtVoter.setName(""); // NOI18N
        jScrollPane5.setViewportView(txtVoter);

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        cbCongressPerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCongressPerson.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Congress Person", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Microsoft PhagsPa", 1, 12))); // NOI18N
        jScrollPane4.setViewportView(cbCongressPerson);

        btVote.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btVote.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btVote.setLabel("Add Vote");
        btVote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoteActionPerformed(evt);
            }
        });
        jScrollPane6.setViewportView(btVote);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        txtSignature.setEditable(false);
        txtSignature.setBackground(new java.awt.Color(255, 255, 255));
        txtSignature.setColumns(20);
        txtSignature.setRows(5);
        txtSignature.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Signature", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Microsoft PhagsPa", 1, 12))); // NOI18N
        jScrollPane1.setViewportView(txtSignature);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        UserData.setEditable(false);
        UserData.setBackground(new java.awt.Color(255, 255, 255));
        UserData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(UserData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTotalVotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalVotes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoteActionPerformed
        String congPerson = (String) cbCongressPerson.getSelectedObjects()[0];
        //criar voto
        TemplarVote v = new TemplarVote(txtVoter.getText(), congPerson);
        //assinar voto
        try {
            v.sign(myUser.getPrivKey());
            txtSignature.setText(v.getSignature());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error signing the vote!");
        }
        
        //Verificar se a pessoa já votou e está a tentar votar novamente
        boolean hasVoted = election.hasVoted(v.getVoter());
        try {
            if (!hasVoted) {
                election.add(v);
                
                JOptionPane.showMessageDialog(this, "Vote from  " + myUser.getName() + " added!");
            }else{
                JOptionPane.showMessageDialog(this, "User " + myUser.getName() + " already voted!");
                
            }
            txtElection.setText(election.toString());
            election.save(fileName);
            txtTotalVotes.setText( "Total number of votes: "+ Integer.toString(election.totalVotes()-1));
        } catch (TemplarElectException ex) {
            ex.show();
        } catch (IOException ex) {
            Logger.getLogger(GuiTemplarElect1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GuiTemplarElect1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btVoteActionPerformed

    private void btElectionTotalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btElectionTotalsActionPerformed
        int totals[] = new int[congressPersonList.size()];
        String txt = "";
        if (myUser.getName().equals("admin")) {
            for (int i = 0; i < congressPersonList.size(); i++) {
                totals[i] = election.totalVotes(congressPersonList.get(i));      
            }
            for (int i = 0; i < congressPersonList.size(); i++) {
                txt += congressPersonList.get(i) + ":\t" + totals[i] + " votes\n";
            }
            JOptionPane.showMessageDialog(this, txt);
        }else {
            JOptionPane.showMessageDialog(this, "Only administrators can see this information");
        }
    }//GEN-LAST:event_btElectionTotalsActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GuiTemplarElect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GuiTemplarElect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GuiTemplarElect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GuiTemplarElect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GuiTemplarElect().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane UserData;
    private javax.swing.JButton btElectionTotals;
    private javax.swing.JButton btVote;
    private javax.swing.JComboBox<String> cbCongressPerson;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea txtElection;
    private javax.swing.JTextArea txtSignature;
    private javax.swing.JLabel txtTotalVotes;
    private javax.swing.JTextArea txtVoter;
    // End of variables declaration//GEN-END:variables
}
