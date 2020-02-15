package phonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/phonebook")
public class PhoneBookController {
    @Autowired
    private MemoryphoneBookService memoryphoneBookService;

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/")
    public List<PhoneBook> helloBook() {
        return memoryphoneBookService.getList();
    }

    @RequestMapping("/{id}")
    public PhoneBook showRecords(@PathVariable long id) {
        return memoryphoneBookService.getRecord(id);
    }


    @PostMapping("/")
    public void addRecord(@RequestBody PhoneBook phoneBook) {
        memoryphoneBookService.addRecord(phoneBook);
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable long id) {
        memoryphoneBookService.deleteRecord(id);

    }

    @PutMapping("/editrecord")
    public void editrecord(@RequestBody PhoneBook phoneBook) {
        memoryphoneBookService.editRecord(phoneBook);
    }
}

