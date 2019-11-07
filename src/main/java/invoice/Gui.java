package invoice;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList; 
import java.awt.BorderLayout;

/**
 * @author paula
 *
 */
public class Gui extends JFrame implements ActionListener{
	
	JMenu invoice, shopping, clientt;
	JMenuItem create, proa, prob, proc, prod, proe, switchClient, newClient, delete;
	static int actualClient=0;
	int counter=-1, amount=0, whosInvoice, invoiceNumber=0;
	String basket="", actualBasket;
	static ArrayList<String> BasketList = new ArrayList<String>();
	static JTextArea text;
	static ArrayList<Integer> whatBoughtList = new ArrayList<Integer>();
	
	
	static Product pra = new Product(200, "bookstand");
	static Product prb = new Product(350, "wardrobe");
	static Product prc = new Product(560, "bed");
	static Product prd = new Product(120, "lamp");
	static Product pre = new Product(40, "vase");
	
	public Gui() {
		setTitle("Invoice program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLayout(new BorderLayout());
		
		JMenuBar menuBar = new JMenuBar();
		invoice = new JMenu("Invoice");
		shopping = new JMenu("Shopping");
		clientt = new JMenu("Client");
		create = new JMenuItem("Create new");
		proa = new JMenuItem("bookstand");
		prob = new JMenuItem("wardrobe");
		proc = new JMenuItem("bed");
		prod = new JMenuItem("lamp");
		proe = new JMenuItem("vase");
		switchClient = new JMenuItem("switch");
		newClient = new JMenuItem("new");
		delete = new JMenuItem("delete shopping");
		
		setJMenuBar(menuBar);
		menuBar.add(invoice);
		menuBar.add(shopping);
		menuBar.add(clientt);
		invoice.add(create);
		shopping.add(proa);
		shopping.add(prob);
		shopping.add(proc);
		shopping.add(prod);
		shopping.add(proe);
		clientt.add(switchClient);
		clientt.add(newClient);
		clientt.add(delete);
		
		create.addActionListener(this);
		proa.addActionListener(this);
		prob.addActionListener(this);
		proc.addActionListener(this);
		prod.addActionListener(this);
		proe.addActionListener(this);
		switchClient.addActionListener(this);
		newClient.addActionListener(this);
		delete.addActionListener(this);
		
		text = new JTextArea();
		text.setEditable(false);
        add(new JScrollPane(text));
		add(text);
	
	}
	
	/**
	 * method, which operate the menu
	 */
	public void actionPerformed(ActionEvent e) {
		
		/** stores information about what has been selected in the menu*/
		Object z = e.getSource();
		
		if(z==switchClient) {
			actualClient = Integer.parseInt( JOptionPane.showInputDialog("enter the id of the client you want to switch to"));
		}
		if(z==newClient) {
			counter++;
			Client.ClientName.add(JOptionPane.showInputDialog("enter the name of the new customer"));
			Client.ClientSurname.add(JOptionPane.showInputDialog("enter the surname of the new customer"));
			Client.ClientAddress.add(JOptionPane.showInputDialog("enter the address of the new customer"));
			Client.ClientNip.add(JOptionPane.showInputDialog("enter the nip of the new customer"));
			BasketList.add("");
		}
		if(z==proa) {
			amount=Integer.valueOf(JOptionPane.showInputDialog("how much?"));
			basket=BasketList.get(actualClient);
			basket=basket+amount+"pra";
			BasketList.set(actualClient, basket);
		}
		if(z==prob) {
			amount=Integer.valueOf(JOptionPane.showInputDialog("how much?"));
			basket=BasketList.get(actualClient);
			basket=basket+amount+"prb";
			BasketList.set(actualClient, basket);
		}
		if(z==proc) {
			amount=Integer.valueOf(JOptionPane.showInputDialog("how much?"));
			basket=BasketList.get(actualClient);
			basket=basket+amount+"prc";
			BasketList.set(actualClient, basket);
		}
		if(z==prod) {
			amount=Integer.valueOf(JOptionPane.showInputDialog("how much?"));
			basket=BasketList.get(actualClient);
			basket=basket+amount+"prd";
			BasketList.set(actualClient, basket);
		}
		if(z==proe) {
			amount=Integer.valueOf(JOptionPane.showInputDialog("how much?"));
			basket=BasketList.get(actualClient);
			basket=basket+amount+"pre";
			BasketList.set(actualClient, basket);
		}
		if(z==create) {
			whosInvoice = Integer.valueOf(JOptionPane.showInputDialog("whose invoice?"));
			actualBasket=BasketList.get(whosInvoice);
			whatBought(actualBasket);
			invoiceNumber++;
			Invoice invoice = new Invoice (invoiceNumber, whosInvoice, whatBoughtList);
			invoice.createInvoice();
		}
		if(z==delete) {
			BasketList.set(actualClient,"");
		}
		
	}
	
	public void whatBought(String s) {
		int [] whatBoughtTable= {0,0,0,0,0};
		String actualAmount="";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>='0' && s.charAt(i)<='9') {
				actualAmount=actualAmount+s.charAt(i);
			}
			else if(actualAmount!="") {
				if(s.charAt(i+2)=='a') {
					whatBoughtTable[0]=Integer.parseInt(actualAmount);
				}
				if(s.charAt(i+2)=='b') {
					whatBoughtTable[1]=Integer.parseInt(actualAmount);
				}
				if(s.charAt(i+2)=='c') {
					whatBoughtTable[2]=Integer.parseInt(actualAmount);
				}
				if(s.charAt(i+2)=='d') {
					whatBoughtTable[3]=Integer.parseInt(actualAmount);
				}
				if(s.charAt(i+2)=='e') {
					whatBoughtTable[4]=Integer.parseInt(actualAmount);
				}
				i=i+2;
				actualAmount="";
			}
		}
		whatBoughtList.clear();
		whatBoughtList.add(whatBoughtTable[0]);
		whatBoughtList.add(whatBoughtTable[1]);
		whatBoughtList.add(whatBoughtTable[2]);
		whatBoughtList.add(whatBoughtTable[3]);
		whatBoughtList.add(whatBoughtTable[4]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Gui frame = new Gui();
		frame.setVisible(true);

	}

}
