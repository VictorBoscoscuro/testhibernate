package com.example.relacioneshibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Asiento {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private Long idAsiento;

    @Column
    private Date fecha;

    @Column(columnDefinition = "Double default 0 ")
    private Double debe;

    @Column(columnDefinition = "Double default 0 ")
    private Double haber;

    @Column
    private Double saldoParcial;        //para ahorrar operaciones a futuro



    public Asiento() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asiento asiento = (Asiento) o;
        return idAsiento.equals(asiento.idAsiento) &&
                fecha.equals(asiento.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsiento, fecha);
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "idAsiento=" + idAsiento +
                ", fecha=" + fecha +
                ", debe=" + debe +
                ", haber=" + haber +
                ", saldoParcial=" + saldoParcial +
                '}';
    }

    public Long getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Long idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getDebe() {
        return debe;
    }

    public void setDebe(Double debe) {
        this.debe = debe;
    }

    public Double getHaber() {
        return haber;
    }

    public void setHaber(Double haber) {
        this.haber = haber;
    }

    public Double getSaldoParcial() {
        return saldoParcial;
    }

    public void setSaldoParcial(Double saldoParcial) {
        this.saldoParcial = saldoParcial;
    }

    @ManyToOne
    @JoinColumn(name="idCuenta")
    private Cuenta cuenta;

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
