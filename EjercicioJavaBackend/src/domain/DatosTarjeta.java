package domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class DatosTarjeta {

    private String marca;
    private long numTarjeta;
    private Persona persona;
    private Date fechaVencimiento;
    private Date fechaTransaccion;
    private int anioVencimiento;
    private int mesVencimiento;
    private int mesTransaccion;
    private int anioTransaccion;
    private int diaTransaccion;

    public DatosTarjeta() {

    }

    public DatosTarjeta(String marca, long numTarjeta, Persona persona, Date fechaVencimiento) {
        //Constructor, recopila Datos de la tarjeta
        this.fechaTransaccion = new Date();
        this.marca = marca;
        this.numTarjeta = numTarjeta;
        this.persona = persona;
        this.fechaVencimiento = fechaVencimiento;
        fechaVencimiento();
        transaccionDiaMesAnio();
    }

    public void transaccionDiaMesAnio() {
        this.mesTransaccion = fechaTransaccion.getMonth() + 1;
        this.anioTransaccion = fechaTransaccion.getYear() + 1900;
        this.diaTransaccion = fechaTransaccion.getDay();
    }

    public void fechaVencimiento() {
        this.mesVencimiento = fechaVencimiento.getMonth() + 1;
        this.anioVencimiento = fechaVencimiento.getYear() + 1900;
    }

    public long getNumTarjeta() {
        return numTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    public String getMarca() {
        
        return marca;
    }
    
    public double getDiaTransaccion() {
        return diaTransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public int getAnioVencimiento() {
        return anioVencimiento;
    }

    public int getMesVencimiento() {
        return mesVencimiento;
    }

    public int getMesTransaccion() {
        return mesTransaccion;
    }

    public int getAnioTransaccion() {
        return anioTransaccion;
    }


    @Override
    public String toString() {
        return "DatosTarjeta:  " + "Marca: " + marca + ", Num. Tarjeta: " + numTarjeta + ", Persona: " + persona
                + ", Fecha de Vencimiento: " + mesVencimiento + "/" + anioVencimiento;
    }

}
