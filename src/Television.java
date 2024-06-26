public class Television extends Electrodomestico {
    private int resolucion;
    private boolean sintonizadorTDT;

    public Television(){
        super();
        resolucion = 20;
        sintonizadorTDT = false;
    }

    public Television(double precioB, int peso){
        super(precioB, peso);
        resolucion = 20;
        sintonizadorTDT = false;
    }

    public Television(String modelo,double precioB,String color,Character consumoE,double peso,int resolucion,boolean sintonizadorTDT){
        super(modelo, precioB, color, consumoE, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public Television(Television tev) throws PrecioInvalidoException{//El constructor de copia
        this.setModelo( tev.getModelo());
        this.setPrecioBase(tev.getPrecioBase());
        this.setColor(tev.getColor());
        this.setConsumoE(tev.getConsumoE());
        this.setPeso(tev.getPeso());
        this.setResolucion(tev.getResolucion());
        this.setSintonizadorTDT(tev.getSintonizadorTDT());
    }

    @Override
    public double getPrecioFinal(){
        double resultado = this.incrementoPrecio();
       if(resolucion > 40){
            resultado = (resultado * 130)/100;
       }
       if(sintonizadorTDT){
            resultado += 50;
       }
       return resultado;
    }

    @Override
    public String toText(){
        return super.toText() + "," + resolucion + "," + sintonizadorTDT;
    }

    @Override
    public String toString(){
        return super.toString() + " La resolucion es:" + resolucion;
    }

    private int getResolucion() {
        return resolucion;
    }

    private void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    private boolean getSintonizadorTDT() {
        return sintonizadorTDT;
    }

    private void setSintonizadorTDT(boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public static Television fromText(String text) {//Tiene que ser hederado de la superclase
        String[] parts = text.split(",");
        String modelo = parts[0];
        double precioB = Double.parseDouble(parts[1]);
        String color = parts[2];
        Character consumoE = parts[3].charAt(0);
        double peso = Double.parseDouble(parts[4]);
        int resolucion = Integer.parseInt(parts[5]);
        boolean sintonizadorTDT = Boolean.parseBoolean(parts[6]);
        return new Television(modelo, precioB, color, consumoE, peso, resolucion, sintonizadorTDT);
    }


    
}
