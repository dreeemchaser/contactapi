package contactapi.controller;

import contactapi.domain.Contact;
import contactapi.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact){
        return ResponseEntity.created(URI.create("/contacts/userID")).body(contactService.createContact(contact));
    }

    @GetMapping
    public ResponseEntity<Page<Contact>> getContacts(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "10") int size){
        return ResponseEntity.ok().body(contactService.getAllContacts(page,size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id){
        return ResponseEntity.ok().body(contactService.getContact(id));
    }

    @PutMapping("/photo")
    public ResponseEntity<String> uploadPhoto(@RequestParam("id") String id, @RequestParam("file") MultipartFile file){
        return ResponseEntity.ok().body(contactService.uploadPhoto(id, file));
    }
}
