package contactapi.service;

import contactapi.domain.Contact;
import contactapi.repository.ContactRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional(rollbackOn =  Exception.class)
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;


    public Page<Contact> getAllContacts(int page, int size) {
        return contactRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "name")));
    }

    public Contact getContact(String id){
        return contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found. "));
    }

    public Contact saveContact(Contact contact){
        return contactRepository.save(contact);
    }

    public void deleteContact(Contact contact){
        contactRepository.deleteById(contact.getId());
    }

}
