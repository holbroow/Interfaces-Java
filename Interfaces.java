import java.util.*;

public class Interfaces implements CollectionTest {
    private CollectionType collectionType;
    private TestType testType;
    private Collection<Person> people;
    private int size;
    private int iterations;
    public Interfaces() {}

    /**
     * Defines the size of the collections that should be created when the ADD test is run.
     *
     * @param size the number of unique items to add to each collection.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Performs the requested test on the requested collection type.
     *
     * ADD test should create a NEW collection of the given type, and populate it with "size" *unique* instances of a Person (as defined by a previous call to setSize).
     * INDEX test should retrieve an item from the collection based on its index in that collection. The position should be approximately half-way through the collection. (e.g. the 42nd item in a collection of size 84) 
     * SEARCH test should retrieve an item from the collection based only the Person's name (e.g. the Person with the name "Person1234"). An item should be chosen that you expect to be approximatley half way through the collection.
     *
     * @param type the type of collection to be tested.
     * @param test the type of test to be undertaken.
     * @param iterations the number of times to repeat the given test before returning.
     */
    public void runTest(CollectionType type, TestType test, int iterations) {
        this.collectionType = type;
        this.testType = test;
        this.iterations = iterations;

        switch (testType) {
            case ADD:
                switch (collectionType) {
                case LINKED_LIST:
                    for (int i = 0; i < iterations; i++) {
                        people = new LinkedList<Person>();
                        for (int j = 0; j < size; j++) {
                            people.add(new Person("Person " + j, 1)); // need to randomise name and age, i believe 
                        }
                    }
                    break;
                case ARRAY_LIST:
                    for (int i = 0; i < iterations; i++) {
                        people = new ArrayList<Person>();
                        for (int j = 0; j < size; j++) {
                            people.add(new Person("Person " + j, 1)); // need to randomise name and age, i believe 
                        }
                    }
                    break;
                case HASH_MAP:
                    for (int i = 0; i < iterations; i++) {
                        people = new HashSet<Person>();
                        for (int j = 0; j < size; j++) {
                            people.add(new Person("Person " + j, 1)); // need to randomise name and age, i believe 
                        }
                    }
                    break;
                }
            break;

            case INDEX:
                int index = people.size() / 2; // halfway +/- 1 (approximately) through the collection
                switch (collectionType) {
                    case LINKED_LIST:
                        for (int i = 0; i < iterations; i++) {
                            Person personLinkedList = ((List<Person>) people).get(index);
                            System.out.println("Found element: "+ personLinkedList.getName() + ", " + personLinkedList.getAge());
                        }
                        break;
                    case ARRAY_LIST:
                        for (int i = 0; i < iterations; i++) {
                            Person personArrayList = ((List<Person>) people).get(index);
                            System.out.println("Found element: "+ personArrayList.getName() + ", " + personArrayList.getAge());
                        }
                        break;
                    case HASH_MAP:
                        for (int i = 0; i < iterations; i++) {
                            int currentIndex = 0;
                            for (Person element : people) {
                                if (currentIndex == index) { 
                                    Person personHashMap = element;
                                    System.out.println("Found element: "+ personHashMap.getName() + ", " + personHashMap.getAge()); 
                                    break; 
                                }
                                currentIndex++;
                            }
                        }
                        break;
                }
                break;
                
            case SEARCH:
                String nameToSearch = "Person " + (size / 2); // halfway +/- 1 (approximately) through the collection
                switch (collectionType) {
                    case LINKED_LIST:
                        for (int i = 0; i < iterations; i++) {
                            for (Person person : (List<Person>) people) {
                                if (person.getName().equals(nameToSearch)) {
                                    System.out.println("Found element: "+ person.getName() + ", " + person.getAge());
                                    Person personLinkedList = person;
                                    break;
                                }
                            }
                        }
                        break;
                    case ARRAY_LIST:
                        for (int i = 0; i < iterations; i++) {
                            for (Person person : (List<Person>) people) {
                                if (person.getName().equals(nameToSearch)) {
                                    System.out.println("Found element: "+ person.getName() + ", " + person.getAge());
                                    Person personArrayList = person;
                                    break;
                                }
                            }
                        }
                        break;
                    case HASH_MAP:
                        for (int i = 0; i < iterations; i++) {
                            for (Person element : people) {
                                if (element.getName().equals(nameToSearch)) { 
                                    System.out.println("Found element: "+ element.getName() + ", " + element.getAge()); 
                                    Person personHashMap = element;
                                    break; 
                                }
                            }
                        }
                        break;
                }
                break;
        }
    }
}
