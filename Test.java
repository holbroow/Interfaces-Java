import java.util.*;

public class Test implements CollectionTest {
    private CollectionType collectionType;
    private TestType testType;
    private Collection<Person> people;
    private int size;
    private int iterations;

    public Test() {}

    public void setSize(int size) {
        this.size = size;
    }

    public void runTest(CollectionType type, TestType test, int iterations) {
        this.collectionType = type;
        this.testType = test;
        this.iterations = iterations;

        switch (collectionType) {
            case LINKED_LIST:
                people = new LinkedList<Person>();
                break;
            case ARRAY_LIST:
                people = new ArrayList<Person>();
                break;
            case HASH_MAP:
                people = new HashSet<Person>();
                break;
        }

        switch (testType) {
            case ADD:
                for (int i = 0; i < size; i++) {
                    people.add(new Person("Person " + i, 1));
                }
                break;
            case INDEX:
                switch (collectionType) {
                    case LINKED_LIST:
                        
                        break;
                    case ARRAY_LIST:

                        break;
                    case HASH_MAP:

                        break;
                }
                break;
            case SEARCH:
                switch (collectionType) {
                    case LINKED_LIST:
                    
                        break;
                    case ARRAY_LIST:

                        break;
                    case HASH_MAP:

                        break;
                }
                break;
        }
    }
}