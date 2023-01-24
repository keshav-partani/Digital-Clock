#include <iostream>
using namespace std;

class Stack
{
    private:
    int top = -1;
    int length;
    int arr[100];

    public:
    Stack(int l){
        length = l; 
    }

    
    bool isEmpty()
    {
        if (top == -1)
        {
            return true;
        }
        return false;
    }

    bool isFull()
    {
        if (top == length-1){
            return true;
        }
        return false;
    }

    void push(int data){
        if(!isFull()){
            top = top + 1;
            arr[top] = data;
        }
        else{
            cout<<"Stack is full"<<endl;
        }
    }

    int pop(){
        if(!isEmpty()){
            top = top - 1;
            return arr[top];
        }
        else{
            cout<<"Stack is Empty"<<endl;
        }
        return 0;
    }

    void print(){
        for (int i = 0; i <= top; i++)
        {
            cout<<arr[i];
        }
        
    }
};

int main(){
    Stack s1(5);
    s1.push(5);
    s1.push(4);
    s1.push(3);
    s1.push(2);
    s1.push(1);
    s1.push(6);
    s1.print();
    return 0;
}