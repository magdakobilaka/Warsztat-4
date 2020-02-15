package phonebook;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.misc.Contended;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryphoneBookService {
    private List<PhoneBook> list;
    static private long idCount = 4;

    public MemoryphoneBookService() {
        list = new ArrayList<>();
        list.add(new PhoneBook(1, "Zych", "Asia",
                "wroclaw", "magellana", "12a/14", "9788324631766"));
        list.add(new PhoneBook(2, "kowalski", "tomasz",
                "warszawa", "powstańscó", "4/5", "9788324631796"));
        list.add(new PhoneBook(3, "Krasko", "michal",
                "Szczecin", "Brzozowa", "9", "978832463178"));
    }

    public List<PhoneBook> getList() {
        return list;
    }

    public PhoneBook getRecord(long id) {
        return list.stream().filter(s -> s.getId() == id)
                .findFirst().get();
    }

    public void setList(List<PhoneBook> list) {
        this.list = list;
    }

    public void addRecord(PhoneBook phoneBook) {
        phoneBook.setId(idCount++);
        this.list.add(phoneBook);
    }

    public void deleteRecord(long id) {
        PhoneBook delrec = list.stream().filter(b -> b.getId() == id).findFirst().get();
        list.remove(delrec);
    }

    public void editRecord(PhoneBook phoneBook) {
        PhoneBook edit = list.stream().filter(b -> b.getId() == phoneBook.getId()).findFirst().get();
        edit.setSurname(phoneBook.getSurname());
        edit.setName(phoneBook.getName());
        edit.setCiti(phoneBook.getCiti());
        edit.setStreet(phoneBook.getStreet());
        edit.setFlatnumber(phoneBook.getFlatnumber());
        edit.setPhonenumber(phoneBook.getPhonenumber());
    }

}
