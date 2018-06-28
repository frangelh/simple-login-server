package xyz.somniumproject.logindemo.configuracion

import com.avathartech.formconocimiento.domains.seguridad.*
import grails.gorm.transactions.Transactional
import org.springframework.stereotype.Component

@Component
class BootStrap {

    @Transactional
    //@EventListener(ApplicationReadyEvent.class)
    public void init() {
        println("Iniciando la Aplicacion....")

    }
}
