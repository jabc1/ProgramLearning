/*
 * Lottery.h
 *
 *  Created on: 2015-9-8
 *      Author: ZKY
 */

#ifndef LOTTERY_H_
#define LOTTERY_H_

// TODO
#include <string>
#include <sstream>
#include <cstdlib>
#include <time.h>

using namespace std;

namespace lotto
{

class Lottery
{
protected:
	int ticketSize;	// ��Ʊ�������Ŀ
	int maxNum;		// ���Ĳ�Ʊ����
	int *generateNumbers();	// ���ݲ�Ʊ�ϵĺ��룬����һ������

public:
	Lottery(int, int);
	virtual ~Lottery();
	virtual string printTicket();	// ������Ʊ��һ���ַ�����ʾ
};

}

#endif /* LOTTERY_H_ */
