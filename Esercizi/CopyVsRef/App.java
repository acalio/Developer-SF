public class App {
    public static void main(String[] args) {
	Simpson a = new Simpson(); // a -> S1
	Simpson b = new Simpson(); // b -> S2
	System.out.println(a);
	int[] array = { 1, 2 };
	
	// System.out.println(a.name); // "Bart"
	// transformIntoHomer(a); 
	// System.out.println(b.name); // "Bart"
	// b = a; // b -> S1 - a e b puntano allo stesso Simpson S1
	// System.out.println(b.name); // "Homer" del Simpson S1

	// StringBuilder wProf = new StringBuilder("Dragon");
	// String weap = "Sword";
	// changeWarriorClass(wProf, weap);
	// System.out.println("Warrior="+wProf+" Weapon="+weap);
    }

    public static void transformIntoHomer(Simpson simpson) {
	simpson.name = "Homer";
    }

    public static void changeWarriorClass(StringBuilder prof, String weap) {
	prof.append(" Knight");
	weap = "Dragon "+weap;
	weap = null;
	prof = null;
    }
}
	
/**
 * Simpson
 * -------------
 * name : String //
 * -------------
 * 
 * simpson.name = "Homer" -> simpson.name = new String("Home");
 */
class Simpson {
    public String name = "Ciao";
    
    public Simpson() {}

    @Override
    public String toString() {
	return "Simpson [name=" + name + "]";
    }

    
}




