/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVN;

/**
 *
 * @author bolic
 */
public class Node {
    int info;
    Node next ;
    
    Node(){
    
    }
    
    Node(int x, Node p){
        this.info = x;
        this.next = p;
    }
    
    Node(int x){
        this(x, null);
    }
}
