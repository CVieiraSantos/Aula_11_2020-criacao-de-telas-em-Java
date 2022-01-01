package aula;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class TelaProduto implements ActionListener {
	private JFrame f;
	private JPanel p,pc,pu,ps,pb;
	private JLabel l0,l1,l2,lm;
	private JTextField t0,t1,t2;
	private JButton cadastrar, consultar;
	private Object consultarValor;
	
	
	public void iniciarTela()
	{
		f=new JFrame();
		f.setTitle("Produto");
		p=new JPanel();
		pc=new JPanel();
		pu=new JPanel();
		ps=new JPanel();
		pb=new JPanel();
		l0=new JLabel("Codigo");
		l1=new JLabel("Descricao");
		l2=new JLabel("Valor");
		lm=new JLabel();
		lm.setForeground(Color.red);
		t0=new JTextField(10);
        t1=new JTextField(10);
        t2=new JTextField(10);
        cadastrar=new JButton("cadastrar");
        cadastrar.addActionListener(this);
        consultar=new JButton("consultar");
        consultar.addActionListener(this);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        pc.add(l0);
        pc.add(t0);
        pu.add(l1);
        pu.add(t1);
        ps.add(l2);
        ps.add(t2);
        pb.add(consultar);
        pb.add(cadastrar);
        p.add(pc);
        p.add(pu);
        p.add(ps);
        p.add(pb);
        p.add(lm);
        f.getContentPane().add(p);
        f.setVisible(true);
        f.setSize(300,300);
        
        
        
        
        
        
       
				
				
				
	
        
       
        
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		Conexao d=new Conexao();
		
		if(arg0.getSource()==cadastrar)
		{
			
			d.cadastrarProduto(Integer.parseInt(t0.getText()),t1.getText(),Float.parseFloat(t2.getText()));

		}
		
		if(arg0.getSource()==consultar)
		{
			
			t1.setText(d.consultarDescricao(Integer.parseInt(t0.getText())));
			t2.setText(""+d.consultarValor(Integer.parseInt(t0.getText())));
			

		}
	
	
}
}



