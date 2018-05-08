import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Lotto extends JFrame{
    private JButton jbtG = new JButton("Generate");
    private JButton jbtExit = new JButton("Exit");
    private JButton jbtns [] = new JButton[6];
    private Container cp ;
    private JPanel jpnC = new JPanel(new GridLayout(1,6,2,2));
    private JPanel jpnS = new JPanel(new GridLayout(1,2,2,2));
    private Random rdn = new Random();
    private Boolean flag = true ;

    public Lotto () {
        this.init();
    }

    private void init () {
        setBounds(200,100,980,360);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpnC,BorderLayout.CENTER);
        cp.add(jpnS,BorderLayout.SOUTH);

        for (int i = 0 ; i < 6 ; i ++){
            jbtns[i] = new JButton();
            jpnC.add(jbtns[i]);
            jbtns[i].setEnabled(false);
            jbtns[i].setBackground(new Color(255, 184, 87));
            jbtns[i].setFont(new Font(null,Font.BOLD,50));
        }

        jpnS.add(jbtG);
        jpnS.add(jbtExit);

        jbtG.setFont(new Font(null,Font.BOLD,50));
        jbtExit.setFont(new Font(null,Font.BOLD,50));

        jbtG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0 ; i < 6 ; i ++){
                    jbtns[i].setText(Integer.toString(rdn.nextInt(49) + 1));
                    for (int j = 0 ; j < i ; j ++){
                        if (jbtns[i].getText().equals(jbtns[j].getText())){
                            jbtns[i].setText(Integer.toString(rdn.nextInt(49) + 1 ));
                        }
                    }
                }
            }
        });

        jbtExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
