package pl.coderslab.phonebook;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/recordes")
@RequiredArgsConstructor
public class RecordController {

    private final RecordRepository recordRepository;

    @GetMapping
    public String getForm(Model model) {
        model.addAttribute("category", new Record());
        return "recordes/form";
    }

    @PostMapping
    public String saveBook(@ModelAttribute Record record, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "recordesform";
        }
       recordRepository.save(record);
        return "redirect:/recordes/list";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Optional<Record> category = recordRepository.findById(id);
        model.addAttribute("record", category.orElseThrow(IllegalArgumentException::new));
        return "recordes/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Record record, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "recordes/edit";
        }
        recordRepository.save(record);
        return "redirect:/recordes/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCheck(@PathVariable long id, Model model) {
        model.addAttribute("recordId", id);
        return "recordeses/delete";
    }

    @GetMapping("/delete-action/{id}")
    public String delete(@PathVariable long id, @RequestParam("action") boolean action) {
        if (action) {
           recordRepository.deleteById(id);
        }
        return "redirect:/categories/list";
    }


    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("categories", recordRepository.findAll());
        return "categories/list";
    }

}
