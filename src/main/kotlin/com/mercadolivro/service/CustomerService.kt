package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (
    val customerRepository: CustomerRepository
        ) {



    fun getall( name: String?):List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }
    fun crete( customer: CustomerModel){
        customerRepository.save(customer)
    }
    fun getById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }
    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)){
            throw  Exception()
        }
        customerRepository.save(customer)
    }
    fun delete( id: Int) {
       if (!customerRepository.existsById(id)){
           throw Exception()
       }
        customerRepository.deleteById(id)
    }

}