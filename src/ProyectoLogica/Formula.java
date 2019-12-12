/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoLogica;

import Algoritmos.FNC;
import java.util.ArrayList;

/**
 * @author Juan Ruiz
 * @author Juan Pinzon
 */
public class Formula {

    private String proposicional;
    private ArrayList<String> pasosFnc;
    private String fnc;

    public Formula(String proposicional) {
        this.proposicional = proposicional;
        this.pasosFnc = obtenerPasosFNC(proposicional);
        this.fnc = pasosFnc.get(pasosFnc.size()-1);
    }

    public String getProposicional() {
        return proposicional;
    }

    public void setProposicional(String proposicional) {
        this.proposicional = proposicional;
    }

    public ArrayList<String> getPasosFnc() {
        return pasosFnc;
    }

    public void setPasosFnc(ArrayList<String> pasosFnc) {
        this.pasosFnc = pasosFnc;
    }

    public String getFnc() {
        return fnc;
    }

    public void setFnc(String fnc) {
        this.fnc = fnc;
    }

    private ArrayList<String> obtenerPasosFNC(String proposicional) {
        
        //Reemplaza los conectores por expresiones que se requieren para 
        //convertir la formula proposicional en FNCs
        String formula = proposicional.toUpperCase();
        formula = formula.replace("↔", "iff");
        formula = formula.replace("→", "imp");
        formula = formula.replace("Λ", "and");
        formula = formula.replace("V", "or");
        formula = formula.replace("¬", "neg");

        ArrayList<String> fnc = FNC.run(formula);

        //Ciclo que reemplaza las expresiones anteriores por los conectores
        for (int i = 0; i < fnc.size(); i++) {
            fnc.set(i, fnc.get(i).toLowerCase());
            fnc.set(i, fnc.get(i).replaceAll("iff", "↔"));
            fnc.set(i, fnc.get(i).replaceAll("imp", "→"));
            fnc.set(i, fnc.get(i).replaceAll("and", "Λ"));
            fnc.set(i, fnc.get(i).replaceAll("or", "V"));
            fnc.set(i, fnc.get(i).replaceAll("neg", "¬"));

        }

        return fnc;
    }

}
