package puzzle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel {

    JPanel panel = new JPanel(new GridBagLayout());
    JPanel panel1 = new JPanel(new GridLayout(0,3));
    int indeoxOfEmpty;
    protected GameFrame gameFrame;

    public JPanel panel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        panel1.setPreferredSize(new Dimension(360,360));
        panel1.setBackground(Color.LIGHT_GRAY);
        List<JButton> buttons = createBtn();
        GameClickListener gameClickListener = new GameClickListener(buttons,gameFrame);

        for (JButton btn: buttons) {
            if (btn.getText().equals("9")) {
                btn.setText("");
                indeoxOfEmpty = buttons.indexOf(btn);
                gameClickListener.setIndexOfEmpty(indeoxOfEmpty);
            }
            btn.addActionListener(gameClickListener);
            panel1.add(btn);
        }

        panel.add(panel1);
        return panel;
    }

    public List<JButton> createBtn() {
        List<JButton> btns = new ArrayList<>();
        Random random = new Random();
        ArrayList<Integer> a = new ArrayList<>();
        while (a.size() < 9) {
            int b = random.nextInt(9)+1;
            if (!a.contains(b)) {
                a.add(b);
                btns.add(new JButton(String.valueOf(b)));
            }
        }
        return btns;
    }
}
