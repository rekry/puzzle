package puzzle;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends Component {
    JFrame frame = new JFrame("Game puzzle");
    JPanel gamePanel = new GamePanel().panel(this);
    GameFrame() {
    }

    public void buildFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel,BorderLayout.CENTER);
        frame.setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setSize(720,480);
        frame.pack();
        frame.setVisible(true);
    }


    public void result(int count,GameFrame fr) {
        JFrame jFrame = new JFrame();
        JButton btn = new JButton("reset");
        JButton btn2 = new JButton("quit");
        JLabel label = new JLabel("your count is : ");
        label.setSize(85,25);
        label.setLocation(10,30);
        JTextField txt = new JTextField(String.valueOf(count));
        txt.setSize(75,25);
        txt.setLocation(120,30);
        txt.setForeground(Color.BLACK);
        txt.setEditable(false);
        jFrame.setPreferredSize(new Dimension(225,300));
        jFrame.setResizable(false);
        jFrame.setLayout(null);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(label);
        jFrame.add(txt);
        btn.setSize(75,25);
        btn.setLocation(20,200);
        btn2.setSize(75,25);
        btn2.setLocation(115,200);
        jFrame.add(btn);
        jFrame.add(btn2);
        jFrame.pack();
        jFrame.setVisible(true);

        btn2.addActionListener(e -> {
            if (e.getActionCommand().equals("quit")) {
                System.exit(0);
            }

        });
        btn.addActionListener(e -> {
            if (e.getActionCommand().equals("reset")) {
                jFrame.dispose();
                frame.remove(gamePanel);
                gamePanel = new GamePanel().panel(this);

                buildFrame();
                SwingUtilities.updateComponentTreeUI(fr);

            }
        });
    }
}
