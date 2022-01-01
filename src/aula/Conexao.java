package aula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	
	private Connection c;
	private Statement s;
	private Connection d;
	private Statement g;
	
	
	
	public Conexao()
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3311/aula","root","root");
            s=c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			d=DriverManager.getConnection("jdbc:mysql://localhost:3311/aula","root","root");
            g=c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
		public void cadastrar(String email,String nome,String telefone)
		{
			try {
				s.executeUpdate ("insert into pessoa values('"+email+"','"+nome+"','"+telefone+"')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	   public String consultarTelefone(String email)
	   {
		   try {
			ResultSet rs=s.executeQuery("select * from pessoa where email='"+email+"'");
			rs.next();
			return rs.getString("telefone");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   return "";
		
	
	}
	   
	   public void cadastrarProduto(int codigo, String descricao, double valor) {
		   try {
				g.executeUpdate ("insert into produto values("+codigo+",'"+descricao+"',"+valor+")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	   }
	   
	   
	   public float consultarValor(int codigo) {
		   try {
			   	ResultSet rd = g.executeQuery("select * from produto where codigo="+codigo);			   			
				rd.next();
			   	return rd.getFloat("valor");
			   }
		   
		   
		   catch(SQLException e) {
			   e.printStackTrace();
		   }
		return 0.0f;
	   }
	   
	   
	   public String consultarDescricao(int codigo)
	   {
		   try {
			ResultSet rd=g.executeQuery("select * from produto where codigo="+codigo);
			rd.next();
			return rd.getString("descricao");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		   return "";
		
	
	}
	   
	   
	  
		
	
	}
	



