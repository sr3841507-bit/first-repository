import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;
import javax.swing.event.*;


class purchase extends JInternalFrame implements ActionListener,FocusListener,ListSelectionListener
{
Connection con;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
JComboBox c3,c4;
JButton b1,b2,b3,b4,b5;
JFileChooser f1;
JList list1;
DefaultListModel model1;
int count1;

purchase()
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


model1= new DefaultListModel();
list1=new JList(model1);
list1.setBounds(1350,370,150,200);
list1.setFont(font3);


t1=new JTextField(); 
//billno
t2=new JTextField(); 
//date
c3=new JComboBox(); 
//pname
t3=new JTextField();
//balance
c4=new JComboBox();
//itemname
t4=new JTextField();
//price
t5=new JTextField();
//clprice
t6=new JTextField();
//qty
t7=new JTextField();
//amt
t8=new JTextField();
//total amt
t9=new JTextField();
//find



l1=new JLabel("PURCHASES");
l2=new JLabel("BILL NO: ");
l3=new JLabel("DATE");
l4=new JLabel("PARTY NAME : ");
l5=new JLabel("BALANCE :");
l6=new JLabel("ITEM NAME :");
l7=new JLabel("PRATE :");
l8=new JLabel("QUANTITY:");
l9=new JLabel("QTY. AVAILABLE :");
l10=new JLabel("AMOUNT :");
l11=new JLabel("TOTAL AMOUNT :");



l1.setFont(font1);
l1.setForeground(Color.decode("#825D55"));
l1.setBounds(740,20,800,40);


l2.setFont(font2);
//bno
l2.setForeground(Color.black);
l2.setBounds(600,80,450,50);

t1.setBounds(1000,80,300,47);
t1.setBackground(Color.decode("#94B0DB"));
t1.setFont(font3);



l3.setFont(font2);
//date
l3.setForeground(Color.black);
l3.setBounds(600,160,450,50);

t2.setBounds(1000,160,300,47);
t2.setBackground(Color.decode("#94B0DB"));
t2.setFont(font3);


l4.setFont(font2);
//pname
l4.setForeground(Color.black);
l4.setBounds(600,230,450,50);

c3.setBounds(1000,230,300,47);
c3.setBackground(Color.decode("#94B0DB"));
c3.setFont(font3);


 
l5.setFont(font2);
//balance
l5.setForeground(Color.black);
l5.setBounds(600,300,450,50);

t3.setBounds(1000,300,300,47);
t3.setBackground(Color.decode("#94B0DB"));
t3.setFont(font3);




   l6.setFont(font2);
//iname
l6.setForeground(Color.black);
l6.setBounds(600,370,450,50);


c4.setBounds(1000,370,300,47);
c4.setBackground(Color.decode("#94B0DB"));
c4.setFont(font3);


  
l7.setFont(font2);
//rate
l7.setForeground(Color.black);
l7.setBounds(600,440,450,50);


t4.setBounds(1000,440,300,47);
t4.setBackground(Color.decode("#94B0DB"));
t4.setFont(font3);

 l8.setFont(font2);
//qty
l8.setForeground(Color.black);
l8.setBounds(600,580,450,50);

t5.setBounds(1000,580,300,47);
t5.setBackground(Color.decode("#94B0DB"));
t5.setFont(font3);



