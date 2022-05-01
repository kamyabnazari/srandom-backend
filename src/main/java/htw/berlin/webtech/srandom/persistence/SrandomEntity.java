package htw.berlin.webtech.srandom.persistence;

import javax.persistence.*;

@Entity(name = "songs")
public class SrandomEntity {

    @Id
    //numerischer Wert, sobald ein neuer Datensatz hinzugefügt wird -> Strategy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private long id;

    @Column( name = "titel", nullable = false)
    private String titel;

    @Column( name = "genre")
    private String genre;

    @Column( name = "ytLink", nullable = false)
    private String ytLink;

    @Column( name = "autor", nullable = false)
    private String autor;

    @Column( name = "erscheinungsdatum")
    private long erscheinungsdatum;

   public SrandomEntity( String titel, String genre, String ytLink, String autor, long erscheinungsdatum){
       this.titel = titel;
       this.genre = genre;
       this.ytLink = ytLink;
       this.autor = autor;
       this.erscheinungsdatum = erscheinungsdatum;
   }

   protected SrandomEntity(){}

    public Long getId() {return id;}

    public String getTitel() { return titel;}

    public void setTitel(String titel) {this.titel = titel;}

    public String getGenre() {return genre;}

    public String getYtLink() {return ytLink;}

    public void setYtLink(String ytLink) {this.ytLink = ytLink;}

    public void setGenre(String genre) {this.genre = genre;}

    public String getAutor() {return autor;}

    public void setAutor(String autor) {this.autor = autor;}

    public long getErscheinungsdatum() {return erscheinungsdatum;}

    public void setErscheinungsdatum(long erscheinungsdatum) {this.erscheinungsdatum = erscheinungsdatum;}
}
