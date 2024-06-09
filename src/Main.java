import java.util.ArrayList;

public class Main {

    static ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>(); 
    public static final String ELECTRODOMESTICOS_ARCHIVO_BINARIO = "electrodomesticos.ser";
    public static final String ELECTRODOMESTICOS_ARCHIVO_TEXTO = "electrodomesticos.txt";


    public static void main(String[] args) throws Exception {
        Electrodomestico.rellenarLetras();
        

        int eleccion;
        // Estructuras de control(for/while)
        do{
            System.out.println("Elige una opcion\n"+
            "1- Agregar un electrodomestico y si esta en la lista no volver a insertarlo:\n"+
            "2- Búsqueda de elec dentro del sistema\n"+
            "3- Modificar\n"+
            "4- Eliminar elec\n"+
           "5- Mostrar todos los elec\n"+
            "6- Comparar el total de elect creados \n"+
            "7- Comparar dos objetos\n"+
            "8- Mostrar precios totales" + 
            "9- Serilizacion binaria guardar"+
            "10- Serilizacion binaria cargar" + 
            "11- Serilizacion texto guardar" +
            "12- Serilizacion texto cargar" +
            "13- Guardar en BD" +
            "14- Cargar de BD" +
            "15- salir");
            eleccion = (int)Integer.parseInt(IO.pedirTexto());
            switch (eleccion) {
                case 1:
                    try{
                        GestionElec.añadirElec(electrodomesticos);
                    }catch(ElecException ee){//ExcepcionPersonalizada2
                        System.err.println(ee.getMessage());
                    }
                    break;
                case 2:
                    try{
                        System.out.println("Que modelo buscas?");
                        String modelo = "Lav";
                        GestionElec.buscarElec(electrodomesticos, modelo);
                    }catch(ElecException ee){
                        System.err.println(ee.getMessage());
                    }
                    break;
                case 3:
                    try{
                        System.out.println("Que modelo buscas?");
                        String modelo = "Lav";
                        GestionElec.modificarElec(electrodomesticos, modelo);
                    }catch(ElecException ee){
                        System.err.println(ee.getMessage());
                    }
                    break;
                case 4:
                    try{
                        System.out.println("Que modelo buscas?");
                        String modelo = "Lav";
                        GestionElec.eliminarElec(electrodomesticos, modelo);
                    }catch (Exception ex) {//manejo de excepciones
                        System.out.println("Ocurrió una excepción: " + ex.getMessage());
                    }
                    break;
                case 5:
                    GestionElec.mostrarElec(electrodomesticos);
                    break; 
                case 6:
                    GestionElec.compareTotal(electrodomesticos);
                    break;
                case 7:
                    GestionElec.compararElec(electrodomesticos);;
                    break;
                case 8:
                    GestionElec.mostrarPrecios(electrodomesticos);
                    break;        
                case 9:
                    GestionElec.guardarBinario(electrodomesticos, ELECTRODOMESTICOS_ARCHIVO_BINARIO);
                case 10:
                    GestionElec.cargarBinario(electrodomesticos, ELECTRODOMESTICOS_ARCHIVO_BINARIO);
                case 11:
                    GestionElec.guardarTexto(electrodomesticos, ELECTRODOMESTICOS_ARCHIVO_BINARIO);
                case 12:
                    GestionElec.cargarTexto(electrodomesticos, ELECTRODOMESTICOS_ARCHIVO_TEXTO);
                case 13:

                case 14:

                case 15:
                    
                default:
                    System.out.println("No existe esa opcion");
                    break;
            }
        }while(eleccion != 9);
       
    }
}
