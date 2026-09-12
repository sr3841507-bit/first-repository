
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.sql.*;
import javax.swing.table.JTableHeader;


class purchasetable extends JInternalFrame  
{
JTable t;
JLabel l1 ;
 Font font1=new Font("Book Antiqua",Font.BOLD,20);

purchasetable()
{
super("",true,true,true,true);
setSize(1980,1800);
setLayout(null);
try{
Object row[][]= new Object[50][8];
String col[]=new String[]{"BILL NO.","ITEM NAME","RATE","QUANTITY","AMOUNT"};
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/user","root","");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("Select* from pbilltrans");
int i=0;
while(rs.next())
{
row[i][0]=rs.getString(1);
row[i][1]=rs.getString(2);
row[i][2]=rs.getString(3);
row[i][3]=rs.getString(4);
row[i][4]=rs.getString(5);

i++;
}


l1=new JLabel("PURCHASES");
l1.setFont(font1);
l1.setBounds(920,10,500,30);

t=new JTable(row,col);
t.setRowHeight(30);
t.setFont(font1);
t.setBackground(Color.decode("#e5f2ff"));
t.setForeground(Color.black);
  
JTableHeader header = t.getTableHeader();
header.setFont(new Font("Arial", Font.BOLD, 32));
header.setPreferredSize(new Dimension(header.getPreferredSize().width, 40));


JScrollPane js=new JScrollPane(t);
js.setBounds(10,60,1970,1780);
add(js);
add(l1);
setVisible(true);

}
catch(Exception e)
{System.out.println(e.toString()) ;}
}
public static void main(String args[])
{
purchasetable obj= new purchasetable();
}
}
