package pl.sda.design_patterns.duck.veterinary;

import java.util.Date;

public class Vet {

    public Vet() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void answerPhone() {
        System.out.println(new Date() + ": Oh hai");
    }
}
