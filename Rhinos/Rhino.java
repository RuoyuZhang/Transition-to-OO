//Ruoyu Zhang rz253 Feb 3rd 2016
//JavaDoc Test

/**
Instances of this class are monitoring data for a single rhino.
 */
public class Rhino{
    private String name;
    private int yearOfBirth;
    private int monOfBirth;
    private int tag;
    private char gender;
    private Rhino mother;
    private Rhino father;
    private int numOfChild;
    
    /** 
    * Constructor: a new rhino with name n, birth year y, birth month m, 
    * and gender g. Its parents are unknown, and it has no children. 
    * Precondition: n's length is > 0. m is in the range 1..12. 
    * g is either `M' (for male) or `F' (for female)
    */
    public Rhino(String n, int y, int m, char g){
        name = n;
        yearOfBirth = y;
        monOfBirth = m;
        gender = g;
        tag = -1;
        mother = null;
        father = null;
        numOfChild = 0;
    }
    
    /** Yields: the name for this rhino */
    public String getName() {
        return name;
    }

    /** Yields: the year the rhino was born */
    public int getYear() {
        return yearOfBirth;
    }
    
    /** Yields: the month the rhino was born. 1 means Jan, 2 means Feb, etc. */
    public int getMonth() {
        return monOfBirth;
    }
    
    /** Yields: "this rhino is a male" */
    public boolean isMale() {
        return gender == 'M' ? true : false;
    }
    
    /** Yields: this rhino's tag (>= 0) if defined; -1 if it is untagged */
    public int getTag() {
        return tag;
    }
    
    /** Yields: the mother of this rhino (null if unknown) */
    public Rhino getMother() {
        return mother;
    }
    
    /** Yields: the father of this rhino (null if unknown) */
    public Rhino getFather() {
        return father;
    }
    
    /** Yields: the number of children for this profile */
    public int getNumChildren() {
        return numOfChild;
    }

    //Part B
    /** Set the tag for this rhino to i. Precondition: i >= 0 */
    public void setTag(int i) {
        tag = i;
    }
    
    /** Add the numOfChild for this rhino by 1 */
    public void addChild() {
        numOfChild = this.numOfChild + 1;
    }
    
    /** Add p as the mother of this rhino. Precondition: p is not null, 
      * p is a female, and this rhino's mother is currently null.
      */
    public void addMother(Rhino p){
        mother = p;
        p.addChild();
    }
    
    /** Add p as the father of this rhino. Precondition: p is not null, 
      * p is a male, and this rhino's father is currently null.
      */
    public void addFather(Rhino p){
        father = p;
        p.addChild();
    }
    
    
    //PartC
    /** Constructor: a new rhino with name n, birth year y, birth month m, 
      * gender g, identifier id, mother ma, and father pa. 
      * Precondition: n's length is > 0. m is in the range 1 .. 12. g is either `M' (for male) 
      * or `F' (for female). tag >= 0 (or -1 if untagged). ma and pa may not be null.
      */
    public Rhino(String n, int y, int m, char g, int tag, Rhino ma, Rhino pa){
        name = n;
        yearOfBirth = y;
        monOfBirth = m;
        gender = g;
        this.tag = tag;
        mother = ma;
        father = pa;
        
        ma.addChild();
        pa.addChild();
    }
    
    
    //PartD
    /** Yields: text representation of this Rhino */
    public String toString() {
        return (this.isMale() == true ? "Male rhino " : "Female rhino ") + 
            this.getName() + 
            (this.getTag() == -1 ? ". " : (". Tag " + this.getTag() + ". ")) + 
            "Born " + this.getMonth() + "/" + this.getYear() + ". " +
            (this.getMother() == null ? "" : ("Mother " + this.getMother().getName()) + ". ") +
            (this.getFather() == null ? "" : ("Father " + this.getFather().getName()) + ". ") +
            "Has " + this.getNumChildren() + 
            (this.getNumChildren() == 1 ? " child." : " children.");
    }
    
    
    //PartE
    /** Yields: "p is not null and this Rhino is older than p".*/
    public boolean isOlder(Rhino p){
        return ((this.getYear() < p.getYear()) || (this.getYear() == p.getYear() && this.getMonth() < p.getMonth()));
    }
    
    /** Yields: "p and q are not null and p is older than q".
      * Make this function static and write it using the previous isOlder(Rhino) 
      * as a helper method.*/
    //public boolean isOlder(Rhino p, Rhino q){
        
    //}
}