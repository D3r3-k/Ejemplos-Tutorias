package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JOptionPane;
import ventana.FrmReloj;

public class ControladorReloj implements Runnable, ActionListener{

    //Atributos de la clase
    FrmReloj vReloj;
    String hora, minuto, segundo, horario;
    Calendar calendar;
    Thread hilo;
    Thread hilo2;
    
    //Variable
    boolean estado = true;

    //Constructor con parámetro
    public ControladorReloj(FrmReloj vReloj) {
        this.vReloj = vReloj;
        //Se agrega el escuchador a los botones para que sean reconocidos al pulsarlos
        this.vReloj.btnSaludar.addActionListener(this);
        this.vReloj.btnParar.addActionListener(this);
        this.vReloj.btnIniciar.addActionListener(this);
        //Se crea e inicia el hilo
        this.hilo = new Thread(this);
        this.hilo2 = new ControladorMensaje(this.vReloj);
        this.hilo.start();
        this.hilo2.start();
    }
    
    //Método implementado
    @Override
    public void run() {
       while(estado){
           calcularHora();
           this.vReloj.txtReloj.setText(hora + ":" + minuto + ":" + segundo + " - " + horario);
           try{
               //Suspende la ejecución del hilo por un tiempo definido en milisegundos
               Thread.sleep(1000);
           }catch(Exception e){
               System.out.println("Error");
           }
       }
    } 

    private void calcularHora() {
        calendar = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        calendar.setTime(fechaHoraActual);
        //Obtenemos el valor que representa AM o PM
        horario = String.valueOf(calendar.get(Calendar.AM_PM));
        if (horario.equals("1")){
            horario = "PM";
            //Obtenemos el valor de hora actual
            int horaObtenida = calendar.get(Calendar.HOUR_OF_DAY) - 12;
            if (horaObtenida > 9){
                hora = String.valueOf(horaObtenida);
            }
            else{
                hora = "0" + horaObtenida;
            }
        }
        else{
            horario = "AM";
            //Obtenemos el valor de hora actual
            int horaObtenida = calendar.get(Calendar.HOUR_OF_DAY);
            if (horaObtenida > 9){
                hora = String.valueOf(horaObtenida);
            }
            else{
                hora = "0" + horaObtenida;
            }
        }
        //Obtenemos el valor de minuto actual
        int minutoObtenido = calendar.get(Calendar.MINUTE);
        if (minutoObtenido > 9){
            minuto = String.valueOf(minutoObtenido);
        }else{
            minuto = "0" + minutoObtenido;
        }
        //Obtenemos el valor de segundo actual
        int segundoObtenido = calendar.get(Calendar.SECOND);
        if (segundoObtenido > 9){
            segundo = String.valueOf(segundoObtenido);
        }else{
            segundo = "0" + segundoObtenido;
        }
    }
    
    private void detenerHilo(){
        estado = false;
    }

    //Método para controlar las pulsaciones en componentes
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Si la fuente del click es el botón Saludar
        if(ae.getSource() == this.vReloj.btnSaludar){
            this.vReloj.jopMensaje.showMessageDialog(null, "Hola :3",
                "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        //Si la fuente del click es el botón Iniciar
        else if(ae.getSource() == this.vReloj.btnIniciar){
            //Se reanuda la ejecución del hilo
            this.hilo.resume();
            this.vReloj.jopMensaje.showMessageDialog(null, "Se ha reanudado el hilo",
                "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        //Si la fuente del click es el botón Parar
        else if(ae.getSource() == this.vReloj.btnParar){
            //Métodos para detener el hilo por completo
            //detenerHilo();
            //this.hilo.stop();
            //Suspende el hilo por un tiempo indefinido, hasta que se reanude con resume()
            this.hilo.suspend();
            this.vReloj.jopMensaje.showMessageDialog(null, "Se ha detenido el hilo",
                "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}