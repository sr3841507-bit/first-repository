import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;
import javax.swing.event.*;


class receive extends JInternalFrame implements ActionListener
{
Connection con;
JLabel l1,l2,l3,l4,l5,l6,l7;
JTextField t1,t2,t3,t4,t5,t6,t7;
JButton b1,b2,b3,b4;
JFileChooser f1;
JComboBox c2;
int count1;

receive()
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
t6=new JTextField();
t7=new JTextField();

c2=new JComboBox();



l1=new JLabel("RECEIVES");
l2=new JLabel("SERIAL NO: ");
l3=new JLabel("PARTY NAME ");
l4=new JLabel("DATE: ");
l5=new JLabel("BALANCE:");
l6=new JLabel("AMOUNT:");
l7=new JLabel("DETAILS:");


l1.setFont(font1);
l1.setForeground(Color.decode("#825D55"));
l1.setBounds(830,20,1000,70);



l2.setFont(font2);
l2.setForeground(Color.black);
l2.setBounds(600,100,450,50);


t1.setBounds(1000,100,300,47);
t1.setBackground(Color.decode("#94B0DB"));
t1.setFont(font3);



l3.setFont(font2);
l3.setForeground(Color.black);
l3.setBounds(600,200,450,50);
 
c2.setBounds(1000,200,300,47);
c2.setBackground(Color.decode("#94B0DB"));
c2.setFont(font3); 



l4.setFont(font2);
l4.setForeground(Color.black);
l4.setBounds(600,300,450,50);
   



t3.setBounds(1000,300,300,47);
t3.setBackground(Color.decode("#94B0DB"));
t3.setFont(font3);




l5.setFont(font2);
l5.setForeground(Color.black);
l5.setBounds(600,400,450,50);



t4.setBounds(1000,400,300,47);
t4.setBackground(Color.decode("#94B0DB"));
t4.setFont(font3);



l6.setFont(font2);
l6.setForeground(Color.black);
l6.setBounds(600,500,450,50);


t5.setBounds(1000,500,300,47);
t5.setBackground(Color.decode("#94B0DB"));
t5.setFont(font3);


  l7.setFont(font2);
l7.setForeground(Color.black);
l7.setBounds(600,600,450,50);


t6.setBounds(1000,600,300,47);
t6.setBackground(Color.decode("#94B0DB"));
t6.setFont(font3);

 


b1=new JButton("NEW");
b2=new JButton("SAVE");
b3=new JButton("MODIFY");
b4=new JButton("FIND");


b1.setBounds(600,700,120,80);
b1.setForeground(Color.white);
b1.setBackground(Color.decode("#34495E"));
b1.setFont(font3);



b2.setBounds(800,700,120,80);
b2.setForeground(Color.white);
b2.setBackground(Color.decode("#34495E"));
b2.setFont(font3);


b3.setBounds(1000,700,120,80);
b3.setForeground(Color.white);
b3.setBackground(Color.decode("#34495E"));
b3.setFont(font3);



b4.setForeground(Color.white);
b4.setBackground(Color.decode("#34495E"));
b4.setFont(font3);
b4.setBounds(700,800,120,50);

t7.setBounds(1000,800,300,47);
t7.setBackground(Color.decode("#94B0DB"));
t7.setFont(font3);






b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
c2.addActionListener(this);



try
{
Statement stmt1 = con.createStatement();
    String s = "SELECT name from sparty ";
ResultSet rs1 = stmt1.executeQuery(s);
c2.addItem("");
    while (rs1.next()) 
{       
c2.addItem(rs1.getString(1));
 }
}catch(Exception f2)
{
System.out.println(f2.toString());
}




add(t1);
add(t2);
add(t3);
add(t4);
add(t5);
add(t6);
add(t7);
add(c2);

add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);


add(b1);
add(b2);
add(b3);
add(b4);



background.setLayout(null);

background.add(t1);
background.add(t2);
background.add(t3);
background.add(t4);
background.add(t5);
background.add(t6);
background.add(t7);
background.add(c2);


background.add(l1);
background.add(l2);
background.add(l3);
background.add(l4);
background.add(l5);
background.add(l6);
background.add(l7);

background.add(b1);
background.add(b2);
background.add(b3);
background.add(b4);

setContentPane(background); 

setVisible(true);
}

public void actionPerformed(ActionEvent e)
{

try{
if(e.getSource()==b1)
{
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("Select serial from receive");
count1=1;
int a=1;
while(rs.next()) {
a++;
}
t1.setText(String.valueOf(a));
t2.setText("");
c2.setSelectedIndex(0);
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");


Calendar c=Calendar.getInstance();
int m=c.get(Calendar.MONTH)+1;
int d=c.get(Calendar.DATE);
int y=c.get(Calendar.YEAR);
String date=d+"/"+ m +"/"+y;

t3.setText(date);
}

 if (e.getSource()==c2)
{
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("Select clbalance from sparty where name='"+c2.getSelectedItem().toString()+"'");

if(rs.next())
t4.setText(rs.getString(1));

}


else if(e.getSource()==b2)
{
Statement stmt = con.createStatement();

String serial = t1.getText();
String pname = c2.getSelectedItem().toString();
String sdate = t3.getText();
String amt = t5.getText();
String details = t6.getText();

String sq1 ="insert into receive values('" +serial + "', '"+ pname +"', '"+sdate +"', '" + amt +"','"+details+"')";
stmt.executeUpdate(sq1);

JOptionPane.showMessageDialog(this, "Bill and item saved successfully!");

}

 else if(e.getSource()==b3)
{
      Statement stmt = con.createStatement();
    String s = "update receive set amt='" + t5.getText() + "', details='" + t6.getText() +"'where pname='"+c2.getSelectedItem()+"'";
    stmt.executeUpdate(s);
    JOptionPane.showMessageDialog(this, "Record Updated");
}



else if(e.getSource()==b4) {
Statement stmt=con.createStatement();
String s2="select * from receive where serial='"+t7.getText()+"'";
ResultSet rs= stmt.executeQuery(s2);
if(rs.next())
 {
t1.setText(rs.getString(1));
c2.setSelectedItem(rs.getString(2));
t3.setText(rs.getString(3));
t5.setText(rs.getString(4));
t6.setText(rs.getString(5));
}

}

} catch(Exception ex) {
System.out.println(ex.toString());
}
}

public static void main(String args[]) {
receive obj =new  receive();
}
}