 l9.setFont(font2);
//qtyavl
l9.setForeground(Color.black);
l9.setBounds(600,510,450,50);


t6.setBounds(1000,510,300,47);
t6.setBackground(Color.decode("#94B0DB"));
t6.setFont(font3);



l10.setFont(font2);
//amt
l10.setForeground(Color.black);
l10.setBounds(600,650,450,50);

t7.setBounds(1000,650,300,47);
t7.setBackground(Color.decode("#94B0DB"));
t7.setFont(font3);


l11.setFont(font2);
//tamt
l11.setForeground(Color.black);
l11.setBounds(600,650,450,50);
l11.setBounds(600,720,250,50);

t8.setBounds(1000,720,300,47);
t8.setBackground(Color.decode("#94B0DB"));
t8.setFont(font3);

//find
t9.setBounds(1000,860,300,47);
t9.setBackground(Color.decode("#94B0DB"));
t9.setFont(font3);




b1=new JButton("NEW BILL");
b2=new JButton("NEW ITEM");
b3=new JButton("SAVE");
b4=new JButton("DELETE ITEM");
b5=new JButton("FIND");


b1.setBounds(250,790,300,50);
b1.setForeground(Color.white);
b1.setBackground(Color.decode("#34495E"));
b1.setFont(font3);



b2.setBounds(650,790,300,50);
b2.setForeground(Color.white);
b2.setBackground(Color.decode("#34495E"));
b2.setFont(font3);


b3.setBounds(1050,790,300,50);
b3.setForeground(Color.white);
b3.setBackground(Color.decode("#34495E"));
b3.setFont(font3);



b4.setBounds(1450,790,300,50);
b4.setForeground(Color.white);
b4.setBackground(Color.decode("#34495E"));
b4.setFont(font3);

b5.setForeground(Color.white);
b5.setBackground(Color.decode("#34495E"));
b5.setFont(font3);
b5.setBounds(700,860,120,50);


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
c4.addActionListener(this);
t5.addFocusListener(this);
c3.addActionListener(this);
list1.addListSelectionListener(this);


try
{
Statement stmt1 = con.createStatement();
    String s = "SELECT name from pparty ";
ResultSet rs1 = stmt1.executeQuery(s);
c3.addItem("");
    while (rs1.next()) 
{       
c3.addItem(rs1.getString(1));
 }

 Statement stmt2 = con.createStatement();
 String s2="SELECT iname from item";
ResultSet rs2 = stmt2.executeQuery(s2);
c4.addItem("");
    while (rs2.next()) {
     c4.addItem(rs2.getString(1));
        }

}
catch(Exception e)
{
}


add(t1);
add(t2);
add(c3);
add(t3);
add(t4);
add(t5);
add(t6);
add(t7);
add(t8);
add(t9);
add(c4);

add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l11);
add(l7);
add(l8);
add(l9);
add(l10);
add(l6);


add(b1);
add(b2);
add(b3);
add(b4);
add(b5);
add(list1);



background.setLayout(null);
background.add(list1);
background.add(t1);
background.add(t2);
background.add(c3);
background.add(c4);
background.add(t4);
background.add(t5);

background.add(t3);
background.add(t4);
background.add(t6);
background.add(t7);
background.add(t8);
background.add(t9);



background.add(l1);
background.add(l2);
background.add(l3);
background.add(l4);
background.add(l5);


background.add(l11);
background.add(l7);
background.add(l8);
background.add(l9);
background.add(l10);
background.add(l6);


background.add(b1);
background.add(b2);
background.add(b3);
background.add(b4);
background.add(b5);

background.setPreferredSize(new Dimension(1900, 1600));
setContentPane(background); 
setVisible(true);

}



 public void focusGained(FocusEvent e)
{
}


public void focusLost(FocusEvent f)
{
try{
if(f.getSource() == t5) {
double prate = Double.parseDouble(t4.getText());
double qty = Double.parseDouble(t5.getText());
double total = prate*qty;
t7.setText(String.valueOf(total));

if(t8.getText().equals(""))
{
t8.setText(String.valueOf(Double.parseDouble(t7.getText())));
}
else
{
 t8.setText(String.valueOf(Double.parseDouble(t8.getText())+Double.parseDouble(t7.getText())));
} 
}
}catch(Exception f2)
{
System.out.println(f2.toString());
}
}



