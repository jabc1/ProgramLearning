import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import javax.swing.*;

/**
 * 
 * @author WY
 * �������
 */
class ChessMainFrame extends JFrame implements ActionListener, MouseListener, Runnable{
	// ���
	JLabel play[] = new JLabel[32];
	// ����
	JLabel image;
	// ����
	Container con;
	// ������
	JToolBar jmain;
	// ���¿�ʼ
	JButton anew;
	// ����
	JButton repent;
	// ��
	JButton showOpen;
	// ����
	JButton showSave;
	// �˳�
	JButton exit;
	// ��ǰ��Ϣ
	JLabel text;
	// ���浱ǰ����
	Vector FileVar;
	Vector Var;
	// ���������
	ChessRule rule;
	
	/*
	 * ��������
	 * chessManClick = true ��˸���ӣ������߳���Ӧ
	 * chessManClick = false ������ ֹͣ��˸ �����߳���Ӧ
	 */
	boolean chessManClick;
	/*
	 * �����������
	 * chessPlayClick=1��������
	 * chessPlayClick=2��������  Ĭ�Ϻ���
	 * chessPlayClick=3˫������������
	 */
	int chessPlayClick=2;
	// ����������˸���߳�
	Thread tmain;
	// �ѵ�һ�εĵ������Ӹ��߳���Ӧ
	static int Man;
	static int i;
	
	ChessMainFrame(){
		new ChessMainFrame("�й�����");
	}
	
