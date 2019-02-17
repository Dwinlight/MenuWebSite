package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	private Connection connexion;
	public boolean connected = false;
	String login;
	String password;
	
	public User(String login, String password) {
		this.setLogin(login);
		this.setPassword(password);
		this.isConnected();
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean equals(String login, String password) {
		return this.getLogin().equals(login) && this.getPassword().equals(password);
	}	
	
	public void isConnected() {
	       
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

         
            resultat = statement.executeQuery("SELECT login, password FROM comptes;");

            while (resultat.next()) {
                String login = resultat.getString("login");
                
                String password = resultat.getString("password");
                if(this.equals(login, password)) {
                	this.connected=true;
                }
                
                
              
                
                
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        	System.out.print("connection failed 3");
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
       
    }
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        	System.out.print("connection failed 1");
        	e.printStackTrace();
        }

        try {
            this.connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
        } catch (SQLException e) {
        	System.out.print("connection failed 2");
            e.printStackTrace();
        }
    }
    
    public static void main (String[] args){
    	User u = new User("to","tu");
    	System.out.print(u.connected);
    }
    
/*    public void ajouterUtilisateur(Utilisateur utilisateur) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?, ?);");
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } */


}

	


