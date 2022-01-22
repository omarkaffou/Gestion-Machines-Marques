package services;

import Dao.IDao;
import beans.Log;
import connexion.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogsService implements IDao<Log>  {

    @Override
    public boolean create(Log o) {
        String req = "insert into logs (id , username , operation) values(null , ? , ?  )";
         try {
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setString(1, o.getUsername());
            pr.setString(2, o.getOperation());
          
          
            
            if (pr.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception e) {
             e.printStackTrace();
        }
         return false;
    }

    @Override
    public boolean update(Log o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(Log o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Log findById(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Log> findAll() {
         List<Log> logs = new ArrayList<Log>();

        String sql = "select * from logs";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                logs.add(new Log(rs.getInt("id"), rs.getString("username"), rs.getString("operation") ));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return logs;
    }
    
}
