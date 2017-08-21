package demo;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class DemoComparator implements Comparator<DemoVO>{

	@Override
	public int compare(DemoVO o1, DemoVO o2) {
		
		
		return o2.getName().compareTo(o1.getName());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DemoComparator comparator = new DemoComparator();
		
		DemoVO demoVO = new DemoVO("a", "1", 0, 0);
		DemoVO demoVO1 = new DemoVO("b", "2", 0, 0);
		DemoVO demoVO2 = new DemoVO("c", "3", 0, 0);
		DemoVO demoVO3 = new DemoVO("d", "5", 0, 0);
		DemoVO demoVO4 = new DemoVO("e", "4", 0, 0);
		
		NavigableSet<DemoVO> demoVOs = new TreeSet<DemoVO>(comparator);
		
		demoVOs.add(demoVO4);
		demoVOs.add(demoVO2);
		demoVOs.add(demoVO1);
		demoVOs.add(demoVO);
		demoVOs.add(demoVO3);
		
		System.err.println(demoVOs);
		
		demoVOs = new TreeSet<DemoVO>();
		demoVOs.add(demoVO4);
		demoVOs.add(demoVO2);
		demoVOs.add(demoVO1);
		demoVOs.add(demoVO);
		demoVOs.add(demoVO3);
		
		System.out.println(demoVOs);
	}
	
}
