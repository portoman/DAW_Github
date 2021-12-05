package com.prog03.figuras;

public class Rectangulo {
    //Atributos
    float base;
    float altura;
    
    //Constructor vacío
    public Rectangulo(){
        this.base=0;
        this.altura=0;
    }
    
    //Constructor con base y altura
    public Rectangulo(float base, float altura){
        this.base=base;
        this.altura=altura;
    }

    //Getter y setters
     public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    
    //Métodos
    public float getArea(){
        return this.base*this.altura;
    }
    
    @Override
    public String toString(){
        
        String areaAlt="El asea es: "+getArea();
        return areaAlt;
    }
    
    public boolean isCuadrado(){
        return (base==altura);
    }
}
