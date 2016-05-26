import java.awt.event.MouseEvent;

import javax.swing.JLabel;

/**
 * 
 * @author WY
 * �й����������
 */
class ChessRule{
	// �����ƶ������ڵ��ƶ�����
	public void cannonRule(JLabel play, JLabel playA[], MouseEvent mevent){
		int count = 0;
		// �����ƶ�
		if (play.getX() - mevent.getX() <= 0 && play.getX() - mevent.getX() >= -55){
			for (int i = 56; i <= 571; i += 57){
				// �ƶ�y���꣬�Ƿ���ָ�����������
				if ((i - mevent.getY() >= -27) && (i - mevent.getY() <= 27)){
					// ���е�����
					for (int j = 0; j < 32; j++){
						if ((playA[j].getX() - play.getX() >= -27) &&
							(playA[j].getX() - play.getX() <= 27) &&
							(playA[j].getName() != play.getName()) &&
							playA[j].isVisible()){
								// ����㵽�յ�(������)
							for (int k = play.getY() + 57; k < i; k += 57){
								// ������㣬С���յ�����꣬�Ϳ���֪���м��Ƿ�������
								if (playA[j].getY() < i && playA[j].getY() > play.getY()){
									count++;
									break;
								}
							}// for
							// ����㵽�յ�(���ҵ���)
							for (int k = i + 57; k < play.getY(); k += 57){
								if (playA[j].getY() < play.getY() && playA[j].getY() > i){
									count++;
									break;
								}
							}
						}// if
					}// for
					// �����յ�û�����ӾͿ����ƶ���
					if (count == 0){
						Var.add(String.valueOf(play.isVisible()));
						Var.add(String.valueOf(play.getX()));
						Var.add(String.valueOf(play.getY()));
						Var.add(String.valueOf(Man));
						play.setBounds(play.getX(), i, 55, 55);
						break;
					}
				}// if
			}// for
		}// if
		// �����ƶ�
		else if ((play.getY()-mevent.getY() >= -27) &&
			(play.getY() - mevent.getY() <= 27)){
			// ָ������ģ��X����
			for (int i = 24; i <= 480; i += 57){
				if ((i - mevent.getX() >= -55) && (i - mevent.getX() <= 0)){
					for (int j = 0; j < 32; j++){
						// �ҳ�һ�������ϵ��������ӣ��������Լ�
						if ((playA[j].getY() - play.getY() >= -27) &&
							(playA[j].getY() - play.getY() <= 27) &&
							(playA[j].getName() != play.getName()) &&
							playA[j].isVisible()){
							// ����㵽�յ� ���ϵ���
							for (int k = play.getX() + 57; k < i; k += 57){
								if (playA[j].getX() < i && playA[j].getX() > play.getX()){
									count++;
									break;
								}
							}
							// ����㵽�յ� ���µ���
							for (int k = i + 57; k < play.getX(); k += 57){
								if (playA[j].getX() < play.getX() && playA[j].getX() > i){
									count++;
									break;
								}
							}
						} // if
					} // for
					if (count == 0){
						Var.add(String.valueOf(play.isVisible()));
						Var.add(String.valueOf(play.getX()));
						Var.add(String.valueOf(play.getY()));
						Var.add(String.valueOf(Man));
						play.setBounds(i, play.getY(), 55, 55);
						break;
					}
				} // if
			} // for
		} // else
	} 
	
	// �����ڳ��ӵĹ���
	public void cannonRule(int Chess, JLabel play, JLabel playTake, JLabel playA[], MouseEvent mevent){
		int count = 0;	// ����յ���Ƿ�������
		for (int j = 0; j < 32; j++){
			if ((playA[j].getX() - play.getX() >= -27) && 
				(playA[j].getX() - play.getX() <= 27) &&
				(playA[j].getName() != play.getName()) &&
				playA[j].isVisible()){
				// ���ϵ���
				for (int k = play.getY() + 57; k < playTake.getY(); k += 57){
					if (playA[j].getY() < playTake.getY() && (playA[j].getY() > play.getY())){
						// ���������յ������Ӹ���
						count++;
						break;
					}
				}
				// from bottom to top
				for (int k = playTake.getY(); k < play.getY(); k += 57){
					if (playA[j].getY() < play.getY() && (playA[j].getY() > playTake.getY())){
						count++;
						break;
					}
				}
			}
			else if (playA[j].getY() - play.getY() >= -10 &&
				(playA[j].getY() - play.getY() <= 10) &&
				(playA[j].getName() != play.getName()) &&
				playA[j].isVisible()){
				for (int k = play.getX() + 50; k < playTake.getX(); k += 57){
					if (playA[j].getX() < playTake.getX() && playA[j].getX() > play.getX()){
						count++;
						break;
					}
				}
				for (int k = playTake.getX(); k < play.getX(); k += 57){
					if (playA[i].getX() < play.getX() && playA[j].getX() > playTake.getX()){
						count++;
						break;
					}
				}
			}
		} // for
		if (count == 1 && Chess == 0 && playTake.getName().charAt(1) != play.getName().charAt(1)){
			Var.add(String.valueOf(play.isVisible()));
			Var.add(String.valueOf(play.getX()));
			Var.add(String.valueOf(play.getY()));
			Var.add(String.valueOf(Man));
			
			Var.add(String.valueOf(playTake.getY()));
			Var.add(String.valueOf(i));
			
			playTake.setVisible(false);
			play.setBounds(playTake.getX(), playTake.getY(), 55, 55);
		}
		else if (count == 0 && Chess == 1 && playTake.getName().charAt(1) != play.getName().charAt(1)){
			Var.add(String.valueOf(play.isVisible()));
			Var.add(String.valueOf(play.getX()));
			Var.add(String.valueOf(play.getY()));
			Var.add(String.valueOf(play.Man));
			
			Var.add(String.valueOf(playTake.isVisible()));
			Var.add(String.valueOf(playTake.getX()));
			Var.add(String.valueOf(playTake.getY()));
			Var.add(String.valueOf(i));
			
			playTake.setVisible(false);
			play.setBounds(playTake.getX(), playTake.getY(), 55, 55);
		}
	}
	
