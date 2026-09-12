
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.sql.*;
import javax.swing.table.JTableHeader;


class ppartytable extends JInternalFrame  
{

JLabel l1;
JTable t;
 
ppartytable()
{
super("",true,true,true,true);

setSize(1980,1800);
setLayout(null);

Font font1=new Font("Book Antiqua",Font.BOLD,20);

try{
Object row[][]= new Object[50][8];
String col[]=new String[]{"NAME","ADDRESS","PHONE","BALANCE"};
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/user","root","");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("Select* from pparty");
int i=0;
while(rs.next())
{
row[i][0]=rs.getString(1);
row[i][1]=rs.getString(2);
row[i][2]=rs.getString(3);
row[i][3]=rs.getString(4);
i++;
}

l1=new JLabel("PURCHASE PARTIES");
l1.setFont(font1);
l1.setBounds(800,8,500,40);
l1.setForeground(Color.black);

t=new JTable(row,col);
t.setFont(font1);
t.setBackground(Color.decode("#E5F2FF"));
t.setForeground(Color.black);
t.setRowHeight(30); 
t.setPreferredScrollableViewportSize(new Dimension(1950,1700));


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
ppartytable obj= new ppartytable();
}
}
