package net.jrtechs.setgame;

import javax.swing.JOptionPane;
import java.awt.event.*;
import javax.swing.Timer;
/*
jeffery R
12-26-15
gui component for set
*/
public class SetGame extends javax.swing.JFrame implements ActionListener
{
    private SetButton[] cards = new SetButton[15];
    private Game game;
    
    public SetGame() 
    {
        initComponents();
        initSetButtons();
        showButtons(false);
        cmdFindSet.setEnabled(false);
        cmdOpen3.setEnabled(false);
        
        //creates an event listener for the timer
        ActionListener actTimer = new ActionListener()
        {
            
            public void actionPerformed(ActionEvent e)
            {
                if(game == null)
                {
                    
                }
                else
                {
                    game.timerTic();
                    lblTime.setText("Time " + game.getTime());
                    
                }
            }
        };
        Timer timer = new Timer(1000, actTimer);
        timer.start();
    }
    public void showButtons(Boolean set)
    {
        for(int i = 0; i < 12; i++)
        {
          cards[i].setVisible(set);
        }
    }
    private void initSetButtons()
    {
        //fills the array with new SetButtons and ands action listeners
        for(int i = 0; i < cards.length; i++)
        {
            cards[i] = new SetButton(i); 
            cards[i].addActionListener(this);
        }
        
        //sets the location of each of the buttons on the absolute layout
        getContentPane().add(cards[0], new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 146, 84));
        getContentPane().add(cards[1], new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 11, 146, 84));
        getContentPane().add(cards[2], new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 11, 146, 84));
        getContentPane().add(cards[3], new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 11, 146, 84));
        getContentPane().add(cards[4], new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 121, 146, 84));
        getContentPane().add(cards[5], new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 121, 146, 84));
        getContentPane().add(cards[6], new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 121, 146, 84));
        getContentPane().add(cards[7], new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 121, 146, 84));
        getContentPane().add(cards[8], new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 233, 146, 84));
        getContentPane().add(cards[9], new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 233, 146, 84));
        getContentPane().add(cards[10], new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 233, 146, 84));
        getContentPane().add(cards[11], new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 233, 146, 84));
        
        getContentPane().add(cards[12], new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 11, 146, 84));
        getContentPane().add(cards[13], new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 121, 146, 84));
        getContentPane().add(cards[14], new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 233, 146, 84));
        for(int i = 12; i < 15; i++)
        {
          cards[i].setVisible(false);
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //System.out.println(e);
        //casts the object of e to a setButton then calls the getLoc to find its index location in the cards "setButtons" array
        SetButton clicked = (SetButton)e.getSource();
        cards[clicked.getLoc()].clicked();
        game.clicked(cards);
        updateBoard();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdPlay = new javax.swing.JButton();
        lblScore = new javax.swing.JLabel();
        lblSets = new javax.swing.JLabel();
        lblCardsLeft = new javax.swing.JLabel();
        lblSetsOnBoard = new javax.swing.JLabel();
        cmdExit = new javax.swing.JButton();
        cmdFindSet = new javax.swing.JButton();
        cmdOpen3 = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Set Game");
        setPreferredSize(new java.awt.Dimension(670, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdPlay.setText("Play");
        cmdPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPlayActionPerformed(evt);
            }
        });
        getContentPane().add(cmdPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 343, 95, 38));

        lblScore.setText("Score");
        getContentPane().add(lblScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        lblSets.setText("Sets");
        getContentPane().add(lblSets, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        lblCardsLeft.setText("Cards Left in Deck");
        getContentPane().add(lblCardsLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        lblSetsOnBoard.setText("Sets on board");
        getContentPane().add(lblSetsOnBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

        cmdExit.setText("Exit");
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });
        getContentPane().add(cmdExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 400, 95, 38));

        cmdFindSet.setText("Find a Set");
        cmdFindSet.setActionCommand("cmdFindaSet");
        cmdFindSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdFindSetActionPerformed(evt);
            }
        });
        getContentPane().add(cmdFindSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 343, 95, 40));

        cmdOpen3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmdOpen3.setText("Open 3 Cards");
        cmdOpen3.setToolTipText("");
        cmdOpen3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOpen3ActionPerformed(evt);
            }
        });
        getContentPane().add(cmdOpen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 95, 38));

        lblTime.setText("Time");
        getContentPane().add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPlayActionPerformed
        cmdFindSet.setEnabled(true);
        cmdOpen3.setEnabled(true);
        game = new Game();
        showButtons(true);
        for(int i = 12; i < 15; i++)
        {
          cards[i].setVisible(false);
        }
        cmdPlay.setText("New Game");
        game.updateBoard(cards);
        this.updateBoard();
    }//GEN-LAST:event_cmdPlayActionPerformed
    private void updateBoard()
    {
        lblScore.setText("Score " + game.getScore());
        lblSets.setText("Sets " + game.getNumSets());
        lblCardsLeft.setText("Cards Left in Deck " + game.getDeck().cardsLeft());
        lblSetsOnBoard.setText("Sets on board " + game.getSetsLeft());
        if(game.getSetsLeft() == 0)
        {
            
            cmdFindSet.setEnabled(false);
            endGame();
        }
        else if(game.getHand().length==12 && game.getDeck().cardsLeft() > 2)
        {
            cmdOpen3.setEnabled(true);
            
        }
    }
    
    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExitActionPerformed
        System.exit(-1);
    }//GEN-LAST:event_cmdExitActionPerformed
    private void endGame()
    {
        if(game.getHand().length ==12 && game.getDeck().cardsLeft() > 3)
        {
            JOptionPane.showMessageDialog(null,"There are no more sets left on the board. However, you can still open three cards.","",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            game = null;
            cmdOpen3.setEnabled(false);
            JOptionPane.showMessageDialog(null,"There are no more sets left on the board.","End of Game",JOptionPane.WARNING_MESSAGE);
            
            
        }
    }
    private void cmdFindSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdFindSetActionPerformed
       game.findSet(cards);
       lblScore.setText("Score " + game.modScore(-150));
    }//GEN-LAST:event_cmdFindSetActionPerformed

    private void cmdOpen3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOpen3ActionPerformed
        game.openThree(cards);
        cmdOpen3.setEnabled(false);
        updateBoard();
        this.setBounds(0,0, 830, 480);
        if(game.getSetsLeft() == 0)
        {
            //end of game
            endGame();
        }
        else
        {
            //keep on playing game
            cmdFindSet.setEnabled(true);
        }
    }//GEN-LAST:event_cmdOpen3ActionPerformed
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(SetGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetGame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdFindSet;
    private javax.swing.JButton cmdOpen3;
    private javax.swing.JButton cmdPlay;
    private javax.swing.JLabel lblCardsLeft;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblSets;
    private javax.swing.JLabel lblSetsOnBoard;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables

}
