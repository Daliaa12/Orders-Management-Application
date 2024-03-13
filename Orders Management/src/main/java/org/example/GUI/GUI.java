package org.example.GUI;

import org.example.Businesslogic.ClientBLL;
import org.example.Businesslogic.ProductBLL;
import org.example.Connection.ConnectionFactory;
import org.example.DataAccess.ClientDAO;
import org.example.DataAccess.ProductDAO;
import org.example.Model.Client;
import org.example.Model.Produs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * Class for Graphical User Interface
 */
public class GUI {
    private JFrame frame = new JFrame("ORDERS MANAGEMENT");
    private JButton buttonClientOperation=new JButton("Client Operations");
    private JButton buttonProductOperation=new JButton("Product Operations");
    private JButton buttonCreateProductOrders=new JButton("Create product orders");
    private JFrame frameClient=new JFrame("CLIENTS");
    private JFrame frameProduct=new JFrame("PRODUCTS");
    private JFrame frameCreateOrders=new JFrame("CREATE PRODUCT ORDERS");
   private JButton buttonShowClients=new JButton("Show clients");
   private JButton buttonDeleteClients=new JButton("Delete clients");
   private JButton buttonInsertClient=new JButton("Insert clients");
   private JButton buttonEditClients= new JButton("Edit clients");
   private JButton buttonDeletefromView=new JButton("Delete");
   private JLabel otherOperation=new JLabel("Delete for other operation");
   private JLabel operations=new JLabel("Operations:");
   private JTable sp=new JTable();
    private JButton buttonShowClients2=new JButton("Show products");
    private JButton buttonDeleteClients2=new JButton("Delete products");
    private JButton buttonInsertClient2=new JButton("Insert products");
    private JButton buttonEditClients2= new JButton("Edit products");
    private JButton buttonDeletefromView2=new JButton("Delete");
    private JLabel otherOperation2=new JLabel("Delete for other operation");
    private JLabel operations2=new JLabel("Operations:");
    private JTable sp2=new JTable();
    private JTextArea orderid=new JTextArea();
    private JTextArea productid=new JTextArea();
    private JTextArea clientid=new JTextArea();
    private JButton buttondoneorder=new JButton("Done Order");
    private JTextArea cantitate=new JTextArea();

    private JLabel label1=new JLabel("Enter order id different from existing ones");
    private JLabel label2=new JLabel("Enter product id");
    private JLabel label3=new JLabel("Enter client id");
    private JLabel label4=new JLabel("Enter quantity");
    private JTable sp3=new JTable();
    private JLabel label5=new JLabel("Existing orders:");
    private JTextArea message=new JTextArea();
    private JButton buttonShowOrders=new JButton("Show orders");
    private JScrollPane js=new JScrollPane(sp);
    private JScrollPane js3=new JScrollPane(sp3);
    private JTextArea textidC=new JTextArea();
    private JTextArea textnameC=new JTextArea();
    private JTextArea textemailC=new JTextArea();
    private JTextArea textadressC=new JTextArea();
    private JLabel label6=new JLabel("Insert,Modify or delete:");
    private JLabel label7=new JLabel("id");
    private JLabel label8=new JLabel("name");
    private JLabel label9=new JLabel("email");
    private JLabel label10=new JLabel("adress");

    private JTextArea textidP=new JTextArea();
    private JTextArea textnameP=new JTextArea();
    private JTextArea textcantitateP=new JTextArea();
    private JLabel label11=new JLabel("Insert,Modify or delete:");
    private JLabel label12=new JLabel("id");
    private JLabel label13=new JLabel("name");
    private JLabel label14=new JLabel("cantitate");
    private JButton buttonDeleteOrder=new JButton("Delete orders");




