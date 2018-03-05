package com.spoonsea.qualitytracing.braumat.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the brau31 database table.
 * 
 */
@Entity
@Table(name = "brau31")
@NamedQuery(name = "Brau31.findAll", query = "SELECT b FROM Brau31 b")
public class Brau31 extends Braumat implements Serializable {
    private static final long serialVersionUID = 1L;
}
