package override.hashcode.and.equals;

import java.util.HashSet;

public class TestHashCodeAndEquals {

	public static void main(String[] args) throws Exception {
		Robot r1 = new Robot(1999, "R2D2");
		Robot r2 = new Robot(1999, "R2D2");
		Robot r3 = r1;
		
		// print toString result in Object
		System.out.println("r1 is " + r1 + " , r2 is " + r2 );
		System.out.println("r1 == r2 result : " + (r1 == r2 ? true : false));
		System.out.println("r1 == r3 result : " + (r1 == r3 ? true : false));
		System.out.println("Equals between r1 and r2 : " + r1.equals(r2));
		System.out.println("HashCode r1 : " + r1.hashCode() + " , r2 : " + r2.hashCode());
		System.out.println("Identity HashCode r1 : " + System.identityHashCode(r1) + " , r2 : " + System.identityHashCode(r2));
		
		HashSet<Robot> rHS = new HashSet<Robot>();
		
		rHS.add(r1);
		rHS.add(r2);
		rHS.add(r3);
		
		System.out.println("HashSet Size : " + rHS.size());
		
		System.out.println("\n==============================\n");
		
		HashSet<CustomRobot> cRHS = new HashSet<CustomRobot>();
		
		CustomRobot cR1 = new CustomRobot(1999, "R2D2");
		CustomRobot cR2 = new CustomRobot(1999, "R2D2");
		CustomRobot cR3 = cR1;
		
		System.out.println("cR1 is " + cR1 + " , cR2 is " + cR2 );
		System.out.println("cR1 == cR2 result : " + (cR1 == cR2 ? true : false));
		System.out.println("cR1 == cR3 result : " + (cR1 == cR3 ? true : false));
		System.out.println("Equals between cR1 and cR2 : " + cR1.equals(cR2)); // cR1 and cR2 are logically equivalent
		System.out.println("HashCode cR1 : " + cR1.hashCode() + " , cR2 : " + cR2.hashCode());
		System.out.println("Identity HashCode cR1 : " + System.identityHashCode(cR1) + " cR2 : " + System.identityHashCode(cR2));
		
		cRHS.add(cR1);
		cRHS.add(cR2);
		cRHS.add(cR3);
		
		System.out.println("HashSet Size : " + cRHS.size());
		
	}

}
