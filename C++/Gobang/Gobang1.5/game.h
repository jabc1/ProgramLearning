/*******************************************************
    ��Ϸ�Ļ���

        ��һ������������Ϸ�Ĺ���

        ���У���������о�ʤ����������Ϸ����
        ��ң�����Ϸ�ߣ�һ������һ������Ϊ2��������
        ���棺������Ϸ�ĵ�ǰ״̬
        ��ʼ״̬����Ϸ��ʼ��ʱ�����������״̬
        ���˵�����Ϸ�Ĳ˵�����

        ���ߣ���Ϸ�ĸ�������

********************************************************/

#ifndef __GAME__
#define __GAME__

class Game
{
public:
    // Game();
    // ~Game();
    // ���ֽӿ�һ����
    virtual void gameInitial() = 0;
    virtual void gameMenu() = 0;
    virtual int gameReferee() = 0;
    virtual void gamePlay() = 0;
    virtual void gameShow() = 0;
    virtual void gameUndo() = 0;
};

#endif // __GAME__
