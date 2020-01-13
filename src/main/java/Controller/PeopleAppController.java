package Controller;

import Data.DatabasePool;
import GUI.GUIMain;
import GUI.MyComponents.MyDocumentListener;
import Model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeopleAppController {
    private GUIMain gui;
    private DatabasePool db;

    public PeopleAppController (DatabasePool db, GUIMain gui) {
        this.db = db;
        this.gui = gui;
    }

    public void start () {
        gui.start();
        gui.addSearchListener(new MyDocumentListener(this));
        gui.addButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Person newPerson = addPersonDialog();
            }
        });
        gui.setPeople(db.getWorker().getPeople());
    }

    public void updatePeople (String patternSearch) {
        gui.setPeople(db.getWorker().getPeopleByName(patternSearch));
        gui.update();
    }

    public Person addPersonDialog () {
        String[] personData = gui.openNewPersonDialog();
        return null;
    }
}
