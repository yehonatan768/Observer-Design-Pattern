package observer;

/**
 ConcreteMember is a class that implements the Member interface and represents a member in an observer pattern.
 It has a name and an UndoableStringBuilder instance representing the document that it is associated with.
 @author Noy Dayan, Yehonatan Mekayten
 @version 1
 @see Member
 */
public class ConcreteMember implements Member {
    private String name;
    private UndoableStringBuilder document;


    /**
     * Constructs a new ConcreteMember instance with the given name.
     * It also initializes the document field with a new UndoableStringBuilder instance.
     *
     * @param name the name of the ConcreteMember
     */
    public ConcreteMember(String name) {
        this.name = name;
        this.document = new UndoableStringBuilder();
    }
    /**
     * In the case of ConcreteMember, the update method updates the document field with a new UndoableStringBuilder instance
     * initialized with the same string builder and stack as the provided usb parameter. It also prints a message to the
     * console indicating that the document has been updated.
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.document = new UndoableStringBuilder(usb.getStringBuilder(), usb.getStack());
        System.out.println(name + ": document updated to: " + document.toString());
    }

    /**
     * Returns the UndoableStringBuilder instance representing the document associated with this ConcreteMember.
     *
     * @return the document of this ConcreteMember
     */
    public UndoableStringBuilder getDocument() {
        return this.document;
    }

    /**
     * Returns the name of this ConcreteMember.
     *
     * @return the name of this ConcreteMember
     */
    public String getName() {
        return this.name;
    }
}