/*******************************************************
    ��������

        ��һ�����󣺼̳���������Ϸ�Ĺ���
        �ڶ���������������Ϸ������

            ���̴�С��14*14 (������ѡ��)
            ���ӣ��ڰ�ɫ����
            ˫�˶���

            ��Ϸ����
                һ��һ�����������Ϸ��ӣ����ӱ����ڿ�λ����
                ��ĳһɫ�������д��ڵ���5��������һ����(�ᡢ�����Խ���)�ϵ�ʱ����ʤ��
                ���ֱ����н��֣�ƽ����������

        ��һ�ο�ܸĽ���2015-10-15 �������ȫ��

********************************************************/

#include "chessgame.h"
#include "boardandpieces.h"

#ifndef __GOBANG__
#define __GOBANG__

class Gobang: public ChessGame
{
private:
    ChessBoard cBoard;
    int timer;   // ��ʱ
    Player man;
    Player computer;

public:
    int gameReferee();
    void gamePlay();
    void gameShow()
    {
        show();
    }
    void show();
    void gameInitial();
    void gameUndo();
    void chessGameManage();
};


#endif // __GOBANG__

/***********************************************************************************
#include "chessgame.h"

#ifndef __GOBANG__
#define __GOBANG__

enum eColor{BLACK, WHITE, GRAY};

class ChessPieces
{
private:
    static int amount;  // �ܵ�������
    static int usedAmout;   // �Ѿ�ʹ��������
    eColor color;
    int shape;
    int psize;      // ���Ӵ�С

public:
    ChessPieces()
    {
        color = GRAY;
        usedAmout++;
    }

    static void init(int amounts)
    {
        amount = amounts;
        usedAmout = 0;
    }

    void setColor(int color)
    {
        this->color = (eColor)color;
    }

    eColor getColor(void)   // ʹ�õ�ʱ��int()ǿ������ת�����ɣ�
    {
        return color;
    }
};

class ChessBoard
{
    // ��������һ��һ���ĵ���ɵģ���˲������̾���
private:
    ChessPieces pieces;         // �����ϵ�����
    int sequenceNumbersXX;      // ������: ˮƽ����
    int sequenceNumbersXY;      // ��������45�ȷ���
    int sequenceNumbersYY;      // ����������ֱ����
    int sequenceNumbersYX;      // ��������135�ȷ���
public:
    ChessBoard()
    {
        board = new int*[BSIZE];
        for (int i = 0; i < BSIZE; i ++)
        {
            board[i] = new int[BSIZE];
        }
    }
    ~ChessBoard()
    {
        for (int i = 0; i < BSIZE; i ++)
        {
            delete [] board[i];
        }
        delete [] board;
    }

    void init()
    {
        // ����ģʽ���ѳ�ʼ�����������⣡
        pieces.init();
    }
};

class Gobang: public ChessGame
{
private:
    int boardSize;  // ���̴�С
    ChessBoard **board;    // ���̾���

    ************************************************************************
        ���̸��������ڴ洢��Ϸ����һ��״̬�����ڻ���һ����
        ���߱���ÿһ�����״̬���ļ��У��������ȡ��Ӧ���ļ�����ɾ��
        ��Ϸ����ʱ����ѡ�񱣴���Ϸ��¼��Ĭ��ɾ����Ϸ��¼
    ************************************************************************
    ChessBoard **boardCopy;    // ���̸���

public:
    Gobang(int );
    ~Gobang();
    int referee();
    void player();
    void show();
    void initial();
    void retract();
};


#endif // __GOBANG__


************************************************************************************/
