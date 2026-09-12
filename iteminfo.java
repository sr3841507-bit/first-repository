import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class iteminfo extends JInternalFrame implements ActionListener
{
Connection con;
JLabel l1,l2,l3,l4,l5;
JTextField t2,t3,t4;
JComboBox c1;
JFileChooser f1;

iteminfo()
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

c1=new JComboBox();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();

c1.setBounds(1000,200,300,47);
c1.setBackground(Color.decode("#94B0DB"));
c1.setFont(font3);


t2.setBounds(1000,300,300,47);
t2.setBackground(Color.decode("#94B0DB"));
t2.setFont(font3);


t3.setBounds(1000,400,300,47);
t3.setBackground(Color.decode("#94B0DB"));
t3.setFont(font3);


t4.setBounds(1000,500,300,47);
t4.setBackground(Color.decode("#94B0DB"));
t4.setFont(font3);




l1=new JLabel("ITEM INFORMATION");
l2=new JLabel("ITEM NAME: ");
l3=new JLabel("QUANTITY AVAILABLE");
l4=new JLabel("PURCHASHING PRICE: ");
l5=new JLabel("SELLING PRICE  :");

l1.setFont(font1);
l1.setForeground(Color.decode("#825D55"));
l1.setBounds(700,70,1000,100);

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





c1.addActionListener(this);



add(c1);
add(t2);
add(t3);
add(t4);

add(l1);
add(l2);
add(l3);
add(l4);
add(l5);

             

background.setLayout(null);

background.add(c1);
background.add(t2);
background.add(t3);
background.add(t4);

background.add(l1);
background.add(l2);
background.add(l3);
background.add(l4);
background.add(l5);

 
try{
Statement stmt1 = con.createStatement();
    String s = "SELECT iname from item ";
ResultSet rs1 = stmt1.executeQuery(s);
c1.addItem("");
    while (rs1.next()) 
{       
c1.addItem(rs1.getString(1));
 }
}catch(Exception c)
{System.out.print(c.toString());
}


setContentPane(background); 


setVisible(true);
}

public void actionPerformed(ActionEvent e)
{
try{
 if(e.getSource()==c1)
{

Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("Select opqty,pprice,sprice from item where iname='"+c1.getSelectedItem().toString()+"'");
while(rs.next())
{
t2.setText(rs.getString(1));
t3.setText(rs.getString(2));
t4.setText(rs.getString(3));
}

 }
} catch(Exception ex) {
System.out.println(ex.toString());
}
} 

public static void main(String args[]) {
iteminfo obj =new iteminfo();
}
}

