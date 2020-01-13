package GUI.MyComponents;

import Controller.PeopleAppController;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class MyDocumentListener implements DocumentListener {
    PeopleAppController controller;
    public MyDocumentListener (PeopleAppController controller) {
        System.out.println("check");
        this.controller = controller;
    }

    public void insertUpdate (DocumentEvent e) {
        try {
            controller.updatePeople(e.getDocument().getText(0,e.getDocument().getLength()));
        } catch (BadLocationException x) {
            System.out.println(x.getMessage());
        }
    }

    public void removeUpdate (DocumentEvent e) {
        try {
            controller.updatePeople(e.getDocument().getText(0,e.getDocument().getLength()));
        } catch (BadLocationException x) {
            System.out.println(x.getMessage());
        }
    }

    public void changedUpdate (DocumentEvent e) {
    }
}
