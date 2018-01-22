#include <iostream>

using namespace std;

void selection(int seq[],int size)
{
	for (int i = 0; i < size-1; i++)
	{
		int min = i;
		for (int j = i + 1; j < size ; j++)
		{
			if (seq[j] < seq[min])
			{
				min = j;
			}
		}
		int temp = seq[i];
		seq[i] = seq[min];
		seq[min] = temp;

		cout << endl;
		for (int z = 0; z < size; z++)
		{
			cout << seq[z] << "   ";
		}
	}
}

int main()
{
	int size = 7;
	int seq[] = { 89,45,68,90,29,34,17 };

	cout << "unsorted array: ";
	for (int i = 0; i < 7; i++)
	{
		cout << seq[i] << "   ";
	}

	selection(seq, size);

	cout << "\nsorted array: ";
	for (int i = 0; i < 7; i++)
	{
		cout << seq[i] << "   ";
	}
	cout << endl;

	system("pause");
	return 0;
}
