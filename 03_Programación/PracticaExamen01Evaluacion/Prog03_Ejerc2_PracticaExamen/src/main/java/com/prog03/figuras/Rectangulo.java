package com.prog03.figuras;

public class Rectangulo {

    int base;
    int altura;

    public Rectangulo() {
        this.base = 0;
        this.altura = 0;
    }

    public Rectangulo(int base, int altura){
        this.base=base;
        this.altura=altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    
    public float getArea(){
        return this.base*this.altura;
    }
    
    public String toString(){
        return "Su  altura  es: "+this.altura+", y su área es: "+this.getArea();
        
    }
    
    public boolean isCuadrado(){
        return this.base==this.altura;
    }
    
    
}
