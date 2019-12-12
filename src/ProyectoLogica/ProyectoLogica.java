/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoLogica;

import Vista.VentanaPrincipal;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import Algoritmos.*;
import Utilidades.*;

/**
 * @author Juan Ruiz
 * @author Juan Pinzon
 */
public class ProyectoLogica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instancia de la ventana principal 
        VentanaPrincipal V = new VentanaPrincipal();
        V.setTitle("Proyecto Final - Lógica Formal");
        V.setVisible(true);
    }

    /**
     * Recibe por parametro un ArrayList con las formulas y retorna un ArrayList
     * con las clausulas
     *
     * @param formulas
     * @return clausulas
     */
    public static ArrayList<String> obtenerClausulas(ArrayList<Formula> formulas) {
        ArrayList<String> clausulas = new ArrayList<>();
        ArrayList<Integer> posiciones = new ArrayList<>();

        //Ciclo que recorre las formulas
        for (int i = 0; i < formulas.size(); i++) {

            String fnc = formulas.get(i).getFnc();
            //Eliminacion de espacios
            fnc = fnc.replaceAll(" ", "");

            //Ciclo que verifica si hay conjunciones y retorna las posiciones
            //en las que se encuentran
            for (int j = 0; j < fnc.length(); j++) {
                if (fnc.charAt(j) == 'Λ') {
                    posiciones.add(j);
                }
            }

            try {
                //Ciclo que separa las conjunciones de disyunciones en clausulas
                //separadas y las agrega al ArrayList de clausulas
                for (int j = 0; j < posiciones.size(); j++) {
                    if (j == 0) {
                        clausulas.add(fnc.substring(0, posiciones.get(j)));
                        fnc = fnc.substring(posiciones.get(j) + 1);
                    } else {
                        clausulas.add(fnc.substring(0, (posiciones.get(j) - posiciones.get(j - 1) - 1)));
                        fnc = fnc.substring(posiciones.get(j) - posiciones.get(j - 1));
                    }
                }
                clausulas.add(fnc);
                posiciones.clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }

        }

        //Ciclo que elimina los parentesis y las disyunciones de las clausulas
        for (int i = 0; i < clausulas.size(); i++) {

            String fnc = clausulas.get(i);
            fnc = fnc.replaceAll("[()]", "");
            fnc = fnc.replaceAll("V", "");

            clausulas.set(i, fnc);

        }

        System.out.println("Formas clausales: " + clausulas);
        return clausulas;
    }

    public static boolean verificarSatisfacibilidad(ArrayList<Formula> formulas) {
        String f = "";
        for (int i = 0; i < formulas.size(); i++) {
            if (i == (formulas.size() - 1)) {
                f += formulas.get(i).getFnc();
            } else {
                f += formulas.get(i).getFnc() + " * ";
            }
        }
//        f = f.substring(0, f.length() - 1);
        f = f.replace("Λ", "*");
        f = f.replace("V", "+");
        f = f.replace("¬", "-");

        return verificar(f);
    }

    /**
     * Obtiene la formula del fichero y comprueba si es satisfacible, informando
     * por pantalla.
     */
    public static boolean verificar(String f) {
        try {
            ArrayList<Clause> sentence;
            String type = "dpll";
            /*
             * Lee la formula y la procesa para el programa
             */
            String formula = f;

            sentence = generateSentence(formula);
            if (sentence == null) {
                System.out.println("Error: literal introducido incorrectamente.");
                System.exit(4);
            }
            if (new Sentence(sentence).checkTwoSat()) {
                System.out.println("Es 2-SAT");
                long t1 = System.currentTimeMillis();
                boolean result = TwoSat.isSatisfiable(sentence);
                long t2 = System.currentTimeMillis();
                printResult(result);
                System.out.println("Tiempo empleado: " + (t2 - t1) + " ms");
                return result;
            } else if (new Sentence(sentence).checkHornSat()) {
                System.out.println("Es HORN-SAT");
                long t1 = System.currentTimeMillis();
                boolean result = HornSat.isSatisfiable(sentence);
                long t2 = System.currentTimeMillis();
                printResult(result);
                System.out.println("Tiempo empleado: " + (t2 - t1) + " ms");
                return result;
            } else {
                System.out.println("No es 2-SAT ni HORN-SAT");

                /*
                 * Lee el fichero de propiedades
                 */
                Properties props = new Properties();
                InputStream file = new FileInputStream("application.properties");
                props.load(file);

                /*
                 * Elige el algoritmo segun lo indicado por parametro
                 */
                if (type.equals("dpll")) {
                    System.out.println("Utilizando algoritmo DPLL");

                    DPLLSat sat = new DPLLSat();
                    long t1 = System.currentTimeMillis();
                    boolean result = sat.isSatisfiable(new Sentence(sentence));
                    long t2 = System.currentTimeMillis();
                    printResult(result);
                    System.out.println("Tiempo empleado: " + (t2 - t1) + " ms");
                    return result;
                } else if (type.equals("walksat")) {
                    double probRandom = Double.parseDouble(props.getProperty("walksat.probrandom"));
                    int maxSteps = Integer.parseInt(props.getProperty("walksat.maxsteps"));
                    System.out.println("Utilizando WalkSAT con p=" + probRandom + " y maxSteps=" + maxSteps);

                    WalkSAT sat = new WalkSAT(probRandom, maxSteps);
                    long t1 = System.currentTimeMillis();
                    boolean result = sat.isSatisfiable(new Sentence(sentence));
                    long t2 = System.currentTimeMillis();
                    printResult(result);
                    System.out.println("Tiempo empleado: " + (t2 - t1) + " ms");
                    return result;
                } else {
                    System.out.println("Error: algoritmo introducido no conocido");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error: fichero de propiedades incorrecto");
            System.exit(2);
        } catch (NumberFormatException e) {
            System.out.println("Error: valores incorrectos en fichero de propiedades");
            System.exit(3);
        } catch (Exception e) {
            System.out.println("Error: desconocido");
            System.exit(6);
        }
        return false;
    }

    /**
     * Muestra por pantalla si es satisfacible o no la formula introducida.
     */
    private static void printResult(boolean result) {
        if (result) {
            System.out.println("Es satisfacible");
        } else {
            System.out.println("No es satisfacible");
        }
    }

    /**
     * Dado un fichero que contiene una formula SAT, genera una sentencia
     * equivalente en forma de lista de clausulas.
     */
    private static ArrayList<Clause> generateSentence(String line) {
        /* Separa la formula en clausulas */
        line = line.replace(" ", "");
        String[] clauses = line.split("\\*");
        ArrayList<Clause> sentence = new ArrayList<Clause>();

        /* Procesa cada clausula de la formula */
        for (int i = 0; i < clauses.length; i++) {
            /* Separa la clausula en literales */
            String[] literales = clauses[i].split("\\+");
            List<Literal> litInClause = new ArrayList<Literal>();

            /* 
             * Procesa cada literal de la clausula, eliminando parentesis
             * y procesando correctamente si son literales negados o no 
             */
            for (int j = 0; j < literales.length; j++) {
                literales[j] = literales[j].replace("(", "").replace(")", "");
                if (literales[j].contains("-")) {
                    literales[j] = literales[j].replace("-", "");
                    if (!literales[j].substring(0, 1).matches("[A-Za-z]")
                            || includes(literales[j], "[^A-Za-z0-9_]")) {
                        /* Comprueba que las variables tengan la sintaxis correcta */
                        return null;
                    }
                    litInClause.add(new Literal(new PropositionSymbol(literales[j]), false));
                } else {
                    if (!literales[j].substring(0, 1).matches("[A-Za-z]")
                            || includes(literales[j], "[^A-Za-z0-9_]")) {
                        /* Comprueba que las variables tengan la sintaxis correcta */
                        return null;
                    }
                    litInClause.add(new Literal(new PropositionSymbol(literales[j]), true));
                }
            }
            sentence.add(new Clause(litInClause));
        }

        return sentence;
    }

    /**
     * Comprueba si un literal incluye algun caracter que aparece en regex
     */
    private static boolean includes(String lit, String regex) {
        String aux = lit.replaceAll(regex, "");
        return lit.length() != aux.length();
    }

}
