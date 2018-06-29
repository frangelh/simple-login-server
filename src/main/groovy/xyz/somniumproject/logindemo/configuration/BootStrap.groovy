package xyz.somniumproject.logindemo.configuration

import grails.gorm.transactions.Transactional
import org.springframework.stereotype.Component
import xyz.somniumproject.logindemo.domains.security.Profile
import xyz.somniumproject.logindemo.domains.security.User

@Component
class BootStrap {

    @Transactional
    void init() {
        println("Running the app...")
        //if admin doesnt exist ... create
        def administratorProfile = new Profile(description: "ADMINISTRATOR").save(failOnError: true)
        def managerProfile = new Profile(description: "MANAGER").save(failOnError: true)
        def admin = new User(username: "admin", name: "Administrator", password: "admin", profiles: Profile.findAll()).save(failOnError: true)

    }
}
