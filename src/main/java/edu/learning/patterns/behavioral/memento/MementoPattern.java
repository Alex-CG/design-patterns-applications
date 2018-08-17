package edu.learning.patterns.behavioral.memento;

public class MementoPattern {

    public static void main(String... arg) {

        CareTaker careTaker = new CareTaker();
        Notepad notepad = new Notepad();

        notepad.setName("Miguel");
        notepad.write("DEV");

        careTaker.save(notepad);
        System.out.println(notepad.getDescription());

        notepad.write(" + Senior DEV");
        System.out.println(notepad.getDescription());

        careTaker.restore(notepad);
        System.out.println(notepad.getDescription());

    }

}
class Notepad {

    private String name;
    private StringBuilder description = new StringBuilder();

    public Memento save(){
        return new Memento(name, description.toString());
    }

    public void write(String text) {
        this.description.append(text);
    }

    public void restore(Object obj){
        Memento m = (Memento) obj;
        this.name = m.name;
        this.description = m.description;
    }

    private class Memento {
        private String name;
        private StringBuilder description;
        Memento(String name, String description){
            this.name = name;
            this.description = new StringBuilder(description);
        }
    }

    public void setName(String name) { this.name = name; }
    public StringBuilder getDescription() { return description; }

}

class CareTaker {

    private Object obj;

    public void save(Notepad notepad){
        this.obj = notepad.save();
    }

    public void restore(Notepad notepad){
        notepad.restore(obj);
    }

}
