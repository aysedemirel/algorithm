#include <iostream>

using namespace std;

void sequential(int seq[],int s)
{
	int i = 0 ;
	
	while (seq[i] != s)
		i++;

	if (i < 10)
		cout << "founded " << i+1 << ". member\n";
	else
		cout << "there is no "<<s<<" in the array\n";
	
}
int main()
{
	int seq[] = { 56,3,249,518,7,26,98,651,23,9 };
	int searching = 3;

	cout << searching<<": searching in array.....\n";

	sequential(seq, searching);

	system("pause");
	return 0;

}

