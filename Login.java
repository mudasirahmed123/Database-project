
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	static int ids=0;
	String dnm;
	String e;
	String p;
	String Name;
	String Fathername;
	String email1;
	String pas;
	
	String user;
	String Pa;
	String n;
	String f;
	
	JLabel email=new JLabel("EMAIL");
	JTextField etxt=new JTextField();
	JLabel pass=new JLabel("PASSWORD");
	JTextField Passtxt=new JTextField();
	JButton login=new JButton("Login");
	JButton Next=new JButton("Next");
	JButton pre=new JButton("Previous");
	JButton update=new JButton("Update");
	JButton delete=new JButton("Delete");
	JLabel id=new JLabel("ID");
	JLabel em=new JLabel("Email");
	JLabel ps=new JLabel("password");
	JLabel nm=new JLabel("Name");
	JLabel fnm=new JLabel("Father Name");
	JLabel dataid=new JLabel();
	JLabel dataem=new JLabel();
	JLabel datapa=new JLabel();
	JLabel datanm=new JLabel();
	JLabel datafnm=new JLabel();
	JLabel rec=new JLabel();
	JLabel Nuname=new JLabel();
	JLabel Npass=new JLabel();
	JLabel Nname=new JLabel();
	JLabel Nfther=new JLabel();
	
	JLabel title=new JLabel("<html><h1>WELCOME IN LOGIN SYSTEM</h1></html>");
	
	
	JTextField emtxt=new JTextField();
	JTextField patxt=new JTextField();
	JTextField namtxt=new JTextField();
	JTextField fnamtxt=new JTextField();
	

Database db=new Database();
public	Login(){
		
		setVisible(true);
		setSize(500,500);
		setLocation(40,5);
		setLayout(null);
		getContentPane().setBackground(Color.CYAN);
		
		
		this.add(title);
		title.setBounds(100,50,1200,20);
		
		this.add(email);
		email.setBounds(100,100,100,20);
		
		
		this.add(etxt);
		etxt.setBounds(150,100,200,30);
		this.add(pass);
		pass.setBounds(70,180,100,20);
		this.add(Passtxt);
		Passtxt.setBounds(150,180,200,30);
		this.add(id);
		id.setBounds(50,300,100,20);
		
		this.add(em);
		em.setBounds(100,300,100,20);
		this.add(ps);
		ps.setBounds(200,300,100,20);
		this.add(nm);
		nm.setBounds(300,300,100,20);
		this.add(fnm);
		fnm.setBounds(400,300,100,20);
		this.add(id);
		id.setBounds(50,300,100,20);
		
		this.add(dataid);
		dataid.setBounds(50,350,100,20);
		
		this.add(dataem);
		dataem.setBounds(100,350,100,20);
		this.add(datapa);
		datapa.setBounds(200,350,100,20);
		this.add(datanm);
		datanm.setBounds(300,350,100,20);
		this.add(datafnm);
		datafnm.setBounds(400,350,100,20);
		
		this.add(rec);
		rec.setBounds(5,300,100,20);
		
		
		this.add(login);
		login.setBounds(200,250,100,20);
		login.addActionListener(this);
		this.add(Next);
		Next.setBounds(160,400,100,30);
		
		Next.addActionListener(this);
		this.add(pre);
		pre.setBounds(50,400,100,30);
		pre.addActionListener(this);
		this.add(update);
		update.setBounds(270,400,100,30);
		update.addActionListener(this);
		this.add(delete);
		delete.setBounds(380,400,100,30);
		delete.addActionListener(this);
	}

	public static void main(String[] args) {

		new Login();
	}
	public void actionPerformed(ActionEvent action) {
if (action.getSource()==login){
	
	//JOptionPane.showMessageDialog(null,"d");
	email1=(etxt.getText());
	pas=(Passtxt.getText());
	String sql="select * from record where username='"+email1+"' and password='"+pas+"' ";
	try{
	ResultSet rs=db.stmt.executeQuery(sql);

	  if(rs.next()){

		  ids=rs.getInt("id");
			String user=rs.getString("username");
			String Pa=rs.getString("password");
			String n=rs.getString("Name");
			String f=rs.getString("Fathername");
			
			dataid.setText(""+ids);
			dataem.setText(user);
			datapa.setText(Pa);
			datanm.setText(n);
			datafnm.setText(f);
		}
		

	  else{
			  JOptionPane.showMessageDialog(null,"Register First");
			  
			  	newreg ob=new newreg();
			  	ob.setVisible(true);	
		 }
		 

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}else if(action.getSource()==Next){
	
	ids++;
	String sql="select * from record where id="+ids;
	try{
	ResultSet rs=db.stmt.executeQuery(sql);

	  if(rs.next()){

		   
		   ids=rs.getInt("id");
			String user=rs.getString("username");
			String Pa=rs.getString("password");
			String n=rs.getString("Name");
			String f=rs.getString("Fathername");
			
			
			dataid.setText(""+ids);
			dataem.setText(user);
			datapa.setText(Pa);
			datanm.setText(n);
			datafnm.setText(f);
			this.pre.setEnabled(true);
								
	  }	else{
		  this.Next.setEnabled(false);	  }
	  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}else if(action.getSource()==pre){

		ids--;
		String sql="select * from record where id="+ids;
		try{
		ResultSet rs=db.stmt.executeQuery(sql);

		  if(rs.next()){

			   
			   ids=rs.getInt("id");
				 user=rs.getString("username");
				 Pa=rs.getString("password");
				 n=rs.getString("Name");
			f=rs.getString("Fathername");
				
			this.Next.setEnabled(true);

			dataid.setText(""+ids);
				dataem.setText(user);
				datapa.setText(Pa);
				datanm.setText(n);
				//datafnm.setText(false);
				
								
		  }	else{
			  
			  this.pre.setEnabled(false);
		  }
		  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}else if(action.getSource()==delete){
	String sql="delete from record where id="+ids;
	try {
		db.stmt.executeUpdate(sql);
		
		JOptionPane.showMessageDialog(null,"Sucesssss");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
}else if(action.getSource()==update){
	
	update up=new update();
	up.idtext.setText(dataid.getText());
	up.emailtxt.setText(dataem.getText());
	up.passtxt.setText(datapa.getText());
	up.nametxt.setText(datanm.getText());
	up.ftxt.setText(datafnm.getText());
	
	up.setVisible(true);
	
		}
	
	}	
}



	
