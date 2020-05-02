/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwanza.tukule.version.pkg1.pkg0;
import javax.mail.Session;
import com.mysql.cj.protocol.Message;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.Properties;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Mariwa
 */
public class ForgotPassword extends javax.swing.JFrame {
     int randomCode;
     public Icon icon = new javax.swing.ImageIcon(getClass().getResource("kwanza tukule icon.png"));
    /**
     * Creates new form ForgotPassword
     */
    public ForgotPassword() {
        initComponents();
        setIcon();
        ImageIcon img = new ImageIcon("kwanza tukule icon.png");
        this.setIconImage(img.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        ForgotPasswordTitle = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        RegistrationIcon = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        RegistrationImage = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        verificationLabel = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        verificationText = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        verifyButton = new javax.swing.JButton();
        loginLink = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kwanza Tukule | Forgot Password");

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ForgotPasswordTitle.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        ForgotPasswordTitle.setText("FORGOT PASSWORD");
        backgroundPanel.add(ForgotPasswordTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, -1));

        jPanel4.setOpaque(false);

        RegistrationIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/version/pkg1/pkg0/kwanza tukule logo.png"))); // NOI18N

        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/version/pkg1/pkg0/avatar2.png"))); // NOI18N

        welcomeLabel.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(102, 102, 102));
        welcomeLabel.setText("Welcome");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(welcomeLabel)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(RegistrationIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addComponent(avatar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(RegistrationIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(avatar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(welcomeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backgroundPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 670));

        RegistrationImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kwanza/tukule/version/pkg1/pkg0/registrationImage4.jpg"))); // NOI18N
        backgroundPanel.add(RegistrationImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 670));

        emailLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        emailLabel.setText("E-mail Address:");
        backgroundPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));

        verificationLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        verificationLabel.setText("Verification code:");
        backgroundPanel.add(verificationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, -1));

        emailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextActionPerformed(evt);
            }
        });
        backgroundPanel.add(emailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 410, -1));

        verificationText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificationTextActionPerformed(evt);
            }
        });
        backgroundPanel.add(verificationText, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 400, -1));

        submitButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        backgroundPanel.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 120, 40));

        verifyButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        verifyButton.setText("Verify");
        verifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonActionPerformed(evt);
            }
        });
        backgroundPanel.add(verifyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 120, 40));

        loginLink.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        loginLink.setForeground(new java.awt.Color(51, 153, 255));
        loginLink.setText("Login Page");
        loginLink.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                loginLinkMouseMoved(evt);
            }
        });
        loginLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginLinkMousePressed(evt);
            }
        });
        backgroundPanel.add(loginLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextActionPerformed
        try{
            Random rand = new Random();
            randomCode = rand.nextInt(999999);
            String host = "smtp.gmail.com";
            String user = "samuelmariwa@gmail.com";
            //String user = "info@kwanzatukule.com";
            String pass = "samokoth.1999";
            //String pass = "Thamestana";
            String to = emailText.getText();
            String subject = "Verification Code";
            String message = "Your verification code is "+randomCode;
            boolean sessionDebug = false;
            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.host","host");
            pros.put("mail.smtp.port", "587");
            pros.put("mail.smtp.auth", "true");
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.starttls.required","true");
            pros.put("mail.smtp.socketFactory.port", "465");
            pros.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            pros.put("mail.smtp.socketFactory.fallback", "false");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(pros,null);
            mailSession.setDebug(sessionDebug);
            MimeMessage msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user));
            InternetAddress [] address = {new InternetAddress(to)};
            msg.setRecipients(RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setText(message);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            JOptionPane.showMessageDialog(this, "The verification code has been sent to your email.","Sent",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch( Exception ex ){
            JOptionPane.showMessageDialog(rootPane,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }//GEN-LAST:event_emailTextActionPerformed

    private void verificationTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificationTextActionPerformed
        if(Integer.valueOf(verificationText.getText())==randomCode)
        {
            ResetPassword rs = new ResetPassword(emailText.getText());
            rs.setVisible(true);
            this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(this, "The codes do not match.","Error",JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }//GEN-LAST:event_verificationTextActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        try{
            Random rand = new Random();
            randomCode = rand.nextInt(999999);
            String host = "smtp.gmail.com";
            String user = "samuelmariwa@gmail.com";
            //String user = "info@kwanzatukule.com";
            String pass = "samokoth.1999";
            //String pass = "Thamestana";
            String to = emailText.getText();
            String subject = "Verification Code";
            String message = "Your verification code is"+randomCode;
            boolean sessionDebug = false;
            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.host","host");
            pros.put("mail.smtp.port", "587");
            pros.put("mail.smtp.auth", "true");
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.starttls.required","true");
            pros.put("mail.smtp.socketFactory.port", "465");
            pros.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            pros.put("mail.smtp.socketFactory.fallback", "false");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(pros,null);
            mailSession.setDebug(sessionDebug);
            MimeMessage msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user));
            InternetAddress [] address = {new InternetAddress(to)};
            msg.setRecipients(RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setText(message);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            JOptionPane.showMessageDialog(this, "The verification code has been sent to your email.","Sent",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch( Exception ex ){
            JOptionPane.showMessageDialog(rootPane,ex,"Oops!Something went wrong!",JOptionPane.INFORMATION_MESSAGE,icon);
        }

    }//GEN-LAST:event_submitButtonActionPerformed

    private void verifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyButtonActionPerformed
        if(Integer.valueOf(verificationText.getText())==randomCode)
        {
            ResetPassword rs = new ResetPassword(emailText.getText());
            rs.setVisible(true);
            this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(this, "The codes do not match.","Error",JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }//GEN-LAST:event_verifyButtonActionPerformed

    private void loginLinkMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLinkMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_loginLinkMouseMoved

    private void loginLinkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLinkMousePressed
        Login lg = new Login();
        this.setVisible(false);
        lg.setVisible(true);
    }//GEN-LAST:event_loginLinkMousePressed

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ForgotPasswordTitle;
    private javax.swing.JLabel RegistrationIcon;
    private javax.swing.JLabel RegistrationImage;
    private javax.swing.JLabel avatar;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel loginLink;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel verificationLabel;
    private javax.swing.JTextField verificationText;
    private javax.swing.JButton verifyButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("kwanza tukule icon.png")));
    }
}
