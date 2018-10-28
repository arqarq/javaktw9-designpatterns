package pl.sda.design_patterns.duck.veterinary;

import java.util.Date;

public class ContactToVet {

    public Vet vet;

    public void callVet() {
        System.out.println(new Date());
        if (vet == null) {
            vet = new Vet();
        }
        vet.answerPhone();
    }
}