	// ����ƶ�����
	public void horseRule(JLabel play, JLabel playA[], MouseEvent mevent){
		// ����������ϰ�  57ҳ
		int Ex = 0;
		int Ey = 0;
		int Move = 0;
		
		// ���ơ����
		if (play.getX() - mevent.getX() >= 2 && 
			play.getX() <= 57 &&
			play.getY() - mevent.getY() >= 87 &&
			play.getY() - mevent.getY() <= 141){
			// �Ϸ���y����
			for (int i = 56; i <= 571; i += 57){
				// �ƶ�y���꣬�Ƿ���ָ�����������
				if (i - mevent.getY() >= -27 && i - mevent.getY() <= 27){
					Ey = i;
					break;
				}
			}
			// �Ϸ���x����
			for (int i = 24; i <= 480; i += 57){
				// �ƶ�x���꣬�Ƿ���ָ�����������
				if (i - mevent.getX() >= -55 && i - mevent.getX() <= 0){
					Ex = i;
					break;
				}
			}
			// ��ǰ���Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == 0) &&
					(play.getY() - playA[i].getY() == 57)){
					Move = 1;
					break;
				}
			}
			// �����ƶ�������
			if (Move == 0){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(play.Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
		} //if
		// ���ơ��ϱ�
		else if (play.getY() - mevent.getY() >= 27 && 
			play.getY() - mevent.getY() <= 86 &&
			(play.getX() - mevent.getX() >= 70) &&
			(play.getX() - mevent.getX() <= 130)){
			// Y
			for (int i = 56; i <= 571; i += 57){
				if (i - mevent.getY() >= -27 && i - mevent.getY() <= 27){
					Ey = i;
					break;
				}
			}
			// X
			for (int i = 24; i <= 480; i += 57){
				if (i - mevent.getX() >= -55 && i - mevent.getX() <= 0){
					Ex = i;
					break;
				}
			}
			// �����Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getY() - playA[i].getY() == 0) &&
					(play.getX() - playA[i].getX() == 57)){
					Move = 1;
					break;
				}
			}
			if (Move == 0){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(play.Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
		} // else
		// ���ơ��ұ�
		else if (play.getY() - mevent.getY() >= -141 && 
			play.getY() - mevent.getY() <= -87 &&
			(play.getX() - mevent.getX() >= -87) &&
			(play.getX() - mevent.getX() <= -2)){
			// Y
			for (int i = 56; i <= 571; i += 57){
				if (i - mevent.getY() >= -27 && i - mevent.getY() <= 27){
					Ey = i;
					break;
				}
			}
			// X
			for (int i = 24; i <= 480; i += 57){
				if (i - mevent.getX() >= -55 && i - mevent.getX() <= 0){
					Ex = i;
					break;
				}
			}
			// ���·��Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getY() - playA[i].getY() == 0) &&
					(play.getX() - playA[i].getX() == -57)){
					Move = 1;
					break;
				}
			}
			if (Move == 0){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(play.Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
		} // else
		// ���ơ��ұ�
		else if (play.getY() - mevent.getY() >= 87 && 
			play.getY() - mevent.getY() <= 141 &&
			(play.getX() - mevent.getX() >= -87) &&
			(play.getX() - mevent.getX() <= -30)){
			// Y
			for (int i = 56; i <= 571; i += 57){
				if (i - mevent.getY() >= -27 && i - mevent.getY() <= 27){
					Ey = i;
					break;
				}
			}
			// X
			for (int i = 24; i <= 480; i += 57){
				if (i - mevent.getX() >= -55 && i - mevent.getX() <= 0){
					Ex = i;
					break;
				}
			}
			// �����Ƿ��б������
			for (int i = 0; i < 32; i++){
				// System.out.println(i + "playA[i].getX()=" + playA[i].getX());
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == 0) &&
					(play.getY() - playA[i].getY() == 57)){
					Move = 1;
					break;
				}
			}
			if (Move == 0){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(play.Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
		} // else
		// ���ơ����
		else if (play.getY() - mevent.getY() >= -141 && 
			play.getY() - mevent.getY() <= -87 &&
			(play.getX() - mevent.getX() >= 10) &&
			(play.getX() - mevent.getX() <= 87)){
			// Y
			for (int i = 56; i <= 571; i += 57){
				if (i - mevent.getY() >= -27 && i - mevent.getY() <= 27){
					Ey = i;
					break;
				}
			}
			// X
			for (int i = 24; i <= 480; i += 57){
				if (i - mevent.getX() >= -55 && i - mevent.getX() <= 0){
					Ex = i;
					break;
				}
			}
			// ���·��Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == 0) &&
					(play.getY() - playA[i].getY() == 57)){
					Move = 1;
					break;
				}
			}
			if (Move == 0){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(play.Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
		} // else
		// ���ơ��ϱ�
		else if (play.getY() - mevent.getY() >= 30 && 
			play.getY() - mevent.getY() <= 87 &&
			(play.getX() - mevent.getX() >= -141) &&
			(play.getX() - mevent.getX() <= -87)){
			// Y
			for (int i = 56; i <= 571; i += 57){
				if (i - mevent.getY() >= -27 && i - mevent.getY() <= 27){
					Ey = i;
					break;
				}
			}
			// X
			for (int i = 24; i <= 480; i += 57){
				if (i - mevent.getX() >= -55 && i - mevent.getX() <= 0){
					Ex = i;
					break;
				}
			}
			// ���ҷ��Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getY() - playA[i].getY() == 0) &&
					(play.getX() - playA[i].getX() == 57)){
					Move = 1;
					break;
				}
			}
			if (Move == 0){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(play.Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
		} // else
		// ���ơ��±�
		else if (play.getY() - mevent.getY() >= -87 && 
			play.getY() - mevent.getY() <= -30 &&
			(play.getX() - mevent.getX() >= -141) &&
			(play.getX() - mevent.getX() <= -87)){
			// Y
			for (int i = 56; i <= 571; i += 57){
				if (i - mevent.getY() >= -27 && i - mevent.getY() <= 27){
					Ey = i;
					break;
				}
			}
			// X
			for (int i = 24; i <= 480; i += 57){
				if (i - mevent.getX() >= -55 && i - mevent.getX() <= 0){
					Ex = i;
					break;
				}
			}
			// �����Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getY() - playA[i].getY() == 0) &&
					(play.getX() - playA[i].getX() == 57)){
					Move = 1;
					break;
				}
			}
			if (Move == 0){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(play.Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
		} // else
		// ���ơ��±�
		else if (play.getY() - mevent.getY() >= -87 && 
			play.getY() - mevent.getY() <= -30 &&
			(play.getX() - mevent.getX() >= 87) &&
			(play.getX() - mevent.getX() <= 141)){
			// Y
			for (int i = 56; i <= 571; i += 57){
				if (i - mevent.getY() >= -27 && i - mevent.getY() <= 27){
					Ey = i;
					break;
				}
			}
			// X
			for (int i = 24; i <= 480; i += 57){
				if (i - mevent.getX() >= -55 && i - mevent.getX() <= 0){
					Ex = i;
					break;
				}
			}
			// �����Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getY() - playA[i].getY() == 0) &&
					(play.getX() - playA[i].getX() == 57)){
					Move = 1;
					break;
				}
			}
			if (Move == 0){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(play.Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
		} // else
	}
	
