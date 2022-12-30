package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * GroupAdmin is a class that implements the Sender interface and serves as the central point of communication for a group of Members.
 * It maintains a list of Members and an UndoableStringBuilder object which represents a shared document that the Members can collaborate on.
 * GroupAdmin has methods for registering and unregistering Members, as well as for inserting, appending, deleting, and undoing changes to the shared document.
 *
 * @author Noy Dayan, Yehonatan Mekayten
 * @version 1
 * @see Sender
 */

public class GroupAdmin implements Sender {
    List<Member> members;
    UndoableStringBuilder document;

    public GroupAdmin() {
        members = new ArrayList<>();
        document = new UndoableStringBuilder();
    }

    /**
     * Registers a Member to the group.
     *
     * @param obj the Member to be registered
     */
    @Override
    public void register(Member obj) {
        members.add(obj);
    }

    /**
     * Unregisters a Member from the group.
     *
     * @param obj the Member to be unregistered
     */
    @Override
    public void unregister(Member obj) {
        members.remove(obj);
    }

    /**
     * Inserts a string into the shared document at the specified offset.
     * If the specified offset is greater than the length of the document, the string is inserted at the end of the document.
     *
     * @param offset the position in the document where the string should be inserted
     * @param obj the string to be inserted
     */
    @Override
    public void insert(int offset, String obj) {
        if (offset > document.toString().length()) {
            offset = document.toString().length();
        }
        document = document.insert(offset, obj);
        notifyMembers();
    }

    /**
     * Appends a string to the end of the shared document.
     *
     * @param obj the string to be appended
     */
    @Override
    public void append(String obj) {
        document = document.append(obj);
        notifyMembers();
    }

    /**
     * Deletes a range of characters from the shared document.
     *
     * @param start the starting index of the range (inclusive)
     * @param end the ending index of the range (exclusive)
     */
    @Override
    public void delete(int start, int end) {
        document = document.delete(start, end);
        notifyMembers();
    }

    /**
     * Undoes the last change made to the shared document.
     */
    @Override
    public void undo() {
        document.undo();
        notifyMembers();
    }

    /**
     * Notifies all registered Members of a change made to the shared document.
     */
    void notifyMembers() {
        for (Member member : members) {
            member.update(document);
        }
    }
}