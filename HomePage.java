import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener {


JMenuItem purchaseParty, saleParty, purchase, sale, payment, receive;
JMenuItem viewPurchaseParty, viewSaleParty, viewPurchase, viewSale,viewpurchasepartyinfo, viewsalepartyinfo,viewpayinfo,viewreceiveinfo,viewitemdetails,viewiteminfo;
JMenuItem itemdetails;


JDesktopPane desk1 = new JDesktopPane() {
Image bg = new ImageIcon("img4.jpg").getImage();

protected void paintComponent(Graphics g) {
super.paintComponent(g);
g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
Graphics2D g2 = (Graphics2D) g;
g2.setColor(new Color(0, 0, 0, 100)); // Transparent black overlay
g2.fillRect(0, 0, getWidth(), getHeight());
}
};

  

public HomePage() {
setTitle("Home Page");
setSize(1900, 1200);
setContentPane(desk1);

Font menuFont = new Font("Arial", Font.BOLD, 18);
Color bgColor = Color.decode("#AED6F1");
Color fgColor = Color.WHITE;
Color hoverColor = Color.decode("#5DADE2"); 


JMenuBar menuBar = new JMenuBar();
menuBar.setBackground(Color.decode("#BD8877")); 
menuBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));


/*
public Dimension getPreferredSize()
 {
return new Dimension(super.getPreferredSize().width, 40);
}
};
menuBar.setFont(menuFont);*/

JMenu transactionMenu = new JMenu("Transaction");
transactionMenu.setFont(menuFont);

purchaseParty = new JMenuItem("Purchase Party");
saleParty = new JMenuItem("Sale Party");
itemdetails=new JMenuItem("Item Details");
purchase = new JMenuItem("Purchase");
sale = new JMenuItem("Sale");
payment = new JMenuItem("Payment");
receive = new JMenuItem("Receive");

JMenu viewMenu = new JMenu("View");
viewMenu.setFont(menuFont);

viewPurchaseParty = new JMenuItem("Purchase Party");
viewSaleParty = new JMenuItem("Sale Party");
viewPurchase = new JMenuItem("Purchase");
viewSale = new JMenuItem("Sale");
viewpurchasepartyinfo = new JMenuItem("Purchase party balance information");
viewsalepartyinfo = new JMenuItem("Sale party balance information");
viewpayinfo= new JMenuItem("Payment Information");
viewreceiveinfo= new JMenuItem("Receive Information");
viewitemdetails= new JMenuItem("Item details");
viewiteminfo=new JMenuItem("Item Information");



JMenuItem[] items = {purchaseParty, saleParty, itemdetails,purchase, sale, payment, receive,
viewPurchaseParty, viewSaleParty, viewPurchase, viewSale,viewpurchasepartyinfo,viewsalepartyinfo,viewpayinfo,viewreceiveinfo,viewitemdetails,viewiteminfo};

transactionMenu.add(purchaseParty);
transactionMenu.add(saleParty);
transactionMenu.add(itemdetails);
transactionMenu.add(purchase);
transactionMenu.add(sale);
transactionMenu.add(payment);
transactionMenu.add(receive);

viewMenu.add(viewPurchaseParty);
viewMenu.add(viewSaleParty);
viewMenu.add(viewPurchase);
viewMenu.add(viewSale);
viewMenu.add(viewpurchasepartyinfo);
viewMenu.add(viewsalepartyinfo);
viewMenu.add(viewpayinfo);
viewMenu.add(viewreceiveinfo);
viewMenu.add(viewitemdetails);
viewMenu.add(viewiteminfo);


menuBar.add(transactionMenu);
menuBar.add(viewMenu);

/*
purchaseParty.setFont(menuFont);
purchaseParty.setBackground(bgColor);
purchaseParty.setForeground(fgColor);
purchaseParty.setOpaque(true);

saleParty.setFont(menuFont);
saleParty.setBackground(bgColor);
saleParty.setForeground(fgColor);
saleParty.setOpaque(true);

itemdetails.setFont(menuFont);
itemdetails.setBackground(bgColor);
itemdetails.setForeground(fgColor);
itemdetails.setOpaque(true);


purchase.setFont(menuFont);
purchase.setBackground(bgColor);
purchase.setForeground(fgColor);
purchase.setOpaque(true);

sale.setFont(menuFont);
sale.setBackground(bgColor);
sale.setForeground(fgColor);
sale.setOpaque(true);

payment.setFont(menuFont);
payment.setBackground(bgColor);
payment.setForeground(fgColor);
payment.setOpaque(true);

receive.setFont(menuFont);
receive.setBackground(bgColor);
receive.setForeground(fgColor);
receive.setOpaque(true);

viewPurchaseParty.setFont(menuFont);
viewPurchaseParty.setBackground(bgColor);
viewPurchaseParty.setForeground(fgColor);
viewPurchaseParty.setOpaque(true);

viewSaleParty.setFont(menuFont);
viewSaleParty.setBackground(bgColor);
viewSaleParty.setForeground(fgColor);
viewSaleParty.setOpaque(true);

viewPurchase.setFont(menuFont);
viewPurchase.setBackground(bgColor);
viewPurchase.setForeground(fgColor);
viewPurchase.setOpaque(true);

viewSale.setFont(menuFont);
viewSale.setBackground(bgColor);
viewSale.setForeground(fgColor);
viewSale.setOpaque(true);

viewpurchasepartyinfo.setFont(menuFont);
viewpurchasepartyinfo.setBackground(bgColor);
viewpurchasepartyinfo.setForeground(fgColor);
viewpurchasepartyinfo.setOpaque(true);

viewsalepartyinfo.setFont(menuFont);
viewsalepartyinfo.setBackground(bgColor);
viewsalepartyinfo.setForeground(fgColor);
viewsalepartyinfo.setOpaque(true);

viewpayinfo.setFont(menuFont);
viewpayinfo.setBackground(bgColor);
viewpayinfo.setForeground(fgColor);
viewpayinfo.setOpaque(true);

viewreceiveinfo.setFont(menuFont);
viewreceiveinfo.setBackground(bgColor);
viewreceiveinfo.setForeground(fgColor);
viewreceiveinfo.setOpaque(true);

viewitemdetails.setFont(menuFont);
viewitemdetails.setBackground(bgColor);
viewitemdetails.setForeground(fgColor);
viewitemdetails.setOpaque(true);


viewiteminfo.setFont(menuFont);
viewiteminfo.setBackground(bgColor);
viewiteminfo.setForeground(fgColor);
viewiteminfo.setOpaque(true);
*/




