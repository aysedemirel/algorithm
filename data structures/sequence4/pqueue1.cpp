#include "pqueue1.h"
#include <iostream>

using namespace std;

//functions for using in PriorityQueue
void l_head_insert(Node*& head_ptr, const PriorityQueue::Item& entry, unsigned int priority)
{
	Node *temp = new Node();
	temp->data = entry;
	temp->link = head_ptr;
	temp->priority = priority;
	head_ptr = temp;
	//head_ptr = new node(entry, head_ptr,priority);
}
void l_insert(Node* previous_ptr, const PriorityQueue::Item& entry, unsigned int priority)
{
	Node *insert_ptr = new Node();
	insert_ptr->data = entry;
	insert_ptr->link = previous_ptr->link;
	insert_ptr->priority = priority;
	//insert_ptr = new Node(entry, previous_ptr->link, priority);
	previous_ptr->link = insert_ptr;
}
void l_copy(const Node* source_ptr, Node*& head_ptr, Node*& tail_ptr)
{
	head_ptr = NULL;
	tail_ptr = NULL;

	if (source_ptr == NULL)
		return;

	l_head_insert(head_ptr, source_ptr->data, source_ptr->priority);
	tail_ptr = head_ptr;

	source_ptr = source_ptr->link;
	while (source_ptr != NULL)
	{
		l_insert(tail_ptr, source_ptr->data, source_ptr->priority);
		tail_ptr = tail_ptr->link;
		source_ptr = source_ptr->link;
	}
}
void l_head_remove(Node*& head_ptr)
{
	Node *remove_ptr;

	remove_ptr = head_ptr;
	head_ptr = head_ptr->link;
	delete remove_ptr;
}
void l_clear(Node*& head_ptr)
{
	while (head_ptr != NULL)
		l_head_remove(head_ptr);
}

//PriorityQueue's functions
PriorityQueue::PriorityQueue()
{
	head_ptr = NULL;
	many_nodes = 0;
}
PriorityQueue::PriorityQueue(PriorityQueue& source)
{
	if (this != &source)
	{
		Node *temp;
		l_copy(source.head_ptr, head_ptr, temp);
		many_nodes = source.many_nodes;
	}
}
PriorityQueue::~PriorityQueue()
{
	while (head_ptr != NULL)
	{
		Node *remove_ptr;

		remove_ptr = head_ptr;
		head_ptr = head_ptr->link;
		delete remove_ptr;
	}
}
void PriorityQueue::operator=(const PriorityQueue& source)
{
	if (this != &source)
	{
		Node *temp;
		l_clear(head_ptr);
		head_ptr = NULL;
		many_nodes = 0;
		l_copy(source.head_ptr, head_ptr, temp);
		many_nodes = source.many_nodes;
	}
}
void PriorityQueue::insert(const Item& entry, unsigned int priority)
{

	Node *tmp, *q;
	tmp = new Node();
	tmp->data = entry;
	tmp->priority = priority;
	if (head_ptr == NULL || priority > head_ptr->priority)
	{
		tmp->link = head_ptr;
		head_ptr = tmp;
	}
	else
	{
		q = head_ptr;
		while (q->link != NULL && q->link->priority >= priority)
			q = q->link;
		tmp->link = q->link;
		q->link = tmp;
	}
	many_nodes++;
}
PriorityQueue::Item PriorityQueue::get_front()
{

	Node *tmp;
	Node t;
	if (head_ptr == NULL)
		cout << "Queue Underflow\n";
	else
	{
		tmp = head_ptr;
		t.data = tmp->data;
		head_ptr = head_ptr->link;
		delete tmp;
		many_nodes--;
	}
	return t.data;

}
size_t PriorityQueue::size() const
{
	return many_nodes;
}
bool PriorityQueue::is_empty() const
{
	if (head_ptr == NULL) return true;
	return false;
}