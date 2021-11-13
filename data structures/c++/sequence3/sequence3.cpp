#include <iostream>
#include "sequence3.h"

using namespace std;

namespace com267_sequence3
{

	sequence::sequence()
	{
		head_ptr = NULL;
		tail_ptr = NULL;
		cursor = NULL;
		precursor = NULL;
		many_nodes = 0;
	}
	sequence::sequence(const sequence& source)
	{
		if (source.cursor == NULL)
		{
			list_copy(source.head_ptr, head_ptr, tail_ptr);
			cursor = NULL;
			precursor = NULL;
		}
		else if (source.many_nodes == 1)
		{
			list_copy(source.head_ptr, head_ptr, tail_ptr);
			cursor = head_ptr;
			precursor = NULL;
		}
		else if (source.many_nodes > 1)
		{
			list_copy(source.head_ptr, head_ptr, tail_ptr);
			precursor = source.precursor;
			cursor = source.cursor;
			if (source.head_ptr == source.cursor) { cursor = head_ptr; }
		}
		many_nodes = source.many_nodes;
	}

	sequence::~sequence()
	{
		list_clear(head_ptr);
		many_nodes = 0;
	}

	void sequence::start()
	{
		if ((head_ptr == NULL) && (tail_ptr == NULL))
		{
			return;
		}
		else
		{
            cursor = head_ptr;
			precursor = NULL;
		}

	}
	void sequence::advance()
	{
		precursor = cursor;
		cursor = cursor->link();
	}
	void sequence::insert(const value_type& entry)//before current item
	{

		if (head_ptr == NULL)
		{
			list_head_insert(head_ptr, entry);
			tail_ptr = head_ptr;
			cursor = head_ptr;
			precursor = NULL;

		}
		else if (cursor == NULL || precursor == NULL)
		{
			list_head_insert(head_ptr, entry);
			cursor = head_ptr;
			precursor = NULL;
		}
		else
		{
			list_insert(precursor, entry);
			cursor = precursor->link();
		}

		many_nodes++;
	}
	void sequence::attach(const value_type& entry)//after current item
	{
		if (head_ptr == NULL)
		{
			list_head_insert(head_ptr, entry);
			tail_ptr = head_ptr;
			cursor = head_ptr;
			precursor = NULL;
		}
		else if (cursor == NULL || cursor == tail_ptr)
		{
			list_insert(tail_ptr, entry);
			precursor = cursor;
			tail_ptr = tail_ptr->link();
			cursor = tail_ptr;
		}
		else
		{
			list_insert(cursor, entry);
			tail_ptr = tail_ptr->link();
			precursor = cursor;
			cursor = cursor->link();
		}
		many_nodes++;
	}
	void sequence::operator =(const sequence& source)
	{
		if (this == &source)
		{
			return;
		}
		if (source.many_nodes == 0)
		{
			list_copy(source.head_ptr, head_ptr, tail_ptr);
			cursor = NULL;
			precursor = NULL;
		}
		else if (source.cursor == source.head_ptr)
		{
			list_copy(source.head_ptr, head_ptr, tail_ptr);
			cursor = head_ptr;
			precursor = NULL;
		}
		else
		{
			list_copy(source.head_ptr, head_ptr, tail_ptr);
			precursor = source.precursor;
			cursor = source.cursor;
		}

		many_nodes = source.many_nodes;
	}
	void sequence::remove_current()
	{
		if (is_item() == true)
		{
			if (cursor == head_ptr)
			{
				if (many_nodes > 1)
				{
					cursor = cursor->link();
					list_head_remove(head_ptr);
				}
				else
				{
					list_head_remove(head_ptr);
					tail_ptr = NULL;
					head_ptr = NULL;
					cursor = NULL;
					precursor = NULL;
				}
			}
			else if (cursor == tail_ptr)
			{
				if (many_nodes > 1)
				{
					node cursorTemp = *precursor->link();
					node *pcursor = NULL;
					list_remove(precursor);
					tail_ptr = precursor;
					*cursor = cursorTemp;
					cursor = pcursor;
					precursor = NULL;
				}
			}
			else
			{
				node cursorTemp = *precursor->link();
				node *pcursor = cursor->link();
				list_remove(precursor);
				*cursor = cursorTemp;
				cursor = pcursor;
			}
			many_nodes--;
		}
	}
	sequence::value_type sequence::current() const
	{
		if (is_item() == true)
			return cursor->data();
	}

}