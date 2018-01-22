#include <iostream>

using namespace std;

void bubble(int seq[],int size)
{
	for (int i = 0; i < size - 1; i++)
	{
		for (int j = 0; j < size - 1 - i; j++)
		{
			if (seq[j] > seq[j + 1])
			{
				int temp = seq[j];
				seq[j] = seq[j + 1];
				seq[j + 1] = temp;
				cout << endl;
				for (int z = 0; z < size; z++)
				{
					cout << seq[z] << "   ";
				}
			}
		}
	}

}
int main()
{
	int size = 7;
	int seq[] = { 89,45,68,90,29,34,17 };//for example

	cout << "unsorted array: ";
	for (int i = 0; i < 7; i++)
	{
		cout << seq[i] << "   ";
	}
    cout<<"sorting\n";
	bubble(seq, size);

	cout << "\nsorted array: ";
	for (int i = 0; i < 7; i++)
	{
		cout << seq[i] << "   ";
	}
	cout << endl;

	system("pause");
	return 0;

}

