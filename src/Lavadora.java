import java.io.Serializable;

public class Lavadora extends Electrodomestico implements Serializable{
    // herencia y herencia múltiple
    private int carga;

    public Lavadora(){
        super();
    }

    public Lavadora(double precioB, int peso){
        super(precioB, peso);
    }


    public Lavadora(String modelo,double precioB,String color,Character consumoE,int peso,int carga){
        super(modelo, precioB, color, consumoE, peso);
        this.carga = 5;
    }

    public Lavadora(Lavadora lav) throws PrecioInvalidoException{//El constructor de copia
        this.setModelo( lav.getModelo());
        this.setPrecioBase(lav.getPrecioBase());
        this.setColor(lav.getColor());
        this.setConsumoE(lav.getConsumoE());
        this.setPeso(lav.getPeso());
        this.setCarga(lav.getCarga());
    }


    // public boolean compareTo(Lavadora lav){
    //     boolean resultado = false;
    //     if(lav.getModelo().equals(this.getModelo())){
    //         if(lav.getPrecioBase() == this.getPrecioBase()){
    //             if(lav.getColor().equals(this.getColor())){
    //                 if(lav.getConsumoE().equals(this.getConsumoE())){
    //                     if(lav.getPeso() == this.getPeso()){
    //                         if(lav.getCarga() == this.getCarga()){
    //                             resultado = true;
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     // Comparar objetos (implements Comparable)
    //     /*if(lav.compareTo(this.lav)){
    //         return true;
    //     }
    //     return false;*/
    // } 

    public static boolean equals(Lavadora lav1, Lavadora lav2){
        if (lav1.getModelo().matches(lav2.getModelo()) 
            && lav1.getPrecioBase() == lav2.getPrecioBase()){//Falta poner el resto
            return true;
        }else{
        return false;
        }
    }

    @Override
    public String toText(){
        return super.toText() + "," + carga;
    }

    @Override
    public String toString(){
        return super.toString() + " La carga es: " + carga;
    }


    public static Lavadora fromText(String text) {
        String[] parts = text.split(",");
        String modelo = parts[0];
        double precioB = Double.parseDouble(parts[1]);
        String color = parts[2];
        Character consumoE = parts[3].charAt(0);
        int peso = Integer.parseInt(parts[4]);
        int carga = Integer.parseInt(parts[5]);
        return new Lavadora(modelo, precioB, color, consumoE, peso, carga);
    }

    private int getCarga() {
        return carga;
    }

    private void setCarga(int carga) {
        this.carga = carga;
    }

    @Override
    public double getPrecioFinal() {
        double resultado = getPrecioBase() + incrementoPrecio();
       if(carga > 30){
            resultado += 50;
       }
       return resultado;
    }

    
}
