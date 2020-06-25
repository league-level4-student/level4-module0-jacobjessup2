//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

public class TheWrongWayCow {

    public static int[] findWrongWayCow(final char[][] field) {
        // Fill in the code to return the x,y coordinate position of the
        // head (letter 'c') of the wrong way cow!
    	int forward = 0;
    	int[] forarr = new int[2];
    	int f1 = 0;
    	int f2 = 0;
    	int back = 0;
    	int[] backarr = new int[2];
    	int b1 = 0;
    	int b2 = 0;
    	int up = 0;
    	int[] uparr = new int[2];
    	int u1 = 0;
    	int u2 = 0;
    	int down = 0;
    	int[] downarr = new int[2];
    	int d1 = 0;
    	int d2 = 0;
        for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if(i < field.length-2  && ("" + field[i][j] + field[i+1][j] + field[i+2][j]).equals("cow")) {
					forward++;
					f1 = j;
					f2 = i;
				}
				if(i > 2 && ("" + field[i][j] + field[i-1][j] + field[i-2][j]).equals("cow")) {
					back++;
					b1 = j;
					b2 = i;
				}
				if(j < field[i].length-2 && ("" + field[i][j] + field[i][j+1] + field[i][j+2]).equals( "cow")) {
					up++;
					u1 = j;
					u2 = i;
				}
				if(j > 2 && ("" + field[i][j] + field[i][j-1] + field[i][j-2]).equals( "cow")) {
					down++;
					d1 = j;
					d2 = i;
					
				}
			}
		}
        if(forward == 1) {
        	forarr[0] = f1;
        	forarr[1] = f2;
        	return forarr;
        }
        else if(back == 1) {
        	backarr[0] = b1;
        	backarr[1] = b2;
        	return backarr;
        }
        else if(up == 1) {
        	uparr[0] = u1;
        	uparr[1] = u2;
        	return uparr;
        }
        else if(down == 1) {
        	downarr [0] = d1;
        	downarr [1] = d2;
        	return downarr;
        }
        return null;
    }
}
