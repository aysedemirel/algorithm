#include <iostream>
#include "sequence2.h"

using namespace std;

namespace com267_sequence2
{
	sequence::sequence(sequence::size_type initial_capacity)
	{
		data = new value_type[initial_capacity+1];
		used = 0;
		capacity = (initial_capacity);
		/*for (sequence::size_type i = 0; i < capacity; i++) //for control
		{
			data[i] = 0;
		}*/
	
	}
	sequence::sequence(const sequence& source)
	{
		data = new value_type[source.capacity];
		used = source.used;
		current_index = source.current_index;
		capacity = source.capacity;
		for (sequence::size_type i = 0; i < capacity; i++)
		{
			data[i] = source.data[i];
		}
	}
	sequence::~sequence()
	{
		delete[] data;
	}
	void sequence::resize(size_type new_capacity)
	{
		value_type *larger;
		if (new_capacity > capacity)
		{
			larger = new value_type[new_capacity+1]; //if i didn't put '+1',test 4 returns false 
			for (size_type i = 0; i < capacity; i++)
			{
				larger[i] = data[i];
			}
			//for (size_type k = capacity; k < new_capacity; k++) //for control
			//	larger[k] = 0;
			delete[] data;
			data = new value_type[new_capacity+1];
			capacity = new_capacity;
			for (size_type j = 0; j < capacity; j++)
			{
				data[j] = larger[j];
			}
		}
	}
	void sequence::start()
	{
		if (current_index!=0)
		{
			current_index = 0;
		}
	}
	void sequence::advance()
	{
		if (is_item() == true)
		{
			current_index++;
		}
	}
	void sequence::insert(const value_type& entry)
	{ 
		if (used == capacity)
		{
			resize(capacity + 2);
		}
		if (used == 0)
		{
			data[0] = entry;
			current_index = 0;
			used++;
		}
		else
		{
			if (current_index==used)
			{
				current_index = 0;
			}
			for (size_type i = used; (i >= current_index)&&(i<=capacity); i--)
			{
				data[i + 1] = data[i];
			}
			data[current_index] = entry;
			used++;
		}
	
	}
	void sequence::attach(const value_type& entry)
	{
		if (used == capacity)
		{
			resize(capacity + 2);
		}
		if (used == 0)
		{
			data[0] = entry;
			current_index = 0;
			used++;
		}
		else
		{
			if(current_index==used)
			{
				data[current_index] = entry;
				used++;
			}
		    else
		    {
			   for (size_type i = used; i > current_index; i--)
			   {
				  data[i + 1] = data[i];
			   }
			   current_index++;
			   data[current_index] = entry;
			   used++;
		    }
		}
	}
	void sequence::remove_current()
	{
		if (is_item() == true)
		{
			for (size_type i = current_index; i < used; i++)
			{
				data[i] = data[i + 1];
			}
			used--;
		}
		else if (current_index == used) //i didn't find a clue about that,so i did current_index=0
		{
			data[current_index] = 0;
			used--;
			current_index = 0;
		}
	}
	void sequence::operator =(const sequence& source)
	{
		if (&source != this)
		{
			if (capacity != source.capacity)
			{
				delete[] data;
				capacity = source.capacity;
				data = new value_type[source.capacity];
			}
			used = source.used;
			current_index = source.current_index;
			for (size_type i = 0; i < capacity; i++)
			{
				data[i] = source.data[i];
			}
		}
	}
	sequence::size_type sequence::size() const
	{
		return used;
	}
	bool sequence::is_item() const
	{
		if ((current_index>=0) && (current_index<used) && (used != 0)) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	sequence::value_type sequence::current() const
	{
		if (is_item())
		{
			return data[current_index];
		}
		else
		{ 
			return 0; //it will return false
		}

	}
}