	// ��������
	public void horseRule(JLabel play, JLabel playTake, JLabel playA[], MouseEvent mevent){
		int Move = 0;	// �ϰ�
		boolean Chess = false;
		// ���ơ����
		if (play.getName().charAt(1) != playTake.getName().charAt(1) &&
			(play.getX() - playTake.getX() == 57) &&
			(play.getY() - playTake.getY() == 114)){
			// ��ǰ���Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == 0) &&
					(play.getY() - playA[i].getY() == 57)){
					Move = 1;
					break;
				}
			}
			Chess = true;
		} // if
		// ���ơ��ҳ�
		else if (play.getName().charAt(1) != playTake.getName().charAt(1) &&
			(play.getX() - playTake.getX() == -57) &&
			(play.getY() - playTake.getY() == 114)){
			// ��ǰ���Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == 0) &&
					(play.getY() - playA[i].getY() == 57)){
					Move = 1;
					break;
				}
			}
			Chess = true;
		} // else if
		// ���ơ��ϳ�
		else if (play.getName().charAt(1) != playTake.getName().charAt(1) &&
			(play.getX() - playTake.getX() == 114) &&
			(play.getY() - playTake.getY() == 57)){
			// �����Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == 57) &&
					(play.getY() - playA[i].getY() == 0)){
					Move = 1;
					break;
				}
			}
			Chess = true;
		} // else if
		// ���ơ��³�
		else if (play.getName().charAt(1) != playTake.getName().charAt(1) &&
			(play.getX() - playTake.getX() == 114) &&
			(play.getY() - playTake.getY() == -57)){
			// �����Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == 57) &&
					(play.getY() - playA[i].getY() == 0)){
					Move = 1;
					break;
				}
			}
			Chess = true;
		} // else if
		// ���ơ��ϳ�
		else if (play.getName().charAt(1) != playTake.getName().charAt(1) &&
			(play.getX() - playTake.getX() == -114) &&
			(play.getY() - playTake.getY() == 57)){
			// ���ҷ��Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == -57) &&
					(play.getY() - playA[i].getY() == 0)){
					Move = 1;
					break;
				}
			}
			Chess = true;
		} // else if
		// ���ơ��³�
		else if (play.getName().charAt(1) != playTake.getName().charAt(1) &&
			(play.getX() - playTake.getX() == -114) &&
			(play.getY() - playTake.getY() == -57)){
			// ���ҷ��Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == -57) &&
					(play.getY() - playA[i].getY() == 0)){
					Move = 1;
					break;
				}
			}
			Chess = true;
		} // else if
		// ���ơ����
		else if (play.getName().charAt(1) != playTake.getName().charAt(1) &&
			(play.getX() - playTake.getX() == 57) &&
			(play.getY() - playTake.getY() == -114)){
			// ���·��Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == 0) &&
					(play.getY() - playA[i].getY() == -57)){
					Move = 1;
					break;
				}
			}
			Chess = true;
		} // else if
		// ���ơ��ҳ�
		else if (play.getName().charAt(1) != playTake.getName().charAt(1) &&
			(play.getX() - playTake.getX() == -57) &&
			(play.getY() - playTake.getY() == -114)){
			// ���·��Ƿ��б������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == 0) &&
					(play.getY() - playA[i].getY() == 57)){
					Move = 1;
					break;
				}
			}
			Chess = true;
		} // else if
		
		// û���ϰ������Գ���
		if (Chess && Move == 0 && playTake.getName().charAt(1) != play.getName().charAt(1)){
			Var.add(String.valueOf(play.isVisible()));
			Var.add(String.valueOf(play.getX()));
			Var.add(String.valueOf(play.getY()));
			Var.add(String.valueOf(Man));
			
			Var.add(String.valueOf(playTake.isVisible()));
			Var.add(String.valueOf(playTake.getX()));
			Var.add(String.valueOf(playTake.getY()));
			Var.add(String.valueOf(i));
			
			playTake.setVisible(false);
			play.setBounds(playTake.getX(), playTake.getY(), 55, 55);
		}
	}
	// ����ƶ�����
	public void elephantRule(int Man, JLabel play, JLabel playA[], MouseEvent mevent){
		int Ex = 0;
		int Ey = 0;
		int Move = 0;
		// ����
		if (play.getX() - mevent.getX() <= 141 &&
			(play.getX() - mevent.getX() >= 87) &&
			(play.getY() - mevent.getY() <= 141) &&
			(play.getY() - mevent.getY() >= 87)){
			// Y �Ϸ�����
			for (int i = 56; i < 571; i += 57){
				if ((i - mevent.getY() >= -27) && (i - mevent.getY() <= 27)){
					Ey = i;
					break;
				}
			}
			// X �Ϸ�����
			for (int i = 24; i <= 480; i += 57){
				if ((i - mevent.getX() >= -27) && (i - mevent.getX() <= 27)){
					Ex = i;
					break;
				}
			}
			// ���Ϸ��Ƿ�������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() && 
					(play.getX() - playA[i].getX() == 57) &&
					(play.getY() - playA[i].getY() == 57)){
					Move = 1;
					break;
				}
			}
			// ���岻�ܹ����Ӻ���
			if (Move == 0 && Ey >= 341 && Man > 9){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				// System.out.println("Ex = " + Ex);
				// System.out.println("Ey = " + Ey);
				
				play.setBounds(Ex, Ey, 55, 55);
			}
			// ���岻�ܹ����Ӻ���
			else if (Move == 0 && Ey <= 284 && Man < 10){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
		} // if
		// ����
		else if (play.getX() - mevent.getX() <= -87 &&
			(play.getX() - mevent.getX() >= -141) &&
			(play.getY() - mevent.getY() <= 141) &&
			(play.getY() - mevent.getY() >= 87)){
			// Y �Ϸ�����
			for (int i = 56; i < 571; i += 57){
				if ((i - mevent.getY() >= -27) && (i - mevent.getY() <= 27)){
					Ey = i;
					break;
				}
			}
			// X �Ϸ�����
			for (int i = 24; i <= 480; i += 57){
				if ((i - mevent.getX() >= -27) && (i - mevent.getX() <= 27)){
					Ex = i;
					break;
				}
			}
			// ���Ϸ��Ƿ�������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() && 
					(play.getX() - playA[i].getX() == -57) &&
					(play.getY() - playA[i].getY() == 57)){
					Move = 1;
					break;
				}
			}
			// ���岻�ܹ����Ӻ���
			if (Move == 0 && Ey >= 341 && Man > 9){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				// System.out.println("Ex = " + Ex);
				// System.out.println("Ey = " + Ey);
				
				play.setBounds(Ex, Ey, 55, 55);
			}
			// ���岻�ܹ����Ӻ���
			else if (Move == 0 && Ey <= 284 && Man < 10){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
		} // else if
		// ����
		else if (play.getX() - mevent.getX() <= 141 &&
			(play.getX() - mevent.getX() >= 87) &&
			(play.getY() - mevent.getY() <= -87) &&
			(play.getY() - mevent.getY() >= -141)){
			// Y �Ϸ�����
			for (int i = 56; i < 571; i += 57){
				if ((i - mevent.getY() >= -27) && (i - mevent.getY() <= 27)){
					Ey = i;
					break;
				}
			}
			// X �Ϸ�����
			for (int i = 24; i <= 480; i += 57){
				if ((i - mevent.getX() >= -27) && (i - mevent.getX() <= 27)){
					Ex = i;
					break;
				}
			}
			// �����Ƿ�������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() && 
					(play.getX() - playA[i].getX() == 57) &&
					(play.getY() - playA[i].getY() == -57)){
					Move = 1;
					break;
				}
			}
			// ���岻�ܹ����Ӻ���
			if (Move == 0 && Ey >= 341 && Man > 9){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
			// ���岻�ܹ����Ӻ���
			else if (Move == 0 && Ey <= 284 && Man < 10){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
		} // else if
		// ����
		else if (play.getX() - mevent.getX() <= -87 &&
			(play.getX() - mevent.getX() >= -141) &&
			(play.getY() - mevent.getY() <= -87) &&
			(play.getY() - mevent.getY() >= -141)){
			// Y �Ϸ�����
			for (int i = 56; i < 571; i += 57){
				if ((i - mevent.getY() >= -27) && (i - mevent.getY() <= 27)){
					Ey = i;
					break;
				}
			}
			// X �Ϸ�����
			for (int i = 24; i <= 480; i += 57){
				if ((i - mevent.getX() >= -27) && (i - mevent.getX() <= 27)){
					Ex = i;
					break;
				}
			}
			// ���ҷ��Ƿ�������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() && 
					(play.getX() - playA[i].getX() == -57) &&
					(play.getY() - playA[i].getY() == -57)){
					Move = 1;
					break;
				}
			}
			// ���岻�ܹ����Ӻ���
			if (Move == 0 && Ey >= 341 && Man > 9){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				// System.out.println("Ex = " + Ex);
				// System.out.println("Ey = " + Ey);
				
				play.setBounds(Ex, Ey, 55, 55);
			}
			// ���岻�ܹ����Ӻ���
			else if (Move == 0 && Ey <= 284 && Man < 10){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(Ex, Ey, 55, 55);
			}
		} // else if
	}
	
	// ��������
	public void elephantRule(JLabel play, JLabel playTake, JLabel playA[]){
		int Move = 0;
		boolean Chess = false;
		// �����Ϸ�������
		if (play.getX() - playTake.getX() >= 87 && 
			(play.getX() - playTake.getX() <= 141) && 
			(play.getY() - playTake.getY() >= 87) &&
			(play.getY() - playTake.getY() <= 141)){
			// ���Ϸ��Ƿ�������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == 57) &&
					(play.getY() - playA[i].getY() == 57)){
					Move = 1;
					break;
				}
			}
			Chess = true;
		}
		// �����Ϸ�������
		else if (play.getX() - playTake.getX() >= -141 && 
			(play.getX() - playTake.getX() <= -87) && 
			(play.getY() - playTake.getY() >= 87) &&
			(play.getY() - playTake.getY() <= 141)){
			// ���Ϸ��Ƿ�������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == -57) &&
					(play.getY() - playA[i].getY() == 57)){
					Move = 1;
					break;
				}
			}
			Chess = true;
		}
		// �����󷽵�����
		else if (play.getX() - playTake.getX() >= 87 && 
			(play.getX() - playTake.getX() <= 141) && 
			(play.getY() - playTake.getY() >= -141) &&
			(play.getY() - playTake.getY() <= -87)){
			// �����Ƿ�������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == 57) &&
					(play.getY() - playA[i].getY() == -57)){
					Move = 1;
					break;
				}
			}
			Chess = true;
		}
		// �����ҷ�������
		else if (play.getX() - playTake.getX() >= -141 && 
			(play.getX() - playTake.getX() <= -87) && 
			(play.getY() - playTake.getY() >= -141) &&
			(play.getY() - playTake.getY() <= -87)){
			//���ҷ��Ƿ�������
			for (int i = 0; i < 32; i++){
				if (playA[i].isVisible() &&
					(play.getX() - playA[i].getX() == -57) &&
					(play.getY() - playA[i].getY() == -57)){
					Move = 1;
					break;
				}
			}
			Chess = true;
		}
		// ���ϰ����Ҳ��ܳ��Լ�������
		if (Chess && Move == 0 && playTake.getName().charAt(1) != play.getName().charAt(1)){
			Var.add(String.valueOf(play.isVisible()));
			Var.add(String.valueOf(play.getX()));
			Var.add(String.valueOf(play.getY()));
			Var.add(String.valueOf(Man));
			
			Var.add(String.valueOf(playTake.isVisible()));
			Var.add(String.valueOf(playTake.getX()));
			Var.add(String.valueOf(playTake.getY()));
			Var.add(String.valueOf(i));
			
			playTake.setVisible(false);
			play.setBounds(playTake.getX(), playTake.getY(), 55, 55);
			
		}
	}
	
	// ʿ���ƶ�����
	public void chapRule(int Man, JLabel play, JLabel playA[], MouseEvent mevent){
		// up right
		if (mevent.getX() - play.getX() >= 29 &&
			(mevent.getX() - play.getX() <= 114) &&
			(mevent.getY() - play.getY() >= -90) &&
			(mevent.getY() - play.getY() <= -25)){
			// ʿ���ܳ����Լ��Ľ���
			if (Man < 14 &&
				(play.getX() + 57 >= 195) &&
				(play.getX() + 57 <= 309) &&
				(play.getY() - 57 <= 170)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX() + 57, play.getY() - 57, 55, 55);
			}
			// ʿ���ܳ����Լ��Ľ���
			if (Man > 13 &&
				(play.getX() + 57 >= 195) &&
				(play.getX() + 57 <= 309) &&
				(play.getY() - 57 >= 455)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX() + 57, play.getY() - 57, 55, 55);
			}
		} // else if
		// up left
		else if (mevent.getX() - play.getX() >= -114 &&
			(mevent.getX() - play.getX() <= -25) &&
			(mevent.getY() - play.getY() >= -95) &&
			(mevent.getY() - play.getY() <= -20)){
			// ʿ���ܳ����Լ��Ľ���
			if (Man < 14 &&
				(play.getX() - 57 >= 195) &&
				(play.getX() - 57 <= 309) &&
				(play.getY() - 57 <= 170)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX() - 57, play.getY() - 57, 55, 55);
			}
			// ʿ���ܳ����Լ��Ľ���
			if (Man > 13 &&
				(play.getX() - 57 >= 195) &&
				(play.getX() - 57 <= 309) &&
				(play.getY() - 57 >= 455)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX() + 57, play.getY() - 57, 55, 55);
			}
		} // else if
		// down left
		else if (mevent.getX() - play.getX() >= -114 &&
			(mevent.getX() - play.getX() <= -20) &&
			(mevent.getY() - play.getY() >= 2) &&
			(mevent.getY() - play.getY() <= 87)){
			// ʿ���ܳ����Լ��Ľ���
			if (Man < 14 &&
				(play.getX() - 57 >= 195) &&
				(play.getX() - 57 <= 309) &&
				(play.getY() + 57 <= 170)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX() - 57, play.getY() + 57, 55, 55);
			}
			// ʿ���ܳ����Լ��Ľ���
			if (Man > 13 &&
				(play.getX() - 57 >= 195) &&
				(play.getX() - 57 <= 309) &&
				(play.getY() + 57 >= 455)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX() - 57, play.getY() + 57, 55, 55);
			}
		} // else if
		// down right
		else if (mevent.getX() - play.getX() >= 27 &&
			(mevent.getX() - play.getX() <= 114) &&
			(mevent.getY() - play.getY() >= 2) &&
			(mevent.getY() - play.getY() <= 87)){
			// ʿ���ܳ����Լ��Ľ���
			if (Man < 14 &&
				(play.getX() + 57 >= 195) &&
				(play.getX() + 57 <= 309) &&
				(play.getY() + 57 <= 170)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX() + 57, play.getY() + 57, 55, 55);
			}
			// ʿ���ܳ����Լ��Ľ���
			if (Man > 13 &&
				(play.getX() + 57 >= 195) &&
				(play.getX() + 57 <= 309) &&
				(play.getY() + 57 >= 455)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX() + 57, play.getY() + 57, 55, 55);
			}
		} // else if
	}
	
	// ʿ�������
	public void chapRule(int Man, JLabel play, JLabel playTake, JLabel playA[]){
		boolean Chap = false;
		// up right
		if ((play.getX() - playTake.getX() <= -20) &&
			(play.getX() - playTake.getX() >= -114) &&
			(play.getY() - playTake.getY() <= 87) &&
			(play.getY() - playTake.getY() >= 2)){
			if (Man < 14 &&
				(playTake.getX() >= 195) &&
				(playTake.getX() <= 309) &&
				(playTake.getY() <= 170) &&
				(playTake.isVisible())){
				Chap = true;
			}
			else if (Man > 13 &&
				(playTake.getX() >= 195) &&
				(playTake.getX() <= 309) &&
				(playTake.getY() >= 455) &&
				playTake.isVisible()){
				Chap = true;
			}
		}
		// up left
		else if ((play.getX() - playTake.getX() <= 114) &&
			(play.getX() - playTake.getX() >= 25) &&
			(play.getY() - playTake.getY() <= 87) &&
			(play.getY() - playTake.getY() >= 2)){
			if (Man < 14 &&
				(playTake.getX() >= 195) &&
				(playTake.getX() <= 309) &&
				(playTake.getY() <= 170) &&
				(playTake.isVisible())){
				Chap = true;
			}
			else if (Man > 13 &&
				(playTake.getX() >= 195) &&
				(playTake.getX() <= 309) &&
				(playTake.getY() >= 455) &&
				playTake.isVisible()){
				Chap = true;
			}
		}
		// down left
		else if ((play.getX() - playTake.getX() <= 114) &&
			(play.getX() - playTake.getX() >= 25) &&
			(play.getY() - playTake.getY() <= -2) &&
			(play.getY() - playTake.getY() >= -87)){
			if (Man < 14 &&
				(playTake.getX() >= 195) &&
				(playTake.getX() <= 309) &&
				(playTake.getY() <= 170) &&
				(playTake.isVisible())){
				Chap = true;
			}
			else if (Man > 13 &&
				(playTake.getX() >= 195) &&
				(playTake.getX() <= 309) &&
				(playTake.getY() >= 455) &&
				playTake.isVisible()){
				Chap = true;
			}
		}
		// down right
		else if ((play.getX() - playTake.getX() <= -25) &&
			(play.getX() - playTake.getX() >= -114) &&
			(play.getY() - playTake.getY() <= -2) &&
			(play.getY() - playTake.getY() >= -87)){
			if (Man < 14 &&
				(playTake.getX() >= 195) &&
				(playTake.getX() <= 309) &&
				(playTake.getY() <= 170) &&
				(playTake.isVisible())){
				Chap = true;
			}
			else if (Man > 13 &&
				(playTake.getX() >= 195) &&
				(playTake.getX() <= 309) &&
				(playTake.getY() >= 455) &&
				playTake.isVisible()){
				Chap = true;
			}
		}
		// ���ƶ������ܳ��Լ�������
		if (Chap && playTake.getName().charAt(1) != play.getName().charAt(1)){
			Var.add(String.valueOf(play.isVisible()));
			Var.add(String.valueOf(play.getX()));
			Var.add(String.valueOf(play.getY()));
			Var.add(String.valueOf(Man));
			
			Var.add(String.valueOf(playTake.isVisible()));
			Var.add(String.valueOf(playTake.getX()));
			Var.add(String.valueOf(playTake.getY()));
			Var.add(String.valueOf(i));
			
			playTake.setVisible(false);
			play.setBounds(playTake.getX(), playTake.getY(), 55, 55);
		}
	}
	
	// �����ƶ�����
	public void willRule(int Man, JLabel play, JLabel playA[], MouseEvent mevent){
		// up
		if (play.getX() - mevent.getX() <= 0 &&
			(play.getX() - mevent.getX() >= -55) &&
			(play.getY() - mevent.getY() <= 87) &&
			(play.getY() - mevent.getY() >= 2)){
			// ���Ƿ񳬳��Լ��Ľ���
			if (Man == 30 &&
				(mevent.getX() <= 359) &&
				(mevent.getX() >= 195) &&
				(mevent.getY() <= 170)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));

				play.setBounds(play.getX(), play.getY() - 57, 55, 55);
			}
			else if (Man == 31 &&
				(mevent.getX() <= 359) &&
				(mevent.getX() >= 195) &&
				(mevent.getY() >= 455)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX(), play.getY() - 57, 55, 55);
			}
		}
		// left
		if (play.getX() - mevent.getX() <= 57 &&
			(play.getX() - mevent.getX() >= 2) &&
			(play.getY() - mevent.getY() <= 27) &&
			(play.getY() - mevent.getY() >= -27)){
			// ���Ƿ񳬳��Լ��Ľ���
			if (Man == 30 &&
				(mevent.getX() <= 359) &&
				(mevent.getX() >= 195) &&
				(mevent.getY() <= 170)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));

				play.setBounds(play.getX() - 57, play.getY(), 55, 55);
			}
			else if (Man == 31 &&
				(mevent.getX() <= 359) &&
				(mevent.getX() >= 195) &&
				(mevent.getY() >= 455)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX() - 57, play.getY(), 55, 55);
			}
		}
		// right
		if (play.getX() - mevent.getX() <= -57 &&
			(play.getX() - mevent.getX() >= -112) &&
			(play.getY() - mevent.getY() <= 27) &&
			(play.getY() - mevent.getY() >= -27)){
			// ���Ƿ񳬳��Լ��Ľ���
			if (Man == 30 &&
				(mevent.getX() <= 359) &&
				(mevent.getX() >= 195) &&
				(mevent.getY() <= 170)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));

				play.setBounds(play.getX() + 57, play.getY(), 55, 55);
			}
			else if (Man == 31 &&
				(mevent.getX() <= 359) &&
				(mevent.getX() >= 195) &&
				(mevent.getY() >= 455)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX() + 57, play.getY(), 55, 55);
			}
		}
		// down
		if (play.getX() - mevent.getX() <= 0 &&
			(play.getX() - mevent.getX() >= -55) &&
			(play.getY() - mevent.getY() <= -27) &&
			(play.getY() - mevent.getY() >= -87)){
			// ���Ƿ񳬳��Լ��Ľ���
			if (Man == 30 &&
				(mevent.getX() <= 359) &&
				(mevent.getX() >= 195) &&
				(mevent.getY() <= 170)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));

				play.setBounds(play.getX(), play.getY() + 57, 55, 55);
			}
			else if (Man == 31 &&
				(mevent.getX() <= 359) &&
				(mevent.getX() >= 195) &&
				(mevent.getY() >= 455)){
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX(), play.getY() + 57, 55, 55);
			}
		}
	}
	
	// ��˧���ӹ���
	public void willRule(int Man, JLabel play, JLabel playTake, JLabel playA[]){
		boolean will = false;
		// ���ϳ�
		if ((play.getX() - playTake.getX() <= 55) &&
			(play.getX() - playTake.getX() >= 0 ) &&
			(play.getY() - playTake.getY() <= 87) &&
			(play.getY() - playTake.getY() >= 27) &&
			playTake.isVisible()){
			if (Man == 30 && 
				(playTake.getX() <= 309) &&
				(playTake.getX() >= 195) &&
				(playTake.getY() <= 170)){
				will = true;
			}
			else if (Man == 31 && 
				(playTake.getX() <= 309) &&
				(playTake.getX() >= 195) &&
				(playTake.getY() >= 455)){
				will = true;
			}
		}
		// �����
		else if ((play.getX() - playTake.getX() <= 57) &&
			(play.getX() - playTake.getX() >= 2 ) &&
			(play.getY() - playTake.getY() <= 27) &&
			(play.getY() - playTake.getY() >= -27) &&
			playTake.isVisible()){
			if (Man == 30 && 
				(playTake.getX() <= 309) &&
				(playTake.getX() >= 195) &&
				(playTake.getY() <= 170)){
				will = true;
			}
			else if (Man == 31 && 
				(playTake.getX() <= 309) &&
				(playTake.getX() >= 195) &&
				(playTake.getY() >= 455)){
				will = true;
			}
		}
		// ���ҳ�
		else if ((play.getX() - playTake.getX() <= -2) &&
			(play.getX() - playTake.getX() >= -57 ) &&
			(play.getY() - playTake.getY() <= 27) &&
			(play.getY() - playTake.getY() >= -27) &&
			playTake.isVisible()){
			if (Man == 30 && 
				(playTake.getX() <= 309) &&
				(playTake.getX() >= 195) &&
				(playTake.getY() <= 170)){
				will = true;
			}
			else if (Man == 31 && 
				(playTake.getX() <= 309) &&
				(playTake.getX() >= 195) &&
				(playTake.getY() >= 455)){
				will = true;
			}
		}
		// ���³�
		else if ((play.getX() - playTake.getX() <= 0) &&
			(play.getX() - playTake.getX() >= -87) &&
			(play.getY() - playTake.getY() <= -40) &&
			(play.getY() - playTake.getY() >= -27) &&
			playTake.isVisible()){
			if (Man == 30 && 
				(playTake.getX() <= 309) &&
				(playTake.getX() >= 195) &&
				(playTake.getY() <= 170)){
				will = true;
			}
			else if (Man == 31 && 
				(playTake.getX() <= 309) &&
				(playTake.getX() >= 195) &&
				(playTake.getY() >= 455)){
				will = true;
			}
		}
		if (playTake.getName().charAt(1) != play.getName().charAt(1) && will){
			Var.add(String.valueOf(play.isVisible()));
			Var.add(String.valueOf(play.getX()));
			Var.add(String.valueOf(play.getY()));
			Var.add(String.valueOf(Man));
			
			Var.add(String.valueOf(playTake.isVisible()));
			Var.add(String.valueOf(playTake.getX()));
			Var.add(String.valueOf(playTake.getY()));
			Var.add(String.valueOf(i));
			
			playTake.setVisible(false);
			play.setBounds(playTake.getX(), playTake.getY(), 55, 55);
		}
	}
	
	// �����ƶ�����
	public void armsRule(int Man, JLabel play, MouseEvent mevent){
		if (Man < 21){	// ��������
			// �����ƶ�
			if ((mevent.getY() - play.getY()) > 27 &&
				(mevent.getY() - play.geyY()) < 86 &&
				(mevent.getX() - play.getX()) < 55 &&
				(mevent.getX() - play.getX()) > 0){
				// ��ǰ��¼��ӵ����ϣ����ڻ���
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				play.setBounds(play.getX(), play.getY() + 57, 55, 55);
			}
			// �����ƶ����������
			else if (play.getY() > 284 &&
				(mevent.getX() - play.getX()) >= 57 &&
				(mevent.getX() - play.getX()) <= 112){
				play.setBounds(play.getX() + 57, play.geyY(), 55, 55);
			}
			// �����ƶ����������
			else if (play.getY() > 284 &&
				(play.getX() - mevent.getX()) >= 2 &&
				(play.getX() - mevent.getX()) <= 58){
				// ģ������
				play.setBounds(play.getX() - 57, play.getY(), 55, 55);
			}
		}
		else{	// �������
			// ��ǰ��¼��ӵ����ϣ����ڻ���
			Var.add(String.valueOf(play.isVisible()));
			Var.add(String.valueOf(play.getX()));
			Var.add(String.valueOf(play.getY()));
			Var.add(String.valueOf(Man));
			play.setBounds(play.getX(), play.getY() + 57, 55, 55);
			// �����ƶ�
			if ((mevent.getX() - play.getX()) >= 0 &&
				(mevent.getX() - play.getX()) <= 55 &&
				(play.getY() - mevent.getY()) > 27 &&
				(play.getY() - mevent.getY()) < 86){
				play.setBounds(play.getX(), play.getY() - 57, 55, 55);
			}
			// �����ƶ����������
			else if (play.getY() <= 341 &&
				(mevent.getX() - play.getX()) >= 57 &&
				(mevent.getX() - play.getX()) <= 112){
				play.setBounds(play.getX() + 57, play.geyY(), 55, 55);
			}
			// �����ƶ����������
			else if (play.getY() <= 341 &&
				(play.getX() - mevent.getX()) >= 3 &&
				(play.getX() - mevent.getX()) <= 58){
				// ģ������
				play.setBounds(play.getX() - 57, play.getY(), 55, 55);
			}
		}
	}
	
	// ��������
	public void armsRule(JLabel play1, JLabel play2){
		// ����
		if ((play2.getX() - play1.getX()) <= 112 &&
			(play2.getX() - play1.getX()) >= 57 &&
			(play1.getY() - play2.getY()) < 22 &&
			(play1.getY() - play2.getY()) > -22 &&
			play2.isVisible() &&
			play1.getName().charAt(1) != play2.getName().charAt(1)){
			// ������Ӳ������Ƴ���
			if (play1.getName().charAt(1) == '1' &&
				play1.getY() > 284 && 
				play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				// �ѶԷ���λ�ø��Լ�
				play1.setBounds(play2.getX(), play2.getY(), 55, 55);
			}
			// ������Ӳ������Ƴ���
			else if (play1.getName().charAt(1) == '2' &&
				play1.getY() < 341 && 
				play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				play1.setBounds(play2.getX(), play2.getY(), 55, 55);
			}
		}
		// ����
		else if ((play1.getX() - play2.getX()) <= 112 &&
			(play1.getX() - play2.getX()) >= 57 &&
			(play1.getY() - play2.getY()) < 22 && 
			(play1.getY() - play2.getY()) > -22 &&
			play2.isVisible() &&
			play1.getName().charAt(1) != play2.getName().charAt(1)){
			if (play1.getName().charAt(1) == '1' &&
				play1.getY() > 284 &&
				play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				play1.setBounds(play2.getX(), play2.getY(), 55, 55);
			}
			else if (play1.getName().charAt(1) == '2' && 
				play1.getY() < 341 &&
				play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				play1.setBounds(play2.getX(), play2.getY(), 55, 55);
			}
		}
		// ������
		else if (play1.getX() - play2.getX() >= -22 &&
			play1.getX() - play2.getX() <= 22 &&
			play1.getY() - play2.getY() >= -112 &&
			play1.getY() - play2.getY() <= 112){
			// ���䲻�����ϳ���
			if (play1.getName().charAt(1) == '1' &&
				play1.getY() < play2.getY() &&
				play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				play1.setBounds(play2.getX(), play2.getY(), 55, 55);
			}
			// ����������³���
			else if (play1.getName().charAt(1) == '2' &&
				play1.getY() > play2.getY() &&
				play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				play1.setBounds(play2.getX(), play2.getY(), 55, 55);
			}
		}
		// ��ǰ��¼��ӵ��������ڻ���
		Var.add(String.valueOf(play1.isVisible()));
		Var.add(String.valueOf(play1.getX()));
		Var.add(String.valueOf(play1.getY()));
		Var.add(String.valueOf(Man));
		// ��ǰ��¼��ӵ��������ڻ���
		Var.add(String.valueOf(play2.isVisible()));
		Var.add(String.valueOf(play2.getX()));
		Var.add(String.valueOf(play2.getY()));
		Var.add(String.valueOf(i));
	}// ��Խ���
}
