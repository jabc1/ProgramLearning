/*******************************************************
    ������ʵ�ֵĸ�����

        ��һ�ο�ܸĽ���2015-10-15 �������ȫ��
        ���ж��󶼴���һ���࣬�����������
        ��ǿ���ݵķ�װ��������Ϣ

        ���ӵ�������һ����
        ���̴���һ����
        ��Ҵ���һ����

        ���ʵ���������ͨ�ţ���������

********************************************************/

#ifndef __BOARDANDPIECES__
#define __BOARDANDPIECES__

enum eColor{BLANK, BLACK, WHITE};

class ChessPieces
{
private:
    //static int amount;  // �ܵ�������
    //static int usedAmout;   // �Ѿ�ʹ��������
    eColor color;
    //int shape;
    //int psize;      // ���Ӵ�С
    const int NUMBERS = 4;
    int* lianzishu;           // ��������0��45��90��135�ȷ���

public:
    ChessPieces()
    {
        color = BLANK;
        lianzishu = new int[NUMBERS];
    }

    ~ChessPieces()
    {
        delete [] lianzishu;
    }

    void init()
    {
        color = BLANK;
        for (int i = 0; i < NUMBERS; i++)
        {
            lianzishu[i] = 0;
        }
    }

    void setColor(int color)
    {
        this->color = (eColor)color;
    }

    eColor getColor(void)   // ʹ�õ�ʱ��int()ǿ������ת�����ɣ�
    {
        return color;
    }

    void setLianzishu(int nums, int site)
    {
        lianzishu[site] = nums;
    }

    int getLianzishu(int site)
    {
        return lianzishu[site];
    }

    int getMaxLianzishu()
    {
        int maxnums = 0;
        for (int i = 0; i < NUMBERS; i++)
        {
            if (maxnums < lianzishu[i])
            {
                maxnums = lianzishu[i];
            }
        }
        return maxnums;
    }
};



class ChessBoard
{
    // ��������һ��һ���ĵ���ɵģ���˲������̾���,����˼·���ã�����̫�࣬���̲���˻��������ӣ�һ��һ����
    // ���̾������Ӿ�����һ��������ʾΪ���̣�Ԫ�������ӣ�������ʾ���ӵĹ���

public:
    const int BOARDSIZE = 14;
    ChessPieces **pBoard;       // ����

    ChessBoard()
    {
        pBoard = new ChessPieces*[BOARDSIZE];
        for (int i = 0; i < BOARDSIZE; i++)
        {
            pBoard[i] = new ChessPieces[BOARDSIZE];
        }
    }

    ~ChessBoard()
    {
        for (int i = 0; i < BOARDSIZE; i++)
        {
            delete [] pBoard[i];
        }
        delete [] pBoard;
    }

    ChessBoard& operator = (const ChessBoard &board)
    {
        pBoard = board.pBoard;
        return *this;
    }

    void init()
    {
        for (int i = 0; i < BOARDSIZE; i++)
        {
            for (int j = 0; j < BOARDSIZE; j++)
            {
                pBoard[i][j].init();
            }
        }
    }

    int getBoardSize(void)
    {
        return BOARDSIZE;
    }

    void showBoard()
    {
        // // �����ַ����� �� ���������������  �����
        // system("cls");
        for (int i = 0; i < BOARDSIZE; i++)
        {
            for (int j = 0; j < BOARDSIZE; j++)
            {
                if (pBoard[i][j].getColor() == BLANK)
                {
                 //   cout << "+";
                }
                else if (pBoard[i][j].getColor() == BLACK)
                {

                }
                else
                {

                }
            }
            //cout << "\n";
        }
    }
};

enum status{COMPUTER, MAN};

class Player
{
private:
    status identity;   // ������

public :
    void init(int identity)
    {
        this->identity = (status)identity;
    }

    void play(ChessBoard cb)
    {
        if (identity == COMPUTER)
        {
            computerPlay(cb);
        }
        else
        {
            manPlay(cb);
        }
    }

    // ��˾Ϳ���ʵ������������ϲ����ˣ�
    void computerPlay(ChessBoard cb)
    {
        //TODO
    }

    void manPlay(ChessBoard cb)
    {
        // TODO
    }

};


#endif // __BOARDANDPIECES__

