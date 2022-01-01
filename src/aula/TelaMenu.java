package aula;

import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class TelaMenu implements ActionListener {
	
	private JFrame telap;
	private JMenuBar barra;
	private JMenu telas;
	private JMenuItem item1,item2;
	
	
	public void iniciarTela() {
		telap=new JFrame();
		barra=new JMenuBar();
		telas=new JMenu("telas");
		item1=new JMenuItem("Pessoa");
		item1.addActionListener(this);
		item2=new JMenuItem("Produto");
		item2.addActionListener(this);
		item1.setAccelerator(KeyStroke.getKeyStroke('N',KeyEvent.CTRL_DOWN_MASK));
		item2.setAccelerator(KeyStroke.getKeyStroke('N',KeyEvent.CTRL_DOWN_MASK));
		
		
		
		barra.add(telas);
        telap.setJMenuBar(barra);
        telas.add(item1);
        telas.add(item2);
        telap.setSize(400,600);
        telap.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == item1) {
			
			Tela t = new Tela();
			t.iniciarTela();
		}
		
		if(e.getSource() == item2) {
			
			TelaProduto p = new TelaProduto();
			p.iniciarTela();
		}
		
		
		
	}

}
