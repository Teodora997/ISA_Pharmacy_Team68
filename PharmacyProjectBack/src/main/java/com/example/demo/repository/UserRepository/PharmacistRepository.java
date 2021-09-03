package com.example.demo.repository.UserRepository;
import com.example.demo.model.Users.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
    //@Lock(LockModeType.PESSIMISTIC_READ)
    //@Query("select p from User p where p.id = :id")
    //@Query("select * from user p where p.id = id")
    //@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="10")})
    //public Pharmacist findOneByIdLock(@Param("id")Long id);
}
