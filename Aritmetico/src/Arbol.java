/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

public class Arbol {
    private final List<Nodo> raiz;

    public Arbol(Nodo raiz){
        this.raiz = new ArrayList<>();
        this.raiz.add(raiz);
    }

    public Arbol(List<Nodo> raiz){
        this.raiz = raiz;
    }

    public void recorrer(){
        for(Nodo n : raiz){
            Token t = n.getValue();
            switch (t.tipo){
                case SUMA:
                case RESTA:
                case MULTIPLICACION:
                case DIVISION:
                    SolverAritmetico solver = new SolverAritmetico(n);
                    Object res = solver.resolver();
                    System.out.println(res);
                break;
            }
        }
    }

}