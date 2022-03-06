import java.util.HashMap;


public class CustomerStorage {
    private HashMap<String, Customer> storage;
    private final static String firsNameRegEx = "^[А-ЯЁ][а-яё]+(-[-А-Я][а-яё]+)?$";
    private final static String numberRegEx = "^\\+?[78]?-?\\(?\\d{3}\\)?-?\\d{3}-?\\d{2}-?\\d{2}$";
    private final static String mailRegEx = "^.+@.+\\..+$";
    private final static String secondNameRegEx = "^[А-ЯЁ][а-яё]+(-[А-Я][а-яё]+)?$";


    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong format. Correct format : \n " +
                    "add Василий Петров  vasily.petrov@gmail.com +79215637722");
        } else if (!components[0].matches(firsNameRegEx) && !components[1].matches(secondNameRegEx)) {
            throw new IllegalArgumentException("Wrong name format. Please check if you entered it correctly.");
        } else if (!components[3].matches(numberRegEx)) {
            throw new IllegalArgumentException("Wrong number format. Please check if you entered it correctly.");
        } else if (!components[2].matches(mailRegEx)) {
            throw new IllegalArgumentException("Wrong email format.Please check if you entered it correctly ");
        }
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
        System.out.println(name + " added to the list.");
    }


    public void listCustomers() {
        if (storage.isEmpty()){
            throw new IllegalArgumentException("The list is empty.");
        }
        else
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (!storage.containsKey(name)){
            throw new IllegalArgumentException("This name is not on the list.");
        }
        storage.remove(name);
        System.out.println(name + " removed from the list.");
    }

    public int getCount() {
        return storage.size();
    }
}
