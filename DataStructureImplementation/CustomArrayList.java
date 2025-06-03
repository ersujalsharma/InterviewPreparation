/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
class ArrayListImplementation<T>{
    T arr[];
    int size;
    public ArrayListImplementation(){
        arr = (T[])new Object[10];
        size = 0;
    }
    public void add(T data){
        if(isFull()){
            resize();
        }
        arr[size++] = data;
    }
    public T get(int index){
        if(index>=size || index<0) return null;
        return arr[index];
    }
    public T removeLast(){
        return arr[size--];
    }
    public T removeIndex(int index){
        T temp = arr[index];
        for(int i=index;i<size-1;i++){
            arr[i] = arr[i+1];
        }
        size--;
        return temp;
    }
    public boolean isFull(){
        return arr.length == size;
    }
    public void resize(){
        T temp[] =(T[]) new Object[(int)(arr.length*1.5)];
        for(int i=0;i<arr.length;i++){
            temp[i] = arr[i];
        }
    }
    public String display(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]+",");
        }
        sb.append("]");
        return sb.toString();
    }
}
public class CustomArrayList
{
	public static void main(String[] args) {
		ArrayListImplementation<Integer> arraylist = new ArrayListImplementation<>();
		String val = arraylist.display();
		System.out.println(val);
		arraylist.add(1);
		arraylist.add(2);
// 		arraylist.removeLast();
        arraylist.removeIndex(0);
		String val2 = arraylist.display();
		System.out.println(val2);
	}
}
