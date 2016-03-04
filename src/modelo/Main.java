package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import vista.VistaTablero;

/**
 *
 * @author Usuario
 */
public class Main {

    String tablero[][];
    LinkedList<String> configuracionInicial;

    public Main() {
        configuracionInicial = new LinkedList<String>();
        leerTxt();
        tablero = new String[devolverTamañoTablero()][devolverTamañoTablero()];
    }

    //TODO:: Aqui quede en la inicializacion del tablero!!!
    public void inicializarTablero() {
        for (int i = 1; i < configuracionInicial.size(); i++) {
            String linea[] = configuracionInicial.get(i).split("\\ ");
            for (int j = 0; j < linea.length; j++) {

                tablero[i - 1][j] = linea[j];
                //System.out.println(" en array linea:" + i + " valor->" + linea[j]);

            }
        }
    }

    public void imprimirTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.println("i,j->" + i + "," + j + " : " + tablero[i][j]);
            }
        }
    }

//DEVUELVE EL TAMAÑO DEL TABLERO  
    public int devolverTamañoTablero() {
        String linea1[] = configuracionInicial.get(0).split("\\ ");
        return Integer.parseInt(linea1[0]);
    }
    //PARTE COMPATIBILIDADES, CARGA LAS COMPATIBILIDADES DESDE TXT

    public void leerTxt() {
        try {
            FileReader fr = new FileReader("fichero.txt");
            BufferedReader bf = new BufferedReader(fr);
            String sCadena;
            while ((sCadena = bf.readLine()) != null) {
                configuracionInicial.add(sCadena);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //metodo que devuelve el tablero
    public String[][] getTablero() {
        return tablero;
    }

//funcion para imprimir lo que cargamos desde el txt
    public void imprimirCargaTxt() {
        for (int i = 0; i < configuracionInicial.size(); i++) {
            System.out.println(configuracionInicial.get(i));
        }
    }

//Funcion que devuelve el estado de una casilla si tiene mas de un acontecimiento     ROBOT.OBJ1.OBJ2.LUGAR_PENALIDAD
    public String casillaMultiple(LinkedList<String> lista) {
        boolean encontroRobot = false;
        boolean encontroObj1 = false;
        boolean encontroObj2 = false;
        boolean encontroL1 = false;
        boolean encontroL2 = false;
        String respuesta = "0000_";
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals("-1")) {
                encontroRobot = true;
                if (respuesta.length() == 1) {
                    respuesta = "1000_";
                } else {
                    respuesta = "1" + respuesta.subSequence(1, 5);
                }

            }
            if (lista.get(i).equals("-2")) {
                encontroObj1 = true;
                if (respuesta.length() == 1) {
                    respuesta = "0100_";
                } else {
                    respuesta = respuesta.subSequence(0, 1) + "1" + respuesta.subSequence(2, 5);
                }
            }
            if ((lista.get(i).equals("-3"))) {
                encontroObj2 = true;
                if (respuesta.length() == 1) {
                    respuesta = "0010_";
                } else {
                    respuesta = respuesta.subSequence(0, 2) + "1" + respuesta.subSequence(3, 5);
                }

            }
            if ((lista.get(i).equals("-4"))) {
                encontroL1 = true;
                if (respuesta.length() == 1) {
                    respuesta = "0001_";
                } else {
                    respuesta = respuesta.subSequence(0, 3) + "1" + respuesta.subSequence(4, 5);
                }
            }
            if ((lista.get(i).equals("-5"))) {
                encontroL2 = true;
                if (respuesta.length() == 1) {
                    respuesta = "0002_";
                } else {
                    respuesta = respuesta.subSequence(0, 3) + "2" + respuesta.subSequence(4, 5);
                }
            }

            if (Integer.parseInt(lista.get(i)) > 0) {
                if (respuesta.length() == 1) {
                    respuesta = "0000_" + lista.get(i);
                } else {
                    //       System.out.println("entro");
                    respuesta = respuesta.subSequence(0, 5) + lista.get(i);
                }
            }

        }
        return "-" + respuesta;
    }

    public void buscarPorAmplitud() {
    }

    public void buscarPorProfundidad() {
    }

    public void buscarPorCostoUniforme() {
    }

    public void buscarPorVoraz() {
    }

    public void buscarPorAEstrella() {
    }

    //desde la interfaz grafica nos llega el tipo de busqueda que vamos a usar..
    public void empezarBusqueda(String tipoDeBusqueda) {
        System.out.println("seleccionaste empezar con " + tipoDeBusqueda);
    }

    //cargamos los datos desde el txt, luego pintamos el tablero y luego desde el tablero le mandamos lo seleccionado al programa y aca hacemos la busqueda.
    public static void main(String[] args) {
        Main main = new Main();
        //main.leerTxt();
        main.imprimirCargaTxt();
         main.inicializarTablero();
         VistaTablero nuevaVista = new VistaTablero(main.devolverTamañoTablero(), main.getTablero(), main);
         nuevaVista.setVisible(true);
         nuevaVista.setSize(700, 700);

        
        LinkedList<String> lista = new LinkedList();
        lista.add("-1");
        lista.add("-2");
        lista.add("-3");
        lista.add("-5");
        lista.add("50");
        System.out.println("la funcion devuelve :" + " " + main.casillaMultiple(lista));
    }
}
