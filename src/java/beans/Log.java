package beans;

import java.sql.Date;

public class Log {
    private int id;
    private String username;
    private String operation;
    private Date dateOp;
   

    
    public Log(int id ,  String username, String ope  ){
          this.id = id;
          this.operation = ope;
          this.username = username;
         
    }
     public Log( String ope , String username){
            this.username = ope;
          this.operation = username;
        
    }
      public Log(int id ,  String username, String ope , Date dateOp  ){
          this.id = id;
          this.operation = ope;
          this.username = username;
          this.dateOp = dateOp;
         
    }
       public Log(int id ,  String username, String ope , String dateOp  ){
          this.id = id;
          this.operation = ope;
          this.username = username;
       
         
    }
      public Log(  String username, String ope , Date dateOp  ){
        
          this.operation = ope;
          this.username = username;
          this.dateOp = dateOp;
         
    }

   
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }
    
      public String getUsername() {
        return username;
    }

    /**
     * @param operation the operation to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the dateOp
     */
   
     public Date getDate() {
        return dateOp;
    }

    /**
     * @param operation the operation to set
     */
    public void setDate(Date date) {
        this.dateOp = date;
    }
 
    
    
}
