package libre;

import java.awt.Menu;

public class Peaje {
    private String vehiculo;
    private double Monto;
    private double Descuento;
    private int opcion;
    private double total;

    public String getVehiculo() {return vehiculo;}
    public void setVehiculo(String vehiculo) { this.vehiculo = vehiculo;}
    public double getMonto() {return Monto;}
    public void setMonto(double Monto) {this.Monto = Monto;}    
    public double getDescuento() {return Descuento;}
    public void setDescuento(double Descuento) {this.Descuento = Descuento;}
    public double getTotal() {return total;}
    public void setTotal(double total) {this.total = total;}
    

    public Peaje(int opcion) {
        this.opcion = opcion;
        this.vehiculo = IdentificarVehiculo(opcion);
        this.Monto = CalcularMonto(opcion);
        this.Descuento = CalcularDescuento(opcion, Monto);
        this.total = calculartotal(Descuento, Monto);
    }
    
    public String IdentificarVehiculo (int opcion){
        String carro = "";
        switch (opcion) {
            case 1:
                carro = "Auto"; break;
            case 2:
                carro = "Vans"; break;
            case 3:
                carro = "Buses"; break;
            case 4:
                carro = "Camion"; break;
            default:
                throw new AssertionError();
        }
        return carro;
    }
    
    public double CalcularMonto(int opcion){
        double monto = 0;
        switch (opcion) {
            case 1:
                monto = 10; break;
            case 2:
                monto = 20; break;
            case 3:
                monto = 35; break;
            case 4:
                monto = 50; break;
            default:
                throw new AssertionError();
        }
        return monto;
    }
    
    public double CalcularDescuento(int opcion, double monto){
        double desc;
        if (opcion == 1) {
            desc = 0.08;            
        }else if (opcion == 3) {
            desc = 0.15;
        }else{
            desc = 0;
        }
        desc = desc*Monto;
        return desc;
    }
    public double calculartotal (double descuento, double monto){
        double total = monto - descuento;
        return total;
    }
            
    public static String MostraTotalMonto (Peaje peaje){
        String Mensaje = "Monto Total a pagar:"
                + "\nVehiculo : " + peaje.getVehiculo()
                + "\nMonto: " + peaje.getMonto()
                + "\nDescuento: " + peaje.getDescuento()
                + "\nTotal Cobro: " + peaje.getTotal();
        return Mensaje;
    }
    
}
