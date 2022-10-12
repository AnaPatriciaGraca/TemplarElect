/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Test.TemplarElectException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import templarelect.TemplarElect;
import templarelect.TemplarVote;

/**
 *
 * @author AnaGraca
 */
public class GuiTemplarElect extends javax.swing.JFrame {

    String fileName = "TemplarElect.obj";
    templarelect.TemplarElect election = new TemplarElect();
    
    /**
     * Creates new form GuiTemplarElect
     */
    public GuiTemplarElect() {
        initComponents();
        try {
            election = TemplarElect.load(fileName);
        } catch (IOException ex) {
            Logger.getLogger(GuiTemplarElect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GuiTemplarElect.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(election.toString());
        txtElection.setText(election.toString());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btVote = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtElection = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtVoter = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCongressPerson = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        btVote.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btVote.setLabel("Add Vote");
        btVote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoteActionPerformed(evt);
            }
        });

        txtElection.setColumns(20);
        txtElection.setRows(5);
        txtElection.setText(" ");
        txtElection.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Votos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 0, 12))); // NOI18N
        jScrollPane3.setViewportView(txtElection);

        txtVoter.setColumns(20);
        txtVoter.setRows(5);
        txtVoter.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Voter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 0, 12))); // NOI18N
        txtVoter.setName(""); // NOI18N
        jScrollPane5.setViewportView(txtVoter);

        txtCongressPerson.setColumns(20);
        txtCongressPerson.setLineWrap(true);
        txtCongressPerson.setRows(5);
        txtCongressPerson.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Congress Man", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 0, 12))); // NOI18N
        jScrollPane4.setViewportView(txtCongressPerson);
        txtCongressPerson.getAccessibleContext().setAccessibleDescription("");

        jScrollPane6.setViewportView(jScrollPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btVote, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btVote))
                    .addComponent(jScrollPane3))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoteActionPerformed
        TemplarVote v = new TemplarVote(txtVoter.getText(), txtCongressPerson.getText());
        try {
            election.add(v);
            txtElection.setText(election.toString());
            election.save(fileName);
        } catch (TemplarElectException ex) {
            ex.show();
        } catch (IOException ex) {
            Logger.getLogger(GuiTemplarElect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btVoteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiTemplarElect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiTemplarElect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiTemplarElect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiTemplarElect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiTemplarElect().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVote;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea txtCongressPerson;
    private javax.swing.JTextArea txtElection;
    private javax.swing.JTextArea txtVoter;
    // End of variables declaration//GEN-END:variables
}
