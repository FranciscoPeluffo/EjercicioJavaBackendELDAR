
package domain;

import javax.swing.JOptionPane;

public class ValidacionMonto {
    //Si el monto es menor a 1000 se informa que el monto debe ser mayoa 1000 y se cierra el prgrama, si es mayor a mil continua la operacion 
    private double monto;

    public ValidacionMonto(double monto) {
        this.monto = monto;
    }
    
   public void validarMonto(){
       if (monto < 1000) {
            JOptionPane.showMessageDialog(null, "El monto debe ser mayor a $1000, usted ingreso $" + monto + ", arranque el programa nuevamente");
            System.exit(1);
        }
   }
}
