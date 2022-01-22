package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Machine;
import beans.Marque;
import connexion.Connexion;
import Dao.IDao;

public class MarqueService implements IDao<Marque>  {

	@Override
	public boolean create(Marque o) {
		  try {
            String req = "insert into marque values (null, ?, ?)";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setString(1, o.getCode());
            pr.setString(2, o.getLibelle());
            
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
	}

	
	public boolean delete(Marque o) {
		String sql = "delete from marque where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public boolean update(Marque o) {
		 String sql = "update marque set code  = ? ,libelle = ?  where id  = ?";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ps.setNString(1, o.getCode());
	            ps.setString(2, o.getLibelle());
	            ps.setInt(3, o.getId());
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("update : erreur sql : " + e.getMessage());

	        }
	        return false;
	}

	@Override
	public Marque findById(int id) {
		  Marque m = null;
	        String sql = "select * from marque where id  = ?";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return new Marque(rs.getInt("id"), rs.getString("code"), rs.getString("libelle"));
	            }

	        } catch (SQLException e) {
	            System.out.println("findById " + e.getMessage());
	        }
	        return null;
	}

	@Override
	public List<Marque> findAll() {
		 List<Marque> marques = new ArrayList<Marque>();

	        String sql = "select * from marque";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	marques.add(new Marque(rs.getInt("id"), rs.getString("code"), rs.getString("libelle")));
	            }

	        } catch (SQLException e) {
	            System.out.println("findAll " + e.getMessage());
	        }
	        return marques;
	}

    @Override
    public boolean Delete(Marque o) {
                String sql = "delete from marque where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false;  
    }
    
    public boolean deleteMachineParMarque(Marque o){
        String sql = "delete from machine where marqueId  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false; 
    }

  

}
