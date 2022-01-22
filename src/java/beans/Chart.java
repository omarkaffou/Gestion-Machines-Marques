package beans;

public class Chart {
    private String cle;
    private int valeur;
    
    public Chart(String cle , int valeur){
        this.cle =  cle;
        this.valeur = valeur;
    }
    
    public String getCle(){
        return this.cle;
    }
     public int getVal(){
        return this.valeur;
    }
}
