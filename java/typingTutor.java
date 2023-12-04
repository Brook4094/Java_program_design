import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Iterator;

public class typingTutor extends JFrame {
    // table for key event reaction
    public Map<Integer, JButton> keyButtonMap;
    public Color color;
    public typingTutor() {
        setTitle("Typing Tutor");
        setSize(900, 600);
        setLayout(null);
        // welcome message
        JLabel label1 = new JLabel("Type something using your keyboard. The key you press will be highlighted and displayed.");
        label1.setBounds(10, 0, 700, 30);
        add(label1);
        JLabel label2 = new JLabel("note: The keyboard on the screen just show which key you press, nothing happen if you click it.");
        label2.setBounds(10, 20, 700, 30);
        add(label2);
        // text area set
        JTextArea textArea = new JTextArea();
        // add keylistener to text area
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode(); 
                if(keyButtonMap.containsKey(keyCode)) {
                    JButton b = keyButtonMap.get(keyCode);
                    color=b.getBackground();
                    b.setBackground(Color.YELLOW);
                }
            }
            // set the reaction of release the key 
            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyButtonMap.containsKey(keyCode)) {
                    JButton b = keyButtonMap.get(keyCode);
                    b.setBackground(color);
                }
            }
            @Override
            public void keyTyped(KeyEvent e) {
            }
        });
        textArea.setBounds(10, 50, 860, 190);
        textArea.setBorder(new LineBorder(Color.GRAY));
        add(textArea);
        // keyborad set, generate relative button and put it into linked hash map
        keyButtonMap = new LinkedHashMap<>();
        keyButtonMap.put(KeyEvent.VK_BACK_QUOTE, new JButton("`"));
        keyButtonMap.put(KeyEvent.VK_1, new JButton("1"));
        keyButtonMap.put(KeyEvent.VK_2, new JButton("2"));
        keyButtonMap.put(KeyEvent.VK_3, new JButton("3"));
        keyButtonMap.put(KeyEvent.VK_4, new JButton("4"));
        keyButtonMap.put(KeyEvent.VK_5, new JButton("5"));
        keyButtonMap.put(KeyEvent.VK_6, new JButton("6"));
        keyButtonMap.put(KeyEvent.VK_7, new JButton("7"));
        keyButtonMap.put(KeyEvent.VK_8, new JButton("8"));
        keyButtonMap.put(KeyEvent.VK_9, new JButton("9"));
        keyButtonMap.put(KeyEvent.VK_0, new JButton("0"));
        keyButtonMap.put(KeyEvent.VK_MINUS, new JButton("-"));
        keyButtonMap.put(KeyEvent.VK_EQUALS, new JButton("="));
        keyButtonMap.put(KeyEvent.VK_BACK_SPACE, new JButton("Backspace"));

        keyButtonMap.put(KeyEvent.VK_TAB, new JButton("Tab"));
        keyButtonMap.put(KeyEvent.VK_Q, new JButton("q"));
        keyButtonMap.put(KeyEvent.VK_W, new JButton("w"));
        keyButtonMap.put(KeyEvent.VK_E, new JButton("e"));
        keyButtonMap.put(KeyEvent.VK_R, new JButton("r"));
        keyButtonMap.put(KeyEvent.VK_T, new JButton("t"));
        keyButtonMap.put(KeyEvent.VK_Y, new JButton("y"));
        keyButtonMap.put(KeyEvent.VK_U, new JButton("u"));
        keyButtonMap.put(KeyEvent.VK_I, new JButton("i"));
        keyButtonMap.put(KeyEvent.VK_O, new JButton("o"));
        keyButtonMap.put(KeyEvent.VK_P, new JButton("p"));
        keyButtonMap.put(KeyEvent.VK_OPEN_BRACKET, new JButton("["));
        keyButtonMap.put(KeyEvent.VK_CLOSE_BRACKET, new JButton("]"));
        keyButtonMap.put(KeyEvent.VK_BACK_SLASH, new JButton("\\"));

        keyButtonMap.put(KeyEvent.VK_CAPS_LOCK, new JButton("Caps"));
        keyButtonMap.put(KeyEvent.VK_A, new JButton("a"));
        keyButtonMap.put(KeyEvent.VK_S, new JButton("s"));
        keyButtonMap.put(KeyEvent.VK_D, new JButton("d"));
        keyButtonMap.put(KeyEvent.VK_F, new JButton("f"));
        keyButtonMap.put(KeyEvent.VK_G, new JButton("g"));
        keyButtonMap.put(KeyEvent.VK_H, new JButton("h"));
        keyButtonMap.put(KeyEvent.VK_J, new JButton( "j" ));
        keyButtonMap.put(KeyEvent.VK_K, new JButton("k"));
        keyButtonMap.put(KeyEvent.VK_L, new JButton("l"));
        keyButtonMap.put(KeyEvent.VK_SEMICOLON, new JButton(";"));
        keyButtonMap.put(KeyEvent.VK_QUOTE, new JButton("'"));
        keyButtonMap.put(KeyEvent.VK_ENTER, new JButton("Enter"));

        keyButtonMap.put(KeyEvent.VK_SHIFT, new JButton("Shift"));
        keyButtonMap.put(KeyEvent.VK_Z, new JButton("z"));
        keyButtonMap.put(KeyEvent.VK_X, new JButton("x"));
        keyButtonMap.put(KeyEvent.VK_C, new JButton("c"));
        keyButtonMap.put(KeyEvent.VK_V, new JButton("v"));
        keyButtonMap.put(KeyEvent.VK_B, new JButton("b"));
        keyButtonMap.put(KeyEvent.VK_N, new JButton("n"));
        keyButtonMap.put(KeyEvent.VK_M, new JButton("m"));
        keyButtonMap.put(KeyEvent.VK_COMMA, new JButton(","));
        keyButtonMap.put(KeyEvent.VK_PERIOD, new JButton("."));
        keyButtonMap.put(KeyEvent.VK_SLASH, new JButton("/"));
        keyButtonMap.put(KeyEvent.VK_UP, new JButton("up"));

        keyButtonMap.put(KeyEvent.VK_CONTROL, new JButton("Ctrl"));
        keyButtonMap.put(KeyEvent.VK_ALT, new JButton("Alt"));
        keyButtonMap.put(KeyEvent.VK_SPACE, new JButton("Space"));
        keyButtonMap.put(KeyEvent.VK_LEFT, new JButton("left"));
        keyButtonMap.put(KeyEvent.VK_DOWN, new JButton( "down" ));
        keyButtonMap.put(KeyEvent.VK_RIGHT, new JButton( "right" ));

        // a container keyboard
        JPanel keyboard = new JPanel(null);
        keyboard.setBounds(10, 250, 860, 300);
        keyboard.setBorder(new LineBorder(Color.GRAY));
        // set button size and location on keyboard
        Iterator<JButton> iterator = keyButtonMap.values().iterator();
        for(int i=0;i<5;i++) {
            int keyNum;
            int r=0;
            if(i == 2) keyNum= 13;
            else if(i== 3) keyNum= 12;
            else if(i ==5 ) keyNum = 6;
            else keyNum= 14;
            for(int j=0;j<keyNum;j++) {
                if(iterator.hasNext()) {
                    JButton b = iterator.next();
                    b.setFont(new Font("Arial", Font.PLAIN, 10));
                    int x=15+56*j+r;
                    int y=10+56*i;
                    int w=54;
                    int h=54;
                    if (b.getText().equals("Backspace")) {
                        w=108;
                    }
                    else if(b.getText().equals("Tab") || b.getText().equals("Caps")) {
                        w=81;
                        r=27;
                    }
                    else if(b.getText().equals("Enter")) {
                        w=108;
                    }
                    else if(b.getText().equals("Shift")) {
                        w=108;
                        r=54;
                    }
                    else if(b.getText().equals("/")) {
                        r=81;
                    }
                    else if(b.getText().equals("Alt")) {
                        r=108;
                    }
                    else if(b.getText().equals("Space")) {
                        w=324;
                        r=473;
                    }
                    else if(b.getText().equals("down")) {
                        b.setFont(new Font("Arial", Font.PLAIN, 8));
                    }
                    b.setBounds(x, y, w, h);
                    keyboard.add(b);
                }
            }
        }
        add(keyboard);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }
    public static void main(String[] args) {
        new typingTutor();
    }
}