setJMenuBar(menuBar);


purchaseParty.addActionListener(this);
saleParty.addActionListener(this);
itemdetails.addActionListener(this);
purchase.addActionListener(this);
sale.addActionListener(this);
payment.addActionListener(this);
receive.addActionListener(this);
viewPurchaseParty.addActionListener(this);
viewSaleParty.addActionListener(this);
viewPurchase.addActionListener(this);
viewSale.addActionListener(this);
viewsalepartyinfo.addActionListener(this);
viewpurchasepartyinfo.addActionListener(this);
viewpayinfo.addActionListener(this);
viewreceiveinfo.addActionListener(this);
viewitemdetails.addActionListener(this);
viewiteminfo.addActionListener(this);






JMenuItem[] itemstoStyle = {
  purchaseParty, saleParty, itemdetails, purchase, sale, payment, receive,
  viewPurchaseParty, viewSaleParty, viewPurchase, viewSale,
  viewpurchasepartyinfo, viewsalepartyinfo, viewpayinfo, viewreceiveinfo,
  viewitemdetails, viewiteminfo
};

for (JMenuItem item : itemstoStyle) {
  beautifyMenuItem(item, bgColor, fgColor, hoverColor);
}



setVisible(true);
}



void beautifyMenuItem(JMenuItem item, Color bgColor, Color fgColor, Color hoverColor) {
    final JMenuItem menuItem = item;
    final Color finalBgColor = bgColor;
    final Color finalHoverColor = hoverColor;

    menuItem.setBackground(finalBgColor);
    menuItem.setForeground(fgColor);
    menuItem.setFont(new Font("Arial", Font.BOLD, 18));
    menuItem.setOpaque(true);
    menuItem.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

    menuItem.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            menuItem.setBackground(finalHoverColor);
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            menuItem.setBackground(finalBgColor);
        }
    });
}




public void actionPerformed(ActionEvent e) {

if (e.getSource() == purchaseParty) {
purchaseparty obj = new purchaseparty();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}




if (e.getSource() == saleParty) {
saleparty obj = new saleparty();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}



if (e.getSource() == itemdetails) {
itemdetails obj = new itemdetails();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}

if (e.getSource() == purchase) {
purchase obj = new purchase();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}



if (e.getSource() == sale) {
sale obj = new sale();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}


if (e.getSource() == payment) 
{
payment obj = new payment();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}
}


if (e.getSource() == receive) {
receive obj = new receive();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}
}


if (e.getSource() == viewPurchaseParty) {
ppartytable obj = new ppartytable();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}


if (e.getSource() == viewSaleParty) {
spartytable obj = new spartytable();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}




if (e.getSource() == viewPurchase) {
purchasetable obj = new purchasetable();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}




if (e.getSource() == viewSale) {
saletable obj = new saletable();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}



if (e.getSource() == viewsalepartyinfo) {
spinfo obj=new spinfo();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}




if (e.getSource() == viewpurchasepartyinfo) {
ppinfo obj= new ppinfo();

desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}




if (e.getSource() == viewreceiveinfo) {
receivedetails obj= new receivedetails();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}


}




 if (e.getSource() == viewpayinfo) {
paymentdetails obj= new paymentdetails();

desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}




 if (e.getSource() == viewitemdetails) {
itemtable obj= new itemtable();
desk1.add(obj);
  obj.setVisible(true);
try
{
obj.setMaximum(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}




  if (e.getSource() == viewiteminfo) {
iteminfo obj= new iteminfo();
desk1.add(obj);
try
{
obj.setMaximum(true);
  obj.setVisible(true);
}
catch(Exception ex)
{
System.out.println(ex.toString());
}

}

}

public static void main(String[] args) {
HomePage obj =new HomePage();
}
}
