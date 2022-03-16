import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;


class Frame {
    static JFrame frame;
    static JPanel panel, body, buttons;


    public Frame() {
        buttons = new JPanel(new GridLayout(0, 2));
        JTextArea textField = new JTextArea(new Clan().toString());
        body = new JPanel();
        body.add(textField);
        panel = new JPanel(new BorderLayout());
        panel.add(buttons, BorderLayout.NORTH);
        panel.add(body, BorderLayout.SOUTH);
        if (frame != null) frame.dispose();
        frame = new JFrame("Clan Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
        frame.add(panel);
		frame.pack();
		frame.setVisible(true);
    }
}