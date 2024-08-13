/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author bolic
 */
public class Customer {
     int ID;
     String CardType;

    public Customer(int ID, String CardType) {
        this.ID = ID;
        this.CardType = CardType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCardType() {
        return CardType;
    }

    public void setCardType(String CardType) {
        this.CardType = CardType;
    }
     
}
