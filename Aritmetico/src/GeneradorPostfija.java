/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GeneradorPostfija {

    private final List<Token> infija;
    private final Stack<Token> pila;
    private final List<Token> postfija;

    public GeneradorPostfija(List<Token> infija) {
        this.infija = infija;
        this.pila = new Stack<>();
        this.postfija = new ArrayList<>();
    }

    public List<Token> convertir(){
        for(Token t : infija){
            if(t.tipo == TipoToken.EOF){
                continue;
            }

            if(t.esOperando()){
                postfija.add(t);
            }
            else if(t.tipo == TipoToken.PARENI){
                pila.push(t);
            }
            else if(t.tipo == TipoToken.PAREND){
                while(!pila.isEmpty() && pila.peek().tipo != TipoToken.PARENI){
                    Token temp = pila.pop();
                    postfija.add(temp);
                }
                if(pila.peek().tipo == TipoToken.PARENI){
                    pila.pop();
                }
            }
            else if(t.esOperador()){
                while(!pila.isEmpty() && pila.peek().precedenciaMayorIgual(t)){
                    Token temp = pila.pop();
                    postfija.add(temp);
                }
                pila.push(t);
            }
        }
        while(!pila.isEmpty()){
            Token temp = pila.pop();
            postfija.add(temp);
        }

        return postfija;
    }

}
