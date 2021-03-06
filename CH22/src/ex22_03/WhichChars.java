package ex22_03;

import java.util.BitSet;
import java.util.HashMap;

public class WhichChars {
	private HashMap<Integer, BitSet> unicodeMap = new HashMap<>();
	private Integer higherBit;
	private final char lowerMask = 0xff00;
	private final char higherMask = 0x00ff;
	
	public WhichChars(String str){
		char ch;
		BitSet lowerBit;
		for(int i = 0; i < str.length(); i++){
			ch = str.charAt(i);
			higherBit = (Integer) ((lowerMask & ch) >>> 8);
			lowerBit = unicodeMap.get(higherBit);
			if(lowerBit == null){
				lowerBit = new BitSet(0xff);
			}
			lowerBit.set(higherMask & ch);
			unicodeMap.put(higherBit, lowerBit);
		}
	}
	
	public boolean contains(char ch){
		BitSet lowerBit = unicodeMap.get((Integer)(lowerMask & ch) >>> 8);
		if(lowerBit == null){
			return false;
		}
		return lowerBit.get(higherMask & ch);
	}
		
}
