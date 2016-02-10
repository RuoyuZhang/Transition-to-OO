import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class RhinoTester extends TestCase {
    
    /**
     * A test method to test constructor and getters in Rhino
     */
    public void testPartA() {
        Rhino R1 = new Rhino("Rhino1", 2012, 3, 'F');
        assertEquals("Rhino1", R1.getName());
        assertEquals(2012, R1.getYear());
        assertEquals(3, R1.getMonth());
        assertEquals(false, R1.isMale());
        assertEquals(-1, R1.getTag());
        assertEquals(null, R1.getMother());
        assertEquals(null, R1.getFather());
        assertEquals(0, R1.getNumChildren());
    }
    
    /**
     * A test method to test PartB
     */
    public void testPartB() {
        Rhino R1 = new Rhino("Rhino1", 2012, 3, 'F');
        Rhino R2 = new Rhino("Rhino2", 2002, 4, 'F');
        Rhino R3 = new Rhino("Rhino3", 2003, 5, 'M');
        
        R1.setTag(3);
        assertEquals(3, R1.getTag());
        
        R1.addMother(R2);
        R1.addFather(R3);
        assertEquals(R2, R1.getMother());
        assertEquals(R3, R1.getFather());
        assertEquals(1, R2.getNumChildren());
        assertEquals(1, R3.getNumChildren());
    }
    
    
    /**
     * A test method to test PartC
     */
    public void testPartC() {
        Rhino R2 = new Rhino("Rhino2", 2002, 4, 'F');//Creat mother
        Rhino R3 = new Rhino("Rhino3", 2003, 5, 'M');//Creat father
        
        Rhino R1 = new Rhino("Rhino1", 2012, 3, 'F', 3, R2, R3);
    
        assertEquals("Rhino1", R1.getName());
        assertEquals(2012, R1.getYear());
        assertEquals(3, R1.getMonth());
        assertEquals(false, R1.isMale());
        assertEquals(3, R1.getTag());
        assertEquals(R2, R1.getMother());
        assertEquals(R3, R1.getFather());
        assertEquals(0, R1.getNumChildren());
       
        assertEquals(1, R2.getNumChildren());
        assertEquals(1, R3.getNumChildren());
    }
    
    
     /**
     * A test method to test PartD
     */
    public void testPartD() {
        Rhino R2 = new Rhino("Daisy", 2005, 4, 'F');//Creat mother
        Rhino R3 = new Rhino("Fatso", 2005, 6, 'M');//Creat father
        
        Rhino R1 = new Rhino("Annie", 2015, 8, 'F', 3, R2, R3);
        
        assertEquals("Female rhino Annie. Tag 3. Born 8/2015. "+
                         "Mother Daisy. Father Fatso. Has 0 children.", 
                     R1.toString());
        assertEquals("Male rhino Fatso. Born 6/2005. Has 1 child.", 
                     R3.toString());
        assertEquals("Female rhino Daisy. Born 4/2005. Has 1 child.", 
                     R2.toString());
    }
    
    
     /**
     * A test method to test PartE
     */
    public void testPartE() {
        Rhino R1 = new Rhino("Jack", 2004, 3, 'M');
        Rhino R2 = new Rhino("Daisy", 2005, 4, 'F');
        Rhino R3 = new Rhino("Fatso", 2005, 6, 'M');
        
        assertEquals(true, R1.isOlder(R2));
        assertEquals(false, R2.isOlder(R1));
        assertEquals(false, R3.isOlder(R2));
        assertEquals(true, R2.isOlder(R3));
        
        assertEquals(true, Rhino.isOlder(R1,R2));
        assertEquals(false, Rhino.isOlder(R2,R1));
        assertEquals(true, Rhino.isOlder(R2,R3));
        assertEquals(false, Rhino.isOlder(R3,R2));               
    }
}
