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
        gui.addDialogButtonListener(actionEvent -> {
            this.addPerson(gui.getNewPersonDialog().getPersonData());
        });
        gui.setPeople(db.getWorker().getPeople());
    }

    public void updatePeople (String patternSearch) {
        gui.setPeople(db.getWorker().getPeopleByName(patternSearch));
        gui.update();
    }
    private void addPerson (String[] personData) {
        db.getWorker().savePerson(new Person(personData[0], personData[1], Integer.parseInt(personData[2])));
    }
}
