#include <iostream>
#include <fstream>
#include <set>
using namespace std;

int main()
{
	ifstream inFile("input.txt");
	ofstream outFile("output.txt");

	if (!inFile.is_open() || !outFile.is_open())
	{
		cout << "Error opening file" << endl;
		return 1;
	}

	set<int> BezPovtorov;
	int number;

	while (inFile >> number)
	{
		BezPovtorov.insert(number);
	}

	long long sum = 0;

	for (int num : BezPovtorov)
	{
		sum += num;
	}

	outFile << sum << endl;

	inFile.close();
	outFile.close();

	return 0;
}