
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class update extends JFrame implements ActionListener {

	
	JLabel idss=new JLabel("ID");
	JLabel email=new JLabel("Email");
	JLabel pass=new JLabel("Password");
	JLabel name=new JLabel("Name");
	JLabel fname=new JLabel("Father Name");
	
	JTextField idtext=new JTextField();
	JTextField emailtxt=new JTextField();
	JTextField passtxt=new JTextField();
	JTextField nametxt=new JTextField();
	JTextField ftxt=new JTextField();
	
	JButton Reg=new JButton("UPDATE");
	
	Database db=new Database();
	
	
update(){
	
	
	setVisible(true);
	setSize(350,400);
	setLocation(500,150);
	setLayout(null);
	getContentPane().setBackground(Color.yellow);
	
	this.add(idss);
	idss.setBounds(40,50,100,30);
	
	this.add(email);
	email.setBounds(40,100,100,30);
	this.add(pass);
	pass.setBounds(40,150,100,30);
	this.add(name);
	name.setBounds(40,200,100,30);
	this.add(fname);
	fname.setBounds(20,250,100,30);
	
this.add(idtext);
idtext.setBounds(100,50,120,30);
	
	this.add(emailtxt);
	emailtxt.setBounds(100,100,120,30);
	this.add(passtxt);
	passtxt.setBounds(100,150,120,30);
	this.add(nametxt);
	nametxt.setBounds(100,200,120,30);
	this.add(ftxt);
	ftxt.setBounds(100,250,120,30);
	
	this.add(Reg);
	Reg.setBounds(110,300,100,30);
	Reg.addActionListener(this);
	
	
	
}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new update();
	}

	
	public void actionPerformed(ActionEvent action) {
	
		if(action.getSource()==Reg){
			
			String ids=(idtext.getText());
			String email=(emailtxt.getText());
			String password=(passtxt.getText());
			String name=(nametxt.getText());
			String fname=(ftxt.getText());
			
			
			try{
			
			String Sql="update record set username='"+email+"',password='"+password+"',Name='"+name+"',Fathername='"+fname+"' where id='"+ids+"'";
			System.out.println(Sql);
			db.stmt.executeUpdate(Sql);
			JOptionPane.showMessageDialog(null,"Record Update Sucess");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		
		}
		
		
		
		
		
	}

}
