/*******************************************************
    五子棋实现的辅助类

        棋盘类的成员函数实现：

********************************************************/

#include <iostream>
#include <cstdlib>
#include "chessboard.h"
#include "globalcontent.h"

ChessBoard::ChessBoard(int n)
{
    BOARDSIZE = n;  // 设置棋盘大小

    numPieces = 0;

    pBoard = new ChessPieces*[BOARDSIZE];
    for (int i = 0; i < BOARDSIZE; i++)
    {
        pBoard[i] = new ChessPieces[BOARDSIZE];
    }
}

ChessBoard::~ChessBoard()
{
    std::cout << "board\n";
    for (int i = 0; i < BOARDSIZE; i++)
    {
        delete [] pBoard[i];
    }
    delete [] pBoard;
}

void ChessBoard::init()
{
    for (int i = 0; i < BOARDSIZE; i++)
    {
        for (int j = 0; j < BOARDSIZE; j++)
        {
            pBoard[i][j].init();
        }
    }
    numPieces = 0;
}


void ChessBoard::setPieces(int x, int y, int color)
{
    pBoard[x][y].setColor(color);
    numPieces++;
}


int ChessBoard::getBoardSize(void)
{
    return BOARDSIZE;
}

void ChessBoard::showBoard()
{
    // 特殊字符：┼ ┽ ┾┿╀╁╂╃╄╅╆╇╈╉╊╋  〇○●
    system("cls");
    using namespace std;

    cout << "\tWelcome to chess!\n";
    cout << "\n\t************************************************\n\n";
    for (int i = 0; i < BOARDSIZE; i++)
    {
        cout << "\t";
        for (int j = 0; j < BOARDSIZE; j++)
        {
            if (pBoard[i][j].getColor() == BLANK)
            {
                cout << "┼";
            }
            else if (pBoard[i][j].getColor() == BLACK)
            {
                cout << "●";
            }
            else
            {
                cout << "○";
            }
        }
        cout << endl;
    }
    cout << "\n\t************************************************\n\n";
}

bool ChessBoard::fullBoard()
{
    return numPieces == 14 * 14;
}



