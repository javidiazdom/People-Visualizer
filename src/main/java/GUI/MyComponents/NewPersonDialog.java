package GUI.MyComponents;
import javax.swing.*;
import java.awt.*;

public class NewPersonDialog extends JFrame {
    public NewPersonDialog () {
        this.setLayout(new GridLayout(4,1));
        this.add(new JLabel("Nombre"));
        this.add(new JTextField("Name"));
        this.add(new JLabel("Apellidos"));
        this.add(new JTextField("Lastname"));
        this.add(new JLabel("Edad"));
        this.add(new JTextField("Age"));
        JButton button = new JButton();
        this.add(button);
        pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public String [] getPersonData() {
        return new String [] {
                ((JTextField)this.getComponent(1)).getText(),
                ((JTextField)this.getComponent(3)).getText(),
                ((JTextField)this.getComponent(5)).getText()
        };
    }
}
