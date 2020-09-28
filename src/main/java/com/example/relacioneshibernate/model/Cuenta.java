package com.example.relacioneshibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private Long idCuenta;

    @Column(unique = true, length = 6, nullable = false)
    private String codigoCuenta;

    @Column
    private Double saldoActual;

    @Column(nullable = false)
    private Boolean recibeSaldo;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoCuenta tipoCuenta;

    public Cuenta() {

    }

    public Cuenta(Long idCuenta, String codigoCuenta, Boolean recibeSaldo, TipoCuenta tipoCuenta) {
        this.idCuenta = idCuenta;
        this.codigoCuenta = codigoCuenta;
        this.recibeSaldo = recibeSaldo;
        saldoActual = 0.0;
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return idCuenta.equals(cuenta.idCuenta) &&
                codigoCuenta.equals(cuenta.codigoCuenta) &&
                recibeSaldo.equals(cuenta.recibeSaldo) &&
                tipoCuenta.equals(cuenta.tipoCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuenta, codigoCuenta, recibeSaldo, tipoCuenta);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "idCuenta=" + idCuenta +
                ", codigoCuenta='" + codigoCuenta + '\'' +
                ", saldoActual=" + saldoActual +
                ", recibeSaldo=" + recibeSaldo +
                ", tipoCuenta=" + tipoCuenta +
                '}';
    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public Double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Boolean getRecibeSaldo() {
        return recibeSaldo;
    }

    public void setRecibeSaldo(Boolean recibeSaldo) {
        this.recibeSaldo = recibeSaldo;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Asiento> asientos = new ArrayList<Asiento>();

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }
}
