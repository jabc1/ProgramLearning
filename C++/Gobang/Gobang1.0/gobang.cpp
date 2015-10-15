#include "gobang.h"
#include <iostream>
#include <cstdlib>

using namespace std;

Gobang::Gobang(int n)
{
    boardSize = n;

    board = new ChessBoard*[boardSize];
    for (int i = 0; i < boardSize; i++)
    {
        board[i] = new ChessBoard[boardSize];
    }
}

Gobang::~Gobang()
{
    for (int i = 0; i < boardSize; i++)
    {
        delete[] board[i];
    }
    delete[] board;
}

/*
���У�
    ����������������ڵ���5������Ϸ������������Ӧ��������ɫ�������ж���һ��ʤ��
    ���� referee()�����ķ���ֵ��ȷ��show()�������״̬
    ���ּ��??????????
*/
int Gobang::referee()
{
    for (int i = 0; i < boardSize; i++)
    {
        for (int j = 0; j < boardSize; j++)
        {
            if (board[i][j].color == 0)
            {
                continue;
            }

            if (board[i][j].sequenceNumbersXX >= 5 || board[i][j].sequenceNumbersXY >= 5 || board[i][j].sequenceNumbersYY >= 5 || board[i][j].sequenceNumbersYX >= 5)
            {
                // ֱ�ӷ��أ���������
                return board[i][j].color;
            }
        }
    }

    return 0;
}


void Gobang::player()
{
    //
}

void Gobang::show()
{
    system("cls");
    cout << "\n\n\n";

    for (int i = 0; i < boardSize; i++)
    {
        cout << endl;
        for (int j = 0; j < boardSize; j++)
        {
            cout << "     ";
            // �����ַ����� �� ���������������  �����

            if (board[i][j].color == 0)
            {
                cout << "��";
            }
            else if (board[i][j].color == 1)
            {
                cout << "��";
            }
            else
            {
                cout << "��";
            }
        }
    }
}

void Gobang::initial()
{
    for (int i = 0; i < boardSize; i++)
    {
        for (int j = 0; j < boardSize; j++)
        {
            board[i][j].color = 0;
            board[i][j].sequenceNumbersXX = 0;
            board[i][j].sequenceNumbersXY = 0;
            board[i][j].sequenceNumbersYY = 0;
            board[i][j].sequenceNumbersYX = 0;
        }
    }
}

void Gobang::retract()
{
    //
}
