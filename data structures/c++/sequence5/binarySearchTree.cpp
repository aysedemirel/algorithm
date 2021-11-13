#include <iostream>
#include <cstdlib>
using namespace std;

class BinarySearchTree
{
  private:
   struct tree_node
   {
     tree_node* left;
     tree_node* right;
     int data;
   };
   tree_node* root;
  public:
   BinarySearchTree()
   {
     root = NULL;
   }
   bool isEmpty() const { return root==NULL; }
   void print_inorder();
   void inorder(tree_node*);
   void insert(int);
   void remove(int);
};
void BinarySearchTree::insert(int d)
{ 
    tree_node* temp = new tree_node;
    tree_node* parent;
    temp->data = d;
    temp->left = NULL;
    temp->right = NULL;
    parent = NULL;
    tree_node* nw;
    
    if(isEmpty()) root = temp;    // if it is empty
    else
    {
        nw = root;
        //if it is bigger than current data,insert right
        //if it is smaller than current data,insert left
        while(nw)
        {
            parent = nw;
            if(temp->data > nw->data)   
                nw = nw->right;
            else 
                nw = nw->left;                 
        }

        if(temp->data < parent->data)
           parent->left = temp;
        else
           parent->right = temp;
    }
}
void BinarySearchTree::remove(int d)
{
    bool fnd = false;
    if(isEmpty())
    {
        cout<<" This Tree is empty! "<<endl;
        return;
    }
    
    tree_node* nw;
    tree_node* parent;
    nw = root;
    if(d==root->data)
    {
        if(root->left==NULL && root->right==NULL)
        { 
            root=NULL;
            return;
        }
        if(root->right==NULL && root->left!=NULL)
        { 
           root=root->left;
           return;
        }
        if((nw->right)->left != NULL)
        {
           tree_node* lnw;
           tree_node* lnwp;
           lnwp = nw->right;
           lnw = (nw->right)->left;
           while(lnw->left != NULL)
           {
              lnwp = lnw;
              lnw = lnw->left;
           }
	   root->data = lnw->data;
           delete lnw;
           lnwp->left = NULL;
        }
        else
        {
               tree_node* tmp;
               tmp = nw->right;
               root->data = tmp->data;
	       root->right = tmp->right;
               delete tmp;
        }
        return;
    }
    while(nw != NULL)
    {
         if(nw->data == d) //data is founded
         {
            if(root->left==NULL && root->right==NULL)
            { 
               root=NULL;
               return;
            }
            fnd = true;
            break;
         }
         else
         {
             parent = nw;
             if(d > nw->data) nw = nw->right;
             else nw = nw->left;
         }
    }
    if(!fnd)  //if data was not founded(fnd==false)
    {
        cout<<" Data not found! "<<endl;
        return;
    }
  
    if((nw->left == NULL && nw->right != NULL)|| (nw->left != NULL && nw->right == NULL))
    {
       if(nw->left == NULL && nw->right != NULL)
       {
           if(parent->left == nw)
           {
             parent->left = nw->right;
             delete nw;
           }
           else
           {
             parent->right = nw->right;
             delete nw;
           }
       }
       else 
       {
          if(parent->left == nw)
           {
             parent->left = nw->left;
             delete nw;
           }
           else
           {
             parent->right = nw->left;
             delete nw;
           }
       }
     return;
    }
    if( nw->left == NULL && nw->right == NULL)
    {
        if(parent->left == nw) parent->left = NULL;
        else parent->right = NULL;
        delete nw;
	return;
    }

    if (nw->left != NULL && nw->right != NULL)
    {
        tree_node* cp;
        cp = nw->right;
        if((cp->left == NULL) && (cp->right == NULL))
        {
            nw = cp;
            delete cp;
            nw->right = NULL;
        }
        else
        {
            if((nw->right)->left != NULL)
            {
                tree_node* lnw;
                tree_node* lnwp;
                lnwp = nw->right;
                lnw = (nw->right)->left;
                while(lnw->left != NULL)
                {
                   lnwp = lnw;
                   lnw = lnw->left;
                }
		nw->data = lnw->data;
                delete lnw;
                lnwp->left = NULL;
           }
           else
           {
               tree_node* tmp;
               tmp = nw->right;
               nw->data = tmp->data;
	       nw->right = tmp->right;
               delete tmp;
           }

       }
       return;
    }

}
void BinarySearchTree::print_inorder()
{
  inorder(root);
}
void BinarySearchTree::inorder(tree_node* p)
{
  /*
    if(p!=NULL)
    {
      inorder(p->left);
      cout<<p->data;
      inorder(p->right);
    }
    */
    if(p != NULL)
    {
        if(p->left) inorder(p->left);
        cout<<" "<<p->data<<" ";
        if(p->right) inorder(p->right);
    }
    else return;
}
int main()
{
  BinarySearchTree b;
  int ch,tmp,tmp1;
  while(1)
  {
    cout<<endl<<endl;
    cout<<" Binary Search Tree Operations "<<endl;
    cout<<" ----------------------------- "<<endl;
    cout<<" 1. Insertion/Creation "<<endl;
    cout<<" 2. In-Order Traversal "<<endl;
    cout<<" 3. Removal "<<endl;
    cout<<" 4. Exit "<<endl;
    cout<<" Enter your choice : ";
    cin>>ch;
    switch(ch)
    {
       case 1 : cout<<" Enter Number to be inserted : ";
                cin>>tmp;
                b.insert(tmp);
                break;
       case 2 : cout<<endl;
                cout<<" In-Order Traversal "<<endl;
                cout<<" -------------------"<<endl;
                b.print_inorder();
                break;
       case 3 : cout<<" Enter data to be deleted : ";
                cin>>tmp1;
                b.remove(tmp1);
                break;
       case 4 : system("pause");
                return 0;
                break;
    }
  }
}
