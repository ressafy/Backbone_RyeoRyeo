
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MyView extends JFrame {

private JPanel contentPane;

/**
 * Launch the application.
 */
public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                MyView frame = new MyView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

/**
 * Create the frame.
 */
public MyView() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800,600); // 0 0 가로 세로
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnNewMenu = new JMenu("File");
    menuBar.add(mnNewMenu);
    
    JMenu mnNewMenu_1 = new JMenu("Edit");
    menuBar.add(mnNewMenu_1);
    
    JMenu mnNewMenu_2 = new JMenu("chat");
    menuBar.add(mnNewMenu_2);
    
    JMenuItem mntmNewMenuItem = new JMenuItem("start");
    mnNewMenu_2.add(mntmNewMenuItem);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(null);
    setContentPane(contentPane);
    
    JLabel lblNewLabel = new JLabel("\uAD6C\uD574\uC918 \uD648\uC988");
    lblNewLabel.setForeground(Color.PINK);
    lblNewLabel.setFont(new Font("굴림", Font.ITALIC, 26));
    lblNewLabel.setBounds(314, 43, 231, 52);
    contentPane.add(lblNewLabel);
}
}