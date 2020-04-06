package br.pro.hashi.ensino.desagil.aps.model;

public abstract class Gate implements Emitter, Receiver {
    private final String name;

    protected Gate(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

// --Commented out by Inspection START (4/6/2020 6:02 PM):
//    public int getInputSize() {
//        return inputSize;
//    }
// --Commented out by Inspection STOP (4/6/2020 6:02 PM)
}
