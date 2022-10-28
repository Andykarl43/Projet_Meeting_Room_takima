package io.takima.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table( name="events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "id_salle")
    private Long id_salle ;
    @Column(name = "id_membre")
    private Long id_membre ;
    @Column(name = "date_debut")
    private Date date_debut;
    @Column(name = "date_fin")
    private Date date_fin;




    public Events() {
    }

    public Events(Long id, String libelle, Long id_salle, Long id_membre, Date date_debut, Date date_fin) {
        this.id = id;
        this.libelle = libelle;
        this.id_salle = id_salle;
        this.id_membre = id_membre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Long getId_membre() {
        return id_membre;
    }

    public void setId_membre(Long id_membre) {
        this.id_membre = id_membre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public Long getId_salle() {
        return id_salle;
    }

    public void setId_salle(Long id_salle) {
        this.id_salle = id_salle;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return Objects.equals(id, events.id) && Objects.equals(libelle, events.libelle)  && Objects.equals(id_salle, events.id_salle) && Objects.equals(id_membre, events.id_membre)&& Objects.equals(date_debut, events.date_debut) && Objects.equals(date_fin, events.date_fin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, id_membre, id_salle, date_debut, date_fin);
    }

    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", id_salle=" + id_salle +
                ", id_membre=" + id_membre +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                '}';
    }
}
