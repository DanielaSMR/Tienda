import java.io.Serializable;
import java.util.HashMap;

public abstract class Electrodomestico implements Serializable{
        // visibilidad
        // constructores
    private String modelo;
    private double precioBase;
    //Accesible desde las subclases
    protected String color;
    protected char consumoE;
    private double peso;
    //Estaticos
    public static int totalElectrodomestico;
    //Arrays y colecciones
    //Encapsulacion
    public static HashMap<Character, Integer> precios = new HashMap<Character, Integer>();//Se hace static para que pueda interactuar con el main

    public Electrodomestico(){
        modelo = "Desconocido";
        precioBase = 100;
        color = "blanco";
        consumoE = 'F';
        peso = 5;
        totalElectrodomestico ++;
    }

    public Electrodomestico(double precioBase, int peso){
        modelo = "Desconocido";
        //sobrecarga ya que esta repetido
        this.precioBase = precioBase;
        color = "blanco";
        this.peso = peso;
        //Valores por defecto
        consumoE = 'F';
        totalElectrodomestico ++;
    }

    public Electrodomestico(String modelo, double precioBase, String color, char consumoE, double peso){
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoE = comprobarConsumo(consumoE);
        this.peso = peso;
        totalElectrodomestico ++;
    }
    
    private char comprobarConsumo(char letra) {
        if (letra < 'A' || letra > 'F')                             
            return consumoE = 'F';
        else
            return consumoE = letra;
    }

    private String comprobarColor(String color){
        color.toLowerCase();
        if(color.equals("negro")){
            color = "negro";
        }else if(color.equals("rojo")){
            color ="rojo";
        }else if(color.equals("azul")){
            color = "azul";
        }else if(color.equals("gris")){
            color = "gris";
        }else{
            color = "blanco";
        }

        return color;
    }

    public final double incrementoPrecio(){//No sera sobreescrito por una subclase
        double resultado = precios.get(consumoE) + this.getPrecioBase();
        if(peso >= 0 && peso <= 19){
            resultado += 10;
        }else if(peso >=20 && peso <= 49){
            resultado += 50;
        }else if(peso >= 50 && peso <= 79){
            resultado += 80;
        }else if(peso > 80){
            resultado += 100;
        }
        return resultado;
    }

    // polimorfismo
    public abstract double getPrecioFinal();
    

    public static void rellenarLetras(){
        precios.put('A', 100);
        precios.put('B', 80);
        precios.put('C', 60);
        precios.put('D', 50);
        precios.put('E', 30);
        precios.put('F', 10);
    }
  

    public String toString(){
        return "El modelo es: " + modelo;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) throws PrecioInvalidoException{
        //Excepcion personalizada1
        if (precioBase <= 0) {
            throw new PrecioInvalidoException("El salario debe ser mayor que 0.");
        }
        this.precioBase = precioBase;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    

    public int getTotalElectrodomestico() {
        return totalElectrodomestico;
    }

    public void setTotalElectrodomestico(int totalElectrodomestico) {
        this.totalElectrodomestico = totalElectrodomestico;
    }

    public static HashMap<Character, Integer> getPrecios() {
        return precios;
    }

    public static void setPrecios(HashMap<Character, Integer> precios) {
        Electrodomestico.precios = precios;
    }

    public char getConsumoE() {
        return consumoE;
    }

    public void setConsumoE(char consumoE) {
        this.consumoE = consumoE;
    }

    public String toText() {
        return modelo + "," + precioBase + "," + color + "," + consumoE + "," + peso;

    }



}
