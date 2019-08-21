//package ruvindhu;
//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.fail;
//import java.util.List;
//import org.junit.Test;
//public class TestCases {
//
//
//	@Test public void test01() {
//
//		String output =
//
//				"00|KKKKKK...BBBBBB...CCCCCC\n" +
//						"01|KKKKKK...BBBBBB...CCCCCC\n" +
//						"02|KKKKKK...BBBBBB...CCCCCC\n" +
//						"03|KKKKKK...BBBBB^...CCCCCC\n" +
//						"04|KKKKKK...^BBBBB...CCCCCC\n" +
//						"05|KKKK^K...BB^B^B...^CCCCC\n" +
//						"06|........................\n" +
//						"07|........................\n" +
//						"08|DDDDDD............IIIIII\n" +
//						"09|DDDDDD....XXXX....^IIIII\n" +
//						"10|DDDDDD....XXXX....IIIIII\n" +
//						"11|DDDDD^....XXXX....IIIIII\n" +
//						"12|DDDDDD....XXXX..........\n" +
//						"13|DDDDDD....XXXX..........\n" +
//						"14|DDDDDD....XXXX....YYYYYY\n" +
//						"15|DDDD^D............^YYYYY\n" +
//						"16|..................YYYYYY\n" +
//						"17|........................\n" +
//						"18|........................\n" +
//						"19|LLLLL^...HH^^HH...SSSSSS\n" +
//						"20|LLLLLL...HHHHHH...SSSSSS\n" +
//						"21|LLLLLL...HHHHHH...^SSSSS\n" +
//						"22|LLLLLL...HHHHHH...SSSSSS\n" +
//						"23|LLLLLL...HHHHHH...SSSSSS\n" +
//						"24|LLLLLL...HHHHHH...SSSSSS\n" ;
//
//		Board b = new Board();
//		b.initialiseBoard();
//
//		assertEquals(b.drawBoard(),output);
//
//	}
//
//	// placing a player in the board
//	@Test public void test02() {
//
//		Board b = new Board();
//		b.initialiseBoard();
//		Position p = new Position(24,6);
//		Character s = new Character("Miss_Scarlet" ,"s", p);
//		Player c = new Player(s,p);		
//		b.getBoard()[24][8].setOccupied(c);
//
//		String output =
//
//				"00|KKKKKK...BBBBBB...CCCCCC\n" +
//						"01|KKKKKK...BBBBBB...CCCCCC\n" +
//						"02|KKKKKK...BBBBBB...CCCCCC\n" +
//						"03|KKKKKK...BBBBB^...CCCCCC\n" +
//						"04|KKKKKK...^BBBBB...CCCCCC\n" +
//						"05|KKKK^K...BB^B^B...^CCCCC\n" +
//						"06|........................\n" +
//						"07|........................\n" +
//						"08|DDDDDD............IIIIII\n" +
//						"09|DDDDDD....XXXX....^IIIII\n" +
//						"10|DDDDDD....XXXX....IIIIII\n" +
//						"11|DDDDD^....XXXX....IIIIII\n" +
//						"12|DDDDDD....XXXX..........\n" +
//						"13|DDDDDD....XXXX..........\n" +
//						"14|DDDDDD....XXXX....YYYYYY\n" +
//						"15|DDDD^D............^YYYYY\n" +
//						"16|..................YYYYYY\n" +
//						"17|........................\n" +
//						"18|........................\n" +
//						"19|LLLLL^...HH^^HH...SSSSSS\n" +
//						"20|LLLLLL...HHHHHH...SSSSSS\n" +
//						"21|LLLLLL...HHHHHH...^SSSSS\n" +
//						"22|LLLLLL...HHHHHH...SSSSSS\n" +
//						"23|LLLLLL...HHHHHH...SSSSSS\n" +
//						"24|LLLLLL..sHHHHHH...SSSSSS\n" ;
//
//		assertEquals(b.drawBoard(),output);
//
//	}	
//
//	// checking players movement
//	@Test public void test03() {
//		Board b = new Board();
//		b.initialiseBoard();
//		Position p = new Position(24,8);
//		Character s = new Character("Miss_Scarlet" ,"s", p);
//		Player c = new Player(s,p);
//		b.getBoard()[24][8].setOccupied(c);
//		b.move(c,4,"n");
//
//		String output =
//
//						"00|KKKKKK...BBBBBB...CCCCCC\n" +
//						"01|KKKKKK...BBBBBB...CCCCCC\n" +
//						"02|KKKKKK...BBBBBB...CCCCCC\n" +
//						"03|KKKKKK...BBBBB^...CCCCCC\n" +
//						"04|KKKKKK...^BBBBB...CCCCCC\n" +
//						"05|KKKK^K...BB^B^B...^CCCCC\n" +
//						"06|........................\n" +
//						"07|........................\n" +
//						"08|DDDDDD............IIIIII\n" +
//						"09|DDDDDD....XXXX....^IIIII\n" +
//						"10|DDDDDD....XXXX....IIIIII\n" +
//						"11|DDDDD^....XXXX....IIIIII\n" +
//						"12|DDDDDD....XXXX..........\n" +
//						"13|DDDDDD....XXXX..........\n" +
//						"14|DDDDDD....XXXX....YYYYYY\n" +
//						"15|DDDD^D............^YYYYY\n" +
//						"16|..................YYYYYY\n" +
//						"17|........................\n" +
//						"18|........................\n" +
//						"19|LLLLL^...HH^^HH...SSSSSS\n" +
//						"20|LLLLLL..sHHHHHH...SSSSSS\n" +
//						"21|LLLLLL...HHHHHH...^SSSSS\n" +
//						"22|LLLLLL...HHHHHH...SSSSSS\n" +
//						"23|LLLLLL...HHHHHH...SSSSSS\n" +
//						"24|LLLLLL...HHHHHH...SSSSSS\n" ;
//
//
//		assertEquals(b.drawBoard(),output);
//
//	}
//	
//	// checking a player is moving to room through the wall
//	@Test public void test04() {
//		Board b = new Board();
//		b.initialiseBoard();
//		Position p = new Position(24,8);
//		Character s = new Character("Miss_Scarlet" ,"s", p);
//		Player c = new Player(s,p);
//		b.getBoard()[24][8].setOccupied(c);
//		b.move(c,4,"e");
//
//		String output =
//
//						"00|KKKKKK...BBBBBB...CCCCCC\n" +
//						"01|KKKKKK...BBBBBB...CCCCCC\n" +
//						"02|KKKKKK...BBBBBB...CCCCCC\n" +
//						"03|KKKKKK...BBBBB^...CCCCCC\n" +
//						"04|KKKKKK...^BBBBB...CCCCCC\n" +
//						"05|KKKK^K...BB^B^B...^CCCCC\n" +
//						"06|........................\n" +
//						"07|........................\n" +
//						"08|DDDDDD............IIIIII\n" +
//						"09|DDDDDD....XXXX....^IIIII\n" +
//						"10|DDDDDD....XXXX....IIIIII\n" +
//						"11|DDDDD^....XXXX....IIIIII\n" +
//						"12|DDDDDD....XXXX..........\n" +
//						"13|DDDDDD....XXXX..........\n" +
//						"14|DDDDDD....XXXX....YYYYYY\n" +
//						"15|DDDD^D............^YYYYY\n" +
//						"16|..................YYYYYY\n" +
//						"17|........................\n" +
//						"18|........................\n" +
//						"19|LLLLL^...HH^^HH...SSSSSS\n" +
//						"20|LLLLLL...HHHHHH...SSSSSS\n" +
//						"21|LLLLLL...HHHHHH...^SSSSS\n" +
//						"22|LLLLLL...HHHHHH...SSSSSS\n" +
//						"23|LLLLLL...HHHHHH...SSSSSS\n" +
//						"24|LLLLLL..sHHHHHH...SSSSSS\n" ;
//
//
//		assertEquals(b.drawBoard(),output);
//
//	}
//	
//	// placing all the players in their initial spot
//	@Test public void test05() {
//		Board b = new Board();
//		b.initialiseBoard();
//		Position p = new Position(24,8);
//		Position p1 = new Position(18,0);
//		Position p2 = new Position(0,8);
//		Position p3 = new Position(0,16);
//		Position p4 = new Position(7,23);
//		Position p5 = new Position(18,23);
//
//		Character s = new Character("Miss_Scarlet" ,"s", p);
//		Character c = new Character("Colonel_Mustard" ,"c", p1);
//		Character w = new Character("Mrs_White" ,"w", p2);
//		Character g = new Character("Mr_Green" ,"g", p3);
//		Character k = new Character("Mrs_Peacock" ,"c", p4);
//		Character m = new Character("Professor_Plum" ,"w", p5);
//
//
//		Player s1 = new Player(s,p);
//		Player s2 = new Player(c,p1);
//		Player s3 = new Player(w,p2);
//		Player s4 = new Player(g,p3);
//		Player s5 = new Player(k,p4);
//		Player s6 = new Player(m,p5);
//		
//		b.getBoard()[24][8].setOccupied(s1);
//		b.getBoard()[18][0].setOccupied(s2);
//		b.getBoard()[0][8].setOccupied(s3);
//		b.getBoard()[0][16].setOccupied(s4);
//		b.getBoard()[7][23].setOccupied(s5);
//		b.getBoard()[18][23].setOccupied(s6);
//
//		String output =
//
//						"00|KKKKKK..wBBBBBB.g.CCCCCC\n" +
//						"01|KKKKKK...BBBBBB...CCCCCC\n" +
//						"02|KKKKKK...BBBBBB...CCCCCC\n" +
//						"03|KKKKKK...BBBBB^...CCCCCC\n" +
//						"04|KKKKKK...^BBBBB...CCCCCC\n" +
//						"05|KKKK^K...BB^B^B...^CCCCC\n" +
//						"06|........................\n" +
//						"07|.......................c\n" +
//						"08|DDDDDD............IIIIII\n" +
//						"09|DDDDDD....XXXX....^IIIII\n" +
//						"10|DDDDDD....XXXX....IIIIII\n" +
//						"11|DDDDD^....XXXX....IIIIII\n" +
//						"12|DDDDDD....XXXX..........\n" +
//						"13|DDDDDD....XXXX..........\n" +
//						"14|DDDDDD....XXXX....YYYYYY\n" +
//						"15|DDDD^D............^YYYYY\n" +
//						"16|..................YYYYYY\n" +
//						"17|........................\n" +
//						"18|c......................w\n" +
//						"19|LLLLL^...HH^^HH...SSSSSS\n" +
//						"20|LLLLLL...HHHHHH...SSSSSS\n" +
//						"21|LLLLLL...HHHHHH...^SSSSS\n" +
//						"22|LLLLLL...HHHHHH...SSSSSS\n" +
//						"23|LLLLLL...HHHHHH...SSSSSS\n" +
//						"24|LLLLLL..sHHHHHH...SSSSSS\n" ;
//
//
//		assertEquals(b.drawBoard(),output);
//
//	}
//	
//
//	//checking the player can move to east
//	@Test public void test06() {
//		Board b = new Board();
//		b.initialiseBoard();
//		Position p = new Position(18,0);
//		Character s = new Character("Colonel_Mustard" ,"m", p);
//		Player c = new Player(s,p);
//		b.getBoard()[18][0].setOccupied(c);
//		b.move(c,2,"e");
//
//		String output =
//
//				"00|KKKKKK...BBBBBB...CCCCCC\n" +
//						"01|KKKKKK...BBBBBB...CCCCCC\n" +
//						"02|KKKKKK...BBBBBB...CCCCCC\n" +
//						"03|KKKKKK...BBBBB^...CCCCCC\n" +
//						"04|KKKKKK...^BBBBB...CCCCCC\n" +
//						"05|KKKK^K...BB^B^B...^CCCCC\n" +
//						"06|........................\n" +
//						"07|........................\n" +
//						"08|DDDDDD............IIIIII\n" +
//						"09|DDDDDD....XXXX....^IIIII\n" +
//						"10|DDDDDD....XXXX....IIIIII\n" +
//						"11|DDDDD^....XXXX....IIIIII\n" +
//						"12|DDDDDD....XXXX..........\n" +
//						"13|DDDDDD....XXXX..........\n" +
//						"14|DDDDDD....XXXX....YYYYYY\n" +
//						"15|DDDD^D............^YYYYY\n" +
//						"16|..................YYYYYY\n" +
//						"17|........................\n" +
//						"18|..m.....................\n" +
//						"19|LLLLL^...HH^^HH...SSSSSS\n" +
//						"20|LLLLLL...HHHHHH...SSSSSS\n" +
//						"21|LLLLLL...HHHHHH...^SSSSS\n" +
//						"22|LLLLLL...HHHHHH...SSSSSS\n" +
//						"23|LLLLLL...HHHHHH...SSSSSS\n" +
//						"24|LLLLLL...HHHHHH...SSSSSS\n" ;
//
//		assertEquals(b.drawBoard(),output);
//
//	}
//	
//	//checking the player can move to south
//	@Test public void test07() {
//		Board b = new Board();
//		b.initialiseBoard();
//		Position p = new Position(16,0);
//		Character s = new Character("Colonel_Mustard" ,"m", p);
//		Player c = new Player(s,p);
//		b[16][0].setOccupied(c);
//		b.move(c,1,"s");
//
//		String output =
//
//						"00|KKKKKK...BBBBBB...CCCCCC\n" +
//						"01|KKKKKK...BBBBBB...CCCCCC\n" +
//						"02|KKKKKK...BBBBBB...CCCCCC\n" +
//						"03|KKKKKK...BBBBB^...CCCCCC\n" +
//						"04|KKKKKK...^BBBBB...CCCCCC\n" +
//						"05|KKKK^K...BB^B^B...^CCCCC\n" +
//						"06|........................\n" +
//						"07|........................\n" +
//						"08|DDDDDD............IIIIII\n" +
//						"09|DDDDDD....XXXX....^IIIII\n" +
//						"10|DDDDDD....XXXX....IIIIII\n" +
//						"11|DDDDD^....XXXX....IIIIII\n" +
//						"12|DDDDDD....XXXX..........\n" +
//						"13|DDDDDD....XXXX..........\n" +
//						"14|DDDDDD....XXXX....YYYYYY\n" +
//						"15|DDDD^D............^YYYYY\n" +
//						"16|..................YYYYYY\n" +
//						"17|m.......................\n" +
//						"18|........................\n" +
//						"19|LLLLL^...HH^^HH...SSSSSS\n" +
//						"20|LLLLLL...HHHHHH...SSSSSS\n" +
//						"21|LLLLLL...HHHHHH...^SSSSS\n" +
//						"22|LLLLLL...HHHHHH...SSSSSS\n" +
//						"23|LLLLLL...HHHHHH...SSSSSS\n" +
//						"24|LLLLLL...HHHHHH...SSSSSS\n" ;
//
//		assertEquals(output, b.drawBoard());
//
//	}
//
//	//checking the player can move to a room by entering through a door 
//	@Test public void test08() {
//		Board b = new Board();
//		b.initialiseBoard();
//		Position p = new Position(17,0);
//		Character s = new Character("Colonel_Mustard" ,"m", p);
//		Player c = new Player(s,p);
//		b.getBoard()[17][0].setOccupied(c);
//		b.move(c,5,"e");
//		b.move(c,2,"s");
//
//		String output =
//
//						"00|KKKKKK...BBBBBB...CCCCCC\n" +
//						"01|KKKKKK...BBBBBB...CCCCCC\n" +
//						"02|KKKKKK...BBBBBB...CCCCCC\n" +
//						"03|KKKKKK...BBBBB^...CCCCCC\n" +
//						"04|KKKKKK...^BBBBB...CCCCCC\n" +
//						"05|KKKK^K...BB^B^B...^CCCCC\n" +
//						"06|........................\n" +
//						"07|........................\n" +
//						"08|DDDDDD............IIIIII\n" +
//						"09|DDDDDD....XXXX....^IIIII\n" +
//						"10|DDDDDD....XXXX....IIIIII\n" +
//						"11|DDDDD^....XXXX....IIIIII\n" +
//						"12|DDDDDD....XXXX..........\n" +
//						"13|DDDDDD....XXXX..........\n" +
//						"14|DDDDDD....XXXX....YYYYYY\n" +
//						"15|DDDD^D............^YYYYY\n" +
//						"16|..................YYYYYY\n" +
//						"17|........................\n" +
//						"18|........................\n" +
//						"19|LLLLLm...HH^^HH...SSSSSS\n" +
//						"20|LLLLLL...HHHHHH...SSSSSS\n" +
//						"21|LLLLLL...HHHHHH...^SSSSS\n" +
//						"22|LLLLLL...HHHHHH...SSSSSS\n" +
//						"23|LLLLLL...HHHHHH...SSSSSS\n" +
//						"24|LLLLLL...HHHHHH...SSSSSS\n" ;
//
//		assertEquals(b.drawBoard(),output);
//
//	}
//
//	//checking player moving through wall  
//	@Test public void test9() {
//		Board b = new Board();
//		b.initialiseBoard();
//		Position p = new Position(17,0);
//		Character s = new Character("Colonel_Mustard" ,"m", p);
//		Player c = new Player(s,p);
//		b.getBoard()[17][0].setOccupied(c);
//		b.move(c,3,"e");
//		b.move(c,3,"s");
//
//		String output =
//
//						"00|KKKKKK...BBBBBB...CCCCCC\n" +
//						"01|KKKKKK...BBBBBB...CCCCCC\n" +
//						"02|KKKKKK...BBBBBB...CCCCCC\n" +
//						"03|KKKKKK...BBBBB^...CCCCCC\n" +
//						"04|KKKKKK...^BBBBB...CCCCCC\n" +
//						"05|KKKK^K...BB^B^B...^CCCCC\n" +
//						"06|........................\n" +
//						"07|........................\n" +
//						"08|DDDDDD............IIIIII\n" +
//						"09|DDDDDD....XXXX....^IIIII\n" +
//						"10|DDDDDD....XXXX....IIIIII\n" +
//						"11|DDDDD^....XXXX....IIIIII\n" +
//						"12|DDDDDD....XXXX..........\n" +
//						"13|DDDDDD....XXXX..........\n" +
//						"14|DDDDDD....XXXX....YYYYYY\n" +
//						"15|DDDD^D............^YYYYY\n" +
//						"16|..................YYYYYY\n" +
//						"17|...m....................\n" +
//						"18|........................\n" +
//						"19|LLLLL^...HH^^HH...SSSSSS\n" +
//						"20|LLLLLL...HHHHHH...SSSSSS\n" +
//						"21|LLLLLL...HHHHHH...^SSSSS\n" +
//						"22|LLLLLL...HHHHHH...SSSSSS\n" +
//						"23|LLLLLL...HHHHHH...SSSSSS\n" +
//						"24|LLLLLL...HHHHHH...SSSSSS\n" ;
//
//		assertEquals(b.drawBoard(),output);
//
//	}
//
//	//checking the players move to an occupied square
//	@Test public void test10() {
//		Board b = new Board();
//		b.initialiseBoard();
//		Position p = new Position(24,8);
//		Position p1 = new Position(18,0);
//
//		Character s = new Character("Miss_Scarlet" ,"s", p);
//		Character c = new Character("Colonel_Mustard" ,"c", p1);
//
//		Player s1 = new Player(s,p);
//		Player s2 = new Player(c,p1);
//
//		b.getBoard()[24][8].setOccupied(s1);
//		b.getBoard()[18][0].setOccupied(s2);
//		b.move(s1,6,"n");
//		b.move(s2,8,"e");
//
//		String output =
//
//						"00|KKKKKK...BBBBBB...CCCCCC\n" +
//						"01|KKKKKK...BBBBBB...CCCCCC\n" +
//						"02|KKKKKK...BBBBBB...CCCCCC\n" +
//						"03|KKKKKK...BBBBB^...CCCCCC\n" +
//						"04|KKKKKK...^BBBBB...CCCCCC\n" +
//						"05|KKKK^K...BB^B^B...^CCCCC\n" +
//						"06|........................\n" +
//						"07|........................\n" +
//						"08|DDDDDD............IIIIII\n" +
//						"09|DDDDDD....XXXX....^IIIII\n" +
//						"10|DDDDDD....XXXX....IIIIII\n" +
//						"11|DDDDD^....XXXX....IIIIII\n" +
//						"12|DDDDDD....XXXX..........\n" +
//						"13|DDDDDD....XXXX..........\n" +
//						"14|DDDDDD....XXXX....YYYYYY\n" +
//						"15|DDDD^D............^YYYYY\n" +
//						"16|..................YYYYYY\n" +
//						"17|........................\n" +
//						"18|c.......s...............\n" +
//						"19|LLLLL^...HH^^HH...SSSSSS\n" +
//						"20|LLLLLL...HHHHHH...SSSSSS\n" +
//						"21|LLLLLL...HHHHHH...^SSSSS\n" +
//						"22|LLLLLL...HHHHHH...SSSSSS\n" +
//						"23|LLLLLL...HHHHHH...SSSSSS\n" +
//						"24|LLLLLL...HHHHHH...SSSSSS\n" ;
//
//		assertEquals(b.drawBoard(),output);
//
//	}
//	
//	// checking boundaries (south and west)
//	@Test public void test11() {
//		Board b = new Board();
//		b.initialiseBoard();
//		Position p = new Position(24,8);
//		Position p1 = new Position(18,0);
//
//		Character s = new Character("Miss_Scarlet" ,"s", p);
//		Character c = new Character("Colonel_Mustard" ,"c", p1);
//
//		Player s1 = new Player(s,p);
//		Player s2 = new Player(c,p1);
//
//		b.getBoard()[24][8].setOccupied(s1);
//		b.getBoard()[18][0].setOccupied(s2);
//		b.move(s1,6,"s");
//		b.move(s2,8,"w");
//
//		String output =
//
//						"00|KKKKKK...BBBBBB...CCCCCC\n" +
//						"01|KKKKKK...BBBBBB...CCCCCC\n" +
//						"02|KKKKKK...BBBBBB...CCCCCC\n" +
//						"03|KKKKKK...BBBBB^...CCCCCC\n" +
//						"04|KKKKKK...^BBBBB...CCCCCC\n" +
//						"05|KKKK^K...BB^B^B...^CCCCC\n" +
//						"06|........................\n" +
//						"07|........................\n" +
//						"08|DDDDDD............IIIIII\n" +
//						"09|DDDDDD....XXXX....^IIIII\n" +
//						"10|DDDDDD....XXXX....IIIIII\n" +
//						"11|DDDDD^....XXXX....IIIIII\n" +
//						"12|DDDDDD....XXXX..........\n" +
//						"13|DDDDDD....XXXX..........\n" +
//						"14|DDDDDD....XXXX....YYYYYY\n" +
//						"15|DDDD^D............^YYYYY\n" +
//						"16|..................YYYYYY\n" +
//						"17|........................\n" +
//						"18|c.......................\n" +
//						"19|LLLLL^...HH^^HH...SSSSSS\n" +
//						"20|LLLLLL...HHHHHH...SSSSSS\n" +
//						"21|LLLLLL...HHHHHH...^SSSSS\n" +
//						"22|LLLLLL...HHHHHH...SSSSSS\n" +
//						"23|LLLLLL...HHHHHH...SSSSSS\n" +
//						"24|LLLLLL..sHHHHHH...SSSSSS\n" ;
//
//		assertEquals(b.drawBoard(),output);
//
//	}
//
//	//checking boundaries(north and east)
//	@Test public void test12() {
//		Board b = new Board();
//		b.initialiseBoard();
//		Position p = new Position(24,8);
//		Position p1 = new Position(18,0);
//
//		Character s = new Character("Miss_Scarlet" ,"s", p);
//		Character c = new Character("Colonel_Mustard" ,"c", p1);
//
//		Player s1 = new Player(s,p);
//		Player s2 = new Player(c,p1);
//
//		b.getBoard()[24][8].setOccupied(s1);
//		b.getBoard()[18][0].setOccupied(s2);
//		b.move(s1,25,"n");
//		b.move(s2,24,"e");
//
//		String output =
//
//						"00|KKKKKK...BBBBBB...CCCCCC\n" +
//						"01|KKKKKK...BBBBBB...CCCCCC\n" +
//						"02|KKKKKK...BBBBBB...CCCCCC\n" +
//						"03|KKKKKK...BBBBB^...CCCCCC\n" +
//						"04|KKKKKK...^BBBBB...CCCCCC\n" +
//						"05|KKKK^K...BB^B^B...^CCCCC\n" +
//						"06|........................\n" +
//						"07|........................\n" +
//						"08|DDDDDD............IIIIII\n" +
//						"09|DDDDDD....XXXX....^IIIII\n" +
//						"10|DDDDDD....XXXX....IIIIII\n" +
//						"11|DDDDD^....XXXX....IIIIII\n" +
//						"12|DDDDDD....XXXX..........\n" +
//						"13|DDDDDD....XXXX..........\n" +
//						"14|DDDDDD....XXXX....YYYYYY\n" +
//						"15|DDDD^D............^YYYYY\n" +
//						"16|..................YYYYYY\n" +
//						"17|........................\n" +
//						"18|c.......................\n" +
//						"19|LLLLL^...HH^^HH...SSSSSS\n" +
//						"20|LLLLLL...HHHHHH...SSSSSS\n" +
//						"21|LLLLLL...HHHHHH...^SSSSS\n" +
//						"22|LLLLLL...HHHHHH...SSSSSS\n" +
//						"23|LLLLLL...HHHHHH...SSSSSS\n" +
//						"24|LLLLLL..sHHHHHH...SSSSSS\n" ;
//
//		assertEquals(b.drawBoard(),output);
//
//	}
//	
////	@Test public void test14() {
////
////		mainGame m = new mainGame();
////		m.initPlayers(4);
////		//assert(m.getPlayers(),4);
////		//System.out.println();
////	}
//
//}