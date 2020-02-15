package pl.coderslab.phonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class RecordConverter implements Converter<String, Record> {
    @Autowired
    private RecordRepository recordRepository;


    @Override
    public Record convert(String s) {
        if (s.equals("-1")) {
            return null;
        }
        return recordRepository.findById(Long.parseLong(s)).orElse(null);
    }
}