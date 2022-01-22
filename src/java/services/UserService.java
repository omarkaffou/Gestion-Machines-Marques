package services;

import Dao.IDao;
import beans.Machine;
import beans.User;
import connexion.Connexion;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IDao<User>  {

    @Override
    public boolean create(User o) {
         String req = "insert into user values(null , ? , ? , ? , ?)";
         try {
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setString(1, o.getUsername());
            pr.setString(2, o.getEmail());
            pr.setString(3,encrypterMotDePasse(o.getPassword()) );
            pr.setInt(4, o.getTele());
            
            if (pr.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception e) {
             e.printStackTrace();
        }
         return false;
    }
    
    public User isloggedIn(String username , String password){
        User user = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String req = "select * from user where username = ? and password =?";
         try {
             ps= Connexion.getInstane().getConnection().prepareStatement(req);
            ps.setString(1,username);
            ps.setString(2,encrypterMotDePasse(password) );
             rs=ps.executeQuery();
          while(rs.next())
                user=new User(rs.getInt("id"),rs.getString("username"),rs.getString("email"),rs.getString("password"),rs.getInt("tele"));

        } catch (Exception e) {
             e.printStackTrace();
        }
        
        return user;
    }

    @Override
    public boolean update(User o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(User o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findById(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
       String req = "select * from user";
               try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(req);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("email")  ,  rs.getString("password") , rs.getInt("tele") ));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
               return users;
    }
   
     
       private String encrypterMotDePasse(String password){
            try {
				MessageDigest md = MessageDigest.getInstance("Md5");
				md.update(password.getBytes());
				byte bytaData[] = md.digest();
				StringBuffer hexString = new StringBuffer();
				for(int i=0; i<bytaData.length; i++) {
					String hex= Integer.toHexString(0xff & bytaData[i]);
					if(hex.length() == 1) hexString.append('0');
					 hexString.append(hex);
				}
                                return hexString.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
      
        return null;
       }
     
}
