/*******************************************************
    ������Ϸ�Ļ���

        ��һ�����󣺼̳�����Ϸ�Ĺ���
        �ڶ�������������Ϸ�Ĺ���

            ����
            ����
            ��Ϊ���ģ��������෽
            �ɻ���

********************************************************/
#include "game.h"

#ifndef __CHESSGAME__
#define __CHESSGAME__

class ChessGame: public Game
{
public:
    // ChessGame();
    // ~ChessGame();
    void gameMenu()
    {
        chessGameMenu();
    }
    void chessGameMenu();

    virtual void chessGameManage() = 0;
};

#endif // __CHESSGAME__
