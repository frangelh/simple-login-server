package xyz.somniumproject.logindemo.domains.security

import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class Profile implements GormEntity<Profile> {

    String description

    static constraints = {

    }

    static mapping = {
        table "security_profile"
    }
}

