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
import beans.Chart;

public class MachineService implements IDao<Machine> {

    @Override
    public boolean create(Machine o) {
        String sql = "insert into machine values (null, ?, ?, ? , ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getReference());
            ps.setDate(2, new Date(o.getDateAchat().getTime()));
            ps.setDouble(3, o.getPrix());
            ps.setInt(4, o.getMarqueId());
            
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return false;
    }

    public boolean delete(Machine o) {
        String sql = "delete from machine where id  = ?";
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
    public boolean update(Machine o) {

        String sql = "update machine set reference  = ? ,prix = ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getReference());
           // ps.setDate(2, new Date(o.getDateAchat().getTime()));
            ps.setDouble(2, o.getPrix());
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
    public Machine findById(int id) {
        Machine m = null;
        String sql = "select * from machine where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Machine> findAll() {
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix") , rs.getInt("marqueId") ));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public List<Machine> findMachineByReference(String ref) {
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine where reference =  ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setString(1, ref);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public List<String> findReference() {
        List<String> references = new ArrayList<String>();
        String sql = "select distinct(reference) as ref from machine";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                references.add(rs.getString("ref"));
            }
        } catch (SQLException e) {
            System.out.println("findReference " + e.getMessage());
        }
        return references;
    }
    
    public List<Machine> machineParMarque(int m){
    	  List<Machine> machines = new ArrayList<Machine>();
          /*String sql = "select *   from machine m INNER JOIN marque t ON m.marqueId = t.id "
          		+ "where t.libelle = ? ";*/
         String sql = "select *   from machine where marqueId = ?; ";
          try {
              PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
              ps.setInt(1, m);
              ResultSet rs = ps.executeQuery();
              while (rs.next()) {
            	 machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix") , rs.getInt("marqueId") ));
              }
          } catch (SQLException e) {
              System.out.println("findReference " + e.getMessage());
          }
          return machines;
    	
    }
    
    public List<Machine> findBetweenDate(java.util.Date d1, java.util.Date d2) {
        String sql = "select * from machine where dateAchat > ? and dateAchat < ?";
        MachineService ma = new MachineService();
        
        List<Machine> machines = new ArrayList<>();
        try {
        	 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setDate(1, new Date(d1.getTime()));
            ps.setDate(2, new Date(d2.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	 machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix") , rs.getInt("marqueId") ));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return machines;
    }
    
    public List<Chart> nombreDeMachineParMarque(){
           String sql = "SELECT COUNT(marque.id),libelle FROM marque,machine WHERE machine.marqueId=marque.id GROUP BY marqueId";
           List<Chart> charts = new ArrayList<>();
           try {
        	 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	 charts.add(new Chart(rs.getString("libelle") , rs.getInt("COUNT(marque.id)")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           return charts;
    }

    @Override
    public boolean Delete(Machine o) {
        String sql = "delete from machine where id  = ?";
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
