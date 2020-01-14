package GUI.MyComponents;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewPersonDialog extends JFrame {
    public NewPersonDialog () {
        this.setLayout(new GridLayout(4,1));
        this.add(new JLabel("Nombre"));
        this.add(new JTextField());
        this.add(new JLabel("Apellidos"));
        this.add(new JTextField());
        this.add(new JLabel("Edad"));
        this.add(new JTextField());
        JButton button = new JButton("Ok");
        this.add(button);
        pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public String [] getPersonData() {
        Container c = this.getContentPane();
        return new String [] {
                ((JTextField)c.getComponent(1)).getText(),
                ((JTextField)c.getComponent(3)).getText(),
                ((JTextField)c.getComponent(5)).getText()
        };
    }
    public void setButtonActionListener(ActionListener listener) {
        ((JButton)this.getContentPane().getComponent(6)).addActionListener(listener);
    }
}
