package com.contacts.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacts.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Serializable> {

}
