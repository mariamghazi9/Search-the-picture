package eg.edu.alexu.csd.datastructure.iceHockey.cs;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class PlayersFinderTest {

	@Test
	void test1() {
		
		String[] Photo=null;
		PlayersFinder Game=new PlayersFinder();
		 assertThrows(NullPointerException.class, ()->{Game.findPlayers(Photo,3,16);});
	}
	
	@Test
	void test2() {
		String [] photo= {"44444H44S4","K444K4L444","4LJ44T44XH","444O4VIF44","44C4D4U444",
				"4V4Y4KB4M4","G4W4HP4O4W","4444ZDQ4S4","4BR4Y4A444","4G4V4T4444"} ;
		
		PlayersFinder Game=new PlayersFinder();
		
		Point [] expected=new Point[6];
		
		for(int i = 0; i < expected.length; i++) {
		    expected[i] = new Point();
		}
        expected[0].x=3;	
        expected[0].y=8;	
        expected[1].x=4;	
        expected[1].y=16;	
        expected[2].x=5;	
        expected[2].y=4;	
        expected[3].x=16;	
        expected[3].y=3;	
        expected[4].x=16;	
        expected[4].y=17;	
        expected[5].x=17;	
        expected[5].y=9;	

		 Point[] output=Game.findPlayers(photo, 4, 16);
		
		 for(int i=0;i<output.length;i++)
	        {
	        	assertEquals(expected[i].x,output[i].x);
	        	assertEquals(expected[i].y,output[i].y);
	   	
	        }


	}
	
}
