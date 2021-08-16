package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.TimeProvider;
import com.example.demo.model.Users.ConfirmationToken;
import com.example.demo.model.Users.Dermatologist;
import com.example.demo.model.Users.PharmacyAdmin;
import com.example.demo.model.Users.Supplier;
import com.example.demo.model.Users.User;
import com.example.demo.repository.UserRepository.AuthorityRepository;
import com.example.demo.repository.UserRepository.ConfirmationTokenRepository;
import com.example.demo.repository.UserRepository.DermatologistRepository;
import com.example.demo.repository.UserRepository.PharmacyAdminRepository;
import com.example.demo.repository.UserRepository.SupplierRepository;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private TimeProvider timeProvider;

    @Autowired
    private DermatologistRepository dermatologistRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private PharmacyAdminRepository pharmacyAdminRepository;

    @Override
    public User findById(Long id) {
        try {
            User user=userRepository.findById(id).get();
            return user;
        } catch (NoSuchElementException e) {
           throw new NoSuchElementException("User with Id "+id+" does not exist") ;
        }
      
    }

    @Override
    public List<User> findAll() throws AccessDeniedException {
        return userRepository.findAll();
    }


    @Override
    public void verifyUserAccount(String token)  {
        ConfirmationToken confirmationToken = confirmationTokenRepository.findByToken(token);

        if (confirmationToken == null) {
            throw new NoSuchElementException("Requested token doesn't exist.");
        }

        User user = confirmationToken.getUser();
        Date now = timeProvider.now();
        long timeDifference = now.getTime() - confirmationToken.getCreatedDateTime().getTime();
        long timeDifferenceMinutes = timeDifference / (60 * 1000);

        if (timeDifferenceMinutes < 15) {
            user.setIsActivated(true);
            userRepository.save(user);
        } else {
            confirmationTokenRepository.delete(confirmationToken);
            userRepository.delete(user);
            throw new NoSuchElementException ("Confirmation token timed out.");
        }
    }

    @Override
    public User save(User u) {
        return userRepository.save(u);
      
    }

    @Override
    public User findByEmail(String mail) {
        try {
            User user=userRepository.findByEmail(mail);
            return user;
        } catch (NoSuchElementException e) {
          throw new NoSuchElementException("User with email "+mail+" does not exist.");
        }
      
    }

    @Override
    public void remove(User u) {
        userRepository.delete(u);
    }



    @Override
    public User registerUser(User newUser) {
        if(findByEmail(newUser.getEmail()) == null){
            User u = new User();
            u.setPassword(passwordEncoder.encode(newUser.getPassword()));
            u.setFirstName(newUser.getFirstName());
            u.setLastName(newUser.getLastName());
            u.setAddress(newUser.getAddress());
            u.setCity(newUser.getCity());
            u.setEmail(newUser.getEmail());
            u.setTelephone(newUser.getTelephone());
            u.setIsActivated(true);
           // u.setPrviPutLogovan(true);
            u.setRole("ROLE_PATIENT");

            userRepository.save(u);
            return u;
        }
        else {
            return null;
        }
    }

    @Override
    public Dermatologist registerDermatologist(User newUser) {
        if(findByEmail(newUser.getEmail()) == null){
            //User u = new User();
            Dermatologist dermatologist=new Dermatologist();
            dermatologist.setPassword(passwordEncoder.encode(newUser.getPassword()));
            dermatologist.setFirstName(newUser.getFirstName());
            dermatologist.setLastName(newUser.getLastName());
            dermatologist.setAddress(newUser.getAddress());
            dermatologist.setCity(newUser.getCity());
            dermatologist.setEmail(newUser.getEmail());
            dermatologist.setTelephone(newUser.getTelephone());
            dermatologist.setIsActivated(true);
           // u.setPrviPutLogovan(true);
           dermatologist.setRole("ROLE_DERMATOLOGIST");

            //userRepository.save(u);
            
            dermatologistRepository.save(dermatologist);

            return dermatologist;
        }
        else {
            return null;
        }
    }

    @Override
    public Supplier registerSupplier(User newUser) {
        if(findByEmail(newUser.getEmail()) == null){
            //User u = new User();
            Supplier supplier=new Supplier();
            supplier.setPassword(passwordEncoder.encode(newUser.getPassword()));
            supplier.setFirstName(newUser.getFirstName());
            supplier.setLastName(newUser.getLastName());
            supplier.setAddress(newUser.getAddress());
            supplier.setCity(newUser.getCity());
            supplier.setEmail(newUser.getEmail());
            supplier.setTelephone(newUser.getTelephone());
            supplier.setIsActivated(true);
           // u.setPrviPutLogovan(true);
           supplier.setRole("ROLE_SUPPLIER");

            //userRepository.save(u);
            
            supplierRepository.save(supplier);

            return supplier;
        }
        else {
            return null;
        }
    }

    @Override
    public PharmacyAdmin registerPharmacyAdmin(User newUser) {
        if(findByEmail(newUser.getEmail()) == null){
            //User u = new User();
            PharmacyAdmin phAdmin=new PharmacyAdmin();
            phAdmin.setPassword(passwordEncoder.encode(newUser.getPassword()));
            phAdmin.setFirstName(newUser.getFirstName());
            phAdmin.setLastName(newUser.getLastName());
            phAdmin.setAddress(newUser.getAddress());
            phAdmin.setCity(newUser.getCity());
            phAdmin.setEmail(newUser.getEmail());
            phAdmin.setTelephone(newUser.getTelephone());
            phAdmin.setIsActivated(true);
           // u.setPrviPutLogovan(true);
           phAdmin.setRole("ROLE_PH_ADMIN");

            //userRepository.save(u);
            
            pharmacyAdminRepository.save(phAdmin);

            return phAdmin;
        }
        else {
            return null;
        }
    }

}
