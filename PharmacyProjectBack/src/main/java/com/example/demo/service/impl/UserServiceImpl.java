package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.TimeProvider;
import com.example.demo.dto.UserForEditDTO;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.Users.ConfirmationToken;
import com.example.demo.model.Users.Dermatologist;
import com.example.demo.model.Users.Patient;
import com.example.demo.model.Users.PharmacyAdmin;
import com.example.demo.model.Users.Supplier;
import com.example.demo.model.Users.SystemAdmin;
import com.example.demo.model.Users.User;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.repository.UserRepository.AuthorityRepository;
import com.example.demo.repository.UserRepository.ConfirmationTokenRepository;
import com.example.demo.repository.UserRepository.DermatologistRepository;
import com.example.demo.repository.UserRepository.PatientRepository;
import com.example.demo.repository.UserRepository.PharmacyAdminRepository;
import com.example.demo.repository.UserRepository.SupplierRepository;
import com.example.demo.repository.UserRepository.SystemAdminRepository;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.service.PharmacyService;
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

    @Autowired
    private SystemAdminRepository systemAdminRepository;

    @Autowired
    private PharmacyService pharmacyService;

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Autowired
    private PatientRepository patientRepository;

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
            Patient patient= new Patient();
            patient.setPassword(passwordEncoder.encode(newUser.getPassword()));
            patient.setFirstName(newUser.getFirstName());
            patient.setLastName(newUser.getLastName());
            patient.setAddress(newUser.getAddress());
            patient.setCity(newUser.getCity());
            patient.setEmail(newUser.getEmail());
            patient.setTelephone(newUser.getTelephone());
            patient.setIsActivated(true);
            patient.setFirstTimeLogin(false);
           // u.setPrviPutLogovan(true);
           patient.setRole("ROLE_PATIENT");
           patient.setCategory("REGULAR");
           patient.setPenals(0);
           patient.setPoints(0);

           patientRepository.save(patient);
            return patient;
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
            dermatologist.setFirstTimeLogin(true);
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
            supplier.setFirstTimeLogin(true);
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
            phAdmin.setFirstTimeLogin(true);
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
    @Override
    public SystemAdmin registerSystemAdmin(User newUser) {
        if(findByEmail(newUser.getEmail()) == null){
            //User u = new User();
            SystemAdmin sysAdmin=new SystemAdmin();
            sysAdmin.setPassword(passwordEncoder.encode(newUser.getPassword()));
            sysAdmin.setFirstName(newUser.getFirstName());
            sysAdmin.setLastName(newUser.getLastName());
            sysAdmin.setAddress(newUser.getAddress());
            sysAdmin.setCity(newUser.getCity());
            sysAdmin.setEmail(newUser.getEmail());
            sysAdmin.setTelephone(newUser.getTelephone());
            sysAdmin.setIsActivated(true);
            sysAdmin.setFirstTimeLogin(true);
           // u.setPrviPutLogovan(true);
           sysAdmin.setRole("ROLE_SYS_ADMIN");

            //userRepository.save(u);
            
            systemAdminRepository.save(sysAdmin);

            return sysAdmin;
        }
        else {
            return null;
        }
    }
    @Override
    public void editProfile(UserForEditDTO editedUser) {
        User u=userRepository.findByEmail(editedUser.getEmail());
        u.setFirstName(editedUser.getFirstName());
        u.setLastName(editedUser.getLastName());
        u.setCity(editedUser.getCity());
        u.setAddress(editedUser.getAddress());
        u.setTelephone(editedUser.getTelephone());
        userRepository.save(u);
    }

    @Override
    public Pharmacy addPharmacyForAdmin(String pId, String id) {
        Long phId=Long.parseLong(pId);
        Pharmacy pharmacy = pharmacyRepository.findById(phId).get();
        Long aId=Long.parseLong(id);
      PharmacyAdmin phAdmin =(PharmacyAdmin)findById(aId);

       if(phAdmin!=null){
           phAdmin.setPharmacy(pharmacy);
           pharmacyAdminRepository.save(phAdmin);
           return pharmacy;
       }
        return null;
    }

    

}
