package com.example.calccombustivel;

public class TodosOSCalculos {
    private double total;
    public void setKmLitro(double rodado, double abastecido){
        total = rodado / abastecido;
    }
    public void setLitrosAbastecidos(double pagoBomba, double precoBomba){
        total = pagoBomba / precoBomba;
    }
    public void setReserva(double capTanque, double litrosAbastecidos){
        total = capTanque - litrosAbastecidos;
    }
    public double getTotal(){
        return total;
    }
}
