import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class project extends JFrame implements ActionListener {
JLabel titleLabel, label2, userLabel, passLabel;
JTextField userField, passField;
JButton loginButton;

Connection con;
Statement stmt;

public project() {
setTitle(" Inventory Management System");
setSize(1980, 1080);

JPanel background = new JPanel() {
Image bg = new ImageIcon("login.jpg").getImage();
protected void paintComponent(Graphics g) {
super.paintComponent(g);
Graphics2D g2d = (Graphics2D) g;
g2d.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
g2d.setColor(new Color(255, 255, 255, 100));
g2d.fillRect(0, 0, getWidth(), getHeight());
}
};
background.setLayout(null);

titleLabel = new JLabel("INVENTORY MANAGEMENT SYSTEM");
titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
titleLabel.setForeground(Color.black);
titleLabel.setBounds(100, 300, 1000, 50);
background.add(titleLabel);

label2 = new JLabel("<html>Manage stock, suppliers, and orders efficiently<br>"
+ "and meet revenue goals by precisely determining the<br>"
+ "required inventory investments across stocking<br>"
+ "locations to achieve target service levels,<br>"
+ "meet customer demand, and deliver<br>"
+ "customer satisfaction</html>");
label2.setFont(new Font("SansSerif", Font.PLAIN, 30));
label2.setForeground(Color.black);
label2.setBounds(150, 270, 1100, 500);
background.add(label2);

userLabel = new JLabel("User ID:");
userLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
userLabel.setBounds(1100, 300, 200, 30);
background.add(userLabel);

userField = new JTextField();
userField.setFont(new Font("SansSerif", Font.PLAIN, 20));
userField.setBounds(1100, 360, 300, 35);
background.add(userField);

passLabel = new JLabel("Password:");
passLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
passLabel.setBounds(1100, 450, 200, 30);
background.add(passLabel);

passField = new JTextField();
passField.setFont(new Font("SansSerif", Font.PLAIN, 20));
passField.setBounds(1100, 500, 300, 35);
background.add(passField);

loginButton = new JButton("Login");
loginButton.setFont(new Font("SansSerif", Font.BOLD, 20));
loginButton.setBounds(1100, 600, 300, 40);
loginButton.setForeground(Color.decode("#082849"));
loginButton.setBackground(Color.decode("#eb9c30"));

loginButton.addActionListener(this);
background.add(loginButton);

add(background);
setVisible(true);

try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost/user", "root", "");
stmt = con.createStatement();
} catch (Exception a) {
JOptionPane.showMessageDialog(this, "Database Error: " + a.getMessage());
}
}

public void actionPerformed(ActionEvent e) {
if (e.getSource() == loginButton) {
String uid = userField.getText();
String pwd = passField.getText();

try {
String query = "SELECT * FROM pass WHERE userid='" + uid + "' AND password='" + pwd + "'";
ResultSet rs = stmt.executeQuery(query);

if (rs.next()) {
JOptionPane.showMessageDialog(this, "Login Successful!");
this.dispose();
new HomePage();
} else {
JOptionPane.showMessageDialog(this, "Wrong User ID or Password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
}
} catch (Exception ex) {
JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
}
}
}

public static void main(String[] args) {
new project();
}
}
