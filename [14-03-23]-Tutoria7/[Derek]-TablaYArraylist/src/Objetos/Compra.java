package Objetos;

public class Compra {

    private int cantidad;
    private String lugar;
    private double total;
    private Usuario comprador;

    public Compra(int cantidad, String lugar, double total, Usuario comprador) {
        this.cantidad = cantidad;
        this.lugar = lugar;
        this.total = total;
        this.comprador = comprador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

}
