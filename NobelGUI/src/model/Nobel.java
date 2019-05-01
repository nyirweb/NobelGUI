/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nyirweb
 */
@Entity
@Table(name = "nobel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nobel.findAll", query = "SELECT n FROM Nobel n")
    , @NamedQuery(name = "Nobel.findById", query = "SELECT n FROM Nobel n WHERE n.id = :id")
    , @NamedQuery(name = "Nobel.findByEv", query = "SELECT n FROM Nobel n WHERE n.ev = :ev")
    , @NamedQuery(name = "Nobel.findByTipus", query = "SELECT n FROM Nobel n WHERE n.tipus = :tipus")
    , @NamedQuery(name = "Nobel.findByKeresztnev", query = "SELECT n FROM Nobel n WHERE n.keresztnev = :keresztnev")
    , @NamedQuery(name = "Nobel.findByVezeteknev", query = "SELECT n FROM Nobel n WHERE n.vezeteknev = :vezeteknev")})
public class Nobel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ev")
    private String ev;
    @Basic(optional = false)
    @Column(name = "tipus")
    private String tipus;
    @Basic(optional = false)
    @Column(name = "keresztnev")
    private String keresztnev;
    @Basic(optional = false)
    @Column(name = "vezeteknev")
    private String vezeteknev;

    public Nobel() {
    }

    public Nobel(Integer id) {
        this.id = id;
    }

    public Nobel(Integer id, String ev, String tipus, String keresztnev, String vezeteknev) {
        this.id = id;
        this.ev = ev;
        this.tipus = tipus;
        this.keresztnev = keresztnev;
        this.vezeteknev = vezeteknev;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEv() {
        return ev;
    }

    public void setEv(String ev) {
        this.ev = ev;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nobel)) {
            return false;
        }
        Nobel other = (Nobel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Nobel[ id=" + id + " ]";
    }
    
}
