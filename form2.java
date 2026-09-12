import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.sql.*;
 

class form2 extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l7,l8,l9;
JTextField t1,t2,t3,t4,t5;
JButton b1,b2,b3,b4,b5;
JCheckBox c1,c2,c3;
JComboBox k1;
JRadioButton r1,r2;



form2()
{
setSize(1900,1400);
setLayout(null);

Font font1=new Font("Arial Black",Font.BOLD,30);
Font font2=new Font("Cambria",Font.BOLD,33);
Font font3=new Font("Cambria",Font.BOLD,20);

ButtonGroup g=new ButtonGroup();

t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();
t5=new JTextField();

t1.setBounds(1000,100,300,47);
t1.setBackground(Color.white);
t1.setFont(font3);


t2.setBounds(1000,200,300,47);
t2.setBackground(Color.white);
t2.setFont(font3);


t3.setBounds(1000,300,300,47);
t3.setBackground(Color.white);
t3.setFont(font3);


t4.setBounds(1000,400,300,47);
t4.setBackground(Color.white);
t4.setFont(font3);


t5.setBounds(1000,900,300,47);
t5.setBackground(Color.white);
t5.setFont(font3);



l1=new JLabel("EMPLOYEE DETAILS");
l2=new JLabel("EMPLOYEE NUMBER: ");
l3=new JLabel("NAME");
l4=new JLabel("ADDRESS : ");
l5=new JLabel("PHONE NUMBER :");
l7=new JLabel("GENDER");
l8=new JLabel("HOBBIES");
l9=new JLabel("CITY");


l1.setFont(font1);
l1.setForeground(Color.red);
l1.setBounds(750,10,600,100);

l2.setFont(font2);
l2.setForeground(Color.black);
l2.setBounds(500,100,450,50);

l3.setFont(font2);
l3.setForeground(Color.black);
l3.setBounds(500,200,450,50);

l4.setFont(font2);
l4.setForeground(Color.black);
l4.setBounds(500,300,450,50);

l5.setFont(font2);
l5.setForeground(Color.black);
l5.setBounds(500,400,450,50);


l7.setFont(font2);
l7.setForeground(Color.black);
l7.setBounds(500,500,400,50);
 

l8.setFont(font2);
l8.setForeground(Color.black);
l8.setBounds(500,600,400,50);


l9.setFont(font2);
l9.setForeground(Color.black);
l9.setBounds(500,700,400,50);


r1=new JRadioButton("MALE");
r1.setBounds(1000,500,200,60);
r1.setForeground(Color.decode("#52595D"));
r1.setFont(font1);

r2=new JRadioButton("FEMALE");
r2.setBounds(1210,500,200,60);
r2.setForeground(Color.decode("#52595D"));
r2.setFont(font1);
 
g.add(r1);
g.add(r2);
add(r1);
add(r2);



c1=new JCheckBox("SPORTS");
c1.setBounds(1000,590,200,50);
c1.setForeground(Color.decode("#FFBF00"));
c1.setFont(font1);

c2=new JCheckBox("MUSIC");
c2.setBounds(1210,590,200,50);
c2.setForeground(Color.decode("#FFBF00"));
c2.setFont(font1);

c3=new JCheckBox("MOVIE");
c3.setBounds(1420,590,200,50);
c3.setForeground(Color.decode("#FFBF00"));
c3.setFont(font1);


k1=new JComboBox();
k1.setBounds(1000,700,300,30);
k1.setBackground(Color.decode("#CFECEC"));
k1.setForeground(Color.decode("#2B3856"));
k1.setFont(font3);
k1.addItem("     select city    ");
k1.addItem("Fatehabad");
k1.addItem("Hisar");
k1.addItem("Sirsa");
k1.addItem("Bhuna");



b1=new JButton("NEW");
b2=new JButton("SAVE");
b3=new JButton("MODIFY");
b4=new JButton("DELETE");
b5=new JButton("FIND");

b1.setBounds(400,800,190,50);
b1.setForeground(Color.white);
b1.setBackground(Color.black);
b1.setFont(font3);



b2.setBounds(700,800,190,50);
b2.setForeground(Color.white);
b2.setBackground(Color.black);
b2.setFont(font3);


b3.setBounds(1000,800,190,50);
b3.setForeground(Color.white);
b3.setBackground(Color.black);
b3.setFont(font3);


b4.setBounds(1300,800,190,50);
b4.setForeground(Color.white);
b4.setBackground(Color.black);
b4.setFont(font3);

b5.setFont(font2);
b5.setForeground(Color.white);
b5.setBackground(Color.black);
b5.setBounds(500,900,190,30);


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
add(k1);
add(r1);
add(r2);
add(c1);
add(c2);
add(c3);

add(l1);
add(l2);
add(l3);
add(l4);
add(l5);

add(l7);
add(l8);
add(l9);

add(b1);
add(b2);
add(b3);
add(b4);
add(b5);


setVisible(true);
}

