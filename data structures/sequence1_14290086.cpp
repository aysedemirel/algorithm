#include <iostream>   //for control
#include "sequence1.h" 

using namespace std; //for control

namespace com267_sequence 
{
    sequence::sequence()
    {
        used=0;
        //current_index=0;  /*start() is doing same thing and attach,insert are doing this,too*/
        for(sequence::size_type i=0;i<CAPACITY;i++) //for control
        {
            data[i]=0;
        }
    }
  
    sequence::size_type sequence::size() const
    {
       return used;
    }
 
    bool sequence::is_item() const
    {
       if((current_index<used) && (current_index>=0) && (current_index<CAPACITY) && (used!=0))
           return true;
       else 
           return false;
    }

    sequence::value_type sequence::current() const
    {
         if(is_item()==true)
             return data[current_index];
    }

    void sequence::start()
    {
        if(current_index!=0)
            current_index=0;
    }

    void sequence::advance()
    {
       if(is_item()==true)
       {
              current_index++;
       }
    }

    void sequence::insert(const value_type& entry)
    {
        if(used==0)
        {
            data[0]=entry;
            current_index=0; //start()
            used++;
        }
        else if((used+1)<CAPACITY)
        {
             if(data[current_index]==0)
             {
                 current_index=0; 
             }
    
             for(sequence::size_type i=used;(i>=current_index) && (i<CAPACITY);i--)
             {
                  data[i+1]=data[i];
             }
             data[current_index]=entry;
             if(used+1<CAPACITY)
                 used++;
        }        

    } 

    void sequence::attach(const value_type& entry)
    {
         if(used==0)
        {
            data[0]=entry;
            current_index=0; //start()
            used++;
        }
         else if((used+1)<CAPACITY)
         {
              if(data[current_index]==0)
              {
                   data[current_index]=entry;
                   if((used+1)<CAPACITY)
                     used++;
              }
              else
              {
                   for(sequence::size_type i=used;i>current_index && i<CAPACITY;i--)
                   {
                        data[i+1]=data[i];
                   }
                   current_index++;
                   data[current_index]=entry;
                   if((used+1)<CAPACITY)
                      used++;
            }
         }
         else if((used+1)>=CAPACITY)
         {
             if(data[current_index])
               {
                data[current_index+1]=entry;
                used++;
               }
         }
    }
     
    void sequence::remove_current()
    {
        if(is_item()==true)
        {
            for(sequence::size_type i=current_index;i<used;i++)
            {
               data[i]=data[i+1];
            }
            used--;
        }

    }


}
