package com.spoonsea.qualitytracing.braumat.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the brau33 database table.
 * 
 */
@Entity
@Table(name = "brau33")
@NamedQuery(name = "Brau33.findAll", query = "SELECT b FROM Brau33 b")
public class Brau33 extends Braumat implements Serializable {
    private static final long serialVersionUID = 1L;
}
