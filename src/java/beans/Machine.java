package beans;
import services.MarqueService;

import java.util.Date;

public class Machine {

    private int id;
    private String reference;
    private Date dateAchat;
    private double prix;
    private Marque marque;
    private int marqueId;
    MarqueService ms = new MarqueService();

    public Machine(int id, String reference, Date dateAchat, double prix ) {
        super();
        
        this.id = id;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
    }

    public Machine(int id, String reference, Date dateAchat, double prix , Marque m ) {
        super();
     
        this.id = id;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.marque = m;
    }
    
    public Machine(int id, String reference, Date dateAchat, double prix , int m ) {
        super();
       
        this.id = id;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.marque = ms.findById(m);
    }
    public Machine(String reference, Date dateAchat, double prix , int id) {
        super();
      
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.marque = ms.findById(id);
    }

    public Machine(int id, String reference, Date dateAchat, double prix, String libelle) {
        
    }

    public Machine(int id, String reference, int prix) {
        this.id = id;
         this.reference = reference;
        
        this.prix = prix;
       
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public Marque getMarque(){
      marque =   ms.findById(marqueId);
        return marque;
        
    }
    
    public int getMarqueId(){
        return this.marque.getId();
    }

    public Marque findLibelle(){
         for(Marque s:ms.findAll()){
            if(s.getId()==marqueId){
                return marque=s;
            }
        }
        return marque;
    }
    @Override
    public String toString() {
        return this.id + " " + this.reference;
    }

}
