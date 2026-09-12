import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class itemdetails extends JInternalFrame implements ActionListener
{
Connection con;
JLabel l1,l2,l3,l4,l5;
JTextField t1,t2,t3,t4,t5;
JButton b1,b2,b3,b4,b5;
JFileChooser f1;

itemdetails()
{
super("",true,true,true,true);
setSize(1900,1100);
setLayout(null);

JPanel background = new JPanel() {
Image bg = new ImageIcon("img2.png").getImage();
protected void paintComponent(Graphics g) {
super.paintComponent(g);
Graphics2D g2d = (Graphics2D) g;
g2d.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
g2d.setColor(new Color(255, 255, 255, 100)); 
g2d.fillRect(0, 0, getWidth(), getHeight());
}
};
 
Font font1=new Font("Mystical",Font.BOLD,50);
Font font2=new Font("Book Antiqua",Font.BOLD,30);
Font font3=new Font("Cambria",Font.BOLD,20);
try{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/user","root","");
}catch(Exception a)
{
System.out.println(a.toString());
}

t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();
t5=new JTextField();

t1.setBounds(1000,200,300,47);
t1.setBackground(Color.decode("#94B0DB"));
t1.setFont(font3);


t2.setBounds(1000,300,300,47);
t2.setBackground(Color.decode("#94B0DB"));
t2.setFont(font3);


t3.setBounds(1000,400,300,47);
t3.setBackground(Color.decode("#94B0DB"));
t3.setFont(font3);


t4.setBounds(1000,500,300,47);
t4.setBackground(Color.decode("#94B0DB"));
t4.setFont(font3);


t5.setBounds(1000,800,300,47);
t5.setBackground(Color.decode("#94B0DB"));
t5.setFont(font3);



l1=new JLabel("ITEM DETAILS");
l2=new JLabel("ITEM NAME: ");
l3=new JLabel("PURCHASE PRICE");
l4=new JLabel("SALE PRICE : ");
l5=new JLabel("OPENING QUANTITY :");

l1.setFont(font1);
l1.setForeground(Color.decode("#825D55"));
l1.setBounds(720,70,800,100);

l2.setFont(font2);
l2.setForeground(Color.black);
l2.setBounds(600,200,450,50);

l3.setFont(font2);
l3.setForeground(Color.black);
l3.setBounds(600,300,450,50);

l4.setFont(font2);
l4.setForeground(Color.black);
l4.setBounds(600,400,450,50);

l5.setFont(font2);
l5.setForeground(Color.black);
l5.setBounds(600,500,450,50);




b1=new JButton("NEW");
b2=new JButton("SAVE");
b3=new JButton("MODIFY");
b4=new JButton("DELETE");
b5=new JButton("FIND");


b1.setBounds(600,670,120,80);
b1.setForeground(Color.white);
b1.setBackground(Color.decode("#34495E"));
b1.setFont(font3);



b2.setBounds(800,670,120,80);
b2.setForeground(Color.white);
b2.setBackground(Color.decode("#34495E"));
b2.setFont(font3);


b3.setBounds(1000,670,120,80);
b3.setForeground(Color.white);
b3.setBackground(Color.decode("#34495E"));
b3.setFont(font3);




b4.setBounds(1200,670,120,80);
b4.setForeground(Color.white);
b4.setBackground(Color.decode("#34495E"));
b4.setFont(font3);

b5.setForeground(Color.white);
b5.setBackground(Color.decode("#34495E"));
b5.setFont(font3);
b5.setBounds(700,800,120,50);


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);





add(t1);
add(t2);
add(t3);
add(t4);
add(t5);

add(l1);
add(l2);
add(l3);
add(l4);
add(l5);



add(b1);
add(b2);
add(b3);
add(b4);
add(b5);



background.setLayout(null);

background.add(t1);
background.add(t2);
background.add(t3);
background.add(t4);
background.add(t5);

background.add(l1);
background.add(l2);
background.add(l3);
background.add(l4);
background.add(l5);

background.add(b1);
background.add(b2);
background.add(b3);
background.add(b4);
background.add(b5);

setContentPane(background); 



setVisible(true);
}

public void actionPerformed(ActionEvent e)
{

try{
if(e.getSource()==b1)
{
t1.requestFocus();
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");

}
else if(e.getSource()==b2)
{
  Statement stmt=con.createStatement();

String s="insert into item values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
stmt.executeUpdate(s);
}

else if(e.getSource()==b3)
{
    Statement stmt = con.createStatement();
    String s = "update items set pprice='"+t2.getText()+"', sprice='" +t3.getText()+"', opqty='" +t4.getText() +"' where iname='" + t1.getText()+"'";
    stmt.executeUpdate(s);
    JOptionPane.showMessageDialog(this, "Record Updated");
}


else if(e.getSource()==b4) {
Statement stmt = con.createStatement();
String s = "delete from item where iname='"+t1.getText()+"'";
int res = stmt.executeUpdate(s);
if(res > 0)
JOptionPane.showMessageDialog(this, "Record Deleted");
else
JOptionPane.showMessageDialog(this, "Record Not Found");
}

else if(e.getSource()==b5) {
Statement stmt=con.createStatement();
String s2="select * from item where iname='"+t5.getText()+"'";
ResultSet rs= stmt.executeQuery(s2);
if(rs.next()) {
t1.setText(rs.getString(1));
t2.setText(rs.getString(2));
t3.setText(rs.getString(3));
t4.setText(rs.getString(4));
} else {
JOptionPane.showMessageDialog(this,"Record not found");
}
}
} catch(Exception ex) {
System.out.println(ex.toString());
}
}

public static void main(String args[]) {
itemdetails obj =new itemdetails();
}
}