public void valueChanged(ListSelectionEvent e)
{
  try{
if(e.getSource()==list1)
{
c4.setSelectedItem(list1.getSelectedValue());
}

String iname = list1.getSelectedValue().toString();
c4.setSelectedItem(iname);
String billno = t1.getText();
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT qty, amt FROM pbilltrans WHERE billno='" + billno + "' AND iname='" + iname + "'");
if(rs.next()) {
t5.setText(rs.getString("qty"));
t7.setText(rs.getString("amt"));
}
}catch(Exception ex)
{System.out.println(ex.toString());
}
}



public void actionPerformed(ActionEvent e)
{

try{

 if(e.getSource() == b1) {
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("Select billno from pbillmaster");
count1=1;
int a=1;
while(rs.next()) {
a++;
}
t1.setText(String.valueOf(a));

t2.setText("");
c3.setSelectedIndex(0);
c4.setSelectedIndex(0);
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
//model1.clear();

Calendar c=Calendar.getInstance();
int m=c.get(Calendar.MONTH)+1;
int d=c.get(Calendar.DATE);
int y=c.get(Calendar.YEAR);
String date=d+"/"+ m +"/"+y;

t2.setText(date);

}

else if(e.getSource()==b2)
{
count1=2;
 c3.requestFocus();
c4.setSelectedIndex(0);
//t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
}


else if (e.getSource()==c3)
{
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("Select opbalance from pparty where name='"+c3.getSelectedItem().toString()+"'");

double opbal=0;
if(rs.next())
opbal=Double.parseDouble(rs.getString(1));
//t3.setText(String.valueOf(opbal));

Statement stmt1=con.createStatement();
ResultSet rs2=stmt1.executeQuery("Select totalamount from pbillmaster where partyname='"+c3.getSelectedItem().toString()+"'");
double tot=0;
while(rs2.next())
{
tot=tot+Double.parseDouble(rs2.getString(1));
}

Statement stmt2=con.createStatement();
ResultSet rs3=stmt2.executeQuery("Select amt from payment where pname='"+c3.getSelectedItem().toString()+"'");
double totalamt=0;
while(rs3.next())
{
totalamt=totalamt+Double.parseDouble(rs3.getString(1));
}
if(c3.getSelectedItem().toString().equals(""))
t3.setText("");
else
t3.setText(String.valueOf(opbal+tot-totalamt));
}
 


else if(e.getSource() == c4)
 {
String item = c4.getSelectedItem().toString();
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("Select pprice ,opqty from item WHERE iname='" + item + "'");
if(rs.next()) {
t4.setText(rs.getString("pprice"));
t6.setText(rs.getString("opqty"));
}
}

  else if(e.getSource() == b3) 
{

Statement stmt = con.createStatement();

 int i;
int k=0;
for( i=0; i<model1.size(); i++)
{
if(model1.getElementAt(i).toString().equals(c4.getSelectedItem()))
{
k=1;
break;
}
}

if(k==1)
{
JOptionPane.showMessageDialog(this, "ERROR , item already exists!");
}
else
{
String sq4 = "insert into pbilltrans values('"+t1.getText()+ "', '" + c4.getSelectedItem()+ "', '" +t4.getText()+ "', '" +t5.getText()+ "', '" + t7.getText()+ "')";
stmt.executeUpdate(sq4);

model1.addElement(c4.getSelectedItem());

stmt.executeUpdate("UPDATE item set opqty = opqty + " +t5.getText() + " WHERE iname='"+ c4.getSelectedItem()+"'");

double qtavail = Double.parseDouble(t6.getText());
double addedQty = Double.parseDouble(t5.getText());
double updatedQty = qtavail+ addedQty;
t6.setText(String.valueOf(updatedQty));

JOptionPane.showMessageDialog(this, "Bill and item saved successfully!");



String billno = t1.getText();
String partyname = c3.getSelectedItem().toString();
String billdate = t2.getText();
String totalamount = t8.getText();

String iname = c4.getSelectedItem().toString();
String rate = t4.getText();
String qty = t5.getText();
String amt = t7.getText();


if(count1==1)
{
String sq1 ="insert into pbillmaster values('" + billno + "', '"+ partyname +"', '"+billdate +"', '" + totalamount +"')";
stmt.executeUpdate(sq1);
}
else if(count1==2)
{
String sq1 = "update pbillmaster set totalamount='"+t8.getText()+"' where billno= '"+t1.getText()+"'";
stmt.executeUpdate(sq1);

String sq3 = "update pparty set opbalance='"+t3.getText()+"' where name= '"+c3.getSelectedItem()+"'";
stmt.executeUpdate(sq3);
}
}
}

else if(e.getSource()==b4)
{
int index = list1.getSelectedIndex();
String billno = t1.getText();
String iname = model1.getElementAt(index).toString();
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select qty, amt from pbilltrans where billno='" + billno + "' and  iname='" + iname + "'");

double qty = 0, amt = 0;
if(rs.next()) 
{
qty = Double.parseDouble(rs.getString("qty"));
amt = Double.parseDouble(rs.getString("amt"));
double availQty = Double.parseDouble(t6.getText()) - qty;
t5.setText("");                   
t4.setText("");                   
t6.setText("");
t7.setText("");
}

stmt.executeUpdate("delete from pbilltrans where billno='" + billno + "' AND iname='" + iname + "'");
ResultSet rs5 = stmt.executeQuery("select totalamount from pbillmaster where billno='" + billno + "'");

if(rs5.next())
 {
double totalAmt = Double.parseDouble(rs5.getString("totalamount"));
double updatedTotal = totalAmt - amt;
stmt.executeUpdate("update pbillmaster set totalamount='" + updatedTotal + "' where billno='" + billno + "'");
t8.setText(String.valueOf(updatedTotal));
}

stmt.executeUpdate("update item set opqty = opqty - " + qty + " where iname='" + iname + "'");

String partyname = c3.getSelectedItem().toString();
ResultSet r6 = stmt.executeQuery("Select opbalance from pparty where name='" + partyname + "'");
double opbal = 0;
if(r6.next()) 
{
    opbal = Double.parseDouble(r6.getString(1));
}

ResultSet rs7= stmt.executeQuery("Select totalamount from pbillmaster where partyname='" + partyname + "'");
double totalAmt = 0;
while(rs7.next()) 
{
    totalAmt = totalAmt+ Double.parseDouble(rs7.getString(1));
}

ResultSet rs8 = stmt.executeQuery("Select amt from payment where pname='" + partyname + "'");
double totalPayment = 0;
while(rs8.next()) 
{
    totalPayment =totalPayment+ Double.parseDouble(rs8.getString(1));
}

double finalBalance = opbal + totalAmt - totalPayment;
t3.setText(String.valueOf(finalBalance));

model1.removeElementAt(index);
JOptionPane.showMessageDialog(this, "Item deleted successfully.");
 }


else if(e.getSource()==b5) 
{
t7.setText("");
Statement stmt=con.createStatement();
String s2="select * from pbillmaster where billno='"+t9.getText()+"'";
ResultSet rs= stmt.executeQuery(s2);
if(rs.next())
 {
t1.setText(rs.getString(1));
t2.setText(rs.getString(3));
c3.setSelectedItem(rs.getString(2));
//t7.setText(""));
t8.setText(rs.getString(4));
}

Statement stmt2=con.createStatement();
String s3="select * from pbilltrans where billno='"+t9.getText()+"'";
ResultSet rs2= stmt2.executeQuery(s3);
model1.clear();
while(rs2.next())
 {
model1.addElement(rs2.getString(2));
}
 
}

else {
JOptionPane.showMessageDialog(this,"Record not found");
}

} catch(Exception ex) {
System.out.println(ex.toString());
}
}

public static void main(String args[]) {
purchase obj =new purchase();
}
}


