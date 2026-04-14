package Pranaya.Searching_Algorithms;

public class linearSearch {
    public int linearSearch(int[] array, int target){
        for(var i=0; i<array.length;i++){
            if(array[i] == target) return i;
        }
        return -1;
    }
}


//class example
public static int linearSearch(int[] array records, int searchValue) {
    int size = records.size();
    int position = -1; 



int index = 0;
   for (var i =0; i < size; i++){
       if(records.get(i) > searchValue) break;
       if(searchValue == Arrays[i])
           postion = i;
       return position;
   }
}
return position;
https://github.com/pranayakhadgi/_dsa101.git


///scenario - simulation
//1. put 1000 tandom values, ranindg from 0 - INTO A LIST
//2 AT RANDOM, PICK A VALUE IN TEH RANGE 0-1000 AND, 
//2 1 SEACH FOR THIS VALUE IN HTE LIST
//2.2. COUNT HOW MANY STEPS IT TAKES TO SEAARCH THE VALUE
//3. REPEAT STEP 1 A TOTAL OF 10000 OR MORE TIME 
//4. CALCULATE THE AVVERAGE NUMBER OF STEPS

//>> SIMULATION IZE : 10000
//>> TOTAL TIMES THE VALUE AWAS OUND: 6323
// tOTAL TIMES NOT FOUND "- 3677
//mAXIMUM STEP:1000
    //mINIMUM STEP100
//SIMULATION RESULT : 631.39  (WORST CASE: N/2 CASE)
//GOAL - MORE CASE, LESS EFFICIENCY


