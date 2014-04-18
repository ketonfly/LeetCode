package leecode;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

import leecode.basic.Interval;

public class MergeIntervals {

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if(intervals.isEmpty()){
			return intervals;
		}
		if(intervals.size() == 1){
			return intervals;
		}
		Collections.sort(intervals, new myComparator());
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		result.add(intervals.get(0));
		
		for(int i = 1 ;i<intervals.size();i++){
			
			int startI = result.get(result.size()-1).start;
			int endI = result.get(result.size()-1).end;
			int startJ = intervals.get(i).start;
			int endJ = intervals.get(i).end;
			
			if(startJ > endI ){
				result.add(intervals.get(i));
				continue;
			}
			if(endI>=endJ){
				
				continue;
			}
			if(startJ <= endI){
				result.remove(result.size()-1);
				result.add(result.size(), new Interval(startI,endJ));
			}
		}
		return result;
		
	}

	public static void main(String[] args) {
		ArrayList<Interval> al = new ArrayList<Interval>();
		al.add(new Interval(1, 4));
		al.add(new Interval(0, 2));
		al.add(new Interval(3, 5));
		//al.add(new Interval(15, 18));
		myComparator c = new myComparator();
		Collections.sort(al, c);
		ArrayList<Interval> mt = new ArrayList<Interval>();
		mt= merge(al);
		
		
		for (int i = 0; i < mt.size(); i++) {
			System.out.println(mt.get(i).start + " end = " + mt.get(i).end);
		}
	}
}

class myComparator implements Comparator<Interval> {

	@Override
	public int compare(Interval before, Interval after) {
		// TODO Auto-generated method stub
		return before.start - after.start;
	}
}