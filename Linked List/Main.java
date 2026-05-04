public class Main {
    public static void main(String[] args) {
        SinglyList<int> myList;
        const int SIZE = 10;


        myList.pushBack(100);
        myList.pushFront(50);
        for(int i = 0; i < SIZE; i++) {
            myList.insert(0, (i + 1) * 5);
        }
        myList.pushBack(120);
        myList.pushFront(30);

        int index = 0, v;
        while(myList.at(index, v) != null){
            System.out.println("Value at index " + index + " is " + v);
            index++;
        }
        System.out.println();
        
    }
}