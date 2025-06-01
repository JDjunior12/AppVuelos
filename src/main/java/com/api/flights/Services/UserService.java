package com.api.flights.Services;

import com.api.flights.Exceptions.EmptyListException;
import com.api.flights.Exceptions.EmptyValueException;
import com.api.flights.Exceptions.NotFoundException;
import com.api.flights.Models.User;
import com.api.flights.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository iUserRepository;

    public ResponseEntity<List<User>> getAll(){
        List<User> userList = this.iUserRepository.findAll();
        if(userList.isEmpty()){
            throw new EmptyListException("No hay usuarios registrados","RFC-400","400");
        }

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    public ResponseEntity<Optional<User>> getById(Long id){
        Optional<User> userOptional = this.iUserRepository.findById(id);

        if(userOptional.isEmpty()){
            throw new NotFoundException("El usuario con el id:"+ id + ", no existe", "RFC-404", "404");
        }

        return new ResponseEntity<>(userOptional, HttpStatus.OK);
    }

    public ResponseEntity<User> newUser(User user){
        if(user.getPassword().isEmpty() || user.getEmail().isEmpty()){
            throw new EmptyValueException("el valor: Email o el valor: Password esta vacio","RFC-404","404");
        }

        return new ResponseEntity<>(this.iUserRepository.save(user),HttpStatus.CREATED);
    }

    public ResponseEntity<User> updateUser(User user, Long id){

        Optional<User> userOptional = this.iUserRepository.findById(id);

        if(userOptional.isEmpty()){
            throw new NotFoundException("El usuario con el id:"+ id + ", no existe", "RFC-404", "404");
        }

        if(user.getPassword().isEmpty() || user.getEmail().isEmpty()){
            throw new EmptyValueException("el valor: Email o el valor: Password esta vacio","RFC-404","404");
        }

        user.setId(id);
        return new ResponseEntity<>(this.iUserRepository.save(user), HttpStatus.OK);

    }

    public void deleteUser(Long id){
        Optional<User> userOptional = this.iUserRepository.findById(id);

        if(userOptional.isEmpty()){
            throw new NotFoundException("El usuario con el id:"+ id + ", no existe", "RFC-404", "404");
        }
        this.iUserRepository.deleteById(id);
    }
}
