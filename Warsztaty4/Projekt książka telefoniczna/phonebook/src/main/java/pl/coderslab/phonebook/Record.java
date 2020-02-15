package pl.coderslab.phonebook;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String surname;
    @NotNull
    private String name;
    private String citi;
    private String street;
    private String flatnumber;
    @NotNull
    private String phonenumber;

    @Override
    public String toString() {
        return "PhoneBook{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", citi='" + citi + '\'' +
                ", street='" + street + '\'' +
                ", flatnumber='" + flatnumber + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
