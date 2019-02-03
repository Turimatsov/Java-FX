package kursova.javafx;

/**
 *
 * @author Turimatsov
 */
public class BooksClass {
    public String name;
    public String signature;
    public String author;
    public String language;
    public String janr;
    public String year;
    
    public BooksClass(String ime,String signatura,String avtor,String ezik,String janR,String godina){
    this.name=ime;
    this.signature=signatura;
    this.author=avtor;
    this.language=ezik;
    this.janr=janR;
    this.year=godina;
    }
    public void setName(String ime){name = ime;}
    public String getName(){return name;}
    
    public void setSignature(String signatura){signature=signatura;}
    public String getSignature(){return signature;}
    
    public void setAuthor(String avtor){author=avtor;}
    public String getAuthor(){return author;}
    
    public void setLanguage(String ezik){language=ezik;}
    public String getLanguage(){return language;}      
         
    public void setJanr(String janR){janr=janR;}
    public String getJanr(){return janr;}        
            
    public void setYear(String godina){year=godina;}
    public String getYear(){return year;}
}
