package xyz.somniumproject.logindemo.domains.security

import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class User implements GormEntity<User> {

    String username
    String name
    String password

    static constraints = {

    }

    static mapping = {
        table "security_user"
    }
}
