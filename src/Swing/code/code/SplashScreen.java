package Swing.code.code;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class SplashScreen extends JWindow {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int height = 350, width = 550;
	private JProgressBar progressBar;
	private JLabel lblHello, icon;
	
	public SplashScreen(JFrame frame, String msg){
		setBounds((int)frame.getLocation().getX()+ 350, (int)frame.getLocation().getY() + 100, width, height);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(125, 241, 99));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Add progressBar
		progressBar = new JProgressBar();
		progressBar.setBounds(5, 327, 540, 18);
		progressBar.setFont(new Font("Century", Font.PLAIN, 12));
		progressBar.setStringPainted(true);
		contentPane.add(progressBar);
		
		icon = new JLabel("");
		icon.setHorizontalAlignment(SwingConstants.CENTER);
		icon.setIcon(new ImageIcon("G:\\VS programs\\Java 2021\\Swing Programs\\bin\\Image\\library_32.png"));
		icon.setBounds(199, 33, 151, 83);
		
		//contentPane.add(icon);
		
		lblHello = new JLabel("");
		lblHello.setBounds(5, 0, 540, 322);
		lblHello.setFont(new Font("Consolas", Font.BOLD, 38));
		lblHello.setForeground(Color.WHITE);
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		lblHello.setText(msg);
		contentPane.add(lblHello);
		
		
		setVisible(true);
		Timer t1 = new Timer();
		t1.schedule(new TimerTask() {
			int n = 0;
			@Override
			public void run() {
				n += 2;
				progressBar.setValue(n);
				if(n == 100) {
					frame.setVisible(true);
					SplashScreen.this.dispose();
				}
			}
				
		},1000, 100);
				
	}
	public void setBackgound(Color color) {		contentPane.setBackground(color);	}
	public void setForeground(Color color) {	contentPane.setForeground(color);	}
	public void setProcessBackground(Color color) {	progressBar.setBackground(color);	}
	public void setProcessForeground(Color color) {	progressBar.setForeground(color);	}
	public void setFont(Font font) { lblHello.setFont(font);  }
	public void setIcon(ImageIcon icon) { this.icon.setIcon(icon);  }
	
	public void setSize(int width, int height) {
		contentPane.setPreferredSize(new Dimension(width, height));
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		SplashScreen sr = new SplashScreen(frame, "Hello");
		sr.setBackground(Color.blue);
		sr.setProcessBackground(Color.yellow);
		sr.setProcessForeground(Color.red);
		sr.setSize(500, 500);
//		sr.setIcon(new ImageIcon("/Swing Programs/src/Image/account_60px.png"));
		
		frame.setBounds(100, 100, 400, 400);
		//frame.setVisible(true);
		sr.setBackgound(Color.blue);
	}
}
