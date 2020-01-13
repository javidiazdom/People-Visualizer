package GUI;

import Controller.PeopleAppController;
import GUI.MyComponents.NewPersonDialog;
import Model.Person;
import GUI.MyComponents.PersonDisplay;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GUIMain extends JFrame {
    private Map<String, JComponent> componentMap = new HashMap<>();
    private PeopleAppController controller;
    private NewPersonDialog dialogFrame;
    public GUIMain () {
        setLayout(new BorderLayout(20,20));
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.setSize(700,800);
        JPanel topBar = new JPanel();
        topBar.setLayout(new BoxLayout(topBar,BoxLayout.LINE_AXIS));
        JLabel searchLabel = new JLabel("Nombre");
        searchLabel.setFont(new Font(searchLabel.getFont().getName(), Font.PLAIN, 30));
        JTextField field = new JTextField();
        JButton addPerson = new JButton("Añadir");
        addPerson.addActionListener(actionEvent -> {
            dialogFrame.setVisible(true);
        });
        field.setFont(new Font(field.getFont().getName(), Font.PLAIN, 30));
        field.setPreferredSize(new Dimension(500,50));
        topBar.add(searchLabel);
        topBar.add(field);
        topBar.add(addPerson);
        dialogFrame = new NewPersonDialog();
        componentMap.put("TextField",field);
        componentMap.put("People", panel);
        componentMap.put("TopBar", topBar);
        componentMap.put("SearchBox", field);
    }

    public void start() {
        setResizable(false);
        setSize(1000,1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(componentMap.get("People"),BorderLayout.CENTER);
        add(componentMap.get("TopBar"),BorderLayout.PAGE_START);
        setVisible(true);
    }

    public void setPeople (List<Person> people) {
        this.componentMap.get("People").removeAll();
        for (Person person : people) {
            this.componentMap.get("People").add(person.getName(), new PersonDisplay(person));
        }
        this.componentMap.get("People").revalidate();
        this.componentMap.get("People").repaint();
    }

    public void addSearchListener(DocumentListener documentListener) {
        ((JTextField)getComponent("TextField")).getDocument().addDocumentListener(documentListener);
    }

    public void addDialogButtonListener(ActionListener actionListener) {
        ((JButton)dialogFrame.getComponent(5)).addActionListener(actionListener);
    }

    public void update () {
        this.componentMap.get("People").validate();
    }

    public JComponent getComponent (String name) {
        return componentMap.get(name);
    }

    public NewPersonDialog getNewPersonDialog () {
        return dialogFrame;
    }

}