package puzzle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class GameClickListener implements ActionListener {

    List<JButton> btns;
    int indexOfEmpty;
    int btnClicked = 0;
    GameFrame gameFrame;

    GameClickListener(List<JButton> btns,GameFrame gameFrame){
        this.btns = btns;
        this.gameFrame = gameFrame;
    }

    public void setIndexOfEmpty(int indexOfEmpty) {
        this.indexOfEmpty = indexOfEmpty;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String buttonClickedText = btn.getText();
        int buttonClicked = btns.indexOf(btn);

        //swap
        /*btns.get(buttonClicked).setText("");
        btns.get(indexOfEmpty).setText(buttonClickedText);
        indexOfEmpty = buttonClicked;*/

        switch (buttonClicked) {
            case 0: if (indexOfEmpty== 1 || indexOfEmpty== 3) {
                btns.get(buttonClicked).setText("");
                btns.get(indexOfEmpty).setText(buttonClickedText);
                indexOfEmpty = buttonClicked;
                btnClicked++;
                }
                break;
            case 1: if (indexOfEmpty== 0 || indexOfEmpty== 2 || indexOfEmpty== 4) {
                btns.get(buttonClicked).setText("");
                btns.get(indexOfEmpty).setText(buttonClickedText);
                indexOfEmpty = buttonClicked;
                btnClicked++;
                }
                break;
            case 2: if (indexOfEmpty== 1 || indexOfEmpty== 5) {
                btns.get(buttonClicked).setText("");
                btns.get(indexOfEmpty).setText(buttonClickedText);
                indexOfEmpty = buttonClicked;
                btnClicked++;
            }
            break;
            case 3: if (indexOfEmpty== 0 || indexOfEmpty== 4 || indexOfEmpty== 6) {
                btns.get(buttonClicked).setText("");
                btns.get(indexOfEmpty).setText(buttonClickedText);
                indexOfEmpty = buttonClicked;
                btnClicked++;
            }
            break;
            case 4: if (indexOfEmpty== 1 || indexOfEmpty== 3 || indexOfEmpty== 5 || indexOfEmpty== 7) {
                btns.get(buttonClicked).setText("");
                btns.get(indexOfEmpty).setText(buttonClickedText);
                indexOfEmpty = buttonClicked;
                btnClicked++;
            }
            break;
            case 5: if (indexOfEmpty== 2 || indexOfEmpty== 4 || indexOfEmpty== 8) {
                btns.get(buttonClicked).setText("");
                btns.get(indexOfEmpty).setText(buttonClickedText);
                indexOfEmpty = buttonClicked;
                btnClicked++;
            }
            break;
            case 6: if (indexOfEmpty== 3 || indexOfEmpty== 7) {
                btns.get(buttonClicked).setText("");
                btns.get(indexOfEmpty).setText(buttonClickedText);
                indexOfEmpty = buttonClicked;
                btnClicked++;
            }
            break;
            case 7: if (indexOfEmpty== 4 || indexOfEmpty== 6 || indexOfEmpty== 8) {
                btns.get(buttonClicked).setText("");
                btns.get(indexOfEmpty).setText(buttonClickedText);
                indexOfEmpty = buttonClicked;
                btnClicked++;
            }
            break;
            case 8: if (indexOfEmpty== 5 || indexOfEmpty== 7) {
                btns.get(buttonClicked).setText("");
                btns.get(indexOfEmpty).setText(buttonClickedText);
                indexOfEmpty = buttonClicked;
                btnClicked++;
            }
            break;
            default: break;
        }
        checkWin(btns);
    }

    private void checkWin(List<JButton> btns) {
        int j = 0;
        for (int i = 0;i< btns.size();i++) {
            if (btns.get(i).getText().equals(String.valueOf(i+1))){
                j++;
            }
        }

        if (j == 8) {
            for (JButton disableBtn:btns) {
                disableBtn.setEnabled(false);
            }
            gameFrame.result(btnClicked,gameFrame);
        }
    }

}
