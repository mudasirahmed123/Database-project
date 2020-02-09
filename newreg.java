
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class newreg extends JFrame implements ActionListener
{
	JLabel email=new JLabel("Email");
	JLabel password=new JLabel("Password");
	JLabel Name=new JLabel("Name");
	JLabel fname=new JLabel("Father Name");
	
	JTextField Etxt=new JTextField();
	JTextField Ptxt=new JTextField();
	JTextField Ntxt=new JTextField();
	JTextField Ftxt=new JTextField();
	JButton reg=new JButton("Register");
	
	Database db=new Database();
newreg(){
	
	setVisible(true);
	setSize(500,700);
	setLocation(100,0);
	setLayout(null);
	getContentPane().setBackground(Color.red);
	
	this.add(email);
	email.setBounds(50,200,300,20);
	this.add(password);
	password.setBounds(40,300,100,20);
	this.add(Name);
	Name.setBounds(50,400,100,20);
	this.add(fname);
	fname.setBounds(20,500,100,20);
	
	this.add(Etxt);
	Etxt.setBounds(100,200,200,40);
	this.add(Ptxt);
	Ptxt.setBounds(100,300,200,40);
	this.add(Ntxt);
	Ntxt.setBounds(100,400,200,40);
	this.add(Ftxt);
	Ftxt.setBounds(100,500,200,40);
	this.add(reg);
	reg.setBounds(100,600,200,40);
	reg.addActionListener(this);
	
	
	
}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new newreg();

	}

	@Override
	public void actionPerformed(ActionEvent action) {
	
	 if(action.getSource()==reg){
			
			
			
			
			String email=(Etxt.getText());
			String password=(Ptxt.getText());
			String name=(Ntxt.getText());
			String fname=(Ftxt.getText());
			
			try {	
			String sql="insert into record(username,password,Name,Fathername)value('"+email+"','"+password+"','"+name+"','"+fname+"')";
			//ResultSet  rs=stmt.executeQuery(sql);
		
			db.stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"Registration Success");
					
			}
		
		
		
	 
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

			
			
	}

	}
}
		