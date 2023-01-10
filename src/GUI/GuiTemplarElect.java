/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Test.TemplarElectException;
import blockchain.p2p.miner.IminerRemoteP2P;
import blockchain.utils.Block;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import myUtils.RMI;
import templarElect.User;
import templarelect.TemplarElect;
import templarelect.TemplarVote;

/**
 *
 * @author AnaGraca
 */
public class GuiTemplarElect extends javax.swing.JFrame {

    private static final long serialVersionUID = 4891176181486442877L;

    public static String fileName = "TemplarElectChain.obj";
    IminerRemoteP2P miner;
    TemplarElect election;
    User myUser;
    List<String> congressPersonList = Arrays.asList("Ronald Reagan", "George H. W. Bush",
            "Bill Cliton", "George W. Bush", "Barack Obama", "Donald J. Trump", "Joe Biden");
    
    /**
     * Creates new form GuiTemplarElect
     */
    public GuiTemplarElect(User user, IminerRemoteP2P Mminer) {
        initComponents();

        try {
            this.myUser = user;
            this.miner = Mminer;
            election = TemplarElect.load(fileName);
            DefaultListModel model = new DefaultListModel();
            model.addAll(election.getBlockChain().getChain());
            lstBlockChain.setModel(model);
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
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtTotalVotes = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        lstBlockChain = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSignature = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        cbCongressPerson = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtVoter = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        UserData = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtElection = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtBlock = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        btVote = new javax.swing.JButton();

        btElectionTotals.setText("Election Totals");
        btElectionTotals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btElectionTotalsActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(800, 800));
        setMinimumSize(new java.awt.Dimension(100, 100));

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setMaximumSize(new java.awt.Dimension(400, 500));

        lstBlockChain.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstBlockChain.setMaximumSize(new java.awt.Dimension(11, 39));
        lstBlockChain.setMinimumSize(new java.awt.Dimension(11, 39));
        lstBlockChain.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstBlockChainValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(lstBlockChain);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        txtSignature.setEditable(false);
        txtSignature.setBackground(new java.awt.Color(255, 255, 255));
        txtSignature.setColumns(20);
        txtSignature.setRows(5);
        txtSignature.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Signature", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Microsoft PhagsPa", 1, 12))); // NOI18N
        txtSignature.setMaximumSize(new java.awt.Dimension(11, 39));
        jScrollPane1.setViewportView(txtSignature);

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        cbCongressPerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCongressPerson.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Congress Person", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Microsoft PhagsPa", 1, 12))); // NOI18N
        cbCongressPerson.setMaximumSize(new java.awt.Dimension(11, 39));
        cbCongressPerson.setMinimumSize(new java.awt.Dimension(11, 39));
        jScrollPane4.setViewportView(cbCongressPerson);

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        txtVoter.setEditable(false);
        txtVoter.setBackground(new java.awt.Color(255, 255, 255));
        txtVoter.setColumns(20);
        txtVoter.setRows(5);
        txtVoter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Voter", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Microsoft PhagsPa", 1, 12))); // NOI18N
        txtVoter.setMaximumSize(new java.awt.Dimension(11, 39));
        txtVoter.setName(""); // NOI18N
        txtVoter.setPreferredSize(new java.awt.Dimension(230, 100));
        jScrollPane5.setViewportView(txtVoter);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtTotalVotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane8)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(txtTotalVotes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3);

        jPanel4.setMaximumSize(new java.awt.Dimension(400, 500));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        UserData.setEditable(false);
        UserData.setBackground(new java.awt.Color(255, 255, 255));
        UserData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(UserData);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        txtElection.setColumns(20);
        txtElection.setRows(5);
        txtElection.setText(" ");
        txtElection.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Votes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Microsoft PhagsPa", 1, 12))); // NOI18N
        txtElection.setMaximumSize(new java.awt.Dimension(2147483647, 100));
        txtElection.setPreferredSize(new java.awt.Dimension(230, 100));
        jScrollPane3.setViewportView(txtElection);

        txtBlock.setColumns(20);
        txtBlock.setRows(5);
        jScrollPane7.setViewportView(txtBlock);

        btVote.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btVote.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btVote.setLabel("Add Vote");
        btVote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoteActionPerformed(evt);
            }
        });
        jScrollPane6.setViewportView(btVote);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane2)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane6)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(443, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                int nonce;
                try {
                    nonce = miner.mine(v.toString(), 4);
                    election.add(v, nonce);
                } catch (RemoteException ex) {
                    Logger.getLogger(GuiTemplarElect.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(GuiTemplarElect.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //nao atualiza porque fica a calcular o hash
                JOptionPane.showMessageDialog(this, "Vote from  " + myUser.getName() + " added!");
            }else{
                JOptionPane.showMessageDialog(this, "User " + myUser.getName() + " already voted!");

            }
            //atualizar campos e guardar ficheiro
            election.save(fileName);
            txtTotalVotes.setText( "Total number of votes: "+ Integer.toString(election.totalVotes()-1));
            Block b = (Block) lstBlockChain.getSelectedValues()[0];
            txtBlock.setText(b.getFullInfo());
            txtElection.setText(election.toString());
            
        } catch (IOException ex) {
            Logger.getLogger(GuiTemplarElect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GuiTemplarElect.class.getName()).log(Level.SEVERE, null, ex);
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

    private void lstBlockChainValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstBlockChainValueChanged
        if( lstBlockChain.getSelectedIndex() >=0){
            Block b = (Block) lstBlockChain.getSelectedValues()[0];
            txtBlock.setText(b.getFullInfo());
        }       
    }//GEN-LAST:event_lstBlockChainValueChanged

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList<String> lstBlockChain;
    private javax.swing.JTextArea txtBlock;
    private javax.swing.JTextArea txtElection;
    private javax.swing.JTextArea txtSignature;
    private javax.swing.JLabel txtTotalVotes;
    private javax.swing.JTextArea txtVoter;
    // End of variables declaration//GEN-END:variables
}
