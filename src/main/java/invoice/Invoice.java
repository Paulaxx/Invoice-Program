package invoice;
import javax.swing.*;
import java.util.Date;
import java.util.ArrayList;

public class Invoice extends JPanel{
	
	int i, c, lp=1;
	double sum=0;
	Date nowDate = new Date();
	ArrayList<Integer> List = new ArrayList<Integer>();
	
	public Invoice(int i, int c, ArrayList<Integer> List) {
		this.i=i;
		this.c=c;
		this.List=List;
	}
	
	public void createInvoice() {
		Gui.text.append("FAKTURA nr:"+i+"\n"+"\n");
		Gui.text.append("Data: "+nowDate+"\n");
		Gui.text.append("Miejscowość: Wrocław"+"\n"+"\n");
		Gui.text.append("Nabywca:"+"\n"+Client.ClientName.get(c)+Client.ClientSurname.get(c)+"\n");
		Gui.text.append(Client.ClientAddress.get(c)+"\n"+"NIP:"+Client.ClientNip.get(c)+"\n"+"\n");
		Gui.text.append("Sprzedawca:"+"\n"+"Firma Meblarska"+"\n"+"ul.Meblarska 11"+"\n");
		Gui.text.append("11-111 Wrocław"+"\n"+"NIP: 123-45-78-90"+"\n"+"\n");
		Gui.text.append("Lp  Nazwa        Ile  Netto  VAT  Brutto"+"\n");
		if(List.get(0)!=0) {
			Gui.text.append(lp+"    "+Gui.pra.name+"    "+List.get(0)+"   "+Gui.pra.price+"  "+"23%    "+Gui.pra.pricePlusVat(Gui.pra.price)+"\n");
			sum=sum+Gui.pra.price*List.get(0)*1.23;
			lp++;
		}
		if(List.get(1)!=0) {
			Gui.text.append(lp+"    "+Gui.prb.name+"      "+List.get(1)+"   "+Gui.prb.price+"  "+"23%    "+Gui.prb.pricePlusVat(Gui.prb.price)+"\n");
			sum=sum+Gui.prb.price*List.get(1)*1.23;
			lp++;
		}
		if(List.get(2)!=0) {
			Gui.text.append(lp+"    "+Gui.prc.name+"                "+List.get(2)+"   "+Gui.prc.price+"  "+"23%    "+Gui.prc.pricePlusVat(Gui.prc.price)+"\n");
			sum=sum+Gui.prc.price*List.get(2)*1.23;
			lp++;
		}
		if(List.get(3)!=0) {
			Gui.text.append(lp+"    "+Gui.prd.name+"              "+List.get(3)+"   "+Gui.prd.price+"  "+"23%    "+Gui.prd.pricePlusVat(Gui.prd.price)+"\n");
			sum=sum+Gui.prd.price*List.get(3)*1.23;
			lp++;
		}
		if(List.get(4)!=0) {
			Gui.text.append(lp+"    "+Gui.pre.name+"               "+List.get(4)+"    "+Gui.pre.price+"  "+"23%     "+Gui.pre.pricePlusVat(Gui.pre.price)+"\n");
			sum=sum+Gui.pre.price*List.get(4)*1.23;
			lp++;
		}
		Gui.text.append("\n"+"RAZEM DO ZAPŁATY: "+sum+"\n+");
	}
	

}