public void actionPerformed(ActionEvent e)
{
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/data3", "root", "");
        Statement stmt = con.createStatement();

  if (e.getSource() == b1) 
{
   t1.setText("");
   t2.setText("");
  t3.setText("");
  t4.setText("");
  t5.setText("");
  k1.setSelectedIndex(0);
  r1.setSelected(false);
  r2.setSelected(false);

  c1.setSelected(false);
  c2.setSelected(false);
  c3.setSelected(false);
  t1.requestFocus();
        }

else if (e.getSource() == b2) {
String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : "";
String hobbies = "";
 if (c1.isSelected()) hobbies = hobbies + "Sports ";
  if (c2.isSelected()) hobbies = hobbies + "Music ";
  if (c3.isSelected()) hobbies = hobbies + "Movie ";
String city = k1.getSelectedItem().toString();

String s = "INSERT INTO employee VALUES (" + t1.getText() + ",'" + t2.getText() + "','" + t3.getText() + "','" + t4.getText() + "','" + gender + "','" + hobbies.trim() + "','" + city + "')";
 stmt.executeUpdate(s);
JOptionPane.showMessageDialog(this, "Record Saved");
        }

 else if (e.getSource() == b3) {
   String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : "";
            String hobbies = "";
 if (c1.isSelected()) hobbies = hobbies + "Sports ";
 if (c2.isSelected()) hobbies = hobbies + "Music ";
 if (c3.isSelected()) hobbies = hobbies + "Movie ";


 String city = k1.getSelectedItem().toString();

String s = "UPDATE employee SET name='" + t2.getText() + "', address='" + t3.getText() + "', phone='" + t4.getText() + "', gender='" + gender + "', hobbies='" + hobbies.trim() + "', city='" + city + "' WHERE eno=" + t1.getText();
            stmt.executeUpdate(s);
            JOptionPane.showMessageDialog(this, "Record Updated");
}

else if (e.getSource() == b4) {
String s = "DELETE FROM employee WHERE eno=" + t1.getText();
int res = stmt.executeUpdate(s);
 if (res > 0)
 JOptionPane.showMessageDialog(this, "Record Deleted");
 else
  JOptionPane.showMessageDialog(this, "Record Not Found");
   }

else if(e.getSource()==b5)
{
    String s2 = "SELECT * FROM employee WHERE eno=" + t5.getText();
    System.out.println(s2);
    ResultSet rs = stmt.executeQuery(s2);
    if(rs.next())
    {
     t1.setText(String.valueOf(rs.getInt("eno")));
    t2.setText(rs.getString("name"));
    t3.setText(rs.getString("address"));
   t4.setText(rs.getString("phone"));

  String gender = rs.getString("gender");
 if(gender.equalsIgnoreCase("Male"))
 r1.setSelected(true);
 else if(gender.equalsIgnoreCase("Female"))
 r2.setSelected(true);

   String hobbies = rs.getString("hobbies");
  c1.setSelected(hobbies.contains("Sports"));
 c2.setSelected(hobbies.contains("Music"));
c2.setSelected(hobbies.contains("Movie"));
   
  String city = rs.getString("city");
 k1.setSelectedItem(city);
    }
}

 else {
  JOptionPane.showMessageDialog(this, "Record not found");
 }

} catch (Exception ex) {
    System.out.println(ex.toString());
}
} 


public static void main(String args[])
{ 
    form2 obj = new form2();
}
}

