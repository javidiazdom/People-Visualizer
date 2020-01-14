package GUI.MyComponents;

import Model.Person;
import javax.swing.*;
import java.awt.*;

public class PersonDisplay extends JComponent {
    private Person person;

    public PersonDisplay(Person person) {
        super();
        this.person = person;
        setMinimumSize(new Dimension(900,100));
        setMaximumSize(new Dimension(900,100));
        setPreferredSize(new Dimension(900,100));
        JLabel name = new JLabel(  person.getName() + " " + person.getSurname());
        JLabel age = new JLabel("Edad: " + person.getAge());
        name.setBounds(10, 0, 1500,90);
        name.setFont(new Font(name.getFont().getName(), Font.PLAIN, 30));
        age.setBounds(700, 0, 200,90);
        age.setFont(new Font(name.getFont().getName(), Font.PLAIN, 30));
        setBorder(BorderFactory.createLineBorder(Color.BLACK,4, true));
        add(name);
        add(age);
    }
}