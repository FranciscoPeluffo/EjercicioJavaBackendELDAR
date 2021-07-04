package test;

import domain.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Test {

    public static void main(String[] args) throws ParseException {
        //declaramos las variables y Objetos, y llamamos a los metodos a utilizar
        Persona persona;
        Persona persona1;
        SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");
        DatosTarjeta tarjeta1;
        DatosTarjeta tarjeta2;
        double monto;
        Double tasa;

        monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a cobrar:"));
        ValidacionMonto montoVal = new ValidacionMonto(monto);
        montoVal.validarMonto();

        persona = agregarPersona();

        tarjeta1 = agregarDatos(persona, formato);

        mostrarDatosTarjeta(tarjeta1);

        double mesVencimiento = tarjeta1.getMesVencimiento();
        double anioVencimiento = tarjeta1.getAnioVencimiento();
        double mesTransaccion = tarjeta1.getMesTransaccion();
        double anioTransaccion = tarjeta1.getAnioTransaccion();
        double diaTransaccion = tarjeta1.getDiaTransaccion();
        String marcaTarjeta = tarjeta1.getMarca();
        
        
        tarjetaValidacion(marcaTarjeta, mesVencimiento, anioVencimiento, mesTransaccion, anioTransaccion);

        tasasSegunTarjeta(mesTransaccion, anioTransaccion, diaTransaccion, marcaTarjeta, monto);

        persona1 = agregarPersona();

        tarjeta2 = agregarDatos(persona1, formato);

        comparacionTarjetas(tarjeta2,tarjeta1);
    }

    public static void mostrarDatosTarjeta(DatosTarjeta tarjeta) {
        //Metodo que realiza un Print del metodo toString() del obejto DatosPersona
        
        JOptionPane.showMessageDialog(null, tarjeta);
    }

    public static DatosTarjeta agregarDatos(Persona persona, SimpleDateFormat formato) throws ParseException {
        //Metodo para crear el Objeto DatosTarjeta mediante los parametros que le pasamos
        String marcaTarjeta = JOptionPane.showInputDialog("Ingrese  la  marca de la tarjeta: VISA || AMEX || NARA");
        
        long numTarjeta = Long.parseLong(JOptionPane.showInputDialog("Ingrese los digitos de la tarjeta:"));

        Date fechaVencimientoTarjeta = formato.parse(JOptionPane.showInputDialog("Ingrese la fecha de vencimiento de la tarjeta (Formato: mm/yyyy): "));

        DatosTarjeta tarjeta = new DatosTarjeta(marcaTarjeta, numTarjeta, persona, fechaVencimientoTarjeta);
        return tarjeta;
    }

    public static Persona agregarPersona() {
        //Metodo para crear el Objeto Persona
        
        String nombre = String.valueOf(JOptionPane.showInputDialog("Ingrese el nombre que figura en la tarjeta:"));

        String apellido = String.valueOf(JOptionPane.showInputDialog("Ingrese el apellido que figura en la tarjeta:"));

        Persona persona = new Persona(nombre, apellido);

        return persona;
    }

    public static void tarjetaValidacion(String marcaTarjeta, double mesVencimiento, double anioVencimiento, double mesTransaccion, double anioTransaccion) {
        //Metodo que valida si la tarjeta es valida para operar y si esta vencida o no.
        
        
        if (anioVencimiento > anioTransaccion && (marcaTarjeta.equalsIgnoreCase("amex") || marcaTarjeta.equalsIgnoreCase("visa") || marcaTarjeta.equalsIgnoreCase("nara"))) {
            JOptionPane.showMessageDialog(null, "Tarjeta Valida para operar");
            JOptionPane.showMessageDialog(null, "Operacion Realizada con exito");
        } else if (anioVencimiento == anioTransaccion && (marcaTarjeta.equalsIgnoreCase("amex") || marcaTarjeta.equalsIgnoreCase("visa") || marcaTarjeta.equalsIgnoreCase("nara"))) {
            if (mesVencimiento > mesTransaccion) {
                JOptionPane.showMessageDialog(null, "Tarjeta Valida para operar");
                JOptionPane.showMessageDialog(null, "Operacion Realizada con exito");
            } else {
                if (mesVencimiento < mesTransaccion) {
                    JOptionPane.showMessageDialog(null, "Tarjeta Invalida para operar");
                    JOptionPane.showMessageDialog(null, "Operacion NO Realizada, Tarjeta vencida");
                } else {
                    JOptionPane.showMessageDialog(null, "Tarjeta Invalida para operar");
                    JOptionPane.showMessageDialog(null, "Operacion NO Realizada, Marca no corresponde");
                }
                System.exit(1);
            }
        } else {
            if (anioVencimiento < anioTransaccion && (marcaTarjeta.equalsIgnoreCase("amex") || marcaTarjeta.equalsIgnoreCase("visa") || marcaTarjeta.equalsIgnoreCase("nara"))) {
                JOptionPane.showMessageDialog(null, "Tarjeta Invalida para operar");
                JOptionPane.showMessageDialog(null, "Operacion NO Realizada, Tarjeta vencida");
            } else if(anioVencimiento > anioTransaccion){
                JOptionPane.showMessageDialog(null, "Tarjeta Invalida para operar");
                JOptionPane.showMessageDialog(null, "Operacion NO Realizada, Marca no corresponde");

            }
            else{
                JOptionPane.showMessageDialog(null,"Tarjeta Invalida para operar");
                JOptionPane.showMessageDialog(null,"Operacion NO Realizada, Marca corresponde y Tarjeta vencida");
            }
            System.exit(1);
        }
    }

    public static void tasasSegunTarjeta(double mesTransaccion, double anioTransaccion, double diaTransaccion, String marca, double monto) {
        //Metodo que verifica cual es la tarjeta ingresada y realiza el calcula de la tasa de interes segun la tarjeta
        
        double tasa = 0;
        if (marca.equalsIgnoreCase("amex")) {

            tasa = mesTransaccion * 0.1;
            tasa = (tasa < 0.3) ? (tasa = 0.3) : (tasa = mesTransaccion * 0.1);

            JOptionPane.showMessageDialog(null, "La tarjeta AMEX tiene una tasa de " + tasa
                    + "% de interes, quedando en un monto de $" + ((tasa / 100) * monto) + " de interes");

        } else if (marca.equalsIgnoreCase("nara")) {

            tasa = diaTransaccion * 0.5;

            JOptionPane.showMessageDialog(null, "La tarjeta NARA tiene una tasa de " + tasa
                    + "% de interes, quedando en un monto de $" + ((tasa / 100) * monto) + " de interes");

        } else if (marca.equalsIgnoreCase("visa")) {

            tasa = (anioTransaccion - 2000) / mesTransaccion;

            tasa = (tasa < 0.3) ? (tasa = 0.3) : (tasa = (anioTransaccion - 2000) / mesTransaccion);

            JOptionPane.showMessageDialog(null, "La tarjeta VISA tiene una tasa de " + tasa
                    + "% de interes, quedando en un monto de $" + ((tasa / 100) * monto) + " de interes");
        }

    }

    public static void comparacionTarjetas(DatosTarjeta tarjeta2, DatosTarjeta tarjeta1) {
        //Metodo que verifica si las tarjetas son las mismas, atraves del numero de las mismas, ya que no hay dos numero de tarjetas iguales
        Long longTarjeta1 = tarjeta1.getNumTarjeta();
        Long longTarjeta2 = tarjeta2.getNumTarjeta();
        int comparacionNumTarjeta = longTarjeta1.compareTo(longTarjeta2);
        if(comparacionNumTarjeta == 0){
            JOptionPane.showMessageDialog(null, "Las tarjetas son iguales");
        }
        else{
            JOptionPane.showMessageDialog(null, "Las tarjetas son distintas");
        }
    }
}
