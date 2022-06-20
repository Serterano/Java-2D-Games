import javax.swing.JFrame;

public class main {
	
	public static void main(String[] args) {
		
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);//yeniden boyutlandırılamaz
		window.setTitle("Treasure Hunting");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);//add component on Jframe
		
		window.pack();//fit the prefferred size and layouts of its subcompenents
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}

}
