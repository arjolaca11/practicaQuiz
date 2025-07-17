/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaquiz;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author arjol
 */
public class Ventas {
    
    // --- Atributos ---
    private int[][] ventasSemanales;
    private String[] nombresProductos;
    // Se quitan las tildes de Miercoles y Sabado
    private final String[] diasSemana = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
    private int numProductos;

    // --- Constructor ---
    public Ventas() {
        this.numProductos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos a registrar:"));
        this.nombresProductos = new String[this.numProductos];
        this.ventasSemanales = new int[diasSemana.length][this.numProductos];
    }

    // --- Metodos ---
    public void ingresarNombresProductos() {
        for (int i = 0; i < this.numProductos; i++) {
            this.nombresProductos[i] = JOptionPane.showInputDialog("Ingrese el nombre del producto #" + (i + 1));
        }
    }

    public void generarVentasAleatorias() {
        Random random = new Random();
        StringBuilder matrizTexto = new StringBuilder("--- Matriz de Ventas Generada ---\n\n");

        for (int dia = 0; dia < diasSemana.length; dia++) {
            for (int producto = 0; producto < this.numProductos; producto++) {
                this.ventasSemanales[dia][producto] = random.nextInt(10);
                matrizTexto.append(this.ventasSemanales[dia][producto]).append("\t"); // Agrega el numero y un tabulador
            }
            matrizTexto.append("\n"); // Salto de linea para la siguiente fila
        }
        
        // Se usa un JTextArea para que los tabuladores y saltos de linea se vean bien
        JTextArea textArea = new JTextArea(matrizTexto.toString());
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(null, textArea, "Matriz de Ventas", JOptionPane.INFORMATION_MESSAGE);
    }

    public void calcularTotalVentasPorProducto() {
        StringBuilder resultado = new StringBuilder("--- Total de Ventas por Producto ---\n");
        for (int producto = 0; producto < this.numProductos; producto++) {
            int totalProducto = 0;
            for (int dia = 0; dia < diasSemana.length; dia++) {
                totalProducto += this.ventasSemanales[dia][producto];
            }
            resultado.append(this.nombresProductos[producto]).append(": ").append(totalProducto).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public void determinarDiaMayoresVentas() {
        int ventaMaxima = -1;
        String diaMaximo = "";

        for (int dia = 0; dia < diasSemana.length; dia++) {
            int totalDia = 0;
            for (int producto = 0; producto < this.numProductos; producto++) {
                totalDia += this.ventasSemanales[dia][producto];
            }
            if (totalDia > ventaMaxima) {
                ventaMaxima = totalDia;
                diaMaximo = this.diasSemana[dia];
            }
        }
        String resultado = "--- Dia con Mayores Ventas ---\n" +
                           "El dia con mayores ventas totales es " + diaMaximo + " (con un total de " + ventaMaxima + " ventas).";
        JOptionPane.showMessageDialog(null, resultado);
    }

    public void encontrarProductoMasVendido() {
        int ventaMaxima = -1;
        String productoMaximo = "";

        for (int producto = 0; producto < this.numProductos; producto++) {
            int totalProducto = 0;
            for (int dia = 0; dia < diasSemana.length; dia++) {
                totalProducto += this.ventasSemanales[dia][producto];
            }
            if (totalProducto > ventaMaxima) {
                ventaMaxima = totalProducto;
                productoMaximo = this.nombresProductos[producto];
            }
        }
        String resultado = "--- Producto Mas Vendido ---\n" +
                           "El producto mas vendido es " + productoMaximo + ", con " + ventaMaxima + " unidades.";
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    public void iniciar() {
        ingresarNombresProductos();
        generarVentasAleatorias();
        calcularTotalVentasPorProducto();
        determinarDiaMayoresVentas();
        encontrarProductoMasVendido();
    }
}



