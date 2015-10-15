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


********************************************************/
#include "chessgame.h"

#ifndef __GOBANG__
#define __GOBANG__


struct ChessBoard
{
    int color;  // 0�������ӣ�1������ӣ�2�������
    int sequenceNumbersXX;    // ������: ˮƽ����
    int sequenceNumbersXY;    // ��������45�ȷ���
    int sequenceNumbersYY;    // ����������ֱ����
    int sequenceNumbersYX;    // ��������135�ȷ���
};

class Gobang: public ChessGame
{
private:
    int boardSize;  // ���̴�С
    ChessBoard **board;    // ����

    /*
        ���̸��������ڴ洢��Ϸ����һ��״̬�����ڻ���һ����
        ���߱���ÿһ�����״̬���ļ��У��������ȡ��Ӧ���ļ�����ɾ��
        ��Ϸ����ʱ����ѡ�񱣴���Ϸ��¼��Ĭ��ɾ����Ϸ��¼
    */
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

