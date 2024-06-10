import java.beans.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GestionElec {
    
    public static void añadirElec(ArrayList<Electrodomestico> electrodomesticos) throws Exception{
        String consum = "C";
        char c = consum.charAt(0);
        electrodomesticos.add(new Lavadora("Lav", 20, "negro", c, 60, 20));
        electrodomesticos.add(new Lavadora(23, 34));
        electrodomesticos.add(new Television("Tel", 80, "verde", 'G', 45, 60, true));
        electrodomesticos.add(new Television(44,33));
        electrodomesticos.add(new Lavadora());
        electrodomesticos.add(new Television());


        // String modelo = IO.pedirTexto();
        // double precio = IO.pedirDouble();
        // String color = IO.pedirTexto();
        // char consumo = IO.pedirChar();
        // int peso = IO.pedirEntero();
        // boolean creado = false;
        //      System.out.println("Quieres 1-Lavadora o 2-Television?");
        //      int elec = IO.pedirRango(1, 2);
        //      if(elec == 1){
        //          int carga = IO.pedirEntero();
        //          electrodomesticos.add(new Lavadora(modelo,precio,color,consumo,peso,carga));
        //          creado = true;
        //      }else if(elec == 2){
        //          int resolucion = IO.pedirEntero();
        //          boolean TDT = IO.pedirBoolean();
        //          electrodomesticos.add(new Television(modelo,precio,color,consumo,peso,resolucion,TDT));
        //          creado = true;
        //     }

        //      if(!creado){
        //          throw new ElecException("No se pudo crear el electrodomestico");
        //      }
        electrodomesticos.add(new Lavadora("Lav", 20, "negro", 'B', 60, 20));
        electrodomesticos.add(new Television("Tel", 20, "negro", 'B', 60, 20, true));

        // System.out.println(Lavadora.equals(lav1, lav2));
    }

    public static void buscarElec(ArrayList<Electrodomestico> electrodomesticos,String modelo) throws ElecException{
        
        boolean encontrado = false;
        int contandor = 0;
        // Estructuras de control(for/while)
        for(Electrodomestico elec : electrodomesticos){
            if(elec.getModelo().equals(modelo)){
                encontrado = true;
                System.out.println("[ " + contandor + " ] " + elec.toString());
                contandor++;
            }
        }
        if (!encontrado) {
            System.out.println("No se encuentra ningun elec con ese modelo");
        }

    }

    public static void modificarElec(ArrayList<Electrodomestico> electrodomesticos, String modelo) throws ElecException, PrecioInvalidoException{
        buscarElec(electrodomesticos, modelo);
        int contador2 = 0;
        System.out.println("Que electrodomestico quieres cambiar(Elige el numero)");    
        int eleccion = IO.pedirEntero();  
        for(Electrodomestico elec : electrodomesticos){ 
            if(elec.getModelo().equals(modelo)){
                if(contador2 == eleccion){
                    System.out.println("Cual es el nuevo precio?");
                    int nuevoPrecio = IO.pedirEntero();
                    elec.setPrecioBase(nuevoPrecio);
                    System.out.println(elec.toString() + " El nuevo precio es: " + elec.getPrecioBase());       
                }
                contador2++;
            }
        }

    }

    public static void eliminarElec(ArrayList<Electrodomestico> electrodomesticos, String modelo) throws ElecException{
        buscarElec(electrodomesticos, modelo);
        System.out.println("Que elec quieres eliminar(Elige el numero)");
        int eleccion = IO.pedirEntero();
        int contador2 = 0;

        boolean encontrado = false;
        Iterator<Electrodomestico> iterator = electrodomesticos.iterator();//Recorre el array

        while (iterator.hasNext() && !encontrado) {
            Electrodomestico ele = iterator.next();

            if (ele.getModelo().equals(modelo)) {
                if(contador2 == eleccion){
                    iterator.remove(); // Eliminar el empleado usando el iterador
                    System.out.println("Eliminando el elec: " + ele.toString());
                    Electrodomestico.totalElectrodomestico--;
                }
                contador2++;
            }

        }

    }

    public static void mostrarElec(ArrayList<Electrodomestico> electrodomesticos){
        int contador = 0;
        for(Electrodomestico elec : electrodomesticos){
            System.out.println("[" + contador + "]" + elec.toString());
            contador++;
        }
    }
    
    public static void compareTotal(ArrayList<Electrodomestico> electrodomesticos){
        int contadorElec = 0;
        for(Electrodomestico elec : electrodomesticos){
            contadorElec++;
        }
        if(contadorElec == Electrodomestico.totalElectrodomestico){
            System.out.println("El total de Electrodomesticos coincide con el Array" + "Total del contador: " + Electrodomestico.totalElectrodomestico + "Total del array: " + contadorElec);
        }else{
            System.out.println("El total no coincide" + "Total del contador: " + Electrodomestico.totalElectrodomestico + "Total del array: " + contadorElec);
        }

    }

    public static void compararElec(ArrayList<Electrodomestico> electrodomesticos){
        System.out.println("Quieres comprar 1-Lavadoras o 2-Televisiones");
        int eleccion = IO.pedirEntero();
        if(eleccion == 1){
            int contadorLavs = 0;
            for(Electrodomestico lavs : electrodomesticos){
                if(lavs instanceof Lavadora){
                    System.out.println(contadorLavs + " " + lavs.toString());
                    contadorLavs++;
                }
            }

            System.out.println("Que lavadoras quieres comparar? Dime el primero");
            int eleccion1 = IO.pedirEntero();
            boolean encontrado1 = false;
            Lavadora lav1 = new Lavadora();
           
            System.out.println("Dime el segundo");
            int eleccion2 = IO.pedirEntero();
            boolean encontrado2 = false;
            Lavadora lav2 = new Lavadora();
    
            boolean termino = false;
            int contador = 0;
            for(Electrodomestico elec : electrodomesticos){
                if(elec instanceof Lavadora && termino == false){
                    if(contador == eleccion1){
                        lav1 = (Lavadora) elec;
                        encontrado1 = true;
                    }else if(contador == eleccion2){
                        lav2 = (Lavadora) elec;
                        encontrado2 = true;
                    }
                    if(encontrado1 && encontrado2){
                        System.out.println("El resultado es: " + Lavadora.equals(lav1, lav2));
                        termino = true;
                    }
                    contador++;
                }
            }
        }
        
       


    }


    public static void mostrarPrecios(ArrayList<Electrodomestico> electrodomesticos){
        for(Electrodomestico elec : electrodomesticos){
            if(elec instanceof Television){
                System.out.println("El precio de" + elec.getModelo() + " es: " + elec.getPrecioFinal());
            }
        }
        for(Electrodomestico elec : electrodomesticos){
            if(elec instanceof Lavadora){
                System.out.println("El precio de" + elec.getModelo() + " es: " + elec.getPrecioFinal());
            }
        }
    }

    // Ficheros binarios
    public static void guardarBinario(String nombreFichero) throws FileNotFoundException, IOException{
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))){
            oos.writeObject(Main.electrodomesticos);
            System.out.println("Empleados serializados correctamente");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void cargarBinario(String nombreFichero) throws FileNotFoundException, IOException{
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
            Main.electrodomesticos = (ArrayList<Electrodomestico>) ois.readObject();
            System.out.println("Empleados deserializados correctamente");
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    // Ficheros texto
    public static void guardarTexto(ArrayList<Electrodomestico> electrodomesticos, String archivo)throws FileNotFoundException, IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
           for (Electrodomestico elec : electrodomesticos) {
               writer.write(elec.toText());
               writer.newLine();
           }
       }
    }

    public static void cargarTexto(ArrayList<Electrodomestico> electrodomesticos, String nombreArchivo) throws IOException {
        //En el caso de borrar el arraylist completo y mejorable 
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            electrodomesticos.clear();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String tipo = parts[0];
                if (tipo.equals("Lav")) {
                    electrodomesticos.add(Lavadora.fromText(line));
                }else if(tipo.equals("Tel")){
                    electrodomesticos.add(Television.fromText(line));
                }
            }
        }
    }


}
