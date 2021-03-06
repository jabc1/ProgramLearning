#include "gobang.h"
#include <iostream>
#include <cstdlib>

using namespace std;

void Gobang::gameInitial()
{
    man.init(MAN);
    computer.init(COMPUTER);
    cBoard.init();
    timer = 500000;  // 倒计时方式
}

/*
裁判：
    如果出现连子数大于等于5，则游戏结束，返回相应的棋子颜色，用于判断哪一方胜利
    根据 referee()函数的返回值，确定show()函数输出状态
    禁手检查??????????
*/
int Gobang::gameReferee()
{
    for (int i = 0; i < cBoard.getBoardSize(); i++)
    {
        for (int j = 0; j < cBoard.getBoardSize(); j++)
        {
            // 利用 && 符号的顺序点特性！
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
