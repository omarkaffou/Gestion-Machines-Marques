/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Chart;
import beans.Log;
import beans.Machine;
import beans.Marque;
import beans.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import services.MachineService;
import services.LogsService;
import services.MarqueService;
import services.UserService;

/**
 *
 * @author omarc
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          MarqueService ms = new MarqueService();
          MachineService mcs = new MachineService();
          UserService u = new UserService();
          LogsService uss = new LogsService();
          
        /* Marque m = new Marque(26 , "alcatel" , "alcatel" );
          ms.create(m);
         System.out.println(m.getId() + m.getCode() + m.getLibelle());
           mcs.create(new Machine(1  , "ref",  new Date("20/20/20")  , 1258.25 , m));*/
          
        //mcs.update(new Machine(8, "cjo haja",2568));
           //uss.create(new Log("omar" , "omar"));
          // Log l = new Log("omar" , "omar");
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
          // uss.create(new Log("omar" , "omar"));
           for(Log s : uss.findAll()) {
               System.out.println( s.getId() + " "+s.getDate() + " "+ s.getOperation()+ " "+s.getUsername());
               
            }
       
         
         
         
      
        
         
    }
    
}
