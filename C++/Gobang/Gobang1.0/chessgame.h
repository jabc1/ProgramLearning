/*******************************************************
    ������Ϸ�Ļ���

        ��һ�����󣺼̳�����Ϸ�Ĺ���
        �ڶ�������������Ϸ�Ĺ���

            ����
            ����
            ��Ϊ����
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
    virtual int referee() = 0;
    virtual void player() = 0;
    virtual void show() = 0;
    virtual void initial() = 0;
    void menu();
};

#endif // __CHESSGAME__
