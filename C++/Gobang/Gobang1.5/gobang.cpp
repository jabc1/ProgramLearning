#include "gobang.h"
#include <iostream>
#include <cstdlib>

using namespace std;

void Gobang::gameInitial()
{
    man.init(MAN);
    computer.init(COMPUTER);
    cBoard.init();
    timer = 500000;  // ����ʱ��ʽ
}

/*
���У�
    ����������������ڵ���5������Ϸ������������Ӧ��������ɫ�������ж���һ��ʤ��
    ���� referee()�����ķ���ֵ��ȷ��show()�������״̬
    ���ּ��??????????
*/
int Gobang::gameReferee()
{
    for (int i = 0; i < cBoard.getBoardSize(); i++)
    {
        for (int j = 0; j < cBoard.getBoardSize(); j++)
        {
            // ���� && ���ŵ�˳������ԣ�
            if (cBoard.pBoard[i][j].getColor() != 0 && cBoard.pBoard[i][j].getMaxLianzishu() >= 5)
            {
                return cBoard.pBoard[i][j].getColor();
            }
        }
    }

    return 0;
}


void Gobang::gamePlay()
{
    computer.play(cBoard, 1);
    man.play(cBoard, 2);
}

void Gobang::show()
{
    system("cls");
    cout << "\n\n\n";
    cBoard.showBoard();
}

void Gobang::gameUndo()
{
    //
}

void Gobang::chessGameManage()
{
    gameInitial();
    gameMenu();
    gameShow();

}