    public GUI()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,550);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(183,232,224));
        addObjectsframe1();
        addObjectsframe2();
        addObjectsframe3();
        addObjectsframe4();
        createObjects();
        createActionListener();
        frame.setVisible(true);

    }

    /***
     * Method to add objects on the first frame
     */
    private void addObjectsframe1()
    {
        frame.add(buttonClientOperation);
        frame.add(buttonProductOperation);
        frame.add(buttonCreateProductOrders);

    }

    /***
     * Method to add objects on the second frame
     */
    private void addObjectsframe2()
    {
        frameClient.add(buttonShowClients);
        frameClient.add(buttonInsertClient);
        frameClient.add(buttonDeleteClients);
        frameClient.add(buttonEditClients);
        frameClient.add(buttonDeletefromView);
        frameClient.add(otherOperation);
        frameClient.add(operations);
        frameClient.add(sp);
        //frameClient.add(new JScrollPane(sp));
        frameClient.add(textidC);
        frameClient.add(textnameC);
        frameClient.add(textemailC);
        frameClient.add(textadressC);
        frameClient.add(label6);
        frameClient.add(label7);
        frameClient.add(label8);
        frameClient.add(label9);
        frameClient.add(label10);

    }

    /***
     * Method to add objects on the third frame
     */
    private void addObjectsframe3()
    {
        frameProduct.add(buttonShowClients2);
        frameProduct.add(buttonInsertClient2);
        frameProduct.add(buttonDeleteClients2);
        frameProduct.add(buttonEditClients2);
        frameProduct.add(buttonDeletefromView2);
        frameProduct.add(otherOperation2);
        frameProduct.add(operations2);
        frameProduct.add(sp2);
        frameProduct.add(textidP);
        frameProduct.add(textnameP);
        frameProduct.add(textcantitateP);
        frameProduct.add(label11);
        frameProduct.add(label12);
        frameProduct.add(label13);
        frameProduct.add(label14);


    }

    /***
     * Method to add objects on the fourth frame
     */
    private void addObjectsframe4()
    {
        frameCreateOrders.add(orderid);
        frameCreateOrders.add(productid);
        frameCreateOrders.add(clientid);
        frameCreateOrders.add(buttondoneorder);
        frameCreateOrders.add(cantitate);
        frameCreateOrders.add(label1);
        frameCreateOrders.add(label2);
        frameCreateOrders.add(label3);
        frameCreateOrders.add(buttondoneorder);
        frameCreateOrders.add(label4);
        frameCreateOrders.add(sp3);
        frameCreateOrders.add(label5);
        frameCreateOrders.add(message);
        frameCreateOrders.add(buttonShowOrders);
        frameCreateOrders.add(js3);
        frameCreateOrders.add(buttonDeleteOrder);

    }

    /***
     * Method to create object for graphical user interface
     */
    private void createObjects()
    {
        buttonClientOperation.setSize(250,100);
        buttonClientOperation.setLocation(15,50);
        buttonClientOperation.setBackground(new Color(89,217,195));

        buttonProductOperation.setSize(250,100);
        buttonProductOperation.setLocation(15,200);
        buttonProductOperation.setBackground(new Color(89,217,195));

        buttonCreateProductOrders.setSize(250,100);
        buttonCreateProductOrders.setLocation(15,350);
        buttonCreateProductOrders.setBackground(new Color(89,217,195));

        buttonShowClients.setSize(125,50);
        buttonShowClients.setLocation(10,50);
        buttonShowClients.setBackground(new Color(89,217,195));

        buttonEditClients.setSize(125,50);
        buttonEditClients.setLocation(10,150);
        buttonEditClients.setBackground(new Color(89,217,195));

        buttonDeleteClients.setSize(125,50);
        buttonDeleteClients.setLocation(10,250);
        buttonDeleteClients.setBackground(new Color(89,217,195));

        buttonInsertClient.setSize(125,50);
        buttonInsertClient.setLocation(10,350);
        buttonInsertClient.setBackground(new Color(89,217,195));

        buttonDeletefromView.setSize(125,25);
        buttonDeletefromView.setLocation(10,450);
        buttonDeletefromView.setBackground(new Color(89,217,195));

        otherOperation.setSize(380,50);
        otherOperation.setLocation(10,410);
        otherOperation.setFont(new Font("Serif",Font.ITALIC,12));

        operations.setSize(380,50);
        operations.setLocation(40,1);
        operations.setFont(new Font("Serif",Font.ITALIC,12));


        sp.setBounds(7, 360, 400, 450);
        sp.setLocation(160,35);
        //sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        buttonShowClients2.setSize(125,50);
        buttonShowClients2.setLocation(10,50);
        buttonShowClients2.setBackground(new Color(89,217,195));

        buttonEditClients2.setSize(125,50);
        buttonEditClients2.setLocation(10,150);
        buttonEditClients2.setBackground(new Color(89,217,195));

        buttonDeleteClients2.setSize(125,50);
        buttonDeleteClients2.setLocation(10,250);
        buttonDeleteClients2.setBackground(new Color(89,217,195));

        buttonInsertClient2.setSize(125,50);
        buttonInsertClient2.setLocation(10,350);
        buttonInsertClient2.setBackground(new Color(89,217,195));

        buttonDeletefromView2.setSize(125,25);
        buttonDeletefromView2.setLocation(10,450);
        buttonDeletefromView2.setBackground(new Color(89,217,195));

        otherOperation2.setSize(380,50);
        otherOperation2.setLocation(10,410);
        otherOperation2.setFont(new Font("Serif",Font.ITALIC,12));

        operations2.setSize(380,50);
        operations2.setLocation(40,1);
        operations2.setFont(new Font("Serif",Font.ITALIC,12));


        sp2.setBounds(7, 360, 400, 450);
        sp2.setLocation(160,35);
        //sp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        orderid.setSize(100,26);
        orderid.setLocation(70,150);

        productid.setSize(100,26);
        productid.setLocation(235,150);

        clientid.setSize(100,26);
        clientid.setLocation(400,150);

        label1.setSize(380,50);
        label1.setLocation(20,115);
        label1.setFont(new Font("Serif",Font.ITALIC,12));

        label2.setSize(380,50);
        label2.setLocation(240,115);
        label2.setFont(new Font("Serif",Font.ITALIC,12));

        label3.setSize(380,50);
        label3.setLocation(410,115);
        label3.setFont(new Font("Serif",Font.ITALIC,12));

        buttondoneorder.setSize(125,25);
        buttondoneorder.setLocation(220,80);
        buttondoneorder.setBackground(new Color(89,217,195));

        cantitate.setSize(100,26);
        cantitate.setLocation(235,200);

        label4.setSize(380,50);
        label4.setLocation(250,160);
        label4.setFont(new Font("Serif",Font.ITALIC,12));

        sp3.setBounds(7, 70, 250, 600);
        sp3.setLocation(550,1);

        label5.setSize(380,50);
        label5.setLocation(450,1);
        label5.setFont(new Font("Serif",Font.ITALIC,12));

        message.setSize(300,26);
        message.setLocation(120,300);

        buttonShowOrders.setSize(125,25);
        buttonShowOrders.setLocation(30,460);
        buttonShowOrders.setBackground(new Color(89,217,195));

        buttonDeleteOrder.setSize(125,25);
        buttonDeleteOrder.setLocation(200,460);
        buttonDeleteOrder.setBackground(new Color(89,217,195));

        sp.setPreferredScrollableViewportSize(new Dimension(450,53));
        sp.setFillsViewportHeight(true);
        js.setVisible(true);


        sp3.setPreferredScrollableViewportSize(new Dimension(450,53));
        sp3.setFillsViewportHeight(true);
        js3.setVisible(true);

        textidC.setSize(200,26);
        textidC.setLocation(570,100);

        textnameC.setSize(200,26);
        textnameC.setLocation(570,150);

        textemailC.setSize(200,26);
        textemailC.setLocation(570,200);

        textadressC.setSize(200,26);
        textadressC.setLocation(570,250);

        label6.setSize(380,50);
        label6.setLocation(590,60);
        label6.setFont(new Font("Serif",Font.ITALIC,18));

        label7.setSize(380,50);
        label7.setLocation(780,87);
        label7.setFont(new Font("Serif",Font.ITALIC,12));

        label8.setSize(380,50);
        label8.setLocation(780,135);
        label8.setFont(new Font("Serif",Font.ITALIC,12));

        label9.setSize(380,50);
        label9.setLocation(780,183);
        label9.setFont(new Font("Serif",Font.ITALIC,12));

        label10.setSize(380,50);
        label10.setLocation(780,231);
        label10.setFont(new Font("Serif",Font.ITALIC,12));

        textidP.setSize(200,26);
        textidP.setLocation(570,100);

        textnameP.setSize(200,26);
        textnameP.setLocation(570,150);

        textcantitateP.setSize(200,26);
        textcantitateP.setLocation(570,200);


        label11.setSize(380,50);
        label11.setLocation(590,60);
        label11.setFont(new Font("Serif",Font.ITALIC,18));

        label12.setSize(380,50);
        label12.setLocation(780,87);
        label12.setFont(new Font("Serif",Font.ITALIC,12));

        label13.setSize(380,50);
        label13.setLocation(780,135);
        label13.setFont(new Font("Serif",Font.ITALIC,12));

        label14.setSize(380,50);
        label14.setLocation(780,183);
        label14.setFont(new Font("Serif",Font.ITALIC,12));


    }

    /***
     * Method to create ActionListeners
     */
    private void createActionListener()
    {
        buttonClientOperation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameClient.dispose();
                frameClient.setSize(850,550);
                frameClient.setResizable(false);
                frameClient.setLayout(null);
                frameClient.getContentPane().setBackground(new Color(183,232,224));
                frameClient.setVisible(true);
            }
        });
        buttonProductOperation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameProduct.dispose();
                frameProduct.setSize(850,550);
                frameProduct.setResizable(false);
                frameProduct.setLayout(null);
                frameProduct.getContentPane().setBackground(new Color(183,232,224));
                frameProduct.setVisible(true);

            }
        });
        buttonCreateProductOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCreateOrders.dispose();
                frameCreateOrders.setSize(850,550);
                frameCreateOrders.setResizable(false);
                frameCreateOrders.setLayout(null);
                frameCreateOrders.getContentPane().setBackground(new Color(183,232,224));
                frameCreateOrders.setVisible(true);
            }
        });
        buttonShowClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = ConnectionFactory.getConnection();
                    Statement statement = connection.createStatement();
                    String query = "select * from client";
                    ResultSet rs = statement.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel)sp.getModel();
                    int cols = rsmd.getColumnCount();
                    String[] colName = new String[cols];
                    for (int i = 0; i < cols; i++)
                        colName[i] = rsmd.getColumnName(i + 1);
                      model.setColumnIdentifiers(colName);
                    String nume, email, adresa;
                    String client_id;
                    while (rs.next()) {
                        client_id = rs.getString(1);
                        nume = rs.getString(2);
                        email = rs.getString(3);
                        adresa = rs.getString(4);
                        String[] row = {client_id, nume, email, adresa};
                        model.addRow(row);
                    }
                    statement.close();
                    ConnectionFactory.close(connection);


                } catch (SQLException e1) {
                    e1.getMessage();
                }

            }
        });
        buttonDeletefromView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sp.setModel(new DefaultTableModel());

            }
        });
        buttonShowClients2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = ConnectionFactory.getConnection();
                    Statement statement = connection.createStatement();
                    String query = "select * from produs";
                    ResultSet rs = statement.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) sp2.getModel();
                    int cols = rsmd.getColumnCount();
                    String[] colName = new String[cols];
                    for (int i = 0; i < cols; i++)
                        colName[i] = rsmd.getColumnName(i + 1);
                    model.setColumnIdentifiers(colName);
                    String produs_id, nume, cantitate;
                    while (rs.next()) {
                        produs_id = rs.getString(1);
                        nume = rs.getString(2);
                        cantitate = rs.getString(3);
                        String[] row = {produs_id, nume, cantitate};
                        model.addRow(row);
                    }
                    statement.close();
                    ConnectionFactory.close(connection);


                } catch (SQLException e1) {
                    e1.getMessage();
                }

            }
        });
        buttonDeletefromView2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sp2.setModel(new DefaultTableModel());

            }
        });
        buttonShowOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = ConnectionFactory.getConnection();
                    Statement statement = connection.createStatement();
                    String query = "select * from comanda";
                    ResultSet rs = statement.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) sp3.getModel();
                    int cols = rsmd.getColumnCount();
                    String[] colName = new String[cols];
                    for (int i = 0; i < cols; i++)
                        colName[i] = rsmd.getColumnName(i + 1);
                    model.setColumnIdentifiers(colName);
                    String order_id, produs_id, client_id;
                    while (rs.next()) {
                        order_id = rs.getString(1);
                        produs_id = rs.getString(2);
                        client_id = rs.getString(3);
                        String[] row = {order_id, produs_id, client_id};
                        model.addRow(row);
                    }
                    statement.close();
                    ConnectionFactory.close(connection);


                } catch (SQLException e1) {
                    e1.getMessage();
                }

            }
        });
        buttonDeleteOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sp3.setModel(new DefaultTableModel());

            }
        });
        buttondoneorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection dbConnection = ConnectionFactory.getConnection();
                try {
                    Statement statement = dbConnection.createStatement();
                    int productId= Integer.parseInt(productid.getText());
                    ResultSet rs = statement.executeQuery("SELECT * FROM produs WHERE produs_id=" + productId);
                    rs.next();
                    String name = rs.getString("nume");
                    Integer cantitate2 = rs.getInt("cantitate");
                    int clientId=Integer.parseInt(clientid.getText());
                    rs = statement.executeQuery("SELECT * FROM client WHERE client_id = " + clientId);
                    rs.next();
                    int orderId=Integer.parseInt(orderid.getText());
                    int quantity=Integer.parseInt(cantitate.getText());
                    if (cantitate2 >= quantity) {
                        PreparedStatement statement2 = dbConnection.prepareStatement("INSERT INTO comanda (order_id, client_id, produs_id) VALUES (?, ?, ?)");
                        statement2.setInt(1, orderId);
                        statement2.setInt(2, clientId);
                        statement2.setInt(3, productId);
                        statement2.executeUpdate();
                        statement2 = dbConnection.prepareStatement("UPDATE produs SET cantitate = ? WHERE produs_id = ?");
                        statement2.setInt(1, cantitate2 - quantity);
                        statement2.setInt(2, productId);
                        statement2.executeUpdate();
                        message.setText("Order succesfully placed");
                    } else {
                        message.setText("Sorry not enough products");

                    }
                } catch (SQLException e1) {
                     e1.getMessage();
                } finally {
                    ConnectionFactory.close(dbConnection);
                }
            }
        });
        buttonEditClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int client_id=Integer.parseInt(textidC.getText());
                String name=textnameC.getText();
                String email=textemailC.getText();
                String adress=textadressC.getText();
                Client client=new Client(client_id,name,email,adress);
                ClientBLL clientBLL=new ClientBLL();
                clientBLL.editClient(client);
            }
        });
        buttonDeleteClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int client_id=Integer.parseInt(textidC.getText());
                ClientBLL clientBLL=new ClientBLL();
                clientBLL.findById(client_id);
                clientBLL.deleteClient(client_id);

            }
        });
        buttonInsertClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int client_id=Integer.parseInt(textidC.getText());
                String name=textnameC.getText();
                String email=textemailC.getText();
                String adress=textadressC.getText();
                Client client=new Client(client_id,name,email,adress);
                ClientBLL clientBLL=new ClientBLL();
                clientBLL.insertClient(client);

            }
        });
        buttonEditClients2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int product_id=Integer.parseInt(textidP.getText());
                String name=textnameP.getText();
                int cantitate=Integer.parseInt(textcantitateP.getText());
                Produs produs=new Produs(product_id,name,cantitate);
                ProductBLL productBLL=new ProductBLL();
                productBLL.editProdus(produs);
            }
        });
        buttonDeleteClients2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int produs_id=Integer.parseInt(textidP.getText());
                ProductBLL productBLL=new ProductBLL();
                productBLL.findById(produs_id);
                productBLL.deleteProdus(produs_id);

            }
        });
        buttonInsertClient2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int product_id=Integer.parseInt(textidP.getText());
                String name=textnameP.getText();
                int cantitate=Integer.parseInt(textcantitateP.getText());
                Produs produs=new Produs(product_id,name,cantitate);
                ProductBLL productBLL=new ProductBLL();
                productBLL.insertProdus(produs);
            }
        });
    }

    /***
     * Method that start the whole program
     * @param args main
     */
    public static void main(String[] args)
    {
        new GUI();

    }
}
