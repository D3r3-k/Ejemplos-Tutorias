package Formas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel; 


public class Formas_Basicas extends JPanel{
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        //extensión que la clase graphics que permite realizar cosas mas avanzadas
        //en este caso agregaremos un contorno más grueso a nuestras figuras
        Graphics2D gd2 = (Graphics2D)g;
        
        //clase para establecer un objeto el cual va a tener las propiedades del grosor que se va a usar para dibujar
        //el parametro 5 hace referencia al número de pixeles de ancho que va a tener la línea 
        BasicStroke grosor = new BasicStroke(5); 
       
        g.setColor(Color.yellow); 
        
        //Dibujar Círculo
        //g.accion(x, y, ancho, alto)
        //g.drawOval(300, 400, 100, 100);
        g.fillOval(300, 400, 100, 100);

        
        
        //Dibujar Rectangulos Redondeados
        //g.accion(x, y, ancho, alto, anchoArco, altoArco)
        //g.drawRoundRect(100, 50, 150, 50, 20, 20); 
        g.setColor(new Color(245, 191, 98 ));
        g.fillRoundRect(50, 50, 200, 50, 20, 20);
        g.fillRoundRect(450, 50, 200, 50, 20, 20);
        //agregar grosor al contorno
        gd2.setStroke(grosor);
        //agregar orilla de otro color a la figura
        g.setColor(new Color(82, 82, 82 ));
        g.drawRoundRect(50, 50, 200, 50, 20, 20);
        g.drawRoundRect(450, 50, 200, 50, 20, 20);
        
        g.setColor(new Color(220, 98, 245));
        g.fillRoundRect(50, 150, 250, 150, 40, 40);
         //agregar orilla de otro color a la figura
        g.setColor(new Color(82, 82, 82 ));
        g.drawRoundRect(50, 150, 250, 150, 40, 40);
        
        g.setColor(new Color(195, 238, 169));
        g.fillRoundRect(400, 150, 250, 150, 40, 40);
         //agregar orilla de otro color a la figura
        g.setColor(new Color(82, 82, 82 ));
        g.drawRoundRect(400, 150, 250, 150, 40, 40);
        
        //247, 169, 225 
        g.setColor(new Color(247, 169, 225 ));
        g.fillRoundRect(50, 500, 250, 150, 40, 40);
         //agregar orilla de otro color a la figura
        g.setColor(new Color(82, 82, 82 ));
        g.drawRoundRect(50, 500, 250, 150, 40, 40);
        
        g.setColor(new Color(124, 180, 230)); 
        g.fillRoundRect(400, 500, 250, 150, 40, 40);
         //agregar orilla de otro color a la figura
        g.setColor(new Color(82, 82, 82 ));
        g.drawRoundRect(400, 500, 250, 150, 40, 40); 
        
        //Dibujar Triangulos 
        //T(50,350) V(100,400) U(50, 450)
        //arreglo para las coordenadas en x
        int [] puntosX = {50, 100, 50};
        //arreglo para las coordenadas en y
        int [] puntosY = {350, 400, 450};
        g.setColor(Color.pink);
        g.fillPolygon(puntosX, puntosY, 3); 
        //agregar orilla de otro color a la figura
        g.setColor(new Color(82, 82, 82 ));
        g.drawPolygon(puntosX, puntosY, 3);
        
        //A1(600,400) W(650,350) Z(650,450)
        g.setColor(new Color(245, 191, 98 ));
        int[] puntosX2 = {600, 650, 650};
        int[] puntosY2 = {400, 350, 450};
        g.fillPolygon(puntosX2, puntosY2, 3); 
         //agregar orilla de otro color a la figura
        g.setColor(new Color(82, 82, 82 ));
        g.drawPolygon(puntosX2, puntosY2, 3); 
        
        g.drawString("Producción: ", 420, 180);
        
        
        
    }
    
    public static void main(String[]args){
        JFrame ventana = new JFrame("Insertar Figuras");
        Formas_Basicas objeto = new Formas_Basicas();
        JLabel label = new JLabel();
        label.setText("Empaquetado: ");
        label.setSize(100, 20);
        label.setLocation(60, 160);
        ventana.add(label);
        ventana.add(objeto);
        ventana.setSize(700,700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}
