/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetova.utils;

/**
 *
 * @author bluescreen
 */
public class Couple<T> {
    public T x;
    public T y;
    
    public Couple(T x, T y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "(" + x.toString() + ", " + y.toString() + ")";
    }
    
}
