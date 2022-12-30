import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * GroupAdminTest is a class that tests the functionality of the GroupAdmin class and its ability to communicate with Members.
 * It contains test cases for the insert, append, delete, and undo methods of the GroupAdmin class.
 *
 * @author Noy Dayan, Yehonatan Mekayten
 * @version 1
 */
public class GroupAdminTest {

    /**
     * Tests the insert method of the GroupAdmin class.
     * It creates a GroupAdmin and some ConcreteMembers, registers them with the GroupAdmin, and then inserts a string into the document at different positions.
     * It verifies that the document was updated correctly for all members.
     */
    @Test
    public void testInsert() {
        // Create a GroupAdmin and some ConcreteMembers
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("Alice");
        ConcreteMember member2 = new ConcreteMember("Bob");
        ConcreteMember member3 = new ConcreteMember("Eve");

        // Register the members with the GroupAdmin
        admin.register(member1);
        admin.register(member2);
        admin.register(member3);

        // Insert a string into the document at different positions
        admin.insert(0, "Hello, ");
        admin.insert(7, "world!");
        admin.insert(7, "my ");
        admin.insert(26, " friend!");
        admin.insert(0, "Hi, ");
        admin.insert(33, " How are you?");
        admin.insert(46, " I hope you're doing well.");
        admin.insert(67, " Take care!");
        admin.insert(78, " Bye.");
        admin.insert(83, " Love, Alice");

        // Check that the document was updated correctly for all members
        assertEquals("Hi, Hello, my world! friend! How are you? I hope you're doing well. Take care! Bye. Love, Alice", member1.getDocument().toString());
        assertEquals("Hi, Hello, my world! friend! How are you? I hope you're doing well. Take care! Bye. Love, Alice", member2.getDocument().toString());
        assertEquals("Hi, Hello, my world! friend! How are you? I hope you're doing well. Take care! Bye. Love, Alice", member3.getDocument().toString());
    }

    /**
     * Tests the append method of the GroupAdmin class.
     * It creates a GroupAdmin and some ConcreteMembers, registers them with the GroupAdmin, and then appends a string to the document.
     * It verifies that the document was updated correctly for all members.
     */
    @Test
    public void testAppend() {
        // Create a GroupAdmin and some ConcreteMembers
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("Alice");
        ConcreteMember member2 = new ConcreteMember("Bob");
        ConcreteMember member3 = new ConcreteMember("Eve");

        // Register the members with the GroupAdmin
        admin.register(member1);
        admin.register(member2);
        admin.register(member3);

        // Append a string to the document
        admin.append("Hello, world!");

        // Check that the document was updated for all members
        assertEquals("Hello, world!", member1.getDocument().toString());
        assertEquals("Hello, world!", member2.getDocument().toString());
        assertEquals("Hello, world!", member3.getDocument().toString());
    }

    /**
     * Tests the delete method of the GroupAdmin class by inserting a string into the shared
     * document and then deleting a portion of the string, and checking that the document was updated correctly for all Members.
     */
    @Test
    public void testDelete() {
        // Create a GroupAdmin and some ConcreteMembers
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("Alice");
        ConcreteMember member2 = new ConcreteMember("Bob");
        ConcreteMember member3 = new ConcreteMember("Eve");

        // Register the members with the GroupAdmin
        admin.register(member1);
        admin.register(member2);
        admin.register(member3);

        // Insert a string into the document
        admin.insert(0, "Hello, world!");

        // Delete a portion of the string
        admin.delete(0, 5);

        // Check that the document was updated for all members
        assertEquals(", world!", member1.getDocument().toString());
        assertEquals(", world!", member2.getDocument().toString());
        assertEquals(", world!", member3.getDocument().toString());
    }

    /**
     * Tests the undo method of the GroupAdmin class by inserting a string into the shared document,
     * deleting a portion of the string, and then undoing the delete operation, and checking that the
     * document was updated correctly for all Members.
     */
    @Test
    public void testUndo() {
        // Create a GroupAdmin and some ConcreteMembers
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("Alice");
        ConcreteMember member2 = new ConcreteMember("Bob");
        ConcreteMember member3 = new ConcreteMember("Eve");

        // Register the members with the GroupAdmin
        admin.register(member1);
        admin.register(member2);
        admin.register(member3);

        // Insert a string into the document
        admin.insert(0, "Hello, world!");

        // Delete a portion of the string
        admin.delete(0, 5);

        // Undo the delete operation
        admin.undo();

        // Check that the document was updated for all members
        assertEquals("Hello, world!", member1.getDocument().toString());
        assertEquals("Hello, world!", member2.getDocument().toString());
        assertEquals("Hello, world!", member3.getDocument().toString());
    }

    /**
     * Tests the register and unregister methods of the GroupAdmin class by registering and
     * unregistering Members and checking that the lists of Members are updated correctly.
     */
    @Test
    public void testRegister() {
        // Create a GroupAdmin and a ConcreteMember
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member = new ConcreteMember("Alice");

        // Register the member with the GroupAdmin
        admin.register(member);

        // Insert a string into the document
        admin.insert(0, "Hello, world!");

        // Check that the document was updated for the member
        assertEquals("Hello, world!", member.getDocument().toString());
    }

    /**
     * Tests the unregister method of the GroupAdmin class by unregistering Members that are not
     * registered and checking that the list of Members is not affected.
     */
    @Test
    public void testUnregister() {
        // Create a GroupAdmin and some ConcreteMembers
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("Alice");
        ConcreteMember member2 = new ConcreteMember("Bob");
        ConcreteMember member3 = new ConcreteMember("Eve");

        // Register the members with the GroupAdmin
        admin.register(member1);
        admin.register(member2);
        admin.register(member3);

        // Unregister one of the members
        admin.unregister(member2);

        // Insert a string into the document
        admin.insert(0, "Hello, world!");

        // Check that the document was updated for the remaining members
        assertEquals("Hello, world!", member1.getDocument().toString());
        assertEquals("Hello, world!", member3.getDocument().toString());

        // Check that the unregistered member did not receive the update
        assertNotEquals("Hello, world!", member2.getDocument().toString());
    }
}
