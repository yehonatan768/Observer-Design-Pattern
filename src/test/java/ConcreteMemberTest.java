import observer.ConcreteMember;
import observer.UndoableStringBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 ConcreteMemberTest is a class that contains test cases for the ConcreteMember class.
 @author Noy Dayan, Yehonatan Mekayten
 @version 1
 @see ConcreteMember
 */
public class ConcreteMemberTest {
    /**
     * Test case for the update method of ConcreteMember.
     * This test case creates a ConcreteMember instance and several UndoableStringBuilder instances, and then
     * tests that the ConcreteMember's document is updated correctly when the update method is called with the
     * different UndoableStringBuilder instances.
     */
    @Test
    public void testUpdate() {
        ConcreteMember member = new ConcreteMember("John");
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("Hello");
        member.update(usb);
        assertEquals("Hello", member.getDocument().toString());

        UndoableStringBuilder usb2 = new UndoableStringBuilder();
        usb2.append("World");
        member.update(usb2);
        assertEquals("World", member.getDocument().toString());

        UndoableStringBuilder usb3 = new UndoableStringBuilder();
        usb3.append("Hello");
        usb3.append(" Alice!");
        member.update(usb3);
        assertEquals("Hello Alice!", member.getDocument().toString());
    }

    /**
     * Test case for the getName method of ConcreteMember.
     * This test case creates several ConcreteMember instances and tests that the getName method returns the correct
     * name for each instance.
     */
    @Test
    public void testGetName() {
        ConcreteMember member1 = new ConcreteMember("Bob");
        ConcreteMember member2 = new ConcreteMember("Alice");
        ConcreteMember member3 = new ConcreteMember("John");

        assertEquals("Bob", member1.getName());
        assertEquals("Alice", member2.getName());
        assertEquals("John", member3.getName());
    }

}
