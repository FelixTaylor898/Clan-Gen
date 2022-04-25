import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Frame {
    static JFrame frame;
    static JPanel panel, body, buttons;

    public Frame() {
        buttons = new JPanel(new GridLayout(0, 1));
        Font font = new Font("Arial", Font.PLAIN, 15);
        JTextArea textField = new JTextArea(new Clan().toString());
        textField.setLineWrap(true);
        textField.setWrapStyleWord(true);
        textField.setSize(500, 500);
        JButton regen = new JButton("Generate");
        regen.setFocusable(false);
        regen.setBackground(new Color(137, 207, 240));
        regen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                new Frame();
            }
        });
        textField.setFont(font);
        textField.setEditable(false);
        buttons.add(regen);
        body = new JPanel();
        body.add(textField);
        panel = new JPanel(new BorderLayout());
        panel.add(buttons, BorderLayout.NORTH);
        panel.add(body, BorderLayout.SOUTH);
        if (frame != null)
            frame.dispose();
        frame = new JFrame("Clan Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(600, 600));

        frame.add(scrollPane);
        frame.pack();
        frame.setPreferredSize(new Dimension(700, 700));
        frame.setVisible(true);
    }
}