	/*
	 * ���캯��
	 * ��ʼ��ͼ���û�����
	 */
	ChessMainFrame(String Title){
		// ���п͸�����
		con = this.getContentPane();
		con.setLayout(null);
		// ʵ����������
		rule = new ChessRule();
		FileVar = new Vector();
		Var = new Vector();
		// ����������
		jmain = new JToolBar();
		text = new JLabel("��ӭʹ���й�����");
		// ����������ʾ��Ϣ
		text.setToolTipText("��Ϣ��ʾ");
		anew = new JButton("����Ϸ");
		anew.setToolTipText("new game");
		exit = new JButton("exit");
		exit.setToolTipText("exit the game");
		showOpen = new JButton("open");
		showOpen.setToolTipText("open old game");
		showSave = new JButton("save");
		showSave.setToolTipText("save current game");
		
		// �������ӵ�������
		jmain.setLayout(new GridLayout(0, 6));
		jmain.add(anew);
		jmain.add(repent);
		jmain.add(showOpen);
		jmain.add(showSave);
		jmain.add(exit);
		jmain.add(text);
		jmain.setBounds(0, 0, 558, 30);
		con.add(jmain);
		// ������ӱ�ǩ
		drawChessMan();
		
		// ע�ᰴť����
		anew.addActionListener(this);
		repent.addActionListener(this);
		exit.addActionListener(this);
		showOpen.addActionListener(this);
		showSave.addActionListener(this);
		
		// ע�������ƶ�����
		for (int i = 0; i < 32; i++){
			con.add(play[i]);
			play[i].addMouseListener(this);
		}
		
		// ������̱�ǩ
		con.add(image = new JLabel(new ImageIcon("image\\Main.GIF")));
		image.setBounds(0, 30, 558, 620);
		image.addMouseListener(this);
		
		// ע�ᴰ��رռ���
		this.addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					System.exit(0);
				}
			}
		);
		
		// �������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		
		if (frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}
		
		this.setLocation((screenSize.width - frameSize.width) / 2 - 280, 
			(screenSize.height - frameSize.height) / 2 - 350);
		// ����
		this.setIconImage(new ImageIcon("image�콫.GIF").getImage());
		this.setResizable(false);
		this.setTitle(Title);
		this.setSize(558, 670);
		this.show();
	}
	
	/*
	 * ������ӷ���
	 */
	public void drawChessMan(){
		// ���̿���
		int i;
		int k;
		// ͼ��
		Icon in;
		// ��ɫ����
		// ��
		in = new ImageIcon("image\�ڳ�.GIF");
		for (i = 0, k = 24; i < 2; i++, k += 456){
			play[i] = new JLabel(in);
			play[i].setBounds(k, 56, 55, 55);
			play[i].setName("�� 1");
		}
		// ��
		in = new ImageIcon("image\����.GIF");
		for (i = 4, k = 81; i < 6; i++, k += 342){
			play[i] = new JLabel(in);
			play[i].setBounds(k, 56, 55, 55);
			play[i].setName("�� 1");
		}
		// ��
		in = new ImageIcon("image\����.GIF");
		for (i = 8, k = 138; i < 10; i++, k += 228){
			play[i] = new JLabel(in);
			play[i].setBounds(k, 56, 55, 55);
			play[i].setName("�� 1");
		}
		// ʿ
		in = new ImageIcon("image\��ʿ.GIF");
		for (i = 12, k = 195; i < 14; i++, k+= 114){
			play[i] = new JLabel(in);
			play[i].setBounds(k, 56, 55, 55);
			play[i].setName("ʿ 1");
		}
		// ��
		in = new ImageIcon("image\����.GIF");
		for (i = 16, k = 24; i < 21; i++, k += 114){
			play[i] = new JLabel(in);
			play[i].setBounds(k, 227, 55, 55);
			play[i].setName("�� 1" + i);
		}
		// ��
		in= new ImageIcon("image\����.GIF");
		for (i = 26, k = 81; i < 28; i++, k += 342){
			play[i] = new JLabel(in);
			play[i].setBounds(k, 170, 55, 55);
			play[i].setName("�� 1" + i);
		}
		
		// ��
		in = new ImageIcon("image\�ڽ�.GIF");
		play[30] = new JLabel(in);
		play[30].setBounds(252, 56, 55, 55);
		play[30].setName("�� 1");
		
		//////// ��ɫ����
		// ��
		in= new ImageIcon("image\�쳵.GIF");
		for (i = 2, k = 24; i < 4; i++, k += 456){
			paly[i] = new JLabel(in);
			play[i].setBounds(k, 569, 55, 55);
			play[i].setName("�� 2");
		}
		// ��
		in = new ImageIcon("image\����.GIF");
		for (i = 6, k = 81; i < 8; i++, k += 342){
			play[i] = new JLabel(in);
			play[i].setBounds(k, 569, 55, 55);
			paly[i].setName("�� 2");
		}
		// ��
		in = new ImagIcon("image\����.GIF");
		for (i = 10, k = 138; i < 12; i++, k += 228){
			play[i] = new JLabel(in);
			paly[i].setBounds(k, 569, 55, 55);
			play[i].setName("�� 2");
		}
		// ʿ
		in = new ImageIcon("image\��ʿ.GIF");
		for (i = 14, k = 195; i < 16; i++, k += 114){
			play[i] = new JLabel(in);
			play[i].setBounds(k, 569, 55, 55);
			play[i].setName("ʿ 2");
		}
		// ��
		in = new ImageIcon("image\���.GIF");
		for (i = 21, k = 24; i < 26; i++, k+= 114){
			play[i] = new JLabel(in);
			play[i].setBounds(k, 398, 55, 55);
			play[i].setName("�� 2" + i);
		}
		// ��
		in = new ImageIcon("image\����.GIF");
		for (i = 28, k = 81; i < 30; i++, k += 342){
			play[i] = new JLabel(in);
			play[i].setBounds(k, 455, 55, 55);
			play[i].setName("�� 2" + i);
		}
		// ˧
		in = new ImageIcon("image\��˧.GIF");
		play[31] = new JLabel(in);
		paly[31].setBounds(252, 569, 55, 55);
		play[31].setName("˧ 2");
	}
	/*
	 * �̷߳�������������˸
	 */
	public void run(){
		while (true){
			// �������ӣ���һ�¿�ʼ��˸
			if (chessManClick){
				play[Man].setVisible(false);
				// time control
				try{
					tmain.sleep(200);
				}
				catch (Exception e){
					
				}
				play[Man].setVisible(true);
			}
			else{	// ��˸��ǰ��ʾ��Ϣ �����û�������
				text.setVisible(false);
				// time control
				try{
					tmain.sleep(250);
				}
				catch (Exception e){
					
				}
				text.setVisible(true);
			}
			try{
				tmain.sleep(350);
			}
			catch (Exception e){
				
			}
		}
	}
	/*
	 * �������ӵķ���
	 */
	public void mouseClicked(MouseEvent mevent){
		System.out.println("Mouse");
		// current coordinate
		int Ex = 0;
		int Ey = 0;
		// start thread
		if (tmain == null){
			tmain = new Thread(this);
			tmain.start();
		}
		// move pieces click the board
		if (mevent.getSource().equals(image)){
			// when red player move
			if (chessPlayClick == 2 && play[Man].getName().charAt(1) == '2'){
				Ex = play[Man].getX();
				Ey = play[Man].getY();
				// move the soldiers
				if (Man > 15 && Man < 26){
					rule.armsRule(Man, play[Man], mevent);
				}
				else if (Man > 25 && Man < 30){	// move pao 
					rule.cannonRule(play[Man], play, mevent);
				}
				else if (Man >= 0 && Man < 4){	// move che
					rule.cannonRule(play[Man], play, mevent);
				}
				else if (Man >= 4 && Man < 8){	// move horse
					rule.horseRule(play[Man], play, mevent);
				}
				else if (Man >= 8 && Man < 12){	// move elephant
					rule.elephantRule(Man, play[Man], play, mevent);
				}
				else if (Man >= 12 && Man < 16){	// move knight
					rule.chapRule(Man, play[Man], play, mevent);
				}
				else if (Man >= 30 && Man < 32){	// move general
					rule.willRule(Man, play[Man], play, mevent);
				}
				
				// �Ƿ��������
				if (Ex == play[Man].getX() && Ey == play[Man].getY()){
					text.setText("please Red move");
					chessPlayClick = 2;
				}
				else{
					text.setText("please Black move");
					chessPlayClick = 1;
				}
			}
			else if (chessPlayClick == 1 && play[Man].getName().charAt(1) == '1'){
				Ex = play[Man].getX();
				Ey = play[Man].getY();
				// move soldiers
				if (Man >= 16 && Man < 26){
					rule.armsRule(Man, play[Man], mevent);
				}
				else if (Man >= 26 && Man < 30){
					rule.cannonRule(play[Man], play, mevent);
				}
				else if (Man >= 0 && Man < 4){
					rule.cannonRule(play[Man], play, mevent);
				}
				else if (Man >= 4 && Man < 8){
					rule.horseRule(play[Man], paly, me);
				}
				else if (Man >= 8 && Man < 12){
					rule.elephantRule(Man, play[Man], play, mevent);
				}
				else if (Man >= 12 && Man < 16){
					rule.chapRule(Man, play[Man], play, mevent);
				}
				else if (Man >= 30 && Man < 32){
					rule.willRule(Man, play[Man], play, mevent);
				}
				
				if (Ex == play[Man].getX() && Ey == play[Man].getY()){
					text.setText("please Black move");
					chessPlayClick = 1;
				}
				else{
					text.setText("please Red move");
					chessPlayClick = 2;
				}
			}
			// ��ǰû�в�������ֹͣ��˸
			chessManClick = false;
		}
		else{	// ��������
			if (!chessManClick){	// ��һ�ε�������(��˸����)
				for (int i = 0; i < 32; i++){
					// ������������
					if (mevent.getSource().equals(play[i])){
						// �����̣߳���������˸
						Man = i;
						// ��ʼ��˸
						chessManClick = true;
						break;
					}
				}	// for
			} // if
			else if (chessManClick){	// �ڶ��ε�������(����)
				// ��ǰ�޲�����ֹͣ��˸
				chessManClick = false;
				for (i = 0; i < 32; i++){
					// �ҵ����Ե�����	�������
					if (mevent.getSource().equals(play[i])){
						if (chessPlayClick == 2 && play[Man].getName().charAt(1) == '2'){
							Ex = play[Man].getX();
							Ey = play[Man].getY();
							//���Թ���
							if (Man >= 16 && Man < 26){
								rule.armsRule(play[Man], play[i]);
							}
							else if (Man >= 26 && Man < 30){
								rule.cannonRule(1, play[Man], play[i], play, mevent);
							}
							else if (Man >= 4 && Man < 8){
								rule.horseRule(play[Man], play[i], play, mevent);
							}
							else if (Man >= 8 && Man < 12){
								rule.elephantRule(play[Man], play[i], play);
							}
							else if (Man >= 12 && Man < 16){
								rule.chapRule(Man, play[Man], play[i], play);
							}
							else if (Man >= 30 && Man < 32){
								rule.willRule(Man, play[Man], play[i], play);
								play[Man].setVisible(true);
							}
							
							// �Ƿ��ߴ����ӣ�ԭ��δ��
							if (Ex == play[Man].getX() && Ey == play[Man].getY()){
								text.setText(" please Red move");
								chessPlayClick = 2;
								break;
							}
							else {
								text.setText(" please Black move");
								chessPlayClick = 1;
								break;
							}
						} // if
						else if (chessPlayClick == 1 && play[Man].getName().charAt(1) == '1'){
							Ex = play[Man].getX();
							Ey = play[Man].getY();
							
							// ���ӹ���
							if (Man >= 16 && Man < 26){
								rule.armsRule(play[Man], play[i]);
							}
							else if (Man >= 25 && Man < 30){
								rule.cannonRule(0, play[Man], play[i], play, mevent);
							}
							else if (Man >= 0 && Man < 4){
								rule.cannonRule(1, play[Man], play[i], play, mevent);
							}
							else if (Man >= 4 && Man <8){
								rule.horseRule(play[Man], play[i], play, mevent);
							}
							else if (Man >= 8 && Man < 12){
								rule.elephantRule(play[Man], play[i], play);
							}
							else if (Man >= 12 && Man < 16){
								rule.chapRule(Man, play[Man], play[i], play);
							}
							else if (Man >= 30 && Man < 32){
								rule.willRule(Man, play[Man], play[i], play);
								play[Man].setVisible(true);
							}
							
							if (Ex == play[Man].getX() && Ey == play[Man].getY()){
								text.setText(" please Black move");
								chessPlayClick = 1;
								break;
							}
							else{
								text.setText(" please Red move");
								chessPlayClick = 2;
								break;
							}
						}
					} // if
				} // for
				// is victory or not
				if (!play[31].isVisible()){
					JOptionPane.showConfirmDialog(
						this, "Black win", "first player win the game",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE
					);
					// ˫��������������
					chessPlayClick = 3;
					text.setText(" Black win the game");
				}
				else if (!play[30].isVisible()){
					JOptionPane.showConfirmDialog(
						this, "Red win", "second player win the game",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE
					);
					chessPlayClick = 3;
					text.setText(" red win the game");
				}
			} // else
		} // else
	}
	
	public void mousePressed(MouseEvent mevent){
		
	}
	
	public void mouseReleased(MouseEvent mevent){
		
	}
	
	public void mouseEntered(MouseEvent mevent){
		
	}
	
	public void mouseExited(MouseEvent mevent){
		
	}
	
	/*
	 * ���尴ť�¼���Ӧ
	 */
	public void actionPerformed(ActionEvent aevent){
		// restart button
		if (aevent.getSource().equals(anew)){
			int i;
			int k;
			// ������������
			/* black */
			// ��
			for (i = 0, k = 24; i < 2; i++, k += 456){
				play[i].setBounds(k, 56, 55, 55);
			}
			for (i = 4, k = 81; i < 6; i++, k += 342){
				play[i].setBounds(k, 56, 55, 55);
			}
			for (i = 8, k = 138; i < 10; i++, k += 228){
				play[i].setBounds(k, 56, 55, 55);
			}
			for (i = 12, k = 195; i < 14; i++, k += 114){
				play[i].setBounds(k, 56, 55, 55);
			}
			for (i = 16, k = 24; i < 21; i++, k += 114){
				play[i].setBounds(k, 227, 55, 55);
			}
			for (i = 26, k = 81; i < 28; i++, k += 342){
				play[i].setBounds(k, 170, 55, 55);
			}
			play[30].setBounds(252, 56, 55, 55);
			
			/* red */
			for (i = 2, k = 24; i < 4; k += 456){
				play[i].setBounds(k, 569, 55, 55);
			}
			for (i = 6, k = 81; i < 8; i++, k += 342){
				play[i].setBounds(k, 569, 55, 55);
			}
			for (i = 10, k = 138; i < 12; i++, k += 228){
				play[i].setBounds(k, 569, 55, 55);
			}
			for (i = 14, k = 195; i < 16; i++, k += 114){
				play[i].setBounds(k, 569, 55, 55);
			}
			for (i = 21, k = 24; i < 26; i++, k += 114){
				play[i].setBounds(k, 398, 55, 55);
			}
			for (i = 28, k = 81; i < 30; i++, k += 342){
				play[i].setBounds(k, 455, 55, 55);
			}
			play[31].setBounds(252, 569, 55, 55);
			
			chessPlayClick = 2;
			text.setText(" please Red move");
			for (i = 0; i < 32; i++){
				play[i].setVisible(true);
			}
			Var.clear();	// ���vector�е�����
		}
		else if (aevent.getSource().equals(repent)){	// ����
			try{
				// ���setVisible����ֵ
				String str = (String)Var.get(Var.size() - 4);
				int x = Integer.parseInt((String)Var.get(Var.size() - 3));
				int y = Integer.parseInt((String)Var.get(Var.size() - 2));
				int index = Integer.parseInt((String)Var.get(Var.size() - 1));
				// ��������
				play[index].setVisible(true);
				play[index].setBounds(x, y, 55, 55);
				if (play[index].getName().charAt(1) == '1'){
					text.setText(" please Black move");
					chessPlayClick = 1;
				}
				else{
					text.setText(" please Red move");
					chessPlayClick = 2;
				}
				// ɾ��ʹ�ù�������
				Var.remove(Var.size()-4);
				Var.remove(Var.size()-3);
				Var.remove(Var.size()-2);
				Var.remove(Var.size()-1);
				
				// ֹͣ������˸
				chessManClick = false;
			}
			catch (Exception e){
				
			}
		}
		else if (aevent.getSource().equals(showOpen)){	// �����
			try{
				// �򿪶Ի���
				JFileChooser jfcOpen = new JFileChooser("�����");
				int v = jfcOpen.showOpenDialog(this);
				if (v != JFileChooser.CANCEL_OPTION){
					// ɾ������������Ϣ
					Var.removeAllElements();
					FileVar.removeAllElements();
					// ���ļ������������
					FileInputStream fileIn = new FileInputStream(jfcOpen.getSelectedFile());
					ObjectInputStream objIn = new ObjectInputStream(fileIn);
					FileVar = (Vector)objIn.readObject();
					fileIn.close();
					objIn.close();
					// �������ݶ�Ӧ��������
					int k = 0;
					for (int i = 0; i < 32; i++){
						play[i].setBounds(((Integer)FileVar.get(k)).intValue(), ((Integer)FileVar.get(k + 1)).intValue(), 55, 55);
						// ���Ե������Ӳ���ʾ
						if (!((boolean)FileVar.elementAt(k + 2)).booleanValue()){
							play[i].setVisible(false);
						}
						k += 3;
					}
					// ��ǰ���ķ���������
					if (((String)FileVar.lastElement()).toString().equals(" please Red move")){
						text.setText(((String)FileVar.lastElement()).toString());
						chessPlayClick = 2;
					}
					else if (((String)FileVar.lastElement()).toString().equals(" please Black move")){
						text.setText(((String)FileVar.lastElement()).toString());
						chessPlayClick = 1;
					}
					else if (((String)FileVar.lastElement()).toString().substring(5).equals("��")){
						text.setText(((String)FileVar.lastElement()).toString());
						chessPlayClick = 3;
					}
				}
			}
			catch (Exception e){
				System.out.println("Error ShowOpen");
			}
		}
		else if (aevent.getSource().equals(showSave)){	// ���浱ǰ���
			try{
				// ����Ի���
				JFileChooser jfcSave = new JFileChooser("save current chess environment");
				int v = jfcSave.showSaveDialog(this);
				if (v != JFileChooser.CANCEL_OPTION){
					FileVar.removeAllElements();
					// �����������ӵ����꼴�ɼ���
					for (int i = 0; i < 32; i++){
						FileVar.addElement(new Integer(play[i].getX()));
						FileVar.addElement(new Integer(play[i].getY()));
						FileVar.addElement(new Boolean(play[i].isVisible()));
					}
					// ���浱ǰ���ķ�����
					FileVar.add(text.getText());
					// ���浽�ļ�
					FileOutputStream fileOut = new FileOutputStream(jfcSave.getSelectedFile());
					ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
					objOut.writeObject(FileVar);
					objOut.close();
					fileOut.close();
				}
			}
			catch (Exception e){
				System.out.println("Error ShowSave");
			}
		}
		else if (aevent.getSource().equals(exit)){	// �˳�
			int j = JOptionPane.showConfirmDialog(
				this, "is really exited?", "exit",
				JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE
			);
			if (j == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}
}

