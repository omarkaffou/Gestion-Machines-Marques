package beans;

public class User {
      private int id;
     private String username;
     private String email;
     private String password;
     private int tele;

     
        public User(String username,String email, String password, int tele){
           this.username=username;
           this.email=email;
           this.password=password;
           this.tele=tele;
       }
       
         public User(int id , String username,String email, String password, int tele){
           this.id = id;
           this.username=username;
           this.email=email;
           this.password=password;
           this.tele=tele;
       }

    public User() {
       
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tele
     */
    public int getTele() {
        return tele;
    }

    /**
     * @param tele the tele to set
     */
    public void setTele(int tele) {
        this.tele = tele;
    }
     
     
}